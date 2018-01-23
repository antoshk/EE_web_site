

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                                    <img alt="News Image" src="resources/images/news/${pieceOfNews.getPhotoURI()}" class="img-thumbnail" />
                                </div>
                                <div class="card-box">
                                    <h4 class="card-title pb-3 mbr-fonts-style display-7">
                                        ${pieceOfNews.getNewsTilte()}
                                    </h4>
                                    <h6>Дата: ${pieceOfNews.getStringPublicationDate()}</h6>
                                    <p class="mbr-text mbr-fonts-style display-7">
                                        ${pieceOfNews.getNewsBody()} <a href="http://mobirise.com">Далее...</a>
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
                         <a href="#" class="btn btn-primary" type="button">Больше новостей</a>
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
                                <img alt="EE-shop product image" src="resources/images/products/${product.getImageURI()}" class="img-rounded"/>
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
                                        <a class="btn btn-primary" href="#">В корзину</a> <a class="btn" href="#">Подробнее</a>
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
                         <a href="#" class="btn btn-primary" type="button">Больше товаров</a>
                    </div>
                </div>
			</div>
		</div>
	</div>
</div>
