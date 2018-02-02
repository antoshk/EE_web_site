
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table">
    <thead>
        <tr>
            <th>Id</th>
            <th>Email</th>
            <th>ФИО</th>
            <th>Роль</th>
            <th>Состояние</th>
            <th>Действия</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <th scope="row"><c:out value="${user.getId()}"/></th>
                <td><c:out value="${user.getEmail()}"/></td>
                <td><c:out value="${user.getFullName()}"/></td>
                <td><c:out value="${user.getRole().toString()}"/></td>
                <td>
                    <c:if test="${user.getActive()}">Активен</c:if>
                    <c:if test="${!user.getActive()}">Заблокирован</c:if>
                </td>
                <td>
                    <c:if test="${user.getActive()}"><button class="btn btn-warning blockUser" userId="${user.getId()}">Блокировать</button></c:if>
                    <c:if test="${!user.getActive()}"><button class="btn btn-success unblockUser" userId="${user.getId()}">Разблокировать</button></c:if>
                    <button class="btn btn-danger deleteUser" userId="${user.getId()}">Удалить</button>
                    <a href="${pageContext.request.contextPath}/admin/users/${user.getId()}" class="btn btn-primary" type="button">Редактировать</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
