package priv.barrow.oes.portlet.createexam;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.dynamic.data.lists.model.DDLRecord;
import com.liferay.dynamic.data.lists.model.DDLRecordSet;
import com.liferay.dynamic.data.lists.service.DDLRecordLocalServiceUtil;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.storage.Fields;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import priv.barrow.model.ExamQuestionLink;
import priv.barrow.model.QuestionRecordLink;
import priv.barrow.oes.portlet.constants.ExamConstants;
import priv.barrow.oes.portlet.util.AddRecordUtil;
import priv.barrow.oes.portlet.util.ExamUtil;
import priv.barrow.service.ExamQuestionLinkLocalServiceUtil;
import priv.barrow.service.QuestionRecordLinkLocalServiceUtil;
import priv.barrow.service.persistence.ExamQuestionLinkPK;

@Component(
    immediate = true,
    property = {
        "com.liferay.portlet.display-category=Teacher",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.display-name=Create Exam",
        "javax.portlet.init-param.template-path=/",
        "com.liferay.portlet.header-portlet-css=/css/createexam/create_exam.css",
        "com.liferay.portlet.footer-portlet-javascript=/js/createexam/create_exam.js",
        "javax.portlet.init-param.view-template=/html/createexam/create_exam.jsp",
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user"
    },
    service = Portlet.class
)

public class CreateExamPortlet extends MVCPortlet {

    private final Log LOG = LogFactoryUtil.getLog(CreateExamPortlet.class);

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {

        long classNameId = PortalUtil.getClassNameId(DDMStructure.class);

        DDMStructure examStructure =
                AddRecordUtil.getDDMStructureByName(ExamConstants.EXAM_STRUCTURE_NAME);
        if (Validator.isNull(examStructure)) {
            return;
        }

        long classPK = examStructure.getStructureId();
        Fields fields = AddRecordUtil.getStructureFields(classPK, null);
        if (Validator.isNull(fields)) {
            return;
        }

        renderRequest.setAttribute(ExamConstants.CLASS_NAME_ID, classNameId);
        renderRequest.setAttribute(ExamConstants.CLASS_PK, classPK);
        renderRequest.setAttribute(ExamConstants.FIELDS, fields);

        super.doView(renderRequest, renderResponse);
    }

    @ProcessAction(name = ExamConstants.CREATE_EXAM)
    public void createExam(ActionRequest actionRequest, ActionResponse actionResponse) {
        UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        ServiceContext serviceContext = null;
        try {
            serviceContext = ServiceContextFactory.getInstance(uploadPortletRequest);
        } catch (PortalException e) {
            LOG.error("Get ServiceContext from UploadPortletRequest failed.", e);
            return;
        }

        long userId = themeDisplay.getUserId();
        DDMStructure examStructure =
                AddRecordUtil.getDDMStructureByName(ExamConstants.EXAM_STRUCTURE_NAME);
        if (Validator.isNull(examStructure)) {
            return;
        }
        long examStructureId = examStructure.getStructureId();

        Fields fields = AddRecordUtil.getStructureFields(examStructureId, serviceContext);
        if (Validator.isNull(fields)) {
            return;
        }

        DDLRecordSet examRecordSet = AddRecordUtil.getDDLRecordSet(examStructureId);
        if (Validator.isNull(examRecordSet)) {
            return;
        }
        long recordSetId = examRecordSet.getRecordSetId();
        long groupId = examRecordSet.getGroupId();

        // Adds a exam record to Question_DDL.
        DDLRecord newRecord = null;
        try {
            newRecord = DDLRecordLocalServiceUtil.addRecord(userId, groupId, recordSetId, 0, fields, serviceContext);
        } catch (PortalException e) {
            LOG.error(String.format("Add question failed. userId: [%d], groupId: [%d], recordSetId: [%d]",
                    userId, groupId, recordSetId), e);
            return;
        }

        Map<String, Object> examValuesMap = ExamUtil.getExamValueMap(fields);
        int questionCount = (int) examValuesMap.get(ExamConstants.QUESTION_COUNT);

        List<QuestionRecordLink> randomQuestionRecordLinks =
                QuestionRecordLinkLocalServiceUtil.findRandomQuestionReocrdLinks(questionCount);

        long examRecordId = newRecord.getRecordId();
        for (QuestionRecordLink questionRecordLink : randomQuestionRecordLinks) {
            long questionRecordId = questionRecordLink.getDdlRecordId();
            ExamQuestionLinkPK examQuestionLinkPK = new ExamQuestionLinkPK(examRecordId, questionRecordId);
            ExamQuestionLink examQuestionLink =
                    ExamQuestionLinkLocalServiceUtil.createExamQuestionLink(examQuestionLinkPK);

            DDLRecord questionRecord = null;
            try {
                questionRecord = DDLRecordLocalServiceUtil.getDDLRecord(questionRecordId);
            } catch (PortalException e) {
                LOG.error(String.format("Get DDLRecord by id [%d] failed.", questionRecordId), e);
                continue;
            }

            String currentVersion = questionRecord.getVersion();
            examQuestionLink.setQuestionRecordVersion(currentVersion);

            ExamQuestionLinkLocalServiceUtil.addExamQuestionLink(examQuestionLink);
        }

    }

}
