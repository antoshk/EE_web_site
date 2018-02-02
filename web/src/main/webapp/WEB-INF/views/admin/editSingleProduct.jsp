<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form class="form-horizontal" method="post" modelAttribute="pieceOfNews" enctype="multipart/form-data">
    <fieldset>

        <!-- Form Name -->
        <legend>Изменить новость</legend>

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
            <label class="col-md-4 control-label" for="newsTitle">Заголовок</label>
            <div class="col-md-4">
                <form:input id="newsTitle" name="newsTitle" type="text" placeholder="" class="form-control input-md" required="" path="newsTitle"/>
                <p class="bg-danger"><form:errors path="newsTitle" cssClass="error" /></p>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="publicationDate">Дата публикации(гггг/мм/дд)</label>
            <div class="col-md-4">
                <form:input id="publicationDate" name="publicationDate" type="text" placeholder="" class="form-control input-md" required="" path="publicationDate"/>
                <p class="bg-danger"><form:errors path="publicationDate" cssClass="error" /></p>
            </div>
        </div>

        <!-- Textarea -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="newsBody" >Новость</label>
            <div class="col-md-4">
                <form:textarea class="form-control" id="newsBody" name="newsBody" path="newsBody"/>
                <p class="bg-danger"><form:errors path="newsBody" cssClass="error" /></p>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="register"></label>
            <div class="col-md-4">
                <button id="register" name="register" class="btn btn-primary">Обновить</button>
            </div>
        </div>

    </fieldset>
</form:form>


