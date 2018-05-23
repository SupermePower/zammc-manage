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
        <a href="http://localhost:7500/manage">
            <i class="icon-dashboard"></i>
            <span class="menu-text"> 控制台 </span>
        </a>
    </li>

    <li>
        <a href="http://localhost:7500/manage/goods/queryGoodsPage" class="dropdown-toggle">
            <i class="icon-edit"></i>
            <span class="menu-text"> 商品管理 </span>

            <b class="arrow icon-angle-down"></b>
        </a>
    </li>

    <li>
        <a href="http://localhost:7500/manage/order/queryOrderPage" class="dropdown-toggle">
            <i class="icon-edit"></i>
            <span class="menu-text"> 订单管理 </span>

            <b class="arrow icon-angle-down"></b>
        </a>
    </li>

    <li>
        <a href="http://localhost:7500/manage/recharge/queryRechargeOrderPage" class="dropdown-toggle">
            <i class="icon-edit"></i>
            <span class="menu-text"> 充值管理 </span>

            <b class="arrow icon-angle-down"></b>
        </a>
    </li>

    <li>
        <a href="http://localhost:7500/manage/customer/queryCustomerPage" class="dropdown-toggle">
            <i class="icon-edit"></i>
            <span class="menu-text"> 顾客管理 </span>

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