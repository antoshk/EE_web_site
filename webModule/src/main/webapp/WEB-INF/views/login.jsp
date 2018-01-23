<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<form:form class="form-horizontal" modelAttribute="user" method="POST">
    <fieldset>

        <!-- Form Name -->
        <legend>Войти</legend>

        <!-- Text input-->
        <div class="form-group">
            <form:label class="col-md-4 control-label" for="username" path="username">Имя пользователя</form:label>
            <div class="col-md-4">
                <form:input id="login_email" name="login_email" type="text" placeholder="" class="form-control input-md" required="" path="username"/>

            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <form:label class="col-md-4 control-label" for="password" path="password">Пароль</form:label>
            <div class="col-md-4">
                <form:input id="login_password" name="login_password" type="password" placeholder="" class="form-control input-md" required="" path="password"/>

            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="login_submit" name="login_submit" class="btn btn-success">Войти</button>
            </div>
        </div>

    </fieldset>
</form:form>

