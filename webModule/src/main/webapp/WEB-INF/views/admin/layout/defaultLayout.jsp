<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<tiles:insertAttribute name="header" />

    <title>EE Shop admin pages</title>
  </head>
<body>

<div class="container">

<tiles:insertAttribute name="menu" />

<tiles:insertAttribute name="body" />

<tiles:insertAttribute name="footer" />