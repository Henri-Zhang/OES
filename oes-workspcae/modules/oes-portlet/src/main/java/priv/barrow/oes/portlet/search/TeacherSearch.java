package priv.barrow.oes.portlet.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.util.StringPool;

import priv.barrow.model.TeacherUserLink;

public class TeacherSearch extends SearchContainer<TeacherUserLink> implements Serializable {

    private static final long serialVersionUID = 1L;

    static List<String> headerNames = new ArrayList<String>();

    static {
        headerNames.add("Teacher Number");
        headerNames.add("First Name");
        headerNames.add("Last Name");
        headerNames.add("Email");
        headerNames.add(StringPool.BLANK);
    }

    public TeacherSearch(PortletRequest portletRequest, PortletURL portletURL) {
    }

}