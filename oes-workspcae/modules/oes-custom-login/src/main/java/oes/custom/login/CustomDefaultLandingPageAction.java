package oes.custom.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;

public class CustomDefaultLandingPageAction extends Action {

    @Override
    public void run(HttpServletRequest request, HttpServletResponse response) throws ActionException {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
    }

}
