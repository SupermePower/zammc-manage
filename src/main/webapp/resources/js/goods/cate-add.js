//提交表单
$('#addGoodsCate').click(function (e) {
    e.preventDefault();
    $(".add-cate-form").ajaxSubmit(common.options);
});
