
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table">
    <thead>
        <tr>
            <th>#</th>
            <th>Наименование</th>
            <th>Количество</th>
            <th>Стоимость</th>
            <th>Действия</th>
        </tr>
    </thead>
    <tbody>
        <c:set var="iter" value="1"/>
        <c:forEach var="entry" items="${bucket}">
            <tr>
                <th scope="row">${iter}</th>
                <td><a href="${pageContext.request.contextPath}/catalog/${entry.getKey().getId()}">${entry.getKey().getName()}</a></td>
                <td>${entry.getValue()}</td>
                <td>${entry.getKey().getPrice()}</td>
                <td><button class="btn btn-default decreaseCount" productId="${entry.getKey().getId()}">-</button><button class="btn btn-default increaseCount" type="submit" productId="${entry.getKey().getId()}">+</button></td>
            </tr>
            <c:set var="iter" value="${iter+1}"/>
        </c:forEach>
    </tbody>
</table>
