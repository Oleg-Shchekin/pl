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
    <div class="my_header_main d-flex">
        <jsp:include page="header.jsp"/>
    </div>
    <form >
        <div >
            <font size="10" color="white"/>
            <fmt:message key="label.successful.registration"/>!</br>
            <fmt:message key="label.successful.registration"/>.</br>


        </div>
    </form>
    <div align="center">

        <font size="10" color="red"/>
        <fmt:message key="label.successful.registration"/>!</br>
        <fmt:message key="label.successful.registration"/>.</br>
        </br>

    </div>
</body>
</html>