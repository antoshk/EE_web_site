<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script type="text/javascript">
    $(document).ready(function() {

        $.get("${pageContext.request.contextPath}/news/${pieceOfNews.getId()}/comments", function(data){
            $("#comments-container").html(data);
        });

        /*  Submit form using Ajax */
        $('#sendComment').click(function(e) {

            //Prevent default submission of form
            e.preventDefault();

            //Remove all errors
            $('#message').next().remove();

            $.get( '${pageContext.request.contextPath}/news/${pieceOfNews.getId()}/commentsadd',
                {message: $('#message').val()},
                function(data) {
                    if(data.trim()[0] == 'e') {
                        $('#message').after('<span class="error">'+data.substr(2)+'</span>');
                    } else {
                        $('#message').val('');
                        $("#comments-container").html(data);
                    }
                }
            );
        });
    });
</script>
<div class="row">
    <div class="card p-3 col-md-12">
        <div class="card-wrapper">
            <div class="card-img">
                <img alt="News Image" src="${pageContext.request.contextPath}/download/news/${pieceOfNews.getPhotoURI()}" class="img-thumbnail" />
            </div>
            <div class="card-box">
                <h4 class="card-title pb-3 mbr-fonts-style display-7">
                    <c:out value="${pieceOfNews.getNewsTitle()}"/>
                </h4>
                <h6>Дата: <c:out value="${pieceOfNews.getStringPublicationDate()}"/></h6>
                <p class="mbr-text mbr-fonts-style display-7">
                    <c:out value="${pieceOfNews.getNewsBody()}"/>
                </p>
            </div>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-md-12">
        <h4 class="text-primary">
            Комментарии
        </h4>
        <div id="comments-container">
            <p>Комментарии</p>
        </div>
        <div class="row">
            <div class="col-md-12">
                <security:authorize access="isAuthenticated()">
                    <form class="form-horizontal">
                        <fieldset>

                            <!-- Textarea -->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="message">Сообщение</label>
                                <div class="col-md-4">
                                    <textarea class="form-control" id="message" name="message"></textarea>
                                </div>
                            </div>

                            <!-- Button -->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="sendComment"></label>
                                <div class="col-md-4">
                                    <button id="sendComment" name="sendComment" class="btn btn-primary">Отправить</button>
                                </div>
                            </div>

                        </fieldset>
                    </form>

                </security:authorize>
                <security:authorize access="isAnonymous()">
                    <p><spring:message code="comments.disabledForAnonymous"/></p>
                </security:authorize>
            </div>
        </div>
    </div>
</div>

