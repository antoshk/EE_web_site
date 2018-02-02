<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="row">
    <div class="col-md-12">
        <h3 class="text-primary">
            Новости
        </h3>
        <div class="well">
            <div class="row">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Фото</th>
                            <th>Заголовок</th>
                            <th>Дата</th>
                            <th>Автор</th>
                            <th>Действия</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="piece" items="${news}">
                            <tr>
                                <th scope="row"><c:out value="${piece.getId()}"/></th>
                                <td style="width:100px;">
                                    <div class="card-img">
                                        <img alt="News Image" height="100px" src="${pageContext.request.contextPath}/download/news/${piece.getPhotoURI()}" class="img-thumbnail" />
                                    </div>
                                </td>
                                <td><a href="${pageContext.request.contextPath}/admin/news/${piece.getId()}"><c:out value="${piece.getNewsTitle()}"/></a></td>
                                <td><c:out value="${piece.getStringPublicationDate()}"/></td>
                                <td><c:out value="${piece.getUser().getFullName()}"/></td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/admin/news/${piece.getId()}" class="btn btn-default" type="button">Редактрировать</a>
                                    <form action="${pageContext.request.contextPath}/admin/news/${piece.getId()}/delete" method="POST"><button class="btn btn-default" >Удалить</button></form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <p><a href="${pageContext.request.contextPath}/admin/news/add" class="btn btn-primary" type="button">Добавить новость</a></p>
        </div>
    </div>
</div>

