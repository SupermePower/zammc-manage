//删除套餐
$('.deletePackage').click(function (e) {

    var url = common.ctx + $(this).attr('url');
    var packageId = $(this).attr('data');
    common.confirm({
        title: '套餐删除',
        message: '是否删除当前套餐？'
    }, function () {
        $.ajax({
            url: url,
            type: 'post',
            data: {
                packageId: packageId
            },
            success: common.options.success
        })
    })
});