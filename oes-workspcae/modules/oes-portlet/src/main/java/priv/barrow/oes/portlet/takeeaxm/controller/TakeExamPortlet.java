package priv.barrow.oes.portlet.takeeaxm.controller;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.liferay.dynamic.data.lists.model.DDLRecord;
import com.liferay.dynamic.data.lists.service.DDLRecordLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import priv.barrow.oes.portlet.constants.ExamConstants;
import priv.barrow.oes.portlet.model.Exam;
import priv.barrow.oes.portlet.util.ExamUtil;

@Component(
    immediate = true,
    property = {
        "com.liferay.portlet.display-category=Student",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.display-name=Take Exam",
        "javax.portlet.init-param.template-path=/",
        "com.liferay.portlet.header-portlet-css=/css/takeexam/take_exam.css",
        "com.liferay.portlet.footer-portlet-javascript=/js/takeexam/take_exam.js",
        "javax.portlet.init-param.view-template=/html/takeexam/take_exam.jsp",
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user"
    },
    service = Portlet.class
)

public class TakeExamPortlet extends MVCPortlet {

    private Log LOG = LogFactoryUtil.getLog(TakeExamPortlet.class);

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {

        HttpServletRequest request =
                PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
        long examId = ParamUtil.get(request, ExamConstants.EXAM_ID, ExamConstants.INEXISTENT_EXAM_ID);
        if (examId == ExamConstants.INEXISTENT_EXAM_ID) {
            throw new PortletException("No examId exist.");
        }

        DDLRecord examRecord = null;
        try {
            examRecord = DDLRecordLocalServiceUtil.getDDLRecord(examId);
        } catch (PortalException e) {
            LOG.error(String.format("Get exam record by id failed. eaxmId: [%d]", examId), e);
        }

        Exam exam = ExamUtil.getExam(examRecord);
        renderRequest.setAttribute(ExamConstants.EXAM, exam);

        super.doView(renderRequest, renderResponse);
    }

}