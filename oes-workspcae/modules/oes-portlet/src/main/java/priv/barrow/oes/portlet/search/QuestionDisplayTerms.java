package priv.barrow.oes.portlet.search;

import java.sql.Timestamp;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class QuestionDisplayTerms extends DisplayTerms {

    public static final String SEARCH_QUESTION_ORDER_START = "questionOrderStart";
    public static final String SEARCH_QUESTION_ORDER_END = "questionOrderEnd";
    public static final String SEARCH_UPDATE_DATE_START = "updateDateStart";
    public static final String SEARCH_UPDATE_DATE_END = "updateDateEnd";
    public static final String SEARCH_QUESTION_KEYWORD = "questionKeyword";
    public static final String SEARCH_USER_NAME_KEYWORD = "userNameKeyword";

    protected long questionOrderStart;
    protected long questionOrderEnd;
    protected Timestamp updateDateStart;
    protected Timestamp updateDateEnd;
    protected String questionKeyword;
    protected String userNameKeyword;

    public QuestionDisplayTerms(PortletRequest portletRequest) {
        super(portletRequest);
        questionOrderStart = ParamUtil.getLong(portletRequest, SEARCH_QUESTION_ORDER_START);
        questionOrderEnd = ParamUtil.getLong(portletRequest, SEARCH_QUESTION_ORDER_END);
        // TODO time
        questionKeyword = ParamUtil.getString(portletRequest, SEARCH_QUESTION_KEYWORD);
        userNameKeyword = ParamUtil.getString(portletRequest, SEARCH_USER_NAME_KEYWORD);
    }

    public long getQuestionOrderStart() {
        return questionOrderStart;
    }

    public void setQuestionOrderStart(long questionOrderStart) {
        this.questionOrderStart = questionOrderStart;
    }

    public long getQuestionOrderEnd() {
        return questionOrderEnd;
    }

    public void setQuestionOrderEnd(long questionOrderEnd) {
        this.questionOrderEnd = questionOrderEnd;
    }

    public Timestamp getUpdateDateStart() {
        return updateDateStart;
    }

    public void setUpdateDateStart(Timestamp updateDateStart) {
        this.updateDateStart = updateDateStart;
    }

    public Timestamp getUpdateDateEnd() {
        return updateDateEnd;
    }

    public void setUpdateDateEnd(Timestamp updateDateEnd) {
        this.updateDateEnd = updateDateEnd;
    }

    public String getQuestionKeyword() {
        return questionKeyword;
    }

    public void setQuestionKeyword(String questionKeyword) {
        this.questionKeyword = questionKeyword;
    }

    public String getUserNameKeyword() {
        return userNameKeyword;
    }

    public void setUserNameKeyword(String userNameKeyword) {
        this.userNameKeyword = userNameKeyword;
    }

}