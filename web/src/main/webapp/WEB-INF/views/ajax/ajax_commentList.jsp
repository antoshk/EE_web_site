<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${hasErrors}">
    e:<spring:message code="comments.incorrectMessage"/>
</c:if>
<c:if test="${!hasErrors}">
    <c:forEach var="comment" items="${comments}">
        <div class="well">
            <p>
                <security:authorize access="hasRole('ADMIN') or hasRole('SUPERADMIN')">
                    <button class="btn btn-danger deleteComment" commentId="${comment.getId()}">Удалить комментарий</button>
                </security:authorize>
            </p>
            <div class="row">
                <div class="col-md-2">
                     <p><strong>Пользователь:</strong> <c:out value="${comment.getUser().getFullName()}"/></p>
                </div>
                <div class="col-md-10">
                     <p><c:out value="${comment.getMessage()}"/></p>
                </div>
            </div>
        </div>
    </c:forEach>
</c:if>