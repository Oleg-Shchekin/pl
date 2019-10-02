<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="t" uri="/WEB-INF/tlds/bodytag" %>


<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<!DOCTYPE html>
<html lang="${locale}">
<head>
    <jsp:include page="head_tag.jsp"/>
</head>
<body>
<div class="header_main_image">
    <div class="my_header_main d-flex">
        <jsp:include page="header.jsp"/>
    </div>
    <div class="container">
        <div class="main_phrase col-8">
            <p class="first"><fmt:message key="label.welcome"/></p>
            <%--<p class="second"><fmt:message key="label.welcome"/> </p>--%>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
