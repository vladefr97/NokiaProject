<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="en" xmlns:c="http://java.sun.com/xml/ns/javaee">
<hea>
    <!-- Подключаем bootstrap CSS,
        Spring boot автоматически замапит ресурс благодаря зависимости webjars в pom.xml -->
    <link rel="stylesheet" type="text/css" href="../../static/css/bootstrap.min.css"/>
    <!--
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
    <c:url value="/css/main.css" var="jstlCss"/>

    </head>
    <body>
    <h1 style="text-align:center; margin: 20px;">Employees List</h1>

    <table class="table table-hover table-bordered table-inverse align-content-center text-lg-center"
           style="margin:10px;">
        <tr style="">
            <td><h5>Имя</h5></td>
            <td><h5>ID</h5></td>
            <td><h5>Налогоплательщик</h5></td>
            <td><h5>Менеджеры</h5></td>
            <td><h5>Подчиненные</h5></td>
        </tr>

        <c:forEach var="i" items="${allEmployees}">

            <tr>
                <td> ${i.name}</td>
                <td> ${i.id}</td>
                <td> ${i.paysTaxes}</td>

                <
                <td>
                    <C:forEach var="p" items="${i.managersIDs}">
                        <a href="/employees/${p}">${p}</a>
                    </C:forEach>
                </td>
                <td>
                    <C:forEach var="p" items="${i.directReportsIDs}">
                        <a href="/employees/${p}">${p}</a>
                    </C:forEach>
                </td>
            </tr>

            <%-- <h2>${i.name}</h2>--%>

        </c:forEach>
    </table>

    <h2>
        <button type="button" class="btn btn-info" style="display: inline-block;float: left; margin-left: 10px;"><a
                href="/" style="color: white;">Главная страница</a></button>
    </h2>


    </body>
</html>