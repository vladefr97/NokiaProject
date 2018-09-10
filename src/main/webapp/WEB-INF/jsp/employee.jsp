<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="en" xmlns:c="http://java.sun.com/xml/ns/javaee">
<head>
    <!-- Подключаем bootstrap CSS,
        Spring boot автоматически замапит ресурс благодаря зависимости webjars в pom.xml -->
    <link rel="stylesheet" type="text/css" href="../../static/css/bootstrap.min.css" />
    <!--
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
    <c:url value="/css/main.css" var="jstlCss"/>
    <link href="${jstlCss}" rel="stylesheet"/>
</head>
<body>

<table class="table table-hover table-bordered table-inverse align-content-center text-lg-center" style="margin:10px;">
    <tr style="">
        <td><h5>Имя</h5></td>
        <td><h5>ID</h5></td>
        <td><h5>Налогоплательщик</h5></td>
        <td><h5>Менеджеры</h5></td>
        <td><h5>Подчиненные</h5></td>
    </tr>

    <tr>
        <td> ${name}</td>
        <td> ${id}</td>
        <td> ${paysTaxes}</td>


        <td>
            <C:forEach var="p" items="${managersIDs}">
                <a href="/employees/${p}">${p}</a>
            </C:forEach>
        </td>
        <td>
            <C:forEach var="p" items="${directReportsIDs}">
                <a href="/employees/${p}">${p}</a>
            </C:forEach>
        </td>
    </tr>

    <%-- <h2>${i.name}</h2>--%>


</table>


<h2><button type="button" class="btn btn-info" style="display: inline-block;float: left; margin-left: 10px;"><a href="/" style="color: white;">Главная страница</a></button></h2>
<h2>
    <button type="button" class="btn btn-info" style="display: inline-block;float: left; margin-left: 10px;"><a
            href="/all" style="color: white;">Список сотрудников</a></button>
</h2>


</body>
</html>