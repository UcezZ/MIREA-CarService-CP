<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF8">
  <title>Автосервис uCarService</title>
  <link rel="stylesheet" type="text/css" href="${contextPath}/resources/fonts/productsans.css">
  <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/styles.css">
</head>

<body>
<div class="header">
  <div class="logo-caption vertical-centerer-wrapper">
      <span>uCarService</span>
  </div>
  <div class="hdr-caption vertical-centerer-wrapper">
    <span>Профиль</span>
  </div>
  <div class="auth-block">
    <sec:authorize access="isAuthenticated()">
    <div class="profile-icon vertical-centerer-wrapper"></div>
    <div class="vertical-centerer-wrapper">
      <span class="profile">${pageContext.request.userPrincipal.name}</span>
    </div>
    <div class="vertical-centerer-wrapper">
      <a href="/logout">Выйти</a>
    </div>
    </sec:authorize>
    <sec:authorize access="!isAuthenticated()">
    <div class="vertical-centerer-wrapper">
      <a href="/login">Войти</a>
    </div>
    <div class="vertical-centerer-wrapper">
      <a href="/register">Регистрация</a>
    </div>
    </sec:authorize>
    </div>
  </div>
  <div class="main">
    <div class=
  </div>
  <div class="footer">
    <span class="copyright">Copyright UcezZ Co. 2022</span>
  </div>
</body>
