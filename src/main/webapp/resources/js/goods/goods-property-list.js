//启用
$('.enable').click(function (e) {

    var url = common.ctx + $(this).attr('url');
    var id = $(this).attr('data');
    common.confirm({
        title: '启用规格',
        message: '是否启用当前商品规格？'
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

//禁用
$('.disable').click(function (e) {

    var url = common.ctx + $(this).attr('url');
    var id = $(this).attr('data');
    common.confirm({
        title: '禁用规格',
        message: '是否禁用当前商品规格？'
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

//删除商品
$('.delete').click(function (e) {

    var url = common.ctx + $(this).attr('url');
    var id = $(this).attr('data');
    common.confirm({
        title: '规格删除',
        message: '是否删除当前商品规格？'
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

//提交订单
$('.add-confirm').click(function (e) {
    e.preventDefault();
    $("#addGoodsProperty").ajaxSubmit(common.options);
});