<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">

			<h3 class="text-primary">
				Подтвердите заказ:
			</h3>

            <p>Заказчик: ${user.getFullName()}</p>
            <p>Адрес доставки: ${user.getAddress()}</p>
            <p>Контактный email: ${user.getEmail()}</p>

            <c:if test="${bucketService.getTotalCount()>0}">
                <div class="well">
                    <div class="row">
                        <div class="col-md-12" id="bucket-container">
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
                                    <c:forEach var="entry" items="${bucketService.getAll()}">
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
                            <form action="${pageContext.request.contextPath}/orders" method="POST"><button type="submit" class="btn btn-primary">Подтвердить заказ</button></form>
                        </div>
                    </div>
                </div>
            </c:if>

		</div>
	</div>
</div>
