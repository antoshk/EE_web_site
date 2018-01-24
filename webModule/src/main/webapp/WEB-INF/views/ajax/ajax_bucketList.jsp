
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table">
    <thead>
        <tr>
            <th>#</th>
            <th>Наименование</th>
            <th>Количество</th>
            <th>Действия</th>
        </tr>
    </thead>
    <tbody>
        <c:set var="iter" value="1"/>
        <c:forEach var="entry" items="${bucket}">
            <tr>
                <th scope="row">${iter}</th>
                <td><a href="${pageContext.request.contextPath}/products/${entry.getKey().getId()}">${entry.getKey().getName()}</a></td>
                <td>${entry.getValue()}</td>
                <td><button class="btn btn-default">-</button><button class="btn btn-default" type="submit">+</button></td>
            </tr>
            <c:set var="iter" value="${iter+1}"/>
        </c:forEach>
    </tbody>
</table>
