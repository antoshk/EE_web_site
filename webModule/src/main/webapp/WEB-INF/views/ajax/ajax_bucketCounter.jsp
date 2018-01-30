
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<a href="${pageContext.request.contextPath}/bucket">Корзина <span class="badge">${bucketService.getTotalCount()}</span></a>
