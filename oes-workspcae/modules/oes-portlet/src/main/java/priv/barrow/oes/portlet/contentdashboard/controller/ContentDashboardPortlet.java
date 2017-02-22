package priv.barrow.oes.portlet.contentdashboard.controller;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import priv.barrow.service.QuestionRecordLinkLocalServiceUtil;

@Component(
    immediate = true,
    property = {
        "com.liferay.portlet.display-category=Content Admin",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.display-name=Content Dashboard",
        "javax.portlet.init-param.template-path=/",
        "com.liferay.portlet.header-portlet-css=/css/contentdashboard/content_dashboard.css",
        "com.liferay.portlet.header-portlet-javascript=/js/contentdashboard/content_dashboard.js",
        "javax.portlet.init-param.view-template=/html/contentdashboard/content_dashboard.jsp",
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user"
    },
    service = Portlet.class
)

public class ContentDashboardPortlet extends MVCPortlet {

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {
//        QuestionRecordLinkLocalServiceUtil.findRecentUpdateQuestionRecordLinks(5);
        QuestionRecordLinkLocalServiceUtil.getQuestionRecordLinksCount();
        super.doView(renderRequest, renderResponse);
    }

}
