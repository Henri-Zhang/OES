package priv.barrow.oes.portlet.editquestion;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.liferay.dynamic.data.lists.model.DDLRecord;
import com.liferay.dynamic.data.lists.service.DDLRecordLocalServiceUtil;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.storage.DDMFormValues;
import com.liferay.dynamic.data.mapping.storage.Field;
import com.liferay.dynamic.data.mapping.storage.Fields;
import com.liferay.dynamic.data.mapping.util.DDMUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import priv.barrow.model.QuestionRecordLink;
import priv.barrow.oes.portlet.constants.QuestionConstants;
import priv.barrow.oes.portlet.util.AddRecordUtil;
import priv.barrow.service.QuestionRecordLinkLocalServiceUtil;

@Component(
    immediate = true,
    property = {
        "com.liferay.portlet.display-category=Content Admin",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.display-name=Edit Question",
        "javax.portlet.init-param.template-path=/",
        "com.liferay.portlet.header-portlet-css=/css/editquestion/edit_question.css",
        "com.liferay.portlet.footer-portlet-javascript=/js/editquestion/edit_question.js",
        "javax.portlet.init-param.view-template=/html/editquestion/edit_question.jsp",
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user"
    },
    service = Portlet.class
)

public class EditQuestionPortlet extends MVCPortlet {

    private Log LOG = LogFactoryUtil.getLog(EditQuestionPortlet.class);

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {

        HttpServletRequest request =
                PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
        long questionOrder = ParamUtil.get(request, QuestionConstants.QUESTION_ORDER, 0L);
        if (questionOrder == 0) {
            throw new PortletException("Lack of parameter questionOrder.");
        }

        QuestionRecordLink questionRecordLink = null;
        try {
            questionRecordLink = QuestionRecordLinkLocalServiceUtil.getQuestionRecordLink(questionOrder);
        } catch (PortalException e) {
            throw new PortletException("No question to edit.", e);
        }

        long questionRecordId = questionRecordLink.getDdlRecordId();
        DDLRecord questionRecord = null;
        try {
            questionRecord = DDLRecordLocalServiceUtil.getDDLRecord(questionRecordId);
        } catch (PortalException e) {
            LOG.error(String.format("Get question DDLRecord failed. recordId: [%d]", questionRecordId), e);
        }

        long classNameId = PortalUtil.getClassNameId(DDMStructure.class);

        DDMStructure questionStructure =
                AddRecordUtil.getDDMStructureByName(QuestionConstants.QUESTION_STRUCTURE_NAME);
        if (Validator.isNull(questionStructure)) {
            return;
        }

        DDMFormValues questionFormValues = null;
        try {
            questionFormValues = questionRecord.getDDMFormValues();
        } catch (PortalException e) {
            LOG.error(String.format("Get question DDMFormValues failed. recordId: [%d]", questionRecordId), e);
        }

        long classPK = questionStructure.getStructureId();
        Fields fields = null;
        try {
            fields = DDMUtil.getFields(classPK, questionFormValues);
        } catch (PortalException e) {
            LOG.error(String.format("Get question Fields failed. structureId: [%d]", classPK), e);
        }

        if (Validator.isNull(fields)) {
            return;
        }

        renderRequest.setAttribute(QuestionConstants.QUESTION_ORDER, questionOrder);
        renderRequest.setAttribute(QuestionConstants.QUESTION_FORM_VALUES, questionFormValues);
        renderRequest.setAttribute(QuestionConstants.CLASS_NAME_ID, classNameId);
        renderRequest.setAttribute(QuestionConstants.CLASS_PK, classPK);
        renderRequest.setAttribute(QuestionConstants.FIELDS, fields);

        super.doView(renderRequest, renderResponse);
    }

    @ProcessAction(name = QuestionConstants.UPDATE_QUESTION)
    public void updateQuestion(ActionRequest actionRequest, ActionResponse actionResponse) {
        long questionOrder = ParamUtil.get(actionRequest, QuestionConstants.QUESTION_ORDER, 0L);
        if (questionOrder == 0) {
            return;
        }

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
        long userId = themeDisplay.getUserId();

        QuestionRecordLink questionRecordLink = null;
        try {
            questionRecordLink = QuestionRecordLinkLocalServiceUtil.getQuestionRecordLink(questionOrder);
        } catch (PortalException e) {
            LOG.error(String.format("Get QuestionRecordLink failed. questionOrder: [%d]", questionOrder), e);
        }

        long questionRecordId = questionRecordLink.getDdlRecordId();

        ServiceContext serviceContext = null;
        try {
            serviceContext = ServiceContextFactory.getInstance(uploadPortletRequest);
        } catch (PortalException e) {
            LOG.error("Get ServiceContext from UploadPortletRequest failed.", e);
            return;
        }

        long questionStructureId =
                AddRecordUtil.getDDMStructureIdByName(QuestionConstants.QUESTION_STRUCTURE_NAME);

        Fields fields = null;
        try {
            fields = DDMUtil.getFields(questionStructureId, QuestionConstants.EDIT_QUESTION_FIELDS_NAMESPACE, serviceContext);
        } catch (PortalException e) {
            LOG.error(String.format("Get Fields failed. structureId: [%d], fieldsNamespcae: [%s]",
                    questionRecordId), e);
        }

        // Updates record.
        try {
            DDLRecordLocalServiceUtil.updateRecord(userId, questionRecordId, false, 0, fields, false, serviceContext);
        } catch (PortalException e) {
            LOG.error(String.format("Update DDLRecord failed. recordId: [%d]", questionRecordId), e);
        }

        // Updates questionRecordLink.
        Field field = fields.get(QuestionConstants.DESCRIPTION_FIELD_NAME);
        String questionDescription = field.getValue().toString();
        questionRecordLink.setQuestionDescription(questionDescription);
        QuestionRecordLinkLocalServiceUtil.updateQuestionRecordLink(questionRecordLink);

        try {
            actionResponse.sendRedirect(String.format(QuestionConstants.QUESTION_DETAIL_URL, questionOrder));
        } catch (IOException e) {
            LOG.error(String.format("Redirect to question detail page failed. questionOrder: [%d]", questionOrder), e);
        }

    }
}
