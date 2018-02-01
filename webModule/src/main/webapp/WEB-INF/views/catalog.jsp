<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
$(document).ready(function() {
    $(document).on("click", ".addToBucket",
    function(){
        $.post("${pageContext.request.contextPath}/bucket/ajax/add/"+$(this).attr("productId"), {productCount: 1}, function(data){
            $("#bucket_counter").html(data);
            alert("Товар добавлен");
        });
    });
});
</script>
<div class="row">
    <div class="col-md-12">
        <h3 class="text-primary">
            Товары
        </h3>
        <div class="well">
            <c:set var="count" value="0"/>
            <div class="row">
                <c:forEach var="product" items="${catalog}">
                    <div class="col-sm-4">
                        <div class="thumbnail">
                            <img alt="EE-shop product image" src="${pageContext.request.contextPath}/resources/images/products/${product.getImageURI()}" class="img-rounded"/>
                            <div class="caption">
                                <h3>
                                    ${product.getName()}
                                </h3>
                                <p>
                                    Описание: ${product.getDescription()}
                                </p>
                                <p>
                                    Цена: ${product.getPrice()}
                                </p>
                                <p>
                                    <security:authorize access="hasRole('USER')">
                                        <button class="btn btn-primary addToBucket" productId="${product.getId()}">В корзину</button>
                                    </security:authorize>
                                    <a class="btn" href="${pageContext.request.contextPath}/catalog/${product.getId()}">Подробнее</a>
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
                        <a href="${pageContext.request.contextPath}/catalog/page/${pagination.getPrevPage()}" class="btn btn-default" type="button"><</a>
                    </c:if>
                </div>
                <div class="col-md-2">
                    Страница ${pagination.getCurrentPage()} из ${pagination.getTotalPages()}
                </div>
                <div class="col-md-1">
                    <c:if test="${pagination.getNextPage() != 0}">
                        <a href="${pageContext.request.contextPath}/catalog/page/${pagination.getNextPage()}" class="btn btn-default" type="button">></a>
                    </c:if>
                </div>
                <div class="col-md-4"></div>
            </div>
        </div>
    </div>
</div>