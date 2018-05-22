//提交表单
$('.add-confirm').click(function (e) {
    e.preventDefault();
    $("#addGoods").ajaxSubmit(common.options);
});