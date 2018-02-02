<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script>
    $(document).ready(function() {
        $.get("${pageContext.request.contextPath}/admin/users/ajax", function(data){
            $("#users-container").html(data);
        });

        $(document).on("click", ".blockUser",
            function(){
                $.post("${pageContext.request.contextPath}/admin/users/"+$(this).attr("userId")+"/block", function(data){
                    $("#users-container").html(data);
                });
            }
        );

        $(document).on("click", ".unblockUser",
            function(){
                $.post("${pageContext.request.contextPath}/admin/users/"+$(this).attr("userId")+"/unblock", function(data){
                    $("#users-container").html(data);
                });
            }
        );
        $(document).on("click", ".deleteUser",
            function(){
                $.ajax({
                    url: "${pageContext.request.contextPath}/admin/users/"+$(this).attr("userId")+"/block",
                    type: 'DELETE',
                    success:
                        function(data){
                            $("#users-container").html(data);
                        }
                });
            }
        );
    });
</script>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">

			<h3 class="text-primary">
				Список пользователей:
			</h3>

            <div class="row">
                <div class="col-md-12" id="users-container">
                </div>
            </div>
		</div>
	</div>
</div>
