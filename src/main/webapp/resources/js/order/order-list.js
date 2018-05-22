//删除订单
$('.deleteOrder').click(function (e) {
    var url = common.ctx + $(this).attr('url');
    var event_id = $(this).parents('tr').attr('data-event_id');
    common.confirm({
        title: '订单删除',
        message: '是否删除当前订单？'
    }, function () {
        $.ajax({
            url: url,
            type: 'post',
            data: {
                event_id: event_id
            },
            success: common.options.success
        })
    })
});

//提交订单
$('.add-confirm').click(function (e) {
    e.preventDefault();
    $("#update").ajaxSubmit(common.options);
});