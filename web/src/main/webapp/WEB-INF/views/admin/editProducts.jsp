<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="row">
    <div class="col-md-12">
        <h3 class="text-primary">
            Товары
        </h3>
        <div class="well">
            <div class="row">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Фото</th>
                            <th>Наименование</th>
                            <th>Цена</th>
                            <th>Действия</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="product" items="${catalog}">
                            <tr>
                                <th scope="row"><c:out value="${product.getId()}"/></th>
                                <td style="width:100px;">
                                    <div class="card-img">
                                        <img alt="Product Image" height="100px" src="${pageContext.request.contextPath}/download/products/${product.getImageURI()}" class="img-thumbnail" />
                                    </div>
                                </td>
                                <td><a href="${pageContext.request.contextPath}/admin/products/${product.getId()}"><c:out value="${product.getName()}"/></a></td>
                                <td><c:out value="${product.getPrice()}"/></td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/admin/products/${product.getId()}" class="btn btn-default" type="button">Редактрировать</a>
                                    <form action="${pageContext.request.contextPath}/admin/products/${product.getId()}/delete" method="POST"><button class="btn btn-default" >Удалить</button></form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <p><a href="${pageContext.request.contextPath}/admin/products/add" class="btn btn-primary" type="button">Добавить продукт</a></p>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-1">
        <c:if test="${pagination.getPrevPage() != 0}">
            <a href="${pageContext.request.contextPath}/admin/products/page/${pagination.getPrevPage()}" class="btn btn-default" type="button"><</a>
        </c:if>
    </div>
    <div class="col-md-2">
        Страница <c:out value="${pagination.getCurrentPage()}"/> из <c:out value="${pagination.getTotalPages()}"/>
    </div>
    <div class="col-md-1">
        <c:if test="${pagination.getNextPage() != 0}">
            <a href="${pageContext.request.contextPath}/admin/products/page/${pagination.getNextPage()}" class="btn btn-default" type="button">></a>
        </c:if>
    </div>
    <div class="col-md-4"></div>
</div>
