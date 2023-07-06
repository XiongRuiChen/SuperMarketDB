<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="head.jsp"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户修改页面</span>
        </div>
        <div class="providerAdd">
        <s:form  method="post" action="${pageContext.request.contextPath }/updateUser.do" modelAttribute="user">
        <s:hidden path="id"/>
			 <div>
                    <label for="userName">用户名称：</label>
                    <s:input path="userName"/>
					<font color="red"></font>
             </div>
			 <div>
                    <label >用户性别：</label>
                   	<s:radiobutton path="gender" value="1"/>男
                   	<s:radiobutton path="gender" value="2"/>女
             </div>
			 <div>
                    <label for="birthday">出生日期：</label>
					<s:input path="birthday" cssClass="Wdate" readonly="true" onclick="WdatePicker();"/>
                    <font color="red"></font>
              </div>
			
		       <div>
                    <label for="phone">用户电话：</label>
                    <s:input path="phone"/>
                    <font color="red"></font>
               </div>
                <div>
                    <label for="address">用户地址：</label>
                    <s:input path="address"/>
                </div>
				<div>
                    <label >用户角色：</label>
                    <!-- 列出所有的角色分类 -->
                    <label>
                        <select name="userRole">
                            <c:forEach items="${RoleNames}" var="RoleName" varStatus="loop">
                                <c:set var="index" value="${loop.index + 1}" />
                                <option value="${index}">${RoleName}</option>
                            </c:forEach>
                        </select>
                    </label>
                    <font color="red"></font>
                </div>
			 <div class="providerAddBtn">
                    <input type="submit" name="save" id="save" value="保存" /> 
                    <input type="button" id="back" name="back" onclick="window.history.back();" value="返回"/>
                </div>
            </s:form>
        </div>
    </div>
</section>
<%@include file="foot.jsp" %>
