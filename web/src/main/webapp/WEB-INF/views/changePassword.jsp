<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form class="form-horizontal" method="post" modelAttribute="user">
    <fieldset>

        <!-- Form Name -->
        <legend>Смена пароля</legend>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="password">Пароль</label>
            <div class="col-md-4">
                <form:input id="password" name="password" type="password" placeholder="" class="form-control input-md" required="" path="password"/>
                <span class="help-block">Минимум 6 символов</span>
                <p class="bg-danger"><form:errors path="password" cssClass="error" /></p>
            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="confirmPassword">Повторите пароль</label>
            <div class="col-md-4">
                <form:input id="confirmPassword" name="confirmPassword" type="password" placeholder="" class="form-control input-md" required="" path="confirmPassword"/>
                <p class="bg-danger"><form:errors path="confirmPassword" cssClass="error" /></p>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="register"></label>
            <div class="col-md-4">
                <button id="register" name="register" class="btn btn-primary">Сохранить</button>
            </div>
        </div>

    </fieldset>
</form:form>