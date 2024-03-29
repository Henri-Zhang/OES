<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ page import="priv.barrow.oes.portlet.model.Question"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%
    ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
    Question question = (Question) row.getObject();
    long questionOrder = question.getOrder();
    pageContext.setAttribute("questionOrder", questionOrder);
%>

<portlet:actionURL name="deleteQuestion" var="deleteQuestionURL">
    <portlet:param name="questionOrder" value="${questionOrder }"/>
</portlet:actionURL>
<liferay-ui:icon-menu>
    <liferay-ui:icon message="edit" image="edit" url="/edit-question?questionOrder=${questionOrder }" target="_blank" />
    <liferay-ui:icon message="view" image="view" url="/question-detail?questionOrder=${questionOrder }" target="_blank" />
    <liferay-ui:icon-delete message="delete" image="delete" confirmation="Are you sure to delete this question?" url="${deleteQuestionURL }" />
</liferay-ui:icon-menu>
