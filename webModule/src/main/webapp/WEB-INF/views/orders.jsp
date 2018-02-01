<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                            <th>Статус</th>
                            <th>Действия</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="iter" value="1"/>
                        <c:forEach var="order" items="${orders}">
                            <tr>
                                <th scope="row"><a href="${pageContext.request.contextPath}/orders/${order.getId()}">${order.getId()}</a></th>
                                <td>${order.getTotalPrice()}</a></td>
                                <td>${order.getStatus().toString()}</td>
                                <td>
                                    <c:if test="${order.isPossibleToEdit()}">
                                        <a href="${pageContext.request.contextPath}/orders/${order.getId()}/return" class="btn btn-default" type="button">Вернуть в корзину</a>
                                    </c:if>
                                </td>
                            </tr>
                            <c:set var="iter" value="${iter+1}"/>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>