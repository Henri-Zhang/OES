package priv.barrow.oes.portlet.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class QuestionSearchTerms extends QuestionDisplayTerms {

    public QuestionSearchTerms(PortletRequest portletRequest) {
        super(portletRequest);

        questionOrderStart = DAOParamUtil.getLong(portletRequest, SEARCH_QUESTION_ORDER_START);
        questionOrderEnd = DAOParamUtil.getLong(portletRequest, SEARCH_QUESTION_ORDER_END);
        // TODO time
        questionKeyword = DAOParamUtil.getString(portletRequest, SEARCH_QUESTION_KEYWORD);
        userNameKeyword = DAOParamUtil.getString(portletRequest, SEARCH_USER_NAME_KEYWORD);
    }

}
