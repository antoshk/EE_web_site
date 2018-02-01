<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-md-12">
        <h3 class="text-primary">
            Новости
        </h3>
        <div class="well">
            <div class="row">
                <c:set var="count" value="0"/>
                <c:forEach var="pieceOfNews" items="${news}">
                    <div class="card p-3 col-12 col-md-6 col-lg-4">
                        <div class="card-wrapper">
                            <div class="card-img">
                                <img alt="News Image" src="${pageContext.request.contextPath}/download/news/${pieceOfNews.getPhotoURI()}" class="img-thumbnail" />
                            </div>
                            <div class="card-box">
                                <h4 class="card-title pb-3 mbr-fonts-style display-7">
                                    ${pieceOfNews.getNewsTilte()}
                                </h4>
                                <h6>Дата: ${pieceOfNews.getStringPublicationDate()}</h6>
                                <p class="mbr-text mbr-fonts-style display-7">
                                    ${pieceOfNews.getNewsBody()} <a href="${pageContext.request.contextPath}/news/${pieceOfNews.getId()}">Далее...</a>
                                </p>
                            </div>
                        </div>
                    </div>
                    <c:set var="count" value="${count+1}"/>
                    <c:if test="${count%3 == 0}">
                        <div class="clearfix"></div>
                    </c:if>
                </c:forEach>
            </div>

            <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-1">
                    <c:if test="${pagination.getPrevPage() != 0}">
                        <a href="${pageContext.request.contextPath}/news/page/${pagination.getPrevPage()}" class="btn btn-default" type="button"><</a>
                    </c:if>
                </div>
                <div class="col-md-2">
                    Страница ${pagination.getCurrentPage()} из ${pagination.getTotalPages()}
                </div>
                <div class="col-md-1">
                    <c:if test="${pagination.getNextPage() != 0}">
                        <a href="${pageContext.request.contextPath}/news/page/${pagination.getNextPage()}" class="btn btn-default" type="button">></a>
                    </c:if>
                </div>
                <div class="col-md-4"></div>
            </div>
        </div>
    </div>
</div>