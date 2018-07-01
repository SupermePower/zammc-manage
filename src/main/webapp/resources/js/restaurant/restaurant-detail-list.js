//删除店家详情信息
$('.deleteRestaurantDetail').click(function (e) {

    var url = common.ctx + $(this).attr('url');
    var id = $(this).attr('data');
    common.confirm({
        title: '删除',
        message: '是否将店家详情删除？'
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