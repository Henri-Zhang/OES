package priv.barrow.oes.portlet.teacherdashboard.controller;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.dynamic.data.lists.model.DDLRecord;
import com.liferay.dynamic.data.lists.model.DDLRecordSet;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import priv.barrow.oes.portlet.constants.ExamConstants;
import priv.barrow.oes.portlet.model.Exam;
import priv.barrow.oes.portlet.util.AddRecordUtil;
import priv.barrow.oes.portlet.util.ExamUtil;

@Component(
    immediate = true,
    property = {
        "com.liferay.portlet.display-category=Teacher",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.display-name=Teacher Dashboard",
        "javax.portlet.init-param.template-path=/",
        "com.liferay.portlet.header-portlet-css=/css/teacherdashboard/teacher_dashboard.css",
        "com.liferay.portlet.header-portlet-javascript=/js/teacherdashboard/teacher_dashboard.js",
        "javax.portlet.init-param.view-template=/html/teacherdashboard/teacher_dashboard.jsp",
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user"
    },
    service = Portlet.class
)

public class TeacherDashboardPortlet extends MVCPortlet {

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long userId = themeDisplay.getUserId();

        long examStructureId = AddRecordUtil.getDDMStructureIdByName(ExamConstants.EXAM_STRUCTURE_NAME);
        DDLRecordSet examRecordSet = AddRecordUtil.getDDLRecordSet(examStructureId);
        List<DDLRecord> examRecords = AddRecordUtil.getExamDDLRecords(examRecordSet.getRecordSetId(), userId);
        List<Exam> exams = ExamUtil.getExamsByRecords(examRecords);

        renderRequest.setAttribute(ExamConstants.EXAMS, exams);

        super.doView(renderRequest, renderResponse);
    }

}
