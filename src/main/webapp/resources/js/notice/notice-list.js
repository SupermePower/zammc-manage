//删除公告
$('.deleteOrder').click(function (e) {

    var url = common.ctx + $(this).attr('url');
    var noticeId = $(this).attr('data');
    common.confirm({
        title: '公告删除',
        message: '是否删除当前公告？'
    }, function () {
        $.ajax({
            url: url,
            type: 'post',
            data: {
                noticeId: noticeId
            },
            success: common.options.success
        })
    })
});

//启用公告
$('.startUsingNotice').click(function (e) {

    var url = common.ctx + $(this).attr('url');
    var noticeId = $(this).attr('data');
    common.confirm({
        title: '公告启用',
        message: '是否启用当前公告？'
    }, function () {
        $.ajax({
            url: url,
            type: 'post',
            data: {
                noticeId: noticeId
            },
            success: common.options.success
        })
    })
});

//禁用公告
$('.forbiddenNotice').click(function (e) {

    var url = common.ctx + $(this).attr('url');
    var noticeId = $(this).attr('data');
    common.confirm({
        title: '公告禁用',
        message: '是否禁用当前公告？'
    }, function () {
        $.ajax({
            url: url,
            type: 'post',
            data: {
                noticeId: noticeId
            },
            success: common.options.success
        })
    })
});