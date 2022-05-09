<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<div class="header">
    <div class="logo-caption vertical-centerer-wrapper">
        <span>uCarService</span>
    </div>
    
    <div class="auth-block">
        <sec:authorize access="isAuthenticated()">
            <div class="profile-icon vertical-centerer-wrapper"></div>
            <div class="vertical-centerer-wrapper">
                <span class="profile"><a href="/profile">${pageContext.request.userPrincipal.name}</a></span>
            </div>
        <c:if headerDefined=true>
            <div class="header-caption vertical-centerer-wrapper">
                <span>${headerCaption}</span>
            </div>
        </c:if>
        </sec:authorize>
        <div class="auth-buttons">
            <sec:authorize access="!isAuthenticated()">
                <div class="vertical-centerer-wrapper">
                    <a href="/login">Войти</a>
                </div>
                <div class="vertical-centerer-wrapper">
                    <a href="/register">Регистрация</a>
                </div>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <div class="vertical-centerer-wrapper">
                    <a href="/logout">Выйти</a>
                </div>
            </sec:authorize>
        </div>
    </div>
</div>