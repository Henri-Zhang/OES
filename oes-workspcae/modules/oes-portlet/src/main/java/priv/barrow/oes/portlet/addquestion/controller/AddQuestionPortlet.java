package priv.barrow.oes.portlet.addquestion.controller;

import java.io.IOException;

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
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import priv.barrow.oes.portlet.addquestion.constants.Constants;
import priv.barrow.oes.portlet.util.QuestionUtil;
import priv.barrow.service.QuestionRecordLinkLocalServiceUtil;

@Component(
    immediate = true,
    property = {
        "com.liferay.portlet.display-category=Content Admin",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.display-name=Add Question",
        "javax.portlet.init-param.template-path=/",
        "com.liferay.portlet.header-portlet-css=/css/addquestion/add_question.css",
        "com.liferay.portlet.header-portlet-javascript=/js/addquestion/add_question.js",
        "javax.portlet.init-param.view-template=/html/addquestion/add_question.jsp",
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user"
    },
    service = Portlet.class
)

public class AddQuestionPortlet extends MVCPortlet {

    private static final Log LOG = LogFactoryUtil.getLog(AddQuestionPortlet.class);

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {

        long classNameId = PortalUtil.getClassNameId(DDMStructure.class);

        DDMStructure questionStructure = QuestionUtil.getQuestionDDMStructure();
        if (Validator.isNull(questionStructure)) {
            return;
        }

        long classPK = questionStructure.getStructureId();
        Fields fields = QuestionUtil.getQuestionStructureFields(classPK, null);
        if (Validator.isNull(fields)) {
            return;
        }

        renderRequest.setAttribute(Constants.CLASS_NAME_ID, classNameId);
        renderRequest.setAttribute(Constants.CLASS_PK, classPK);
        renderRequest.setAttribute(Constants.FIELDS, fields);

        super.doView(renderRequest, renderResponse);
    }

    @Transactional
    @ProcessAction(name = "addQuestion")
    public void addQuestion(ActionRequest actionRequest, ActionResponse actionResponse) {
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
        DDMStructure questionStructure = QuestionUtil.getQuestionDDMStructure();
        if (Validator.isNull(questionStructure)) {
            return;
        }
        long questionStructureId = questionStructure.getStructureId();

        Fields fields = QuestionUtil.getQuestionStructureFields(questionStructureId, serviceContext);
        if (Validator.isNull(fields)) {
            return;
        }

        DDLRecordSet questionRecordSet = QuestionUtil.getQuestionRecordSet(questionStructureId);
        if (Validator.isNull(questionRecordSet)) {
            return;
        }
        long recordSetId = questionRecordSet.getRecordSetId();
        long groupId = questionRecordSet.getGroupId();

        // Adds a question record to Question_DDL.
        DDLRecord newRecord = null;
        try {
            newRecord = DDLRecordLocalServiceUtil.addRecord(userId, groupId, recordSetId, 0, fields, serviceContext);
        } catch (PortalException e) {
            LOG.error(String.format("Add question failed. userId: [%d], groupId: [%d], recordSetId: [%d]",
                    userId, groupId, recordSetId), e);
            return;
        }

        // Adds a QuestionRecordLink to oes_questionrecordlink.
        QuestionRecordLinkLocalServiceUtil.addQuestionRecordLink(newRecord.getRecordId());
    }

}