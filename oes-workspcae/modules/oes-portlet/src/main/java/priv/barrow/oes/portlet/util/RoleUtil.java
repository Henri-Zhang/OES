package priv.barrow.oes.portlet.util;

import java.util.List;

import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;

public class RoleUtil {

    public static boolean isAdministrator(User user) {
        List<Role> roles = user.getRoles();
        for (Role role : roles) {
            if ("Administrator".equals(role.getName())) {
                return true;
            }
        }

        return false;
    }

}
