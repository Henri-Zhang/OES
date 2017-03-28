<%
    System.out.println("########################");
    ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
    Question question = (Question) row.getObject();
    long questionOrder = question.getOrder();
    pageContext.setAttribute("questionOrder", questionOrder);
    System.out.println(questionOrder);
%>

<liferay-ui:icon-menu>
    <liferay-ui:icon image="edit" url="/edit-quesiton?questionOrder=<%= %>" target="_blank"/>
    <liferay-ui:icon image="view" url="/question-detail?questionOrder=<%= %>" target="_blank" />
</liferay-ui:icon-menu>
