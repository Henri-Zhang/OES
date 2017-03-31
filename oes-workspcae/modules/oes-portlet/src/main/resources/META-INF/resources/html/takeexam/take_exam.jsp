<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<portlet:resourceURL var="resourceURL" />
<c:set var="questions" value="${exam.questions }" scope="request"/>
<aui:input name="size" type="hidden" value="${questions.size() }" />

<h1>${exam.name }</h1>
<aui:input name="resourceURL" type="hidden" value="<%=resourceURL.toString()%>" />
<aui:input name="examId" type="hidden" value="${exam.examId }" />
<aui:input name="studentId" type="hidden" value="${studentId }" />
<div class="take">
    <aui:button name="prevQuestion" value="Previous" icon="icon-backward" cssClass="btn-success switch-button prev" />
    <div class="question-container">
        <div class="question-list">
            <c:forEach items="${questions }" var="question" varStatus="status">
                <div class="question-card">
                    <h3 id="index">${status.count }</h3>
                    <span>${question.description }</span><br />
                    <c:set var="questionOrder" value="${question.order }" />
                    <c:choose>
                        <c:when test="${'A' eq resultMap[questionOrder] }">
                            <aui:input name="${questionOrder }" type="radio" value="A" label="${question.optionA }" checked="true" /><br />
                            <aui:input name="${questionOrder }" type="radio" value="B" label="${question.optionB }" /><br />
                            <aui:input name="${questionOrder }" type="radio" value="C" label="${question.optionC }" /><br />
                            <aui:input name="${questionOrder }" type="radio" value="D" label="${question.optionD }" /><br />
                        </c:when>
                        <c:when test="${'B' eq resultMap[questionOrder] }">
                            <small>A</small>
                            <aui:input name="${questionOrder }" type="radio" value="A" label="${question.optionA }" /><br />
                            <small>B</small>
                            <aui:input name="${questionOrder }" type="radio" value="B" label="${question.optionB }" checked="true" /><br />
                            <aui:input name="${questionOrder }" type="radio" value="C" label="${question.optionC }" /><br />
                            <aui:input name="${questionOrder }" type="radio" value="D" label="${question.optionD }" /><br />
                        </c:when>
                        <c:when test="${'C' eq resultMap[questionOrder] }">
                            <aui:input name="${questionOrder }" type="radio" value="A" label="${question.optionA }" /><br />
                            <aui:input name="${questionOrder }" type="radio" value="B" label="${question.optionB }" /><br />
                            <aui:input name="${questionOrder }" type="radio" value="C" label="${question.optionC }" checked="true" /><br />
                            <aui:input name="${questionOrder }" type="radio" value="D" label="${question.optionD }" /><br />
                        </c:when>
                        <c:when test="${'D' eq resultMap[questionOrder] }">
                            <aui:input name="${questionOrder }" type="radio" value="A" label="${question.optionA }" /><br />
                            <aui:input name="${questionOrder }" type="radio" value="B" label="${question.optionB }" /><br />
                            <aui:input name="${questionOrder }" type="radio" value="C" label="${question.optionC }" /><br />
                            <aui:input name="${questionOrder }" type="radio" value="D" label="${question.optionD }" checked="true" /><br />
                        </c:when>
                        <c:otherwise>
                            <aui:input name="${questionOrder }" type="radio" value="A" label="${question.optionA }" /><br />
                            <aui:input name="${questionOrder }" type="radio" value="B" label="${question.optionB }" /><br />
                            <aui:input name="${questionOrder }" type="radio" value="C" label="${question.optionC }" /><br />
                            <aui:input name="${questionOrder }" type="radio" value="D" label="${question.optionD }" /><br />
                        </c:otherwise>
                    </c:choose>
                    <hr />
                </div>
            </c:forEach>
        </div>
    </div>
    <aui:button name="nextQuestion" value="Next" icon=" icon-forward" cssClass="btn-success switch-button next" />
</div>
<portlet:actionURL name="submit" var="submitURL">
    <portlet:param name="examId" value="${exam.examId }"/>
</portlet:actionURL>
<aui:button name="submit" href="${submitURL }" value="submit" cssClass="hide btn-primary btn-block" />
