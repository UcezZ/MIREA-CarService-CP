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
  <div class="logoCaption verticalCentererWrapper">
      <span>uCarService</span>
  </div>
  <div class="authBlock">
    <div class="profile-icon verticalCentererWrapper"></div>
    <sec:authorize access="isAuthenticated()">
    <div class="verticalCentererWrapper">
      <span class="profile">Username</span>
    </div>
    <div class="verticalCentererWrapper">
      <a href="/logout">Выйти</a>
    </div>
    </sec:authorize>
    <sec:authorize access="!isAuthenticated()">
    <div class="verticalCentererWrapper">
      <a href="/login">Войти</a>
    </div>
    <div class="verticalCentererWrapper">
      <a href="/register">Регистрация</a>
    </div>
    </sec:authorize>
    </div>
  </div>
  <div class="main">
<p></p>
    </div>
    <div class="footer">
        <span class="copyright">Copyright UcezZ Co. 2022</span>
    </div>
</body>
