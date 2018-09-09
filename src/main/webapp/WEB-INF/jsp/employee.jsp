<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="en" xmlns:c="http://java.sun.com/xml/ns/javaee">
<head>
    <!-- Подключаем bootstrap CSS,
        Spring boot автоматически замапит ресурс благодаря зависимости webjars в pom.xml -->
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
    <!--
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
    <c:url value="/css/main.css" var="jstlCss" />
    <link href="${jstlCss}" rel="stylesheet" />
</head>
<body>
<h1>Employee </h1>


<h1>${employee.id}</h1>
<h2>${employee.paysTaxes}</h2>
<h2>${name}</h2>
<C:forEach var="p" items="${directReports}">
    <h1><a href="/employees/${p}">${p}</a></h1>
</C:forEach>


</body>
</html>