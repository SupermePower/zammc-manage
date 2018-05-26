//删除餐位信息
$('.deleteDiningTable').click(function (e) {

    var url = common.ctx + $(this).attr('url');
    var tableId = $(this).attr('data');
    common.confirm({
        title: '餐位删除',
        message: '是否删除当前餐位？'
    }, function () {
        $.ajax({
            url: url,
            type: 'post',
            data: {
                tableId: tableId
            },
            success: common.options.success
        })
    })
});