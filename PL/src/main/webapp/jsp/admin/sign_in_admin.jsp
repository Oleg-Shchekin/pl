<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<fmt:setBundle basename="${bundle}"/>

<!DOCTYPE HTML>
<html lang="en">

<head>
    <jsp:include page="/jsp/head_tag.jsp"/>
</head>

<body style="background: white; background-size: cover; ">
<div class="">
    <div class="sign-up col-lg-4" style="color: darkslategray; margin:100px auto auto auto">
        <h3 class="mb-5"><fmt:message key="label.menu.sign.in"/></h3>
        <form class="sign_form" action="${pageContext.request.contextPath}/library/admin" method="post">
            <div class="form-group">
                <label for="login">Login:</label>
                <input type="text" class="form-control" id="login" placeholder="Enter login" name="login" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" placeholder="Enter password" name="password"
                       required>
            </div>
            <button type="submit" class="sign_button">
                Sign In
            </button>
        </form>
    </div>
</div>
</body>
</html>
