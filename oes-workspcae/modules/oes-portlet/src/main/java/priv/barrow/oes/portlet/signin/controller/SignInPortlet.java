package priv.barrow.oes.portlet.signin.controller;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

/**
 * @author barrow
 */
@Component(
    immediate = true,
    property = {
        "com.liferay.portlet.display-category=category.sample",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.display-name=Sign In",
        "javax.portlet.init-param.template-path=/",
        "com.liferay.portlet.header-portlet-css=/css/signin/sign_in.css",
        "com.liferay.portlet.header-portlet-javascript=/js/signin/sign_in.js",
        "javax.portlet.init-param.view-template=/html/signin/sign_in.jsp",
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user"
    },
    service = Portlet.class
)

public class SignInPortlet extends MVCPortlet {

}
