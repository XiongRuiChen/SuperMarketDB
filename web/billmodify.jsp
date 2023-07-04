<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="head.jsp"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>订单管理页面 >> 订单修改页面</span>
        </div>
        <div class="providerAdd">
          <s:form id="billForm" name="billForm" method="post" action="${pageContext.request.contextPath}/updateBill.do" modelAttribute="bill">
               <s:hidden path="id"/>
                <div>
                    <label for="billCode">订单编码：</label>
                    <s:input path="billCode"/>
                </div>
                <div>
                    <label for="productName">商品名称：</label>
                    <s:input path="productName"/>
					<font color="red"></font>
                </div>
              <div>
                  <label for="productDesc">商品描述：</label>
                  <s:input path="productDesc"/>
                  <font color="red"></font>
              </div>
                <div>
                    <label for="productUnit">商品单位：</label>
                    <s:input path="productUnit"/>
					<font color="red"></font>
                </div>
                <div>
                    <label for="productCount">商品数量：</label>
                    <s:input path="productCount"/>
					<font color="red"></font>
                </div>
                <div>
                    <label for="totalPrice">总金额：</label>
                    <s:input path="totalPrice"/>
					<font color="red"></font>
                </div>
              <div>
                  <label >供应商：</label>
                  <label for="providerId">
                      <select name="providerId" id="providerId">
                          <c:forEach items="${ProNames}" var="proNames" varStatus="loop">
                              <c:set var="index" value="${loop.index + 1}" />
                              <option value="${index}">${proNames}</option>
                          </c:forEach>
                      </select>
                  </label>

                  <font color="red"></font>
              </div>
                <div>
                    <label >是否付款：</label>
						<s:radiobutton path="isPayment" value="1"/>未付款
                   	    <s:radiobutton path="isPayment" value="2"/>已付款
                </div>
                <div class="providerAddBtn">
                    <p style="color: red;font-size: 14px;font-weight: bold">${UpdateMess}</p>
                  <input type="submit" name="save" id="save" value="保存">
				  <input type="button" id="back" name="back" onclick="javascript:window.history.back(-1);" value="返回"/>
              	</div>
            </s:form>
        </div>
    </div>
</section>
<%@include file="foot.jsp" %>