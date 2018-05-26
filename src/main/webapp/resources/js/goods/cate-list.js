//启用
$('.startUsingCate').click(function (e) {

    var url = common.ctx + $(this).attr('url');
    var cateId = $(this).attr('data');
    common.confirm({
        title: '启用分类',
        message: '是否启用当前商品分类？'
    }, function () {
        $.ajax({
            url: url,
            type: 'post',
            data: {
                cateId: cateId
            },
            success: common.options.success
        })
    })
});

//禁用商品分类
$('.forbiddenCate').click(function (e) {

    var url = common.ctx + $(this).attr('url');
    var cateId = $(this).attr('data');
    common.confirm({
        title: '禁用分类',
        message: '是否禁用当前商品分类？'
    }, function () {
        $.ajax({
            url: url,
            type: 'post',
            data: {
                cateId: cateId
            },
            success: common.options.success
        })
    })
});

//删除商品分类
$('.deleteGoodsCate').click(function (e) {

    var url = common.ctx + $(this).attr('url');
    var cateId = $(this).attr('data');
    common.confirm({
        title: '分类删除',
        message: '是否删除当前商品分类？'
    }, function () {
        $.ajax({
            url: url,
            type: 'post',
            data: {
                cateId: cateId
            },
            success: common.options.success
        })
    })
});