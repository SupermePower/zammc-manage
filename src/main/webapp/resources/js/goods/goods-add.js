//提交表单
$('#addGoods').click(function (e) {
    e.preventDefault();
    $(".add-goods-form").ajaxSubmit(common.options);
});