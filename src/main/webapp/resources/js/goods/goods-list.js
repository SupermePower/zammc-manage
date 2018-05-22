//上架
$('.shelfGoods').click(function (e) {

    var url = common.ctx + $(this).attr('url');
    var goodsId = $(this).attr('data');
    common.confirm({
        title: '上架商品',
        message: '是否上架当前商品？'
    }, function () {
        $.ajax({
            url: url,
            type: 'post',
            data: {
                goodsId: goodsId
            },
            success: common.options.success
        })
    })
});

//下架
$('.dismountGoods').click(function (e) {

    var url = common.ctx + $(this).attr('url');
    var goodsId = $(this).attr('data');
    common.confirm({
        title: '下架商品',
        message: '是否下架当前商品？'
    }, function () {
        $.ajax({
            url: url,
            type: 'post',
            data: {
                goodsId: goodsId
            },
            success: common.options.success
        })
    })
});

//删除订单
$('.deleteGoods').click(function (e) {

    var url = common.ctx + $(this).attr('url');
    var goodsId = $(this).attr('data');
    common.confirm({
        title: '商品删除',
        message: '是否删除当前商品？'
    }, function () {
        $.ajax({
            url: url,
            type: 'post',
            data: {
                goodsId: goodsId
            },
            success: common.options.success
        })
    })
});

//提交订单
$('.add-confirm').click(function (e) {
    e.preventDefault();
    $("#addGoods").ajaxSubmit(common.options);
});