<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>点餐系统管理</title>
    <link rel="stylesheet" href='${rootURL}resources/css/ace.min.css'/>
    <link rel="stylesheet" href="${rootURL}resources/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="${rootURL}resources/css/ace-skins.min.css"/>
    <link rel="stylesheet" href="${rootURL}resources/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="${rootURL}resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${rootURL}resources/css/common.css"/>
    <!--[if IE 7]-->
    <link rel="stylesheet" href="${rootURL}resources/css/font-awesome-ie7.min.css"/>
    <!--[if lte IE 8]-->
    <link rel="stylesheet" href="${rootURL}resources/css/ace-ie.min.css"/>
    <meta charset="UTF-8">
    <title></title>
    <style>
        * {
            padding: 0;
            margin: 0;
            list-style: none;
        }

        .classA {
            width: 1143px;
            background: white;
            margin: 0 auto;
        }

        .class_main {
            width: 1000px;
            height: 200px;
            margin: 0 auto;
            background: aliceblue;
            margin-bottom: 20px;
            display: flex;
            align-items: center;
            box-shadow: 5px 5px 5px #888888;
            border-radius:10px;
        }

        .class_main_body {
            width: 900px;
            height: 180px;
            margin: 0 auto;
            background: aliceblue;
            align-items: center;
            display: flex;
        }

        .class_main_body_list {
            width: 780px;
            margin: 0 auto;
            justify-content: space-between;
            align-items: center;
            display: flex;
        }

        .main_body {
            width: 220px;
            height: 80px;
            display: inline-block;
            border: solid 1px #CCCCCC;
            box-shadow: 0px 0px 3px #888888;
        }

        .main_title {
            height: 50px;
            line-height: 50px;
            font-size: 16px;
            color: black;
            text-align: center;
        }

        .main_body p + p {
            text-align: center;
            font-size: 16px;
        }

        .close_title {
            width: 110px;
            height: 80px;
            line-height: 80px;
            font-size: 16px;
            text-align: center;
            display: inline-block;
        }

        .close_button {
            width: 220px;
            height: 80px;
            line-height: 80px;
            font-size: 16px;
            display: inline-block;
        }

        .button_d {
            border: none;
        }

        .wrap {
            float: left;
            margin-top: -6px;
        }

        label {
            margin: 1.5em auto;
        }

        input {
            position: absolute;
            left: -9999px;
        }

        .slider-v2 {
            position: relative;
            display: block;
            width: 5.5em;
            height: 3em;
            cursor: pointer;
            border-radius: 1.5em;
            transition: 350ms;
            background: linear-gradient(rgba(0, 0, 0, 0.07), rgba(255, 255, 255, 0)), #ddd;
            box-shadow: 0 0.07em 0.1em -0.1em rgba(0, 0, 0, 0.4) inset, 0 0.05em 0.08em -0.01em rgba(255, 255, 255, 0.7);
        }

        .slider-v2::after {
            position: absolute;
            content: '';
            width: 2em;
            height: 2em;
            top: 0.5em;
            left: 0.5em;
            border-radius: 50%;
            transition: 250ms ease-in-out;
            background: linear-gradient(#f5f5f5 10%, #eeeeee);
            box-shadow: 0 0.1em 0.15em -0.05em rgba(255, 255, 255, 0.9) inset, 0 0.2em 0.2em -0.12em rgba(0, 0, 0, 0.5);
        }

        .slider-v2::before {
            position: absolute;
            content: '';
            width: 4em;
            height: 1.5em;
            top: 0.75em;
            left: 0.75em;
            border-radius: 0.75em;
            transition: 250ms ease-in-out;
            background: linear-gradient(rgba(0, 0, 0, 0.07), rgba(255, 255, 255, 0.1)), #d0d0d0;
            box-shadow: 0 0.08em 0.15em -0.1em rgba(0, 0, 0, 0.5) inset, 0 0.05em 0.08em -0.01em rgba(255, 255, 255, 0.7), 0 0 0 0 rgba(68, 204, 102, 0.7) inset;
        }

        input:checked + .slider-v2::before {
            box-shadow: 0 0.08em 0.15em -0.1em rgba(0, 0, 0, 0.5) inset, 0 0.05em 0.08em -0.01em rgba(255, 255, 255, 0.7), 3em 0 0 0 rgba(68, 204, 102, 0.7) inset;
        }

        input:checked + .slider-v2::after {
            left: 3em;
        }

        .nody_main {
            width: 900px;
            height: 180px;
            margin: 0 auto;
            background: aliceblue;
        }

        .nody_title {
            font-size: 16px;
            line-height: 40px;
            padding-left: 20px;
        }

        .last_main {
            width: 780px;
            height: 100px;
            margin: 0 auto;
            background: aliceblue;
            justify-content: space-between;
            align-items: center;
            display: flex;
        }

        .last_main_button {
            width: 200px;
            height: 40px;
            line-height: 40px;
            text-align: center;
            display: inline-block;
            border: solid 1px #CCCCCC;
            box-shadow: 0px 0px 3px #888888;
            text-decoration: none;
            color: #000000;
        }
    </style>
</head>
<body>
<div class="navbar navbar-default" id="navbar">
    <script type="text/javascript">
        try {
            ace.settings.check('navbar', 'fixed')
        } catch (e) {
        }
    </script>
    <!--头部开始-->
    <div class="navbar-container" id="navbar-container">
        <%@include file="../header.jsp" %>
    </div><!-- /.container -->
    <!--头部结束-->
</div>
<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <a class="menu-toggler" id="menu-toggler" href="#">
            <span class="menu-text"></span>
        </a>

        <!--菜单开始-->
        <div class="sidebar" id="sidebar">
            <%@include file="../menu.jsp" %>
        </div>
        <!--菜单结束-->

        <div class="main-content">
            <div class="breadcrumbs" id="breadcrumbs">
                <script type="text/javascript">
                    try {
                        ace.settings.check('breadcrumbs', 'fixed')
                    } catch (e) {
                    }
                </script>

                <ul class="breadcrumb">
                    <li>
                        <i class="icon-home home-icon"></i>
                        <a href="#">首页</a>
                    </li>
                    <li class="active">控制台</li>
                </ul><!-- .breadcrumb -->
            </div>
            <div class="classA">
                <div class="class_main">
                    <div class="class_main_body">
                        <div class="class_main_body_list">
                            <div class="main_body">
                                <p class="main_title">今日订单总量</p>
                                <p>${orderCount}</p>
                            </div>
                            <div class="main_body">
                                <p class="main_title">今日营业额</p>
                                <p>${totalPrice}</p>
                            </div>
                            <div class="main_body">
                                <p class="main_title">空余餐位</p>
                                <p>${freeTableCount}</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="class_main">
                    <div class="class_main_body">
                        <div class="class_main_body_list">

                            <div class="close_title">
                                店家营业
                            </div>
                            <div class="close_button">
                                <div class="wrap">
                                    <input type="checkbox" id="s3"/>
                                    <label class="slider-v2" for="s3"></label>
                                </div>
                            </div>
                            <div class="close_button button_d">

                            </div>
                        </div>
                    </div>
                </div>
                <div class="class_main">
                    <div class="nody_main">
                        <p class="nody_title">常用功能</p>
                        <div class="last_main">
                            <a href="https://www.sxmbyd.com/manage/order/queryOrderPage" class="last_main_button">订单管理</a>
                            <a href="https://www.sxmbyd.com/manage/recharge/queryRechargeOrderPage" class="last_main_button">充值管理</a>
                            <a href="https://www.sxmbyd.com/manage/activity/queryActivityPage" class="last_main_button">活动管理</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
