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
                        <table class="card-contents" id="add-transport">
                            <tr>
                                <td>Тип транспорта</td>
                                <td>
                                    <select name="idTransport" form="add-transport">
                                        <option value="0">Выберите тип</option>
                                        <c:forEach items="${allTransportType}" var="transportType">
                                            <option value="${transportType.getId()}">${transportType.getCaption()}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>Марка</td>
                                <td><input name="brand" type="text" /></td>
                            </tr>
                            <tr>
                                <td>Модель</td>
                                <td><input name="model" type="text" /></td>
                            </tr>
                            <tr>
                                <td>Регистрационный номер</td>
                                <td><input name="regNumber" minlength="8" minlength="9" type="text" /></td>
                            </tr>
                            <tr>
                                <td>Год выпуска</td>
                                <td><input name="releaseYear" min="1900" max="${currentYear}" type="number" /></td>
                            </tr>
                        </table>
                        <div class="submit-wrapper">
                            <button type="submit">Добавить</button>
                        </div>
                    </form>
                </div>
            </div>
        </c:if>
    </div>
</body>
