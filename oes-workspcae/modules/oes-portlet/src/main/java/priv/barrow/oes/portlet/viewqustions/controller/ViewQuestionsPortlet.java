package priv.barrow.oes.portlet.viewqustions.controller;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

@Component(
    immediate = true,
    property = {
        "com.liferay.portlet.display-category=Content Admin",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.display-name=View Questions",
        "javax.portlet.init-param.template-path=/",
        "com.liferay.portlet.header-portlet-css=/css/viewquestions/view_questions.css",
        "com.liferay.portlet.header-portlet-javascript=/js/viewquestions/view_questions.js",
        "javax.portlet.init-param.view-template=/html/viewquestions/view_questions.jsp",
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user"
    },
    service = Portlet.class
)

public class ViewQuestionsPortlet extends MVCPortlet {

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {

        super.doView(renderRequest, renderResponse);
    }

    @ProcessAction(name = "searchQuestions")
    public void searchQuestions(ActionRequest actionRequest, ActionResponse actionResponse) {
        String questionNo = ParamUtil.get(actionRequest, "questionNo", "Question No.");
        String keyword = ParamUtil.get(actionRequest, "keyword", "Question No.");
        String perPage = ParamUtil.get(actionRequest, "perPage", "Question No.");

    }

}