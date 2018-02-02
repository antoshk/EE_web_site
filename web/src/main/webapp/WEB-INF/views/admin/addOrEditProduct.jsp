<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form class="form-horizontal" method="post" modelAttribute="product" enctype="multipart/form-data">
    <fieldset>

        <!-- Form Name -->
        <legend><c:out value="${action}"/> товар</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="image">Изображение</label>
            <div class="col-md-4">
                <form:input type="file" name="image" path="image"/>
                <p class="bg-danger"><form:errors path="image" cssClass="error" /></p>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="name">Наименование</label>
            <div class="col-md-4">
                <form:input id="name" name="name" type="text" placeholder="" class="form-control input-md" required="" path="name"/>
                <p class="bg-danger"><form:errors path="name" cssClass="error" /></p>
            </div>
        </div>

        <!-- Textarea -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="description" >Описание</label>
            <div class="col-md-4">
                <form:textarea class="form-control" id="description" name="description" path="description"/>
                <p class="bg-danger"><form:errors path="description" cssClass="error" /></p>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="price">Цена</label>
            <div class="col-md-4">
                <form:input id="price" name="price" type="text" placeholder="" class="form-control input-md" required="" path="price"/>
                <p class="bg-danger"><form:errors path="price" cssClass="error" /></p>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="register"></label>
            <div class="col-md-4">
                <button id="register" name="register" class="btn btn-primary"><c:out value="${action}"/></button>
            </div>
        </div>

    </fieldset>
</form:form>

