package priv.barrow.oes.portlet.search;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;

public class QuestionDisplayTerms extends DisplayTerms {
    private final Log LOG = LogFactoryUtil.getLog(QuestionDisplayTerms.class);

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
        questionKeyword = ParamUtil.getString(portletRequest, SEARCH_QUESTION_KEYWORD);
        userNameKeyword = ParamUtil.getString(portletRequest, SEARCH_USER_NAME_KEYWORD);

        SimpleDateFormat defaultFormat = new SimpleDateFormat("MM/dd/yyyy");
        String updateDateStartString = ParamUtil.getString(portletRequest, SEARCH_UPDATE_DATE_START);
        try {
            updateDateStart = new Timestamp(defaultFormat.parse(updateDateStartString).getTime());
        } catch (ParseException e) {
            updateDateStart = new Timestamp(0L);
            LOG.trace(String.format(
                    "The string %s of updateDateStart can not parse to Date.", updateDateStartString), e);
        }

        String updateDateEndString = ParamUtil.getString(portletRequest, SEARCH_UPDATE_DATE_END);
        try {
            updateDateEnd = new Timestamp(defaultFormat.parse(updateDateEndString).getTime());
        } catch (ParseException e) {
            updateDateEnd = new Timestamp(System.currentTimeMillis());
            LOG.trace(String.format(
                    "The string %s of updateDateEnd can not parse to Date.", updateDateEndString), e);
        }
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
