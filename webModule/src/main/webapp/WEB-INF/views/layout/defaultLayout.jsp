<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<tiles:insertAttribute name="header" />

    <title>EE Shop <tiles:insertAttribute name="title" /></title>
  </head>
<body>

<div class="container">

<tiles:insertAttribute name="menu" />


    <div class="row">
        <div class="col-md-12">
            <security:authorize access="isAuthenticated()">
                <p>Вы вошли как: ${userIdentifier}</p>
            </security:authorize>
            <security:authorize access="isAnonymous()">
                <p>Вы не авторизировались. Для совершения покупок необходима авторизация.</p>
            </security:authorize>
        </div>
    </div>

<tiles:insertAttribute name="body" />

<tiles:insertAttribute name="footer" />