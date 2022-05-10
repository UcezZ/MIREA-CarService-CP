<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF8">
    <title>Автосервис uCarService - Профиль</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/fonts/productsans.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/styles.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/card.css">
</head>

<body>
    <%@ include file="header.jsp" %>
    <div class="main">
        <div class="card-wrapper flex-wrap">
            <c:forEach items="${allTransport}" var="transport">
                <div class="card">
                    <div class="card-header">${transport.getVin()}</div>
                    <table class="card-contents">
                        <tr>
                            <td>Идентификатор</td>
                            <td>${transport.getId()}</td>
                        </tr>
                        <tr>
                            <td>VIN</td>
                            <td>${transport.getVin()}</td>
                        </tr>
                        <tr>
                            <td>Тип транспорта</td>
                            <td>To be implemented</td>
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
                                ${transport.getRegNumber().subString((Integer)0, (Integer)6)}
                                <sup>${transport.getRegNumber().subString((Integer)6)}</sup>
                            </td>
                        </tr>
                        <tr>
                            <td>Год выпуска</td>
                            <td>${transport.getReleaseYear()}</td>
                        </tr>
                        <tr>
                            <td>Оказано услуг</td>
                            <td>To be implemented</td>
                        </tr>
                    </table>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
