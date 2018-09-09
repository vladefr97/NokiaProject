<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="en">
<head>
    <!-- Подключаем bootstrap CSS,
        Spring boot автоматически замапит ресурс благодаря зависимости webjars в pom.xml -->
    <link rel="stylesheet" type="text/css" href="../../static/css/bootstrap.min.css" />



    <link href="${jstlCss}" rel="stylesheet" />
</head>
<body>

 <h1 style="text-align: center; margin: 10px;">Задание претендента на стажировку в компанию NOKIA</h1>

<h3>Задание выполнено с использованием Spring Boot для серверной части и технологии JSP для клиентской части</h3>
<h4 style="float: right;margin: 20px; font-style:italic;">Задание выполнил Ефремов Владислав</h4>

 <h2><button type="button" class="btn btn-info" style="display: inline-block;float: left; margin-left: 10px;"><a href="/all" style="color: white;">Список сотрудников</a></button></h2>
</body>
</html>