//删除卡券
$('.deleteCoupon').click(function (e) {

    var url = common.ctx + $(this).attr('url');
    var id = $(this).attr('data');
    common.confirm({
        title: '卡券删除',
        message: '是否删除当前卡券？'
    }, function () {
        $.ajax({
            url: url,
            type: 'post',
            data: {
                id: id
            },
            success: common.options.success
        })
    })
});