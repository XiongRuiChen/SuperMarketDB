<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/head.jsp"%>

<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>供应商管理页面 >> 供应商添加页面</span>
        </div>
        <div class="providerAdd">
           <form id="providerForm" name="providerForm" method="post" action="${pageContext.request.contextPath }/add">
                <div class="">
                    <label for="procode">供应商编码：</label>
                    <input type="text" name="procode" id="procode" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="proname">供应商名称：</label>
                   <input type="text" name="proname" id="proname" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="procontact">联系人：</label>
                    <input type="text" name="procontact" id="procontact" value=""> 
					<font color="red"></font>

                </div>
                <div>
                    <label for="prophone">联系电话：</label>
                    <input type="text" name="prophone" id="prophone" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="proaddress">联系地址：</label>
                    <input type="text" name="proaddress" id="proaddress" value="">
                    <font color="red"></font>
                </div>
                <div>
                    <label for="profax">传真：</label>
                    <input type="text" name="profax" id="profax" value="">
                    <font color="red"></font>
                </div>
                <div>
                    <label for="prodesc">描述：</label>
                    <input type="text" name="proDesc" id="proDesc" value="">
                    <font color="red"></font>
                </div>
                <div class="providerAddBtn">
                    <input type="submit" name="add" id="add" value="保存">
                    <input type="button" id="back" name="back" onclick="javascript:window.history.back(-1);" value="返回"/>	
                </div>
            </form>
     </div>
</div>
</section>
<%@include file="/foot.jsp" %>
<script type="text/javascript">
    $(document).ready(function() {
        // 表单提交事件处理程序
        $('#providerForm').submit(function(event) {
            // 遍历所有的输入框
            $('input[type="text"]').each(function() {
                var input = $(this);
                // 检查输入框的值是否为空
                if (input.val().trim() === '') {
                    // 如果为空，给输入框旁边添加提示信息
                    input.next('font').text('请输入信息');
                    // 阻止表单提交
                    event.preventDefault();
                }
            });
        });
    });

</script>