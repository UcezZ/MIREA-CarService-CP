<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="header">
    <div class="logo-caption vertical-centerer-wrapper">
        <span>
            <a href="/">uCarService</a>
        </span>
    </div>
    <sec:authorize access="isAuthenticated()">
        <div class="menu-wrapper">
            <div class="menu">
                <a href="/" class="${pageName == "index" ? "selected" : ""}">Главная</a>
                <a href="/profile" class="${pageName == "profile" ? "selected" : ""}">Профиль</a>
                <a href="/service" class="${pageName == "service" ? "selected" : ""}">Услуги</a>
                <a href="/transport" class="${pageName == "transport" ? "selected" : ""}">Транспорт</a>
            </div>
        </div>
    </sec:authorize>
    <div class="auth-block">
        <sec:authorize access="isAuthenticated()">
            <div class="profile-icon vertical-centerer-wrapper"></div>
            <div class="vertical-centerer-wrapper">
                <span class="profile"><a href="/profile">${pageContext.request.userPrincipal.name}</a></span>
            </div>
        </sec:authorize>
        <div class="auth-buttons">
            <sec:authorize access="!isAuthenticated()">
                <c:if test="${not fn:contains(pageContext.request.requestURI, '/login')}">
                    <div class="vertical-centerer-wrapper">
                        <a href="/login">Войти</a>
                    </div>
                </c:if>
                <c:if test="${not fn:contains(pageContext.request.requestURI, '/register')}">
                    <div class="vertical-centerer-wrapper">
                        <a href="/register">Регистрация</a>
                    </div>
                </c:if>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <div class="vertical-centerer-wrapper">
                    <a href="/logout">Выйти</a>
                </div>
            </sec:authorize>
        </div>
    </div>
</div>
