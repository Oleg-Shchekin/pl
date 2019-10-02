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
<div class="my_header_other d-flex">
    <jsp:include page="header.jsp"/>
</div>

<div class="wrapper_search">
    <div class="d-flex">
        <div class="search_book m-auto d-flex">
            <form class="search_form" action="${pageContext.request.contextPath}/library/search" method="get">
                <input required type="text" placeholder="<fmt:message key="label.search.placeholder"/>" name="search_param" minlength="5">
                <button class="search_button" type="submit">
                    <img class="search_image" src="../images/magnifying-glass.png">
                </button>
            </form>
        </div>
    </div>
    <div class="search_line">
    </div>
</div>

<div class="title_list">
    <div class="container">
        <h2 class="title">
            SEARCH FOR: ${requestScope.search_param}
        </h2>
        <c:if test="${requestScope.search_size == 0}">
            <h3 class="title">NOTHING WAS FOUND</h3>
        </c:if>
        <div class="books_list row">
            <c:forEach var="book" items="${requestScope.booksSearchByParam}">
                <div class="book_item col-6 mb-6">
                    <a href="${pageContext.request.contextPath}/library/book_item?book_id=${book.id}">
                        <div class="w-100 wrapper_image d-flex">
                            <div class="m-auto">
                                <img class="book_image" src="data:image/jpg;base64,${book.base64Image}">
                                <div class="book_attributes">
                                    <p class="book_attributes_title">Attributes:</p>
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
                            <input type="hidden" value="/search" name="from">
                            <input type="hidden" value="${book.id}" name="book_id">
                            <input type="submit" value="ORDER">
                        </form>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<div class="my_footer">
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>
