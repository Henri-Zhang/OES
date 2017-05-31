package priv.barrow.oes.portlet.questiondetail;

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
import com.liferay.dynamic.data.mapping.storage.Fields;
import com.liferay.dynamic.data.mapping.util.DDMUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import priv.barrow.model.QuestionRecordLink;
import priv.barrow.oes.portlet.constants.QuestionConstants;
import priv.barrow.oes.portlet.util.AddRecordUtil;
import priv.barrow.service.QuestionRecordLinkLocalServiceUtil;

@Component(
    immediate = true,
    property = {
        "com.liferay.portlet.display-category=Content Admin",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.display-name=Question Detail",
        "javax.portlet.init-param.template-path=/",
        "com.liferay.portlet.header-portlet-css=/css/questiondetail/question_detail.css",
        "com.liferay.portlet.footer-portlet-javascript=/js/questiondetail/question_detaill.js",
        "javax.portlet.init-param.view-template=/html/questiondetail/question_detail.jsp",
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user"
    },
    service = Portlet.class
)

public class QuestionDetailPortlet extends MVCPortlet {

    private Log LOG = LogFactoryUtil.getLog(QuestionDetailPortlet.class);

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {

        HttpServletRequest request =
                PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
        long questionOrder = ParamUtil.get(request, QuestionConstants.QUESTION_ORDER,
                                QuestionConstants.INEXISTENT_QUESTION_ORDER);
        if (questionOrder == QuestionConstants.INEXISTENT_QUESTION_ORDER) {
            throw new PortletException("Lack of parameter questionOrder.");
        }

        QuestionRecordLink questionRecordLink = null;
        try {
            questionRecordLink = QuestionRecordLinkLocalServiceUtil.getQuestionRecordLink(questionOrder);
        } catch (PortalException e) {
            throw new PortletException("No question to show.", e);
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

        renderRequest.setAttribute(QuestionConstants.QUESTION_FORM_VALUES, questionFormValues);
        renderRequest.setAttribute(QuestionConstants.QUESTION_ORDER, questionOrder);
        renderRequest.setAttribute(QuestionConstants.CLASS_NAME_ID, classNameId);
        renderRequest.setAttribute(QuestionConstants.CLASS_PK, classPK);
        renderRequest.setAttribute(QuestionConstants.FIELDS, fields);

        super.doView(renderRequest, renderResponse);
    }

    @ProcessAction(name = QuestionConstants.DELETE_QUESTION)
    public void deleteQuestion(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
        long questionOrder = ParamUtil.get(actionRequest, QuestionConstants.QUESTION_ORDER, 0L);
        if (questionOrder == 0) {
            return;
        }

        QuestionRecordLink questionRecordLink = null;
        try {
            questionRecordLink = QuestionRecordLinkLocalServiceUtil.getQuestionRecordLink(questionOrder);
        } catch (PortalException e) {
            LOG.error(String.format("Get QuestionRecordLink failed. questionOrder: [%d]", questionOrder), e);
            return;
        }

        questionRecordLink.setActive(false);
        QuestionRecordLinkLocalServiceUtil.updateQuestionRecordLink(questionRecordLink);

        actionResponse.sendRedirect("/content-dashboard");

    }

}
