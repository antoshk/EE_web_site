
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    $(document).ready(function() {
        $.post("bucket/ajax/list/", function(data){
            $("#bucket-container").html(data);
        });

        $(document).on("click", ".increaseCount",
        function(){
            $.post("${pageContext.request.contextPath}/bucket/ajax/increase-product-count/"+$(this).attr("productId"), function(data){
                $("#bucket-container").html(data);
            });
        });
        $(document).on("click", ".decreaseCount",
        function(){
            $.post("${pageContext.request.contextPath}/bucket/ajax/decrease-product-count/"+$(this).attr("productId"), function(data){
                $("#bucket-container").html(data);
            });
        });
    });
</script>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">

			<h3 class="text-primary">
				Список товаров в корзине:
			</h3>

            <c:if test="${numProductsInBucket<1}">
                <p>Вы пока не добавили ни одного продукта в корзину</p>
            </c:if>

            <c:if test="${numProductsInBucket>0}">
                <div class="well">
                    <div class="row">
                        <div class="col-md-12" id="bucket-container">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-10">
                        </div>
                        <div class="col-md-2">
                             <a href="#" class="btn btn-primary" type="button">Оформить заказ</a>
                        </div>
                    </div>
                </div>
            </c:if>

		</div>
	</div>
</div>
