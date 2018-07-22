<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <title>商品规格管理</title>
    <link rel="stylesheet" href="${rootURL}resources/css/bootstrap.min.css"/>


    <link rel="stylesheet" href="${rootURL}resources/css/font-awesome.min.css"/>

    <link rel="stylesheet" href="${rootURL}resources/css/common.css"/>
    <link rel="stylesheet" href="${rootURL}resources/css/dropzone.css"/>

    <link rel="stylesheet" href='${rootURL}resources/css/ace.min.css'/>
    <link rel="stylesheet" href="${rootURL}resources/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="${rootURL}resources/css/ace-skins.min.css"/>
    <!--[if IE 7]-->
    <link rel="stylesheet" href="${rootURL}resources/css/font-awesome-ie7.min.css"/>
    <!--[if lte IE 8]-->
    <link rel="stylesheet" href="${rootURL}resources/css/ace-ie.min.css"/>

    <script src="${rootURL}resources/js/ace-extra.min.js"></script>
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

<!--主屏-->
<div class="main-container" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.check('main-container', 'fixed')
        } catch (e) {
        }
    </script>

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

            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <h3 class="header smaller lighter blue">新增商品规格</h3>
                        <form class="form-horizontal add-goods-property-form" action="${ctx}/manage/goodsProperty/addGoodsProperty" method="post"
                              enctype="multipart/form-data" role="form">
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" > 商品名称 </label>

                                <div class="col-sm-9">
                                    <select name="goodsId">
                                        <c:forEach items="${goodsList}" var="goods">
                                            <option value="${goods.goodsId}">${goods.goodsName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="space-4"></div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right"> 商品规格名称 </label>

                                <div class="col-sm-9">
                                    <input type="text" id="goodsDiscount" name="propertyName" placeholder="商品规格名称"
                                           class="col-xs-10 col-sm-5"/>
                                </div>
                            </div>

                            <div class="space-4"></div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" > 规格参数 </label>

                                <div class="col-sm-9 tag">
                                    <input type="text" name="propertyMsgs" id="form-field-tags" placeholder="规格参数" />
                                </div>
                            </div>

                            <div class="space-4"></div>

                            <div class="clearfix form-actions">
                                <div class="col-md-offset-3 col-md-9">
                                    <button class="btn btn-info" id="addGoodsProperty" type="button">
                                        <i class="icon-ok bigger-110"></i>
                                        提交
                                    </button>

                                    &nbsp; &nbsp; &nbsp;
                                    <button class="btn" type="reset">
                                        <i class="icon-undo bigger-110"></i>
                                        重置
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div><!-- /.row -->
    </div><!-- /.page-content -->
</div><!-- /.main-content -->

    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="icon-double-angle-up icon-only bigger-110"></i>
    </a>
</body>
<script type="text/javascript" src="${rootURL}resources/js/jQuery.min.js"></script>
<script type="text/javascript" src="${rootURL}resources/js/jQuery.form.js"></script>
<script type="text/javascript" src="${rootURL}resources/js/common.js"></script>
<script type="text/javascript" src="${rootURL}resources/js/goods/goods-property-add.js"></script>
<script type="text/javascript" src="${rootURL}resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${rootURL}resources/js/typeahead-bs2.min.js"></script>
<script type="text/javascript" src="${rootURL}resources/js/dropzone.min.js"></script>
<script type="text/javascript" src="${rootURL}resources/js/ace-elements.min.js"></script>
<script type="text/javascript" src="${rootURL}resources/js/ace.min.js"></script>

<script type="text/javascript" src="${rootURL}resources/js/jquery-ui-1.10.3.custom.min.js"></script>
<script type="text/javascript" src="${rootURL}resources/js/jquery.ui.touch-punch.min.js"></script>
<script type="text/javascript" src="${rootURL}resources/js/chosen.jQuery.min.js"></script>
<script type="text/javascript" src="${rootURL}resources/js/fuelux/fuelux.spinner.min.js"></script>
<script type="text/javascript" src="${rootURL}resources/js/date-time/bootstrap-datepicker.min.js"></script>
<script type="text/javascript" src="${rootURL}resources/js/date-time/bootstrap-timepicker.min.js"></script>
<script type="text/javascript" src="${rootURL}resources/js/date-time/moment.min.js"></script>
<script type="text/javascript" src="${rootURL}resources/js/date-time/daterangepicker.min.js"></script>
<script type="text/javascript" src="${rootURL}resources/js/bootstrap-colorpicker.min.js"></script>
<script type="text/javascript" src="${rootURL}resources/js/jquery.knob.min.js"></script>
<script type="text/javascript" src="${rootURL}resources/js/jquery.autosize.min.js"></script>
<script type="text/javascript" src="${rootURL}resources/js/jquery.inputlimiter.1.3.1.min.js"></script>
<script type="text/javascript" src="${rootURL}resources/js/jquery.maskedinput.min.js"></script>
<script type="text/javascript" src="${rootURL}resources/js/bootstrap-tag.min.js"></script>
<script !src="">
    var tag_input = $('#form-field-tags');
    if(! ( /msie\s*(8|7|6)/.test(navigator.userAgent.toLowerCase())) )
    {
        tag_input.tag(
            {
                placeholder:tag_input.attr('placeholder'),
                source: ace.variable_US_STATES,
            }
        );
    }
    else {
        tag_input.after('<textarea id="'+tag_input.attr('id')+'" name="'+tag_input.attr('name')+'" rows="3">'+tag_input.val()+'</textarea>').remove();
    }
</script>
</html>