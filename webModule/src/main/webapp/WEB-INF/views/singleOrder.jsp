<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">

			<h3 class="text-primary">
				Заказ номер: ${order.getId()}
			</h3>

			<p>Состояние заказа: ${order.getStatus().toString()}</p>

            <div class="well">
                <div class="row">
                    <div class="col-md-12">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Наименование</th>
                                    <th>Количество</th>
                                    <th>Стоимость</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:set var="iter" value="1"/>
                                <c:forEach var="entry" items="${order.getProducts().entrySet()}">
                                    <tr>
                                        <th scope="row">${iter}</th>
                                        <td>${entry.getKey().getName()}</td>
                                        <td>${entry.getValue()}</td>
                                        <td>${entry.getKey().getPrice()}</td>
                                    </tr>
                                    <c:set var="iter" value="${iter+1}"/>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>

                <p>Итого: ${totalPrice}</p>

                <div class="row">
                    <div class="col-md-10">
                    </div>
                    <div class="col-md-2">
                         <c:if test="${order.isPossibleToEdit()}">
                             <a href="${pageContext.request.contextPath}/orders/${order.getId()}/return" class="btn btn-default" type="button">Вернуть в корзину</a>
                         </c:if>
                    </div>
                </div>
            </div>

		</div>
	</div>
</div>
