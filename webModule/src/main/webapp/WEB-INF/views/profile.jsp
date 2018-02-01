<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
            <p>ФИО: ${user.getFullName()}</p>
			<p>Email: ${user.getEmail()}</p>
			<p>Телефон: ${user.getPhone()}</p>
			<p>Адрес: ${user.getAddress()}</p>
			<p>Дополнительная информация: ${user.getAdditionalInfo()}</p>
			<p>Роль: ${user.getRole().toString()}</p>
			<p><a href="${pageContext.request.contextPath}/profile/edit" class="btn btn-default" type="button">Редактировать</a></p>
			<p><a href="${pageContext.request.contextPath}/profile/changePassword" class="btn btn-default" type="button">Сменить пароль</a></p>
		</div>
	</div>
</div>