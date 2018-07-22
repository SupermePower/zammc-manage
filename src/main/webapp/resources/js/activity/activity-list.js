//删除活动
$('.deleteActivity').click(function (e) {
    var url = common.ctx + $(this).attr('url');
    var activityId = $(this).attr('data');
    common.confirm({
        title: '活动删除',
        message: '是否删除当前活动？'
    }, function () {
        $.ajax({
            url: url,
            type: 'post',
            data: {
                activityId: activityId
            },
            success: common.options.success
        })
    })
});

//启用活动
$('.startUsingActivity').click(function (e) {

    var url = common.ctx + $(this).attr('url');
    var activityId = $(this).attr('data');
    common.confirm({
        title: '活动启用',
        message: '是否启用当前活动？'
    }, function () {
        $.ajax({
            url: url,
            type: 'post',
            data: {
                activityId: activityId
            },
            success: common.options.success
        })
    })
});

//禁用活动
$('.forbiddenActivity').click(function (e) {

    var url = common.ctx + $(this).attr('url');
    var activityId = $(this).attr('data');
    common.confirm({
        title: '活动禁用',
        message: '是否禁用当前活动？'
    }, function () {
        $.ajax({
            url: url,
            type: 'post',
            data: {
                activityId: activityId
            },
            success: common.options.success
        })
    })
});