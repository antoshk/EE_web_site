<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form class="form-horizontal" method="post" modelAttribute="user">
    <fieldset>

        <!-- Form Name -->
        <legend>Редактрировать профиль</legend>

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
                <button id="register" name="register" class="btn btn-primary">Сохранить</button>
            </div>
        </div>

    </fieldset>
</form:form>


