<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/ddm" prefix="liferay-ddm"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<portlet:actionURL name="addQuestion" var="addQuestionURL" />

<aui:form action="${addQuestionURL }" method="POST">
    <liferay-ddm:html
        classNameId="${classNameId }"
        classPK="${classPK }"
        fields="${fields }"
        checkRequired="true"
    />
    <aui:button type="submit" value="add" />
</aui:form>
