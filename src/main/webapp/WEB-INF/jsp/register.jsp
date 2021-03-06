<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF8">
    <title>Автосервис uCarService - Регистрация</title>
    <meta name="viewport" content="width=device-width, initial-scale=0.75">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/fonts/productsans.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/styles.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/card.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/form.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/card-state.css">
    <link rel="icon" href="${contextPath}/resources/media/icons/favicon.ico" type="image/icon">
</head>

<body>
    <%@ include file="header.jsp" %>
    <div class="main">
        <c:if test="${errorCode != -1}">
            <div class="card-wrapper ${errorCode == 0 ? "success" : "error"}">
                <div class="card">
                    <div class="card-header">${errorCode == 0 ? "Успешная регистрация" : "Ошибка регистрации"}</div>
                    <div class="card-contents">
                        <c:choose>
                            <c:when test="${errorCode == 0}">
                                <span>Вы успешно зарегистрировались!</span>
                                <span>Используйте введенные при регистрации данные для входа.</span>
                                <a href="/login">Войти</a>
                            </c:when>
                            <c:when test="${errorCode == 1}">Имя или фамилия не указаны!</c:when>
                            <c:when test="${errorCode == 2}">Дата рождения не указана или указана неверно!</c:when>
                            <c:when test="${errorCode == 3}">Имя пользователя не указано!</c:when>
                            <c:when test="${errorCode == 4}">Указанное имя пользователя уже занято!</c:when>
                            <c:when test="${errorCode == 5}">Пароль не указан!</c:when>
                            <c:when test="${errorCode == 6}">Введённые пароли не совпадают!</c:when>
                            <c:when test="${errorCode == 7}">Логин и пароль не должны совпадать!</c:when>
                            <c:otherwise>undefined</c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </c:if>
        <c:if test="${errorCode != 0}">
            <div class="card-wrapper">
                <div class="card">
                    <div class="card-header">Регистрация клиента</div>
                    <form action="" method="POST" enctype="utf8">
                        <table class="card-contents">
                            <tr>
                                <td>Фамилия</td>
                                <td><input name="lastName" minlength="2" maxlength="64" value="${user.getLastName()}"/></td>
                            </tr>
                            <tr>
                                <td>Имя</td>
                                <td><input name="firstName" minlength="2" maxlength="64" value="${user.getFirstName()}"/></td>
                            </tr>
                            <tr>
                                <td>Отчество</td>
                                <td><input name="middleName" maxlength="64" value="${user.getMiddleName()}"/></td>
                            </tr>
                            <tr>
                                <td>Дата рождения</td>
                                <td><input type="date" name="birthDate" min="1900-01-01" max="${maxDate}" value="${user.getBirthDate()}"/></td>
                            </tr>
                            <tr>
                                <td>Логин</td>
                                <td><input name="username" value="${user.getUsername()}"/></td>
                            </tr>
                            <tr>
                                <td>Пароль</td>
                                <td><input type="password" name="password"/></td>
                            </tr>
                            <tr>
                                <td>Подтвердите пароль</td>
                                <td><input type="password" name="passwordConfirm"/></td>
                            </tr>
                        </table>
                        <div class="submit-wrapper">
                            <button type="submit">Зарегистирироваться</button>
                        </div>
                    </form>
                </div>
            </div>
        </c:if>
    </div>
</body>
