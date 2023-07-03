<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="head.jsp"%>

<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>订单管理页面</span>
    </div>
    <div class="search">
        <form method="get" action="${pageContext.request.contextPath }/billlist.do">
            <span>商品名称：</span>
            <input name="productName" type="text" value="${productName}">

            <span>供应商：</span>
            <select name="proName">
                <option value="">--请选择--</option>
                <c:forEach items="${proNames }" var="proNames">
                    <option value="${proNames}" <c:if test="${proName==proNames}">selected</c:if>>${proNames}</option>
                </c:forEach>
            </select>

            <span>是否付款：</span>
            <select name="isPayment">
                <option value="">--请选择--</option>
                <option value="1">未付款</option>
                <option value="2">已付款</option>
            </select>

            <input	value="查 询" type="submit" id="searchbutton">
            <a href="${pageContext.request.contextPath }/add">添加订单</a>
        </form>

    </div>
    <!--账单表格 样式和供应商公用-->
    <table class="providerTable" cellpadding="0" cellspacing="0">
        <tr class="firstTr">
            <th width="10%">订单编码</th>
            <th width="15%">供应商</th>
            <th width="15%">商品名称</th>
            <th width="5%">商品单位</th>
            <th width="10%">商品单价</th>
            <th width="10%">商品数量</th>

            <th width="10%">订单金额</th>
            <th width="5%">是否付款</th>
            <th width="10%">创建时间</th>
            <th width="30%">操作</th>
        </tr>
        <c:forEach items="${pageInfo.list}" var="bill">
            <tr>
                <td>
                    <span>${bill.billCode} </span>
                </td>

                <td>
                    <span>${bill.smbmsProvider.proName}</span>
                </td>

                <td>
                    <span>${bill.productName}</span>
                </td>

                <td>
                    <span>${bill.productUnit}</span>
                </td>

                <td>
                    <span>${bill.totalPrice/bill.productCount}￥</span>
                </td>

                <td>
                    <span>${bill.productCount}</span>
                </td>

                <td>
                    <span>${bill.totalPrice}￥</span>
                </td>
                <td>
                    <span>${bill.isPayment==1?"未付款":"已付款"}</span>
                </td>
                <td>
                    <span><f:formatDate value="${bill.creationDate}" pattern="yyyy-MM-dd"/></span>
                </td>
                <td>
                    <span><a class="viewBill" href="${pageContext.request.contextPath }view?id=${bill.id}&flag=update"><img src="${pageContext.request.contextPath }/images/read.png" alt="查看" title="查看"/></a></span>
                    <span><a class="modifyBill" href="${pageContext.request.contextPath }modify?id=${bill.id}&flag=update"><img src="${pageContext.request.contextPath }/images/xiugai.png" alt="修改" title="修改"/></a></span>
                    <span><a class="deleteBill" href="${pageContext.request.contextPath }del?id=${bill.id}"><img src="${pageContext.request.contextPath }/images/schu.png" alt="删除" title="删除"/></a></span>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div class="page-bar">
        <ul class="page-num-ul clearfix">
            <li>共${pageInfo.total}条记录&nbsp;&nbsp; ${pageInfo.pageNum}/${pageInfo.pages}页</li>
            <a href="${pageContext.request.contextPath }/billlist.do?n=${pageInfo.firstPage}&productName=${productName}&proName=${proName}&isPayment=${isPayment}">首页</a>
            <a href="${pageContext.request.contextPath }/billlist.do?n=${pageInfo.prePage}&productName=${productName}&proName=${proName}&isPayment=${isPayment}">上一页</a>
            <c:forEach items="${pageInfo.navigatepageNums}" var="num">
                <a href="${pageContext.request.contextPath }/billlist.do?n=${num}&productName=${productName}&proName=${proName}&isPayment=${isPayment}">${num}</a>
            </c:forEach>
            <a href="${pageContext.request.contextPath }/billlist.do?n=${pageInfo.nextPage}&productName=${productName}&proName=${proName}&isPayment=${isPayment}">下一页</a>
            <a href="${pageContext.request.contextPath }/billlist.do?n=${pageInfo.lastPage}&productName=${productName}&proName=${proName}&isPayment=${isPayment}">最后一页</a>
            &nbsp;&nbsp;
        </ul>
        <!--  <span class="page-go-form"><label>跳转至</label>
         <input type="text" name="inputPage" id="inputPage" class="page-key" />页
         <button type="button" class="page-btn" onClick=''>GO</button>
        </span> -->
    </div>
    </section>

    <!--点击删除按钮后弹出的页面-->
    <div class="zhezhao"></div>
    <div class="remove" id="removeBi">
        <div class="removerChid">
            <h2>提示</h2>
            <div class="removeMain">
                <p>你确定要删除该订单吗？</p>
                <a href="#" id="yes">确定</a>
                <a href="#" id="no">取消</a>
            </div>
        </div>
    </div>

    <%@include file="foot.jsp" %>
<%--    <script type="text/javascript" src="${pageContext.request.contextPath }/js/list.do.js"></script>--%>