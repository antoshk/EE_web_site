<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a id="main_menu_home" class="navbar-brand" href="${pageContext.request.contextPath}/">EE Shop</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <security:authorize access="hasRole('SUPERADMIN') or hasRole('ADMIN')">
                    <li><a href="${pageContext.request.contextPath}/admin/">Администрировать</a></li>
                </security:authorize>
                <li><a href="${pageContext.request.contextPath}/news">Новости</a></li>
                <li><a href="${pageContext.request.contextPath}/catalog">Каталог</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <security:authorize access="hasRole('USER')">
                    <li><a href="${pageContext.request.contextPath}/orders">Заказы</a></li>
                    <li><a href="${pageContext.request.contextPath}/profile">Личный кабинет</a></li>
                </security:authorize>
                <security:authorize access="isAnonymous()">
                    <li><a href="${pageContext.request.contextPath}/login?from=${currentURI}">Войти</a></li>
                    <li><a href="${pageContext.request.contextPath}/reg">Регистрация</a></li>
                </security:authorize>
                <security:authorize access="isAuthenticated()">
                        <li><a href="${pageContext.request.contextPath}/logout">Выйти</a></li>
                </security:authorize>
                <security:authorize access="hasRole('USER')">
                    <li id="bucket_counter"><a href="${pageContext.request.contextPath}/bucket">Корзина <span class="badge">${bucketService.getTotalCount()}</span></a></li>
                </security:authorize>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>


