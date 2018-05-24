//删除banner
$('.deleteBanner').click(function (e) {

    var url = common.ctx + $(this).attr('url');
    var bannerId = $(this).attr('data');
    common.confirm({
        title: 'banner删除',
        message: '是否删除当前banner？'
    }, function () {
        $.ajax({
            url: url,
            type: 'post',
            data: {
                bannerId: bannerId
            },
            success: common.options.success
        })
    })
});

//启用banner
$('.startUsingBanner').click(function (e) {

    var url = common.ctx + $(this).attr('url');
    var bannerId = $(this).attr('data');
    common.confirm({
        title: 'banner启用',
        message: '是否启用当前banner？'
    }, function () {
        $.ajax({
            url: url,
            type: 'post',
            data: {
                bannerId: bannerId
            },
            success: common.options.success
        })
    })
});

//禁用banner
$('.forbiddenBanner').click(function (e) {

    var url = common.ctx + $(this).attr('url');
    var bannerId = $(this).attr('data');
    common.confirm({
        title: 'banner禁用',
        message: '是否禁用当前banner？'
    }, function () {
        $.ajax({
            url: url,
            type: 'post',
            data: {
                bannerId: bannerId
            },
            success: common.options.success
        })
    })
});