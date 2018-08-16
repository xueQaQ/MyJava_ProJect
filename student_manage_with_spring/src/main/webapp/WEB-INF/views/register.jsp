<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<jsp:include page="common/base.jsp"/>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8"/>
    <meta name="author" content="order by dede58.com"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>login</title>
    <link rel="stylesheet" type="text/css" href="/assets/css/normalize.css"/>
    <link rel="stylesheet" type="text/css" href="/assets/css/demo.css"/>
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="/assets/css/component.css"/>
    <!--[if IE]>
    <script src="/assets/js/html5.js"></script>
    <![endif]-->
    <script>
        function register() {
            document.getElementById("registerForm").submit();
        }

        function login() {
            window.location.href = "${basePath}/user/login";
        }
    </script>
</head>
<body>
<div class="container demo-1">
    <div class="content">
        <div id="large-header" class="large-header">
            <canvas id="demo-canvas"></canvas>
            <div class="logo_box">
                <h3>欢迎注册</h3>
                <form action="/user/register" id="registerForm" method="post" name="f">
                    <div class="input_outer">
                        <span class="u_user"></span>
                        <input name="userName" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户">
                    </div>
                    <div class="input_outer">
                        <span class="us_uer"></span>
                        <input name="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;" value=""
                               type="password" placeholder="请输入密码">
                    </div>
                    <div class="input_outer">
                        <span class="us_uer"></span>
                        <input name="passwordAgain" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"
                               value=""
                               type="password" placeholder="请再次输入密码">
                    </div>
                    <div class="mb2">
                        <a class="act-but submit" href="javascript:register();" style="color: #FFFFFF">注册</a> <a class="act-but submit"
                                                                                                                 href="javascript:login();"
                                                                                                                 style="color: #FFFFFF">登录</a>
                    </div>
                </form>
                <p><font color="red">${error}</font></p>
            </div>
        </div>
    </div>
</div><!-- /container -->
<script src="/assets/js/TweenLite.min.js"></script>
<script src="/assets/js/EasePack.min.js"></script>
<script src="/assets/js/rAF.js"></script>
<script src="/assets/js/demo-1.js"></script>
</body>
</html>