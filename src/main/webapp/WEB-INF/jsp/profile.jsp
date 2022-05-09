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
        <div class="card-wrapper">
            <div class="card">
                <div class="card-header">${user.getUsername()}</div>
                <table class="card-contents">
                    <tr>
                        <td>Идентификатор</td>
                        <td>${user.getId()}</td>
                    </tr>
                    <tr>
                        <td>Фамилия</td>
                        <td>${user.getLastName()}</td>
                    </tr>
                    <tr>
                        <td>Имя</td>
                        <td>${user.getFirstName()}</td>
                    </tr>
                    <tr>
                        <td>Отчество</td>
                        <td>${user.getMiddleName()}</td>
                    </tr>
                    <tr>
                        <td>Дата рождения</td>
                        <td>${user.getBirthDate()}</td>
                    </tr>
                    <tr>
                        <td>Роль</td>
                        <td>${user.getRole()}</td>
                    </tr>
                    <tr>
                        <td>
                            <a href="/transport">
                                Транспортные средства
                            </a>
                        </td>
                        <td>${transportCount}</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</body>
