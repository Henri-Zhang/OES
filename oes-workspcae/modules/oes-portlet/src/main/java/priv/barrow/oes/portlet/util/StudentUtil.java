package priv.barrow.oes.portlet.util;

import java.util.List;

import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;

import priv.barrow.oes.portlet.constants.StudentConstants;

public class StudentUtil {

    public static boolean isStudent(User user) {
        List<Role> roles = user.getRoles();
        for (Role role : roles) {
            if (StudentConstants.STUDENT_ROLE_NAME.equals(role.getName())) {
                return true;
            }
        }

        return false;
    }

}
