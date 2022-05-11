<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF8">
    <title>Автосервис uCarService - Транспорт</title>
    <meta name="viewport" content="width=device-width, initial-scale=0.75">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/fonts/productsans.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/styles.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/card.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/card-state.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/bigbluebutton.css">
</head>

<body>
    <%@ include file="header.jsp" %>
    <div class="main">
        <c:if test="${allTransport.size() == 0}">
            <div class="card-wrapper error">
                <div class="card">
                    <div class="card-header">Нет транспорта!</div>
                    <div class="card-contents">
                        <span>Добавьте транспортные средства чтобы увидеть их здесь</span>
                    </div>
                </div>
            </div>
        </c:if>
        <div class="card-wrapper flex-wrap">
            <c:forEach items="${allTransport}" var="transport">
                <div class="card">
                    <div class="card-header">${transport.getBrand()} ${transport.getModel()}</div>
                    <table class="card-contents">
                        <tr>
                            <td>Идентификатор</td>
                            <td>${transport.getId()}</td>
                        </tr>
                        <tr>
                            <td>Тип транспорта</td>
                            <td>${transportTypeRepository.getCaption(transport.getIdTransportType())}</td>
                        </tr>
                        <tr>
                            <td>Марка</td>
                            <td>${transport.getBrand()}</td>
                        </tr>
                        <tr>
                            <td>Модель</td>
                            <td>${transport.getModel()}</td>
                        </tr>
                        <tr>
                            <td>Регистрационный номер</td>
                            <td>
                                ${fn:substring(transport.getRegNumber(), 0, 6)}<sup>${fn:substring(transport.getRegNumber(), 6, -1)}</sup>
                            </td>
                        </tr>
                        <tr>
                            <td>Год выпуска</td>
                            <td>${transport.getReleaseYear()}</td>
                        </tr>
                        <tr>
                            <td>
                                <a href="/service/${transport.getId()}">Оказано услуг</a>
                            </td>
                            <td>${serviceRepository.getCountByTransportId(transport.getId())}</td>
                        </tr>
                    </table>
                </div>
            </c:forEach>
            <div class="vertical-centerer-wrapper">
                <a class="big-blue-button add-car-icon" href="/transport/add"><span>Добавить транспорт</span></a>
            </div>
        </div>
    </div>
</body>
