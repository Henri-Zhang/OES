package priv.barrow.oes.portlet.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class TeacherDisplayTerms extends DisplayTerms {

    public static final String SEARCH_KEYWORD = "keyword";

    protected String keyword;

    public TeacherDisplayTerms(PortletRequest portletRequest) {
        super(portletRequest);
        keyword = ParamUtil.getString(portletRequest, SEARCH_KEYWORD);
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

}
