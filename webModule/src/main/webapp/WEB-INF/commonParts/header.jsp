<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Simple Instagram</title>

    <!-- Bootstrap -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">

  </head>
<body>

<div class="container">
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="${pageContext.request.contextPath}/">Simple Instagram</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
      <c:if test="${user != null}">
        <li><a href="${pageContext.request.contextPath}/?command=publish">Создать публикацию</a></li>
      </c:if>
        <li><a href="${pageContext.request.contextPath}/?command=resetDB">Обнулить БД</a></li>

      </ul>

      <ul class="nav navbar-nav navbar-right">

        <c:choose>
            <c:when test="${user == null}" >
                <li><a href="${pageContext.request.contextPath}/?command=login">Войти</a></li>
                <li><a href="${pageContext.request.contextPath}/?command=register">Регистрация</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="${pageContext.request.contextPath}/?command=profile">Личный кабинет</a></li>
                <li><a href="${pageContext.request.contextPath}/?command=logout">Выйти</a></li>
            </c:otherwise>
        </c:choose>

      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>


