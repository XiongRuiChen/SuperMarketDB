<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="head.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>用户管理页面 >> 用户信息查看页面</span>
    </div>
    <div class="providerView">
        <s:form modelAttribute="user" action="submitForm">
            <input type="hidden" id="uid" value="${user.id}"/>
            <div>
                <label for="userCode">用户编码：</label>
                <input type="text" id="userCode" readonly="readonly" value="${user.userCode}"/>
            </div>
            <div>
                <label for="userName">用户名称：</label>
                <input type="text" id="userName" readonly="readonly" value="${user.userName}"/>
            </div>
            <div>
                <label for="gender">性别：</label>
                <input type="text" id="gender" readonly="readonly" value="${user.gender == 1 ? '女' : user.gender == 2 ? '男' : ''}"/>
            </div>
            <div>
                <label for="birthday">生日：</label>
                <fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd" var="formattedBirthday" />
                <input type="text" id="birthday" readonly="readonly" value="${formattedBirthday}" />
            </div>
            <div>
                <label for="phone">电话号码：</label>
                <input type="text" id="phone" readonly="readonly" value="${user.phone}"/>
            </div>
            <div>
                <label for="address">用户地址：</label>
                <input type="text" id="address" readonly="readonly" value="${user.address}"/>
            </div>
            <div>
                <label for="userRole">用户角色：</label>
                <input type="text" id="userRole" readonly="readonly"
                       value="${user.userRole == 1 ? '系统管理员' : user.userRole == 2 ? '经理' : user.userRole == 3 ? '普通员工' : ''}"/>
            </div>
        </s:form>
        <div class="providerAddBtn">
        <input type="button" id="back" name="back" onclick="javascript:window.history.back(-1);" value="返回"/>
    </div>
</div>
</section>
<%@include file="foot.jsp" %>