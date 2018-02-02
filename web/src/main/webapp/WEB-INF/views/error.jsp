<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
            <h3 class="text-primary">
                <spring:message code="exception.title"/>
            </h3>
            <spring:message code="exception.message"/>

            <form:form class="form-horizontal" method="post" modelAttribute="feedback" enctype="multipart/form-data">
                <fieldset>

                    <!-- Form Name -->
                    <legend><spring:message code="feedback.title"/></legend>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="email"><spring:message code="feedback.form.emailFieldName"/></label>
                        <div class="col-md-4">
                            <form:input id="email" name="email" type="text" placeholder="" class="form-control input-md" required="" path="email"/>
                            <p class="bg-danger"><form:errors path="email" cssClass="error" /></p>
                        </div>
                    </div>

                    <!-- Textarea -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="message" ><spring:message code="feedback.form.messageFieldName"/></label>
                        <div class="col-md-4">
                            <form:textarea class="form-control" id="message" name="message" path="message"/>
                            <p class="bg-danger"><form:errors path="message" cssClass="error" /></p>
                        </div>
                    </div>

                    <!-- Button -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="register"></label>
                        <div class="col-md-4">
                            <button id="register" name="register" class="btn btn-primary"><spring:message code="feedback.form.buttonCaption"/></button>
                        </div>
                    </div>

                </fieldset>
            </form:form>
		</div>
	</div>
</div>
