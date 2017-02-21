package priv.barrow.oes.portlet.addquestion.controller;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.dynamic.data.lists.model.DDLRecordSet;
import com.liferay.dynamic.data.lists.service.DDLRecordLocalServiceUtil;
import com.liferay.dynamic.data.lists.service.DDLRecordSetLocalServiceUtil;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalServiceUtil;
import com.liferay.dynamic.data.mapping.storage.Fields;
import com.liferay.dynamic.data.mapping.util.DDMUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import priv.barrow.oes.portlet.addquestion.constants.Constants;
import priv.barrow.oes.portlet.addquestion.exception.NoQuestionStructureException;

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

        DDMStructure questionStructure = getQuestionDDMStructure();
        if (Validator.isNull(questionStructure)) {
            return;
        }

        long classPK = questionStructure.getStructureId();
        Fields fields = getQuestionStructureFields(classPK, null);
        if (Validator.isNull(fields)) {
            return;
        }

        renderRequest.setAttribute(Constants.CLASS_NAME_ID, classNameId);
        renderRequest.setAttribute(Constants.CLASS_PK, classPK);
        renderRequest.setAttribute(Constants.FIELDS, fields);

        super.doView(renderRequest, renderResponse);
    }

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
        DDMStructure questionStructure = getQuestionDDMStructure();
        if (Validator.isNull(questionStructure)) {
            return;
        }
        long questionStructureId = questionStructure.getStructureId();

        Fields fields = getQuestionStructureFields(questionStructureId, serviceContext);
        if (Validator.isNull(fields)) {
            return;
        }

        DDLRecordSet questionRecordSet = getQuestionRecordSet(questionStructureId);
        if (Validator.isNull(questionRecordSet)) {
            return;
        }
        long recordSetId = questionRecordSet.getRecordSetId();
        long groupId = questionRecordSet.getGroupId();

        try {
            DDLRecordLocalServiceUtil.addRecord(userId, groupId, recordSetId, 0, fields, serviceContext);
        } catch (PortalException e) {
            LOG.error(String.format("Add question failed. userId: [%d], groupId: [%d], recordSetId: [%d]",
                    userId, groupId, recordSetId), e);
        }

    }

    private DDMStructure getQuestionDDMStructure() {
        DynamicQuery structrueQuery = DDMStructureLocalServiceUtil.dynamicQuery();
        Property property = PropertyFactoryUtil.forName("name");
        Criterion criterion =
                property.like(StringPool.PERCENT+ Constants.QUESTION + Constants.NAME_END_TAG + StringPool.PERCENT);
        structrueQuery.add(criterion);
        List<DDMStructure> ddmStructures = DDMStructureLocalServiceUtil.dynamicQuery(structrueQuery);

        if (Validator.isNull(ddmStructures) || ddmStructures.isEmpty()) {
            String errorMessage = String.format("No ddmStructure found with name [%s]", Constants.QUESTION);
            LOG.error(errorMessage, new NoQuestionStructureException(errorMessage));
            return null;
        }

        return ddmStructures.get(0);
    }

    private Fields getQuestionStructureFields(long structureId, ServiceContext serviceContext) {
        if (Validator.isNull(serviceContext)) {
            serviceContext = new ServiceContext();
        }

        Fields fields = null;
        try {
            fields = DDMUtil.getFields(structureId, serviceContext);
        } catch (PortalException e) {
            LOG.error(String.format("Get fields from ddmStructure which id is [%s] failed.", structureId), e);
        }

        return fields;
    }

    private DDLRecordSet getQuestionRecordSet(long questionStructureId) {
        DynamicQuery dynamicQuery = DDLRecordSetLocalServiceUtil.dynamicQuery();
        Property property = PropertyFactoryUtil.forName("DDMStructureId");
        Criterion criterion = property.eq(questionStructureId);
        dynamicQuery.add(criterion);
        List<DDLRecordSet> list = DDLRecordSetLocalServiceUtil.dynamicQuery(dynamicQuery);
        if (Validator.isNull(list) || list.isEmpty()) {
            return null;
        }

        return list.get(0);
    }

}
