//删除商品
$('.deleteReserve').click(function (e) {

    var url = common.ctx + $(this).attr('url');
    var reserveId = $(this).attr('data');
    common.confirm({
        title: '预约删除',
        message: '是否删除当前预约信息？'
    }, function () {
        $.ajax({
            url: url,
            type: 'post',
            data: {
                reserveId: reserveId
            },
            success: common.options.success
        })
    })
});