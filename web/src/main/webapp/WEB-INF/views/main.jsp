
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
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

<div class="container-fluid">

	<div class="row">
		<div class="col-md-12">
			<h3 class="text-primary">
				Новости
			</h3>
			<div class="well">
                <div class="row">

                    <c:forEach var="pieceOfNews" items="${news}">
                        <div class="card p-3 col-12 col-md-6 col-lg-4">
                            <div class="card-wrapper">
                                <div class="card-img">
                                    <img alt="News Image" src="${pageContext.request.contextPath}/download/news/${pieceOfNews.getPhotoURI()}" class="img-thumbnail" />
                                </div>
                                <div class="card-box">
                                    <h4 class="card-title pb-3 mbr-fonts-style display-7">
                                        <c:out value="${pieceOfNews.getNewsTitle()}"/>
                                    </h4>
                                    <h6>Дата: ${pieceOfNews.getStringPublicationDate()}</h6>
                                    <p class="mbr-text mbr-fonts-style display-7">
                                        <c:out value="${pieceOfNews.getNewsBody()}"/> <a href="${pageContext.request.contextPath}/news/${pieceOfNews.getId()}">Далее...</a>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="row">
                    <div class="col-md-10">
                    </div>
                    <div class="col-md-2">
                         <a href="${pageContext.request.contextPath}/news}" class="btn btn-primary" type="button">Больше новостей</a>
                    </div>
                </div>
			</div>
		</div>
	</div>



	<div class="row">
		<div class="col-md-12">
			<h3 class="text-primary">
				Товары
			</h3>
			<div class="well">
			    <c:set var="count" value="0"/>
                <div class="row">
                    <c:forEach var="product" items="${products}">
                        <div class="col-sm-4">
                            <div class="thumbnail">
                                <img alt="EE-shop product image" src="${pageContext.request.contextPath}/download/products/${product.getImageURI()}" class="img-rounded"/>
                                <div class="caption">
                                    <h3>
                                        <c:out value="${product.getName()}"/>
                                    </h3>
                                    <p>
                                        Описание: <c:out value="${product.getDescription()}"/>
                                    </p>
                                    <p>
                                        Цена: <c:out value="${product.getPrice()}"/>
                                    </p>
                                    <p>
                                        <button class="btn btn-primary addToBucket" productId="${product.getId()}">В корзину</button><a class="btn" href="${pageContext.request.contextPath}/catalog/${product.getId()}">Подробнее</a>
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
                    <div class="col-md-10">
                    </div>
                    <div class="col-md-2">
                         <a href="${pageContext.request.contextPath}/catalog" class="btn btn-primary" type="button">Больше товаров</a>
                    </div>
                </div>
			</div>
		</div>
	</div>
</div>
