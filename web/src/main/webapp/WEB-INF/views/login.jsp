<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<form class="form-horizontal" method="POST">
    <fieldset>

        <!-- Form Name -->
        <legend>Вход</legend>

        <div>
            <c:if test="${param.error != null}">
                <div class="alert alert-danger">
                    <p>Invalid username and password.</p>
                </div>
            </c:if>
            <c:if test="${param.logout != null}">
                <div class="alert alert-success">
                    <p>You have been logged out successfully.</p>
                </div>
            </c:if>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="email" >Email</label>
            <div class="col-md-4">
                <input id="email" name="email" type="text" placeholder="" class="form-control input-md" required="" />
            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="password" path="password">Пароль</label>
            <div class="col-md-4">
                <input id="password" name="password" type="password" placeholder="" class="form-control input-md" required="" />
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="login_submit" name="login_submit" class="btn btn-success">Войти</button>
            </div>
        </div>

    </fieldset>
</form>

