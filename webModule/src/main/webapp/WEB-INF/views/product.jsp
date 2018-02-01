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
    <div class="col-sm-4">
        <div class="thumbnail">
            <img alt="EE-shop product image" src="${pageContext.request.contextPath}/download/products/${product.getImageURI()}" class="img-rounded"/>
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
                </p>
            </div>
        </div>
    </div>
</div>