<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="head.jsp"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
  <div class="right">
      <div class="location">
          <strong>你现在所在的位置是:</strong>
          <span>供应商管理页面 >> 供应商修改页</span>
      </div>
      <div class="providerAdd">
          <p>${UpMess}</p>
          <s:form id="providerForm" name="providerForm" method="post" action="${pageContext.request.contextPath }/update.do" modelAttribute="provider">
            <s:hidden path="id"/>
              <div>
                  <label for="proCode">供应商编码：</label>
                  <s:input path="proCode"/>
              </div>
              <div>
                  <label for="proName">供应商名称：</label>
                 <s:input path="proName"/>
			<font color="red"></font>
              </div>
              
              <div>
                  <label for="proContact">联系人：</label>
                  <s:input path="proContact"/>
			<font color="red"></font>
              </div>
              
              <div>
                  <label for="proPhone">联系电话：</label>
                  <s:input path="proPhone"/>
			<font color="red"></font>
              </div>
              
              <div>
                  <label for="proAddress">联系地址：</label>
                  <s:input path="proAddress"/>
              </div>
              
              <div>
                  <label for="proFax">传真：</label>
                  <s:input path="proFax"/>
              </div>
              
              <div>
                  <label for="proDesc">描述：</label>
                  <s:textarea path="proDesc"/>
              </div>
              <div class="providerAddBtn">
                  <input type="submit" name="save" id="save" value="保存">
				  <input type="button" id="back" name="back" onclick="javascript:window.history.back(-1);" value="返回"/>
              </div>
          </s:form>
      </div>
  </div>
</section>
<%@include file="foot.jsp" %>