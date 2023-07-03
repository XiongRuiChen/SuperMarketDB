<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="head.jsp"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
    $(function(){
        $("#rnewpassword").blur(function(){
            var newpwd = $("#newpassword").val();
            var rnewpwd = $("#rnewpassword").val();
            if (newpwd != '' && rnewpwd != '') {
                if (newpwd == rnewpwd) {
                    $("#rnewpassword").next().html("密码一致！").css("color","#0f0");
                } else {
                    $("#rnewpassword").next().html("密码不一致！").css("color","#f00");
                }
            } else {
                $("#rnewpassword").next().html("密码不能为空！").css("color","#f00");
            }
        })
    })
</script>
<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>密码修改页面</span>
    </div>
    <div class="providerAdd">
        <form id="userForm" name="userForm" method="post" action="${pageContext.request.contextPath}/UpdatePwd.do">
            <input type="hidden" id="userid" value="${user.id}">
            <!--div的class 为error是验证错误，ok是验证成功-->
            <div class="info">${UpdateMESS}</div>
            <div class="">
                <label for="oldPassword">旧密码：</label>
                <input type="password" name="oldpassword" id="oldpassword" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="newPassword">新密码：</label>
                <input type="password" name="newpassword" id="newpassword" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="rnewpassword">确认新密码：</label>
                <input type="password" name="rnewpassword" id="rnewpassword" value="">
                <font color="red"></font>
            </div>
            <div class="providerAddBtn">
                <!--<a href="#">保存</a>-->
                <input type="submit" name="save" id="save" value="保存" class="input-button">
            </div>
        </form>
    </div>
</div>
</section>
<%@include file="foot.jsp" %>
