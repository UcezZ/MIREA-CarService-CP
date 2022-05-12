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
                            <c:when test="${errorCode == 1}">Тип транспорта не выбран!</c:when>
                            <c:when test="${errorCode == 2}">Марка или модель транспорта не указана!</c:when>
                            <c:when test="${errorCode == 3}">Регистрационный номер не указан или указан неверно!</c:when>
                            <c:when test="${errorCode == 4}">Год выпуска не указан или указан неверно!</c:when>
                            <c:when test="${errorCode == 5}">Транспорт с таким регистрационным номером уже существует!</c:when>
                            <c:when test="${errorCode == 6}">Пользователь не распознан!<br>Попробуйте перезайти в аккаунт.</c:when>
                            <c:otherwise>undefined</c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </c:if>
        <c:if test="${errorCode != 0}">
            <div class="card-wrapper">
                <div class="card">
                    <div class="card-header">Добавление транспорта</div>
                    <form action="/transport/add" method="POST" id="add-transport" enctype="utf8">
                        <table class="card-contents">
                            <tr>
                                <td>Тип транспорта</td>
                                <td>
                                    <select name="transportType" form="add-transport">
                                        <c:choose>
                                            <c:when test="${transport.getIdTransportType() == 0}">
                                                <option value="0" selected>Выберите тип</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="0">Выберите тип</option>
                                            </c:otherwise>
                                        </c:choose>
                                        <c:forEach items="${allTransportType}" var="transportType">
                                            <c:choose>
                                                <c:when test="${transport.getIdTransportType() == transportType.getId()}">
                                                    <option value="${transportType.getId()}" selected>${transportType.getCaption()}</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${transportType.getId()}">${transportType.getCaption()}</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>Марка</td>
                                <td><input name="brand" type="text" value="${transport.getBrand()}" /></td>
                            </tr>
                            <tr>
                                <td>Модель</td>
                                <td><input name="model" type="text" value="${transport.getModel()}" /></td>
                            </tr>
                            <tr>
                                <td>Регистрационный номер</td>
                                <td><input name="regNumber" placeholder="А000АА000" minlength="8" minlength="9" type="text" value="${transport.getRegNumber()}" /></td>
                            </tr>
                            <tr>
                                <td>Год выпуска</td>
                                <td><input name="releaseYear" min="1900" max="${currentYear}" type="number" value="${transport.getReleaseYear() >= 1900 && transport.getReleaseYear() <= currentYear ? Integer.toString(transport.getReleaseYear()) : ""}" /></td>
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
