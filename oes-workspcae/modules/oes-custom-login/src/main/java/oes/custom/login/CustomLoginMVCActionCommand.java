package oes.custom.login;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=com_liferay_login_web_portlet_FastLoginPortlet",
        "javax.portlet.name=com_liferay_login_web_portlet_LoginPortlet",
        "mvc.command.name=/login/login",
        "service.ranking:Integer=16627"
    },
    service = MVCActionCommand.class
)

public class CustomLoginMVCActionCommand extends BaseMVCActionCommand {

    @Reference(target = "(&(mvc.command.name=/login/login)(javax.portlet.name=com_liferay_login_web_portlet_FastLoginPortlet)(javax.portlet.name=com_liferay_login_web_portlet_LoginPortlet)(component.name=com.liferay.login.web.internal.portlet.action.LoginMVCActionCommand))")

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        System.out.println("lalalalallaallalal");
    }

}
