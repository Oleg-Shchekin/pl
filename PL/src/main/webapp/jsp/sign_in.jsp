<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<!DOCTYPE html>
<html lang="${locale}">
<head>
    <jsp:include page="head_tag.jsp"/>
</head>

<body>
<div class="">
    <div class="sign-up col-lg-4" style="color: darkslategray; margin:100px auto auto auto">
        <h3 class="mb-5"><fmt:message key="label.menu.sign.in"/></h3>
        <p style="color: red; font-size: 14px; margin:20px auto">
            ${requestScope.SignInFailedMessage}
        </p>
        <form class="sign_form" action="${pageContext.request.contextPath}/library/sign_in" method="post">
            <div class="form-group">
                <label for="email"><fmt:message key="label.sign.in.email"/> </label>
                <input type="email" class="form-control" id="email" placeholder="<fmt:message key="label.placeholder.sign.email"/>" name="email" required>
            </div>
            <div class="form-group">
                <label for="password"><fmt:message key="label.sign.in.password"/> </label>
                <input type="password" class="form-control" id="password" placeholder="<fmt:message key="MIN_PASSWORD"/> " name="password"
                       required>
            </div>
            <button type="submit" class="sign_button">
                <fmt:message key="label.menu.sign.in"/>
            </button>
        </form>
        <p class="mt-5"><fmt:message key="label.sign.in.do.not.have.account"/>
            <a href="${pageContext.request.contextPath}/jsp/sign_up.jsp"><fmt:message
                    key="label.sign.in.do.not.have.account.here"/> </a></p>
    </div>
</div>
</body>
</html>
