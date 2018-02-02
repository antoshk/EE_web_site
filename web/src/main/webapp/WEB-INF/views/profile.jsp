<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
            <p>ФИО: <c:out value="${user.getFullName()}"/></p>
			<p>Email: <c:out value="${user.getEmail()}"/></p>
			<p>Телефон: <c:out value="${user.getPhone()}"/></p>
			<p>Адрес: <c:out value="${user.getAddress()}"/></p>
			<p>Дополнительная информация: <c:out value="${user.getAdditionalInfo()}"/></p>
			<p>Роль: <c:out value="${user.getRole().toString()}"/></p>
			<p><a href="${pageContext.request.contextPath}/profile/edit" class="btn btn-default" type="button">Редактировать</a></p>
			<p><a href="${pageContext.request.contextPath}/profile/changePassword" class="btn btn-default" type="button">Сменить пароль</a></p>
		</div>
	</div>
</div>