<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>系统登录 - 超市订单管理系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"/>
    <script type="text/javascript">
        /* if(top.location!=self.location){
              top.location=self.location;
         } */
    </script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
</head>
<body class="login_bg">
<section class="loginBox">
    <header class="loginHeader">
        <h1>超市订单管理系统</h1>
    </header>
    <section class="loginCont">
        <form class="loginForm" action="${pageContext.request.contextPath }/login.do" name="actionForm" id="actionForm"
              method="post">
            <div class="info">${MESS}</div>
            <div class="info">${UpdateMESS}</div>
            <div class="inputbox">
                <label for="userCode">用户名：</label>
                <input type="text" class="input-text" id="userCode" name="userCode" placeholder="请输入用户名" required
                       value="cxk666"/>
            </div>
            <div class="inputbox">
                <label for="userPassword">密码：</label>
                <input type="password" id="userPassword" name="userPassword" placeholder="请输入密码" required
                       value="0000000"/>
            </div>
            <div class="subBtn">
                <input type="submit" value="登录"/>
                <input type="reset" value="重置"/>
            </div>
        </form>
    </section>
    <center>
        <h1 class="typing" id="OneYan"></h1>
        <h2 class="typing" style="font-size: 14px;">
            <a href="https://hitokoto.cn/" style="text-decoration: none" target="_blank">@一言API
            </a>
        </h2>
    </center>
</section>
</body>
<style>
    .typing {
        font-size: 20px;
        /* 初始宽度为0 */
        width: 0;
        height: 30px;
        border-right: 1px solid darkgray;
        animation: write 4s steps(14) forwards,
        blink 0.5s steps(1) infinite;
        overflow: hidden;
        color: white;
        font-family: "Microsoft JhengHei UI", serif;
    }

    @keyframes write {
        0% {
            width: 0;
        }
        100% {
            width: 100%;
        }
    }

    @keyframes blink {
        50% {
            /* transparent是全透明黑色(black)的速记法，即一个类似rgba(0,0,0,0)这样的值。 */
            border-color: transparent; /* #00000000 */
        }
    }
</style>
<script type="text/javascript">
    $.post('https://v1.hitokoto.cn/?encode=text', function (res) {
        $("#OneYan").text(res);
    })
</script>
</html>
