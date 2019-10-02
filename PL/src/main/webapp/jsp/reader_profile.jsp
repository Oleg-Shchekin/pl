<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<c:if test="${not empty refuse}">
    <script type="text/javascript"> function alertName() {
        alert("YOU CAN NOT DELETE THIS ORDER!")
    }</script>
</c:if>
<script type="text/javascript"> window.onload = alertName;</script>
<div class="my_header_other d-flex">
    <jsp:include page="header.jsp"/>
</div>
<div class="title_list">
    <div class="container">
        <h2 class="title">
            PROFILE
        </h2>
        <p>
            Email: ${sessionScope.readerSession.email}
        </p>
        <p>
            Name: ${sessionScope.readerSession.firstName} ${sessionScope.readerSession.lastName}
        </p>
        <p>
            Telephone Number: ${sessionScope.readerSession.telephoneNumber}
        </p>

        <h3 class="mt-4">My orders:</h3>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Book title</th>
                <th scope="col">Order time</th>
                <th scope="col">Order status</th>
                <th scope="col">Delete order</th>
            </tr>
            </thead>
            <c:forEach items="${requestScope.orders}" var="order">
                <tr>
                    <td>${order.id}</td>
                    <td>${order.book.title}</td>
                    <td>${order.time}</td>
                    <td>${order.status}</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/library/reader_profile/delete_order"
                              method="post">
                            <input type="hidden" value="/reader_profile" name="from">
                            <input type="hidden" name="order_id" value="${order.id}">
                            <input type="submit" value="<fmt:message key="label.profile.order.delete"/>">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </div>
</div>
<div class="my_footer">
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>
