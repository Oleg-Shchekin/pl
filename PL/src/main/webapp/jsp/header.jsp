<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<div class="container d-flex m-auto">
    <div class="language_menu col-6 d-flex justify-content-between">
        <div class="language">
            <div class="dropdown_language">
                <a class="dropdown_link" ><img src="/images/menu25.png" width="80"
                                               height="27" alt="MENU"></a>
                <div class="dropdown-content">
                    <a href="${pageContext.request.contextPath}/library/home">
                        <fmt:message key="label.menu.home"/>
                    </a>
                    <a href="${pageContext.request.contextPath}/library/catalogue">
                        <fmt:message key="label.menu.catalogue"/></a>

                    <a href="${pageContext.request.contextPath}/library/search">
                        <fmt:message key="label.menu.search"/></a>

                </div>
            </div>
        </div>
        <div class="menu d-flex">
            <a href="?locale=en"><img src="/images/change-language-eng.png" width="30"
                                      height="30" alt="Eng"></a>

            <a style="color: #8C4637">&#8195|&#8195</a>

            <a href="?locale=ua"><img src="/images/change-language-ua.png" width="30"
                                      height="30" alt="Укр"></a>


        </div>
    </div>
    <div class="sign_in col-6 text-right">
        <c:if test="${sessionScope.readerSession == null}">
            <a href="${pageContext.request.contextPath}/library/sign_in_page"><img src="/images/signinbut.png" width="80"
                                                                                   height="27" alt="SIGN IN"></a>
        </c:if>
        <c:if test="${sessionScope.readerSession != null}">
            <a href="${pageContext.request.contextPath}/library/reader_profile">
                <fmt:message key="label.menu.sign.profile"/>
            </a>
            <a style="color: #8C4637">&#8195|&#8195</a>
            <a href="${pageContext.request.contextPath}/library/log_out">
                <fmt:message key="label.menu.sign.up"/>
            </a>
        </c:if>
    </div>
</div>
