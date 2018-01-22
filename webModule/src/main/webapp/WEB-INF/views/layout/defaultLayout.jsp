<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>



<tiles:insertAttribute name="header" />

    <title>EE Shop <tiles:insertAttribute name="title" /></title>
  </head>
<body>

<div class="container">

<tiles:insertAttribute name="menu" />

<tiles:insertAttribute name="body" />

<tiles:insertAttribute name="footer" />