//结束订单
$('.finishOrder').click(function (e) {

    var url = common.ctx + $(this).attr('url');
    var orderId = $(this).attr('data');
    common.confirm({
        title: '结束订单',
        message: '是否结束当前订单？'
    }, function () {
        $.ajax({
            url: url,
            type: 'post',
            data: {
                orderId: orderId
            },
            success: common.options.success
        })
    })
});

//取消订单
$('.cancelOrder').click(function (e) {

    var url = common.ctx + $(this).attr('url');
    var orderId = $(this).attr('data');
    common.confirm({
        title: '取消订单',
        message: '是否取消当前订单？'
    }, function () {
        $.ajax({
            url: url,
            type: 'post',
            data: {
                orderId: orderId
            },
            success: common.options.success
        })
    })
});

//删除订单
$('.deleteOrder').click(function (e) {

    var url = common.ctx + $(this).attr('url');
    var orderId = $(this).attr('data');
    common.confirm({
        title: '订单删除',
        message: '是否删除当前订单？'
    }, function () {
        $.ajax({
            url: url,
            type: 'post',
            data: {
                orderId: orderId
            },
            success: common.options.success
        })
    })
});