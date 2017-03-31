<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<h1>${exam.name }</h1>
<h2>Completed Students:</h2>
<c:forEach items="${completedStudents }" var="student">
    <aui:a href="/review-exam?examId=${exam.examId }&studentId=${student.userId }">${student.fullName }</aui:a>
</c:forEach>
<h2>Uncompleted Students:</h2>
<c:forEach items="${uncompletedStudents }" var="student">
    <span>${student.fullName }</span>
</c:forEach>