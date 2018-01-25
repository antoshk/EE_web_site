<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form class="form-horizontal" method="post" modelAttribute="newUser">
    <fieldset>

        <!-- Form Name -->
        <legend>Регистрация</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="fullname">ФИО</label>
            <div class="col-md-4">
                <form:input id="fullname" name="fullname" type="text" placeholder="" class="form-control input-md" required="" path="fullName"/>
                <p class="bg-danger"><form:errors path="fullName" cssClass="error" /></p>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="email">Email</label>
            <div class="col-md-4">
                <form:input id="email" name="email" type="text" placeholder="" class="form-control input-md" required="" path="email"/>
                <p class="bg-danger"><form:errors path="email" cssClass="error" /></p>
            </div>
        </div>

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
            <label class="col-md-4 control-label" for="passwordrepeate">Повторите пароль</label>
            <div class="col-md-4">
                <form:input id="passwordrepeate" name="passwordrepeate" type="password" placeholder="" class="form-control input-md" required="" path="passwordRep"/>
                <p class="bg-danger"><form:errors path="passwordRep" cssClass="error" /></p>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="phone">Телефон</label>
            <div class="col-md-4">
                <form:input id="phone" name="phone" type="text" placeholder="" class="form-control input-md" required="" path="phone"/>
                <p class="bg-danger"><form:errors path="phone" cssClass="error" /></p>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="address">Адрес</label>
            <div class="col-md-4">
                <form:input id="address" name="address" type="text" placeholder="" class="form-control input-md" required="" path="address"/>
                <p class="bg-danger"><form:errors path="address" cssClass="error" /></p>
            </div>
        </div>

        <!-- Textarea -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="additionalInfo" >Дополнительная информация</label>
            <div class="col-md-4">
                <form:textarea class="form-control" id="additionalInfo" name="additionalInfo" path="additionalInfo"/>
                <p class="bg-danger"><form:errors path="additionalInfo" cssClass="error" /></p>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="register"></label>
            <div class="col-md-4">
                <button id="register" name="register" class="btn btn-primary">Зарегистрировать</button>
            </div>
        </div>

    </fieldset>
</form:form>


