<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row">
    <div class="col-md-12">
        <h3 class="text-primary">
            Товары
        </h3>
        <div class="well">
            <c:set var="count" value="0"/>
            <div class="row">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Стоимость</th>
                            <th>Пользователь</th>
                            <th>Статус</th>
                            <th>Действия</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="order" items="${orders}">
                            <tr>
                                <th scope="row"><c:out value="${order.getId()}"/></th>
                                <td><c:out value="${order.getTotalPrice()}"/></a></td>
                                <td><c:out value="${order.getUser().getEmail()}"/></a></td>
                                <td><c:out value="${order.getStatus().toString()}"/></td>
                                <td>
                                    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/admin/orders/${order.getId()}/edit">
                                        <select id="status" name="status" class="form-control">
                                          <option value="NEW">Новый</option>
                                          <option value="REVIEWING">Подготовка к доставке</option>
                                          <option value="IN_PROGRESS">В процессе доставки</option>
                                          <option value="DELIVERED">Доставлен</option>
                                        </select>
                                        <button id="add" name="add" class="btn btn-primary">Изменить статус</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>