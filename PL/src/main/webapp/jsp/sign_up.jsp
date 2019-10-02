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

<div class="">
    <div class="sign-up col-lg-4" style="color: gray; margin:100px auto auto auto">
        <h3 class="mb-3"><fmt:message key="label.sign.up.registration"/></h3>
        <p style="color: darkslategray; font-size: 14px; margin: 20px auto">
            ${requestScope.SignUpFailedMessage}
        </p>
        <form class="sign_form" action="${pageContext.request.contextPath}/library/sign_up" onsubmit="return validate();" method="post">
            <div class="form-group">
                <label for="first-name"><fmt:message key="label.sign.up.first.name"/> </label>
                <input type="text" class="form-control" id="first-name"
                       placeholder="<fmt:message key="label.placeholder.sign.first.name"/>" name="first_name"
                       required>
            </div>
            <div class="form-group">
                <label for="last-name"><fmt:message key="label.sign.up.last.name"/> </label>
                <input type="text" class="form-control" id="last-name"
                       placeholder="<fmt:message key="label.placeholder.sign.last.name"/> " name="last_name"
                       required>
            </div>
            <div class="form-group">
                <label for="telephone_number"><fmt:message key="label.sign.up.telephone.number"/> </label>
                <input type="text" class="form-control" id="telephone_number"
                       placeholder="<fmt:message key="PHONE_EXAMPLE"/> 380503332211 "
                       name="telephone_number" required>
            </div>
            <div class="form-group">
                <label for="email"><fmt:message key="label.sign.in.email"/> </label>
                <input type="email" class="form-control" id="email"
                       placeholder="<fmt:message key="label.sign.in.email"/> " name="email" required>
            </div>
            <div class="form-group">
                <label for="password"><fmt:message key="label.sign.in.password"/> </label>
                <input type="password" class="form-control" id="password"
                       placeholder="<fmt:message key="MIN_PASSWORD" />" name="password"
                       required>
            </div>
            <button type="submit" class="button">Sign Up</button>
        </form>
        <script>
            function validate() {
                var phone = document.getElementById("telephone_number");
                var firstName = document.getElementById("first-name");
                var lastName = document.getElementById("last-name");
                var userPassword = document.getElementById("password");
                var submitPassword = document.getElementById("confirmPassword");

                if (phone.value.toString().length != 12) {
                    phone.style.border = "2px solid red";
                    return false;
                } else {
                    phone.style.border = "1px solid blue"
                }

                if (!firstName.value || (firstName.value.toString().length > 50)) {
                    firstName.style.border = "2px solid red";
                    return false;
                } else {
                    firstName.style.border = "1px solid blue"
                }
                if (!lastName.value || (lastName.value.toString().length > 50)) {
                    lastName.style.border = "2px solid red";
                    return false;
                } else {
                    lastName.style.border = "1px solid blue"
                }

                if (userPassword.value.toString().length <= 5) {
                    userPassword.style.border = "2px solid red";
                    alert("Password must be 6 characters or more")
                    return false;
                } else {
                    userPassword.style.border = "1px solid blue"
                }

                if (submitPassword.value != userPassword.value) {
                    submitPassword.style.border = "2px solid red";
                    alert("Password fields do not match")
                    return false;
                } else {
                    submitPassword.style.border = "1px solid blue"
                }
                return true;
            }
        </script>

    </div>
</div>
</body>
</html>
