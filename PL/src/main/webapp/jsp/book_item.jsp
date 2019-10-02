<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<div class="my_header_other d-flex">
    <jsp:include page="header.jsp"/>
</div>
<c:set var="book" value="${requestScope.book}"/>
<div class="book_wrapper title_list">
    <div class="container">
        <h3 class="title">
            <fmt:message key="label.book.item.title"/> ${book.title}
        </h3>
        <div class="book_item_image_information d-flex">
            <div class="book_item_image col-4">
                <img class="book_image" src="data:image/jpg;base64,${book.base64Image}">
            </div>
            <div class="book_item_information col-4">
                <p><b><fmt:message key="label.book.item.author"/> </b> ${book.author.firstName} ${book.author.lastName}</p>
                <p><b><fmt:message key="label.book.item.number.of.pages"/> </b> ${book.numberOfPages}</p>
                <p><b><fmt:message key="label.book.item.address"/> </b> ${book.address}</p>
                <p><b><fmt:message key="label.book.item.language"/> </b> ${book.bookLanguage}</p>
                <p><b><fmt:message key="label.book.item.publication.year"/> </b> ${book.publicationYear}</p>
                <p><b><fmt:message key="label.book.item.publication.office"/> </b> ${book.publicationOffice}</p>
            </div>
            <div class="book_item_information col-4">
                <div class="book_attributes mb-5">
                    <p><b><fmt:message key="label.book.attributes"/> </b></p>
                    <c:forEach var="attribute" items="${book.bookAttributes}">
                        <p class="book_item_attributes_item" style="margin: 5px"> - ${attribute.keyWord}</p>
                    </c:forEach>
                </div>
                <div class="catalogue_book_button">
                    <form class="order_book_form book_item_order_book_form"
                          action="${pageContext.request.contextPath}/library/book_item/order_book"
                          method="get">
                        <input type="hidden" value="/catalogue" name="from">
                        <input type="hidden" value="${book.id}" name="book_id">
                        <input type="submit" value="<fmt:message key="label.book.button.order"/>">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
