<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
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
                <div class="row">
                    <div class="col-md-4">
                        <div class="thumbnail">
                            <img alt="Bootstrap Thumbnail First" src="http://lorempixel.com/output/people-q-c-600-200-1.jpg" />
                            <div class="caption">
                                <h3>
                                    Thumbnail label
                                </h3>
                                <p>
                                    Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                                </p>
                                <p>
                                    <a class="btn btn-primary" href="#">Action</a> <a class="btn" href="#">Action</a>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="thumbnail">
                            <img alt="Bootstrap Thumbnail Second" src="http://lorempixel.com/output/city-q-c-600-200-1.jpg" />
                            <div class="caption">
                                <h3>
                                    Thumbnail label
                                </h3>
                                <p>
                                    Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                                </p>
                                <p>
                                    <a class="btn btn-primary" href="#">Action</a> <a class="btn" href="#">Action</a>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="thumbnail">
                            <img alt="Bootstrap Thumbnail Third" src="http://lorempixel.com/output/sports-q-c-600-200-1.jpg" />
                            <div class="caption">
                                <h3>
                                    Thumbnail label
                                </h3>
                                <p>
                                    Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                                </p>
                                <p>
                                    <a class="btn btn-primary" href="#">Action</a> <a class="btn" href="#">Action</a>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <div class="thumbnail">
                            <img alt="Bootstrap Thumbnail First" src="http://lorempixel.com/output/people-q-c-600-200-1.jpg" />
                            <div class="caption">
                                <h3>
                                    Thumbnail label
                                </h3>
                                <p>
                                    Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                                </p>
                                <p>
                                    <a class="btn btn-primary" href="#">Action</a> <a class="btn" href="#">Action</a>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="thumbnail">
                            <img alt="Bootstrap Thumbnail Second" src="http://lorempixel.com/output/city-q-c-600-200-1.jpg" />
                            <div class="caption">
                                <h3>
                                    Thumbnail label
                                </h3>
                                <p>
                                    Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                                </p>
                                <p>
                                    <a class="btn btn-primary" href="#">Action</a> <a class="btn" href="#">Action</a>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="thumbnail">
                            <img alt="Bootstrap Thumbnail Third" src="http://lorempixel.com/output/sports-q-c-600-200-1.jpg" />
                            <div class="caption">
                                <h3>
                                    Thumbnail label
                                </h3>
                                <p>
                                    Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                                </p>
                                <p>
                                    <a class="btn btn-primary" href="#">Action</a> <a class="btn" href="#">Action</a>
                                </p>
                            </div>
                        </div>
                    </div>
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
