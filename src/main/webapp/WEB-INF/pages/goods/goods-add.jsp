<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <title>商品管理</title>
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
                        <h3 class="header smaller lighter blue">新增商品</h3>
                        <form class="form-horizontal add-goods-form" action="${ctx}/manage/goods/addGoods" method="post"
                              enctype="multipart/form-data" role="form">
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 商品名称 </label>

                                <div class="col-sm-9">
                                    <input type="text" id="form-field-1" name="goodsName" placeholder="商品名称"
                                           class="col-xs-10 col-sm-5"/>
                                </div>
                            </div>

                            <div class="space-4"></div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-2"> 商品分类 </label>

                                <div class="col-sm-9">
                                    <select name="goodsCate" id="form-field-2">
                                        <c:forEach items="${cateList}" var="cate">
                                            <option value="${cate.cateId}">${cate.cateName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="space-4"></div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-2"> 商品类型 </label>

                                <div class="col-sm-9">
                                    单品 <input type="radio" id="singleProduct" value="0" name="goodsType" checked="checked"/>
                                    规格 <input type="radio" id="specifications" value="1" name="goodsType"/>
                                </div>

                                <div class="col-sm-9 tag hidden">
                                    <input type="text" name="property" id="form-field-tags" placeholder="商品规格" />
                                </div>
                            </div>

                            <div class="space-4"></div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-2"> 商品价格 </label>

                                <div class="col-sm-9">
                                    <input type="number" id="goodsPrice" name="goodsPrice" placeholder="商品价格"
                                           class="col-xs-10 col-sm-5"/>
                                </div>
                            </div>

                            <div class="space-4"></div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-2">
                                    商品优惠价 </label>

                                <div class="col-sm-9">
                                    <input type="number" id="goodsDiscount" name="goodsDiscount" placeholder="商品优惠价"
                                           class="col-xs-10 col-sm-5"/>
                                </div>
                            </div>

                            <div class="space-4"></div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-2">
                                    商品图片 </label>
                                <div class="col-sm-9" id="dropzone">

                                        <div class="widget-main">
                                            <input type="file" name="image" id="id-input-file-2" />
                                        </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-2">
                                    商品描述 </label>
                                <div class="col-sm-9">
                                    <textarea class="form-control" style="width: 350px;" id="form-field-8"
                                              placeholder="商品描述"></textarea>
                                </div>
                            </div>

                            <div class="clearfix form-actions">
                                <div class="col-md-offset-3 col-md-9">
                                    <button class="btn btn-info" id="addGoods" type="button">
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
<script type="text/javascript" src="${rootURL}resources/js/goods/goods-add.js"></script>
<script type="text/javascript" src="${rootURL}resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${rootURL}resources/js/typeahead-bs2.min.js"></script>
<script type="text/javascript" src="${rootURL}resources/js/dropzone.min.js"></script>
<script type="text/javascript" src="${rootURL}resources/js/ace-elements.min.js"></script>
<script type="text/javascript" src="${rootURL}resources/js/ace.min.js"></script>

<script type="text/javascript" src="${rootURL}resources/js/jquery-ui-1.10.3.custom.min.js"></script>
<script type="text/javascript" src="${rootURL}resources/js/jquery.ui.touch-punch.min.js"></script>
<script type="text/javascript" src="${rootURL}resources/js/chosen.jquery.min.js"></script>
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
                //enable typeahead by specifying the source array
                source: ace.variable_US_STATES,//defined in ace.js >> ace.enable_search_ahead
            }
        );
    }
    else {
        //display a textarea for old IE, because it doesn't support this plugin or another one I tried!
        tag_input.after('<textarea id="'+tag_input.attr('id')+'" name="'+tag_input.attr('name')+'" rows="3">'+tag_input.val()+'</textarea>').remove();
        //$('#form-field-tags').autosize({append: "\n"});
    }
</script>
</html>