<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" uri="/WEB-INF/tlds/bodytag" %>
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
<div class="title_list">
    <div class="container">
        <h2 class="title">
            <fmt:message key="label.home.books"/>
        </h2>

        <div class="books_list row">
            <c:forEach var="book" items="${requestScope.allBooks}">
                <div class="book_item col-6 mb-5">
                    <a href="${pageContext.request.contextPath}/library/book_item?book_id=${book.id}">
                        <div class="w-100 wrapper_image d-flex">
                            <div class="m-auto">
                                <img class="book_image" src="data:image/jpg;base64,${book.base64Image}">
                                <div class="book_attributes">
                                    <p class="book_attributes_title"><fmt:message key="label.book.attributes"/> </p>
                                    <c:forEach var="attribute" items="${book.bookAttributes}">
                                        <p class="book_attributes_item"> - ${attribute.keyWord}</p>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                        <div class="book_name_wrapper d-flex m-auto">
                            <div class="m-auto">
                                <p class="book_author">${book.author.firstName} ${book.author.lastName}</p>
                                <p class="book_name">"${book.title}"</p>
                            </div>
                        </div>
                    </a>
                    <div class="catalogue_book_button">
                        <form class="order_book_form"
                              action="${pageContext.request.contextPath}/library/book_item/order_book"
                              method="get">
                            <input type="hidden" value="/catalogue" name="from">
                            <input type="hidden" value="${book.id}" name="book_id">
                            <input type="submit" value="<fmt:message key="label.book.button.order"/> ">
                        </form>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
