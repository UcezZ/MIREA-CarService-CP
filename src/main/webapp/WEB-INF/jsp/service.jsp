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
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/bigbluebutton.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/big-card-wrapper.css">
</head>

<body>
    <%@ include file="header.jsp" %>
    <div class="main">
        <c:if test="${errorCode == 1}">
            <div class="card-wrapper error">
                <div class="card">
                    <div class="card-header">Ошибка управления</div>
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
                <c:if test="${managerNewServices.size() > 0}">
                    <div class="card big">
                        <div class="card-header">Управление - нерассмотренные заявки</div>
                        <div class="card-wrapper flex-wrap">
                            <c:forEach items="${managerNewServices}" var="service">
                                <c:set var="transport" value="${transportRepository.get(service.getIdTransport())}" />
                                <c:set var="client" value="${userRepository.get(transport.getIdUser())}" />
                                <div class="card">
                                    <div class="card-header">${transport.getBrand()} ${transport.getModel()}</div>
                                    <form action="/service/accept" method="POST">
                                        <table class="card-contents">
                                            <tr>
                                                <td>Идентификатор</td>
                                                <td>${service.getId()}</td>
                                            </tr>
                                            <tr>
                                                <td>Категория услуги</td>
                                                <td>${serviceCategoryRepository.get(service.getIdServiceCategory()).getCaption()}</td>
                                            </tr>
                                            <tr>
                                                <td>Обслуживаемый транспорт</td>
                                                <td>
                                                    ${transport.getBrand()} ${transport.getModel()}, ${transport.getReleaseYear()}, ${fn:substring(transport.getRegNumber(), 0, 6)}<sup>${fn:substring(transport.getRegNumber(), 6, -1)}</sup>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Заявитель</td>
                                                <td>${client.getSummary()}</td>
                                            </tr>
                                            <tr>
                                                <td>Дата заявки</td>
                                                <td>${service.getCreationHumanReadable()}</td>
                                            </tr>
                                            <tr>
                                                <td>Описание</td>
                                                <td>${service.getDescription()}</td>
                                            </tr>
                                        </table>
                                        <input type="hidden" name="idService" value="${service.getId()}">
                                        <div class="submit-wrapper">
                                            <button type="submit">Принять</button>
                                        </div>
                                    </form>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </c:if>
                <c:if test="${managerActiveServices.size() > 0}">
                    <div class="card big">
                        <div class="card-header">Управление - принятые заявки</div>
                        <div class="card-wrapper flex-wrap">
                            <c:forEach items="${managerActiveServices}" var="service">
                                <c:set var="transport" value="${transportRepository.get(service.getIdTransport())}" />
                                <c:set var="client" value="${userRepository.get(transport.getIdUser())}" />
                                <div class="card">
                                    <div class="card-header">${transport.getBrand()} ${transport.getModel()}</div>
                                    <form action="/service/close" method="POST">
                                        <table class="card-contents">
                                            <tr>
                                                <td>Идентификатор</td>
                                                <td>${service.getId()}</td>
                                            </tr>
                                            <tr>
                                                <td>Категория услуги</td>
                                                <td>${serviceCategoryRepository.get(service.getIdServiceCategory()).getCaption()}</td>
                                            </tr>
                                            <tr>
                                                <td>Обслуживаемый транспорт</td>
                                                <td>
                                                    ${transport.getBrand()} ${transport.getModel()}, ${transport.getReleaseYear()}, ${fn:substring(transport.getRegNumber(), 0, 6)}<sup>${fn:substring(transport.getRegNumber(), 6, -1)}</sup>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Заявитель</td>
                                                <td>${client.getSummary()}</td>
                                            </tr>
                                            <tr>
                                                <td>Дата заявки</td>
                                                <td>${service.getCreationHumanReadable()}</td>
                                            </tr>
                                            <tr>
                                                <td>Описание</td>
                                                <td>${service.getDescription()}</td>
                                            </tr>
                                        </table>
                                        <input type="hidden" name="idService" value="${service.getId()}">
                                        <div class="submit-wrapper">
                                            <button type="submit">Завершить</button>
                                        </div>
                                    </form>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </c:if>
                <c:if test="${managerClosedServices.size() > 0}">
                    <div class="card big">
                        <div class="card-header">Управление - завершённые заявки</div>
                        <div class="card-wrapper flex-wrap">
                            <c:forEach items="${managerClosedServices}" var="service">
                                <c:set var="transport" value="${transportRepository.get(service.getIdTransport())}" />
                                <c:set var="client" value="${userRepository.get(transport.getIdUser())}" />
                                <div class="card">
                                    <div class="card-header">${transport.getBrand()} ${transport.getModel()}</div>
                                    <table class="card-contents">
                                        <tr>
                                            <td>Идентификатор</td>
                                            <td>${service.getId()}</td>
                                        </tr>
                                        <tr>
                                            <td>Категория услуги</td>
                                            <td>${serviceCategoryRepository.get(service.getIdServiceCategory()).getCaption()}</td>
                                        </tr>
                                        <tr>
                                            <td>Обслуживаемый транспорт</td>
                                            <td>
                                                ${transport.getBrand()} ${transport.getModel()}, ${transport.getReleaseYear()}, ${fn:substring(transport.getRegNumber(), 0, 6)}<sup>${fn:substring(transport.getRegNumber(), 6, -1)}</sup>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Заявитель</td>
                                            <td>${client.getSummary()}</td>
                                        </tr>
                                        <tr>
                                            <td>Дата заявки</td>
                                            <td>${service.getCreationHumanReadable()}</td>
                                        </tr>
                                        <tr>
                                            <td>Дата исполнения</td>
                                            <td>${service.getCompletionHumanReadable()}</td>
                                        </tr>
                                        <tr>
                                            <td>Описание</td>
                                            <td>${service.getDescription()}</td>
                                        </tr>
                                    </table>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </c:if>
            </c:if>
            <div class="card big">
                <div class="card-header">Запрошенные услуги</div>
                <div class="card-wrapper ${userNewServices.size() == 0 ? "flex-column" : "flex-wrap"}">
                    <c:if test="${userNewServices.size() == 0}">
                        <div class="card-wrapper error">
                            <div class="card">
                                <div class="card-header">Нет запрошенных услуг!</div>
                                <div class="card-contents">
                                    <span>Оставьте заявку на обслуживание транспорта,</span>
                                    <span>чтобы увидеть её здесь</span>
                                </div>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${userNewServices.size() > 0}">
                        <c:forEach items="${userNewServices}" var="service">
                            <c:set var="transport" value="${transportRepository.get(service.getIdTransport())}" />
                            <div class="card">
                                <div class="card-header">${transport.getBrand()} ${transport.getModel()}</div>
                                <table class="card-contents">
                                    <tr>
                                        <td>Идентификатор</td>
                                        <td>${service.getId()}</td>
                                    </tr>
                                    <tr>
                                        <td>Категория услуги</td>
                                        <td>${serviceCategoryRepository.get(service.getIdServiceCategory()).getCaption()}</td>
                                    </tr>
                                    <tr>
                                        <td>Обслуживаемый транспорт</td>
                                        <td>
                                            ${transport.getBrand()} ${transport.getModel()}, ${transport.getReleaseYear()}, ${fn:substring(transport.getRegNumber(), 0, 6)}<sup>${fn:substring(transport.getRegNumber(), 6, -1)}</sup>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Дата заявки</td>
                                        <td>${service.getCreationHumanReadable()}</td>
                                    </tr>
                                    <tr>
                                        <td>Описание</td>
                                        <td>${service.getDescription()}</td>
                                    </tr>
                                </table>
                            </div>
                        </c:forEach>
                    </c:if>
                    <div class="vertical-centerer-wrapper ${userNewServices.size() == 0 ? "row" : ""}">
                        <a class="big-blue-button add-service-icon" href="/service/add">
                            <span>Новая услуга</span>
                        </a>
                    </div>
                </div>
            </div>
            <c:if test="${userActiveServices.size() > 0}">
                <div class="card big">
                    <div class="card-header">Активные услуги</div>
                    <div class="card-wrapper flex-wrap">
                        <c:forEach items="${userActiveServices}" var="service">
                            <c:set var="transport" value="${transportRepository.get(service.getIdTransport())}" />
                            <div class="card">
                                <div class="card-header">${transport.getBrand()} ${transport.getModel()}</div>
                                <table class="card-contents">
                                    <tr>
                                        <td>Идентификатор</td>
                                        <td>${service.getId()}</td>
                                    </tr>
                                    <tr>
                                        <td>Категория услуги</td>
                                        <td>${serviceCategoryRepository.get(service.getIdServiceCategory()).getCaption()}</td>
                                    </tr>
                                    <tr>
                                        <td>Обслуживаемый транспорт</td>
                                        <td>
                                            ${transport.getBrand()} ${transport.getModel()}, ${transport.getReleaseYear()}, ${fn:substring(transport.getRegNumber(), 0, 6)}<sup>${fn:substring(transport.getRegNumber(), 6, -1)}</sup>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Исполнитель</td>
                                        <td>${userRepository.get(service.getIdManager()).getSummary()}</td>
                                    </tr>
                                    <tr>
                                        <td>Дата заявки</td>
                                        <td>${service.getCreationHumanReadable()}</td>
                                    </tr>
                                    <tr>
                                        <td>Описание</td>
                                        <td>${service.getDescription()}</td>
                                    </tr>
                                </table>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </c:if>
            <c:if test="${userClosedServices.size() > 0}">
                <div class="card big">
                    <div class="card-header">Выполненные услуги</div>
                    <div class="card-wrapper flex-wrap">
                        <c:forEach items="${userClosedServices}" var="service">
                            <c:set var="transport" value="${transportRepository.get(service.getIdTransport())}" />
                            <div class="card">
                                <div class="card-header">${transport.getBrand()} ${transport.getModel()}</div>
                                <table class="card-contents">
                                    <tr>
                                        <td>Идентификатор</td>
                                        <td>${service.getId()}</td>
                                    </tr>
                                    <tr>
                                        <td>Категория услуги</td>
                                        <td>${serviceCategoryRepository.get(service.getIdServiceCategory()).getCaption()}</td>
                                    </tr>
                                    <tr>
                                        <td>Обслуживаемый транспорт</td>
                                        <td>
                                            ${transport.getBrand()} ${transport.getModel()}, ${transport.getReleaseYear()}, ${fn:substring(transport.getRegNumber(), 0, 6)}<sup>${fn:substring(transport.getRegNumber(), 6, -1)}</sup>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Исполнитель</td>
                                        <td>${userRepository.get(service.getIdManager()).getSummary()}</td>
                                    </tr>
                                    <tr>
                                        <td>Дата заявки</td>
                                        <td>${service.getCreationHumanReadable()}</td>
                                    </tr>
                                    <tr>
                                        <td>Дата исполнения</td>
                                        <td>${service.getCompletionHumanReadable()}</td>
                                    </tr>
                                    <tr>
                                        <td>Описание</td>
                                        <td>${service.getDescription()}</td>
                                    </tr>
                                </table>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </c:if>
        </div>
    </div>
</body>
