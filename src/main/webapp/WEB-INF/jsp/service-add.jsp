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
            <div class="card-wrapper error">
                <div class="card">
                    <div class="card-header">Ошибка добавления</div>
                    <div class="card-contents">
                        <c:choose>
                            <c:when test="${errorCode == 1}">Транспорт не выбран!</c:when>
                            <c:when test="${errorCode == 2}">Категория услуги не выбрана!</c:when>
                            <c:when test="${errorCode == 3}">Пользователь не распознан!<br>Попробуйте перезайти в аккаунт.</c:when>
                            <c:when test="${errorCode == 4}">Транспорт не пренадлежит вошедшему пользователю!</c:when>
                            <c:otherwise>undefined</c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </c:if>
        <c:if test="${errorCode != 0}">
            <div class="card-wrapper">
                <div class="card">
                    <div class="card-header">Добавление заявки на услугу</div>
                    <form action="" method="POST" id="add-service" enctype="utf8">
                        <table class="card-contents">
                            <tr>
                                <td>Обслуживаемый транспорт</td>
                                <td>
                                    <select name="idTransport" form="add-service">
                                        <c:choose>
                                            <c:when test="${service.getIdTransport() == 0}">
                                                <option value="0" selected>Выберите транспорт</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="0">Выберите транспорт</option>
                                            </c:otherwise>
                                        </c:choose>
                                        <c:forEach items="${allUserTransport}" var="transport">
                                            <c:choose>
                                                <c:when test="${transport.getId() == service.getIdTransport()}">
                                                    <option value="${transport.getId()}" selected>
                                                        ${transport.getBrand()}
                                                        ${transport.getModel()},
                                                        ${fn:substring(transport.getRegNumber(), 0, 6)}<sup>${fn:substring(transport.getRegNumber(), 6, -1)}</sup>,
                                                        ${transport.getReleaseYear()}
                                                    </option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${transport.getId()}">
                                                        ${transport.getBrand()}
                                                        ${transport.getModel()},
                                                        ${fn:substring(transport.getRegNumber(), 0, 6)}<sup>${fn:substring(transport.getRegNumber(), 6, -1)}</sup>,
                                                        ${transport.getReleaseYear()}
                                                    </option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>Тип обслуживания</td>
                                <td>
                                    <select name="idServiceCategory" form="add-service">
                                        <c:choose>
                                            <c:when test="${service.getId() == 0}">
                                                <option value="0" selected>Выберите категорию</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="0">Выберите категорию</option>
                                            </c:otherwise>
                                        </c:choose>
                                        <c:forEach items="${allServiceCategory}" var="serviceCategory">
                                            <c:choose>
                                                <c:when test="${service.getIdServiceCategory() == serviceCategory.getId()}">
                                                    <option value="${serviceCategory.getId()}" selected>${serviceCategory.getCaption()}</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${serviceCategory.getId()}">${serviceCategory.getCaption()}</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>Описание</td>
                                <td>
                                    <textarea name="description" form="add-service" maxlength="255" rows="1"
                                        placeholder="Добавьте описание услуги"></textarea>
                                </td>
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
