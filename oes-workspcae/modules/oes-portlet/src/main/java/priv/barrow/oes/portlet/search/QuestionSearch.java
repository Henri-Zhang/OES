package priv.barrow.oes.portlet.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.liferay.portal.kernel.dao.search.SearchContainer;

import priv.barrow.model.QuestionRecordLink;

public class QuestionSearch extends SearchContainer<QuestionRecordLink> implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String EMPTY_RESULT_MESSAGE = "no-questions-found";

    static List<String> headerNames = new ArrayList<>();

    static {
        headerNames.add("Question Order");
        headerNames.add("Description");
        headerNames.add("Updated Date");
        headerNames.add("Updated user");
    }

    public QuestionSearch(PortletRequest portletRequest, PortletURL portletURL) {
        super(portletRequest, new QuestionDisplayTerms(portletRequest), new QuestionSearchTerms(portletRequest),
                DEFAULT_CUR_PARAM, DEFAULT_DELTA, portletURL, headerNames, EMPTY_RESULT_MESSAGE);

//        QuestionDisplayTerms displayTerms = (QuestionDisplayTerms) getDisplayTerms();
//        portletURL.setParameter(QuestionDisplayTerms.SEARCH_QUESTION_ORDER_START,
//                String.valueOf(displayTerms.getQuestionOrderStart()));
//        portletURL.setParameter(QuestionDisplayTerms.SEARCH_QUESTION_ORDER_END,
//                String.valueOf(displayTerms.getQuestionOrderEnd()));
//        portletURL.setParameter(QuestionDisplayTerms.SEARCH_UPDATE_DATE_START,
//                "sss");
//        portletURL.setParameter(QuestionDisplayTerms.SEARCH_UPDATE_DATE_END,
//                "sssss");
//        portletURL.setParameter(QuestionDisplayTerms.SEARCH_QUESTION_KEYWORD,
//                displayTerms.getQuestionKeyword());
//        portletURL.setParameter(QuestionDisplayTerms.SEARCH_QUESTION_ORDER_START,
//                displayTerms.getUserNameKeyword());

    }

}
