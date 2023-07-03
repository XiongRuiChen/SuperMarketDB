<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--<%--%>
<%--String path = request.getContextPath();--%>
<%--String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";--%>
<%--%>--%>
<%@include file="head.jsp"%>
    <input type="hidden" id="path" name="path" value="/SMBMS"/>
    <input type="hidden" id="referer" name="referer" value="${pageContext.request.contextPath}/login.do"/>
    <div class="right">
        <img class="wColck" src="${pageContext.request.contextPath}/images/clock.jpg" alt=""/>
        <div class="wFont">
            <h2>${sessionScope.USER.userName}</h2>
            <p>欢迎来到超市订单管理系统!</p>
            <h3>${providerFail}</h3>
        </div>
    </div>
</section>
<%@include file="foot.jsp" %>

