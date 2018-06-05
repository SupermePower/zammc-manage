//设置店家为-营业状态
$('.editRestaurantBusiness').click(function (e) {

    var url = common.ctx + $(this).attr('url');
    var restaurantId = $(this).attr('data');
    common.confirm({
        title: '设置状态',
        message: '是否将店家设置为营业状态？'
    }, function () {
        $.ajax({
            url: url,
            type: 'post',
            data: {
                restaurantId: restaurantId
            },
            success: common.options.success
        })
    })
});

//设置店家信息为休息状态
$('.editRestaurantRest').click(function (e) {

    var url = common.ctx + $(this).attr('url');
    var restaurantId = $(this).attr('data');
    common.confirm({
        title: '状态设置',
        message: '是否将店家设置为休息状态？'
    }, function () {
        $.ajax({
            url: url,
            type: 'post',
            data: {
                restaurantId: restaurantId
            },
            success: common.options.success
        })
    })
});