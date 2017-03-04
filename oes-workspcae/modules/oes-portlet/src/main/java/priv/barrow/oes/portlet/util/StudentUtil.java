package priv.barrow.oes.portlet.util;

import java.util.List;

import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;

public class StudentUtil {

    private static final String STUDENT_ROLE_NAME = "Student";

    public static boolean isStudent(User user) {
        List<Role> roles = user.getRoles();
        for (Role role : roles) {
            if (STUDENT_ROLE_NAME.equals(role.getName())) {
                return true;
            }
        }

        return false;
    }

}