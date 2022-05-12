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
        <c:if test="${errorCode == 1}">
            <div class="card-wrapper error">
                <div class="card">
                    <div class="card-header">Ошибка</div>
                    <div class="card-contents">
                        <span>Не удалось выполнить последнее действие!</span>
                        <br>
                        <span>Перезайдите в аккаунт и повторите попытку.</span>
                    </div>
                </div>
            </div>
        </c:if>
        <div class="card-wrapper flex-column">
            <c:if test="${user.getIsManager()}">
                <c:if test="${managementNewServices.size() > 0}">
                    <div class="card big">
                        <div class="card-header">Управление - нерассмотренные заявки</div>
                        <div class="card-wrapper flex-wrap">
                            <div class="card">
                                <div class="card-header">14881337228332</div>
                                <form action="/accept" method="POST">
                                    <table class="card-contents">
                                        <tr>
                                            <td>Идентификатор</td>
                                            <td>1</td>
                                        </tr>
                                        <tr>
                                            <td>Категория услуги</td>
                                            <td>14881337228332</td>
                                        </tr>
                                        <tr>
                                            <td>Обслуживаемый транспорт</td>
                                            <td>1</td>
                                        </tr>
                                        <tr>
                                            <td>Дата заявки</td>
                                            <td>Ковёр-самолёт</td>
                                        </tr>
                                        <tr>
                                            <td>Описание</td>
                                            <td>бабаб</td>
                                        </tr>
                                    </table>
                                    <input type="hidden" name="idService" value="0">
                                    <div class="submit-wrapper">
                                        <button type="submit">Принять</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </c:if>
                <c:if test="${managementActiveServices.size() > 0}">
                    <div class="card big">
                        <div class="card-header">Управление - принятые заявки</div>
                        <div class="card-wrapper flex-wrap">
                            <div class="card">
                                <div class="card-header">14881337228332</div>
                                <form action="/close" method="POST">
                                    <table class="card-contents">
                                        <tr>
                                            <td>Идентификатор</td>
                                            <td>1</td>
                                        </tr>
                                        <tr>
                                            <td>Категория услуги</td>
                                            <td>14881337228332</td>
                                        </tr>
                                        <tr>
                                            <td>Обслуживаемый транспорт</td>
                                            <td>1</td>
                                        </tr>
                                        <tr>
                                            <td>Дата заявки</td>
                                            <td>Ковёр-самолёт</td>
                                        </tr>
                                        <tr>
                                            <td>Описание</td>
                                            <td>бабаб</td>
                                        </tr>
                                    </table>
                                    <input type="hidden" name="idService" value="0">
                                    <div class="submit-wrapper">
                                        <button type="submit">Завершить</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <c:if test="${managementClosedServices.size() > 0}">
                        <div class="card big">
                            <div class="card-header">Управление - завершённые заявки</div>
                            <div class="card-wrapper flex-wrap">
                                <div class="card">
                                    <div class="card-header">14881337228332</div>
                                    <table class="card-contents">
                                        <tr>
                                            <td>Идентификатор</td>
                                            <td>1</td>
                                        </tr>
                                        <tr>
                                            <td>Категория услуги</td>
                                            <td>14881337228332</td>
                                        </tr>
                                        <tr>
                                            <td>Обслуживаемый транспорт</td>
                                            <td>1</td>
                                        </tr>
                                        <tr>
                                            <td>Дата заявки</td>
                                            <td>Ковёр-самолёт</td>
                                        </tr>
                                        <tr>
                                            <td>Дата завершения</td>
                                            <td>Ковёр-самолёт</td>
                                        </tr>
                                        <tr>
                                            <td>Описание</td>
                                            <td>бабаб</td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </c:if>
                </c:if>
                <div class="card big">
                    <div class="card-header">Запрошенные услуги</div>
                    <div class="card-wrapper flex-wrap">
                        <div class="card">
                            <div class="card-header">14881337228332</div>
                            <table class="card-contents">
                                <tr>
                                    <td>Идентификатор</td>
                                    <td>1</td>
                                </tr>
                                <tr>
                                    <td>Категория услуги</td>
                                    <td>14881337228332</td>
                                </tr>
                                <tr>
                                    <td>Обслуживаемый транспорт</td>
                                    <td>1</td>
                                </tr>
                                <tr>
                                    <td>Дата заявки</td>
                                    <td>Ковёр-самолёт</td>
                                </tr>
                                <tr>
                                    <td>Описание</td>
                                    <td>бабаб</td>
                                </tr>
                            </table>
                        </div>
                        <div class="vertical-centerer-wrapper">
                            <a class="big-blue-button add-service-icon" href="/service/add"><span>Новая
                                    услуга</span></a>
                        </div>
                    </div>
                </div>
                <c:if test="${userActiveServices.size() > 0}">
                    <div class="card big">
                        <div class="card-header">Активные услуги</div>
                        <div class="card-wrapper flex-wrap">
                            <div class="card">
                                <div class="card-header">14881337228332</div>
                                <table class="card-contents">
                                    <tr>
                                        <td>Идентификатор</td>
                                        <td>1</td>
                                    </tr>
                                    <tr>
                                        <td>Категория услуги</td>
                                        <td>14881337228332</td>
                                    </tr>
                                    <tr>
                                        <td>Обслуживаемый транспорт</td>
                                        <td>1</td>
                                    </tr>
                                    <tr>
                                        <td>Исполнитель</td>
                                        <td>1жопа</td>
                                    </tr>
                                    <tr>
                                        <td>Дата заявки</td>
                                        <td>Ковёр-самолёт</td>
                                    </tr>
                                    <tr>
                                        <td>Описание</td>
                                        <td>бабаб</td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>
                    <c:if test="${userClosedServices.size() > 0}">
                        <div class="card big">
                            <div class="card-header">Выполненные услуги</div>
                            <div class="card-wrapper flex-wrap">
                                <div class="card">
                                    <div class="card-header">14881337228332</div>
                                    <table class="card-contents">
                                        <tr>
                                            <td>Идентификатор</td>
                                            <td>1</td>
                                        </tr>
                                        <tr>
                                            <td>Категория услуги</td>
                                            <td>14881337228332</td>
                                        </tr>
                                        <tr>
                                            <td>Обслуживаемый транспорт</td>
                                            <td>1</td>
                                        </tr>
                                        <tr>
                                            <td>Дата заявки</td>
                                            <td>Ковёр-самолёт</td>
                                        </tr>
                                        <tr>
                                            <td>Описание</td>
                                            <td>бабаб</td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </c:if>
        </div>
    </div>
</body>
