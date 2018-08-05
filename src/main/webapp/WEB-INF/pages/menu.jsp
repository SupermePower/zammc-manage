<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<script type="text/javascript">
    try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
</script>

<div class="sidebar-shortcuts" id="sidebar-shortcuts">
    <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
        <button class="btn btn-success">
            <i class="icon-signal"></i>
        </button>

        <button class="btn btn-info">
            <i class="icon-pencil"></i>
        </button>

        <button class="btn btn-warning">
            <i class="icon-group"></i>
        </button>

        <button class="btn btn-danger">
            <i class="icon-cogs"></i>
        </button>
    </div>

    <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
        <span class="btn btn-success"></span>

        <span class="btn btn-info"></span>

        <span class="btn btn-warning"></span>

        <span class="btn btn-danger"></span>
    </div>
</div><!-- #sidebar-shortcuts -->

<ul class="nav nav-list">
    <li class="active">
        <a href="https://www.sxmbyd.com/manage">
            <i class="icon-dashboard"></i>
            <span class="menu-text"> 控制台 </span>
        </a>
    </li>

    <li>
        <a href="https://www.sxmbyd.com/manage/goods/queryGoodsPage" class="dropdown-toggle">
            <img style="width:20px;height:20px;" src="${rootURL}resources/images/foods-manage.png">
            <span class="menu-text"> 商品管理 </span>

            <b class="arrow icon-angle-down"></b>
        </a>
    </li>

    <li>
        <a href="https://www.sxmbyd.com/manage/goodsProperty/queryGoodsPropertyPage" class="dropdown-toggle">
            <img style="width:20px;height:20px;" src="${rootURL}resources/images/guige-manage.png">
            <span class="menu-text"> 商品规格管理 </span>

            <b class="arrow icon-angle-down"></b>
        </a>
    </li>

    <li>
        <a href="https://www.sxmbyd.com/manage/goodsCate/queryGoodsCatePage" class="dropdown-toggle">
            <img style="width:20px;height:20px;" src="${rootURL}resources/images/fenlei-manage.png">
            <span class="menu-text"> 商品分类 </span>

            <b class="arrow icon-angle-down"></b>
        </a>
    </li>

    <li>
        <a href="https://www.sxmbyd.com/manage/order/queryOrderPage" class="dropdown-toggle">
            <img style="width:20px;height:20px;" src="${rootURL}resources/images/order-manage.png">
            <span class="menu-text"> 订单管理 </span>

            <b class="arrow icon-angle-down"></b>
        </a>
    </li>

    <li>
        <a href="https://www.sxmbyd.com/manage/recharge/queryRechargeOrderPage" class="dropdown-toggle">
            <img style="width:20px;height:20px;" src="${rootURL}resources/images/recharge-manage.png">
            <span class="menu-text"> 充值管理 </span>

            <b class="arrow icon-angle-down"></b>
        </a>
    </li>

    <li>
        <a href="https://www.sxmbyd.com/manage/rechargePackage/queryRechargePackagePage" class="dropdown-toggle">
            <img style="width:20px;height:20px;" src="${rootURL}resources/images/taocan-manage.png">
            <span class="menu-text"> 充值套餐管理 </span>

            <b class="arrow icon-angle-down"></b>
        </a>
    </li>

    <li>
        <a href="https://www.sxmbyd.com/manage/banner/queryBannerPage" class="dropdown-toggle">
            <img style="width:20px;height:20px;" src="${rootURL}resources/images/banner-manage.png">
            <span class="menu-text"> banner管理 </span>

            <b class="arrow icon-angle-down"></b>
        </a>
    </li>

    <li>
        <a href="https://www.sxmbyd.com/manage/notice/queryNoticePage" class="dropdown-toggle">
            <img style="width:20px;height:20px;" src="${rootURL}resources/images/gonggao-manage.png">
            <span class="menu-text"> 公告管理 </span>

            <b class="arrow icon-angle-down"></b>
        </a>
    </li>

    <li>
        <a href="https://www.sxmbyd.com/manage/customer/queryCustomerPage" class="dropdown-toggle">
            <img style="width:20px;height:20px;" src="${rootURL}resources/images/customer-manage.png">
            <span class="menu-text"> 顾客管理 </span>

            <b class="arrow icon-angle-down"></b>
        </a>
    </li>

    <li>
        <a href="https://www.sxmbyd.com/manage/diningTable/queryDiningTablePage" class="dropdown-toggle">
            <img style="width:20px;height:20px;" src="${rootURL}resources/images/canwei-manage.png">
            <span class="menu-text"> 餐位管理 </span>

            <b class="arrow icon-angle-down"></b>
        </a>
    </li>

    <li>
        <a href="https://www.sxmbyd.com/manage/restaurantDetail/queryRestaurantDetailPage" class="dropdown-toggle">
            <img style="width:20px;height:20px;" src="${rootURL}resources/images/restaurant-manage.png">
            <span class="menu-text"> 店家详情 </span>

            <b class="arrow icon-angle-down"></b>
        </a>
    </li>

    <li>
        <a href="https://www.sxmbyd.com/manage/restaurant/queryRestaurantPage" class="dropdown-toggle">
            <img style="width:20px;height:20px;" src="${rootURL}resources/images/restaurant-manage.png">
            <span class="menu-text"> 店家管理 </span>

            <b class="arrow icon-angle-down"></b>
        </a>
    </li>

    <li>
        <a href="https://www.sxmbyd.com/manage/reserve/queryReservePage" class="dropdown-toggle">
            <img style="width:20px;height:20px;" src="${rootURL}resources/images/yuyue-manage.png">
            <span class="menu-text"> 预约管理 </span>

            <b class="arrow icon-angle-down"></b>
        </a>
    </li>

    <li>
        <a href="https://www.sxmbyd.com/manage/activity/queryActivityPage" class="dropdown-toggle">
            <img style="width:20px;height:20px;" src="${rootURL}resources/images/huodong-manage.png">
            <span class="menu-text"> 活动管理 </span>

            <b class="arrow icon-angle-down"></b>
        </a>
    </li>

</ul><!-- /.nav-list -->

<div class="sidebar-collapse" id="sidebar-collapse">
    <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
</div>

<script type="text/javascript">
    try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
</script>