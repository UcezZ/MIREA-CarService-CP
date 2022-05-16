<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF8">
    <title>Автосервис uCarService - Вход</title>
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
        <c:if test="${errorCode == 1}">
            <div class="card-wrapper error">
                <div class="card">
                    <div class="card-header">Ошибка входа</div>
                    <div class="card-contents">
                        <span>Логин или пароль не распознаны!</span>
                    </div>
                </div>
            </div>
        </c:if>
        <div class="card-wrapper">
            <div class="card">
                <div class="card-header">Вход в аккаунт</div>
                <form action="" method="POST" enctype="utf8">
                    <table class="card-contents">
                            <td>Логин</td>
                            <td><input name="username"/></td>
                        </tr>
                        <tr>
                            <td>Пароль</td>
                            <td><input type="password" name="password"/></td>
                        </tr>
                    </table>
                    <div class="submit-wrapper">
                        <button type="submit">Войти</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
