<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
		    <h3 class="text-primary">
                Пользователь:
        	</h3>
            <p>ФИО: ${user.getFullName()}</p>
			<p>Email: ${user.getEmail()}</p>
			<p>Телефон: ${user.getPhone()}</p>
			<p>Адрес: ${user.getAddress()}</p>
			<p>Дополнительная информация: ${user.getAdditionalInfo()}</p>
			<p>Роль: ${user.getRole().toString()}</p>
		</div>
	</div>

    <div class="row">
        <div class="col-md-12">
            <h3 class="text-primary">
                Сменить роль:
            </h3>
            <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/admin/users/${user.getId()}">
                <p>
                    <select id="role" name="role" class="form-control">
                        <option value="ROLE_USER">Пользователь</option>
                        <option value="ROLE_ADMIN">Администратор</option>
                        <option value="ROLE_SUPERADMIN">Суперадминистратор</option>
                    </select>
                </p>
                <p><button id="changeRole" name="changeRole" class="btn btn-primary">Изменить роль</button></p>
            </form>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <h3 class="text-primary">
                Сменить пароль:
                <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/admin/users/${user.getId()}">
                    <p><input id="password" name="password" type="password" placeholder="" class="form-control input-md" /></p>
                    <p><button id="changePassword" name="changePassword" class="btn btn-primary">Изменить пароль</button></p>
                </form>
            </h3>
        </div>
    </div>
</div>

