//提交表单
$('#addBanner').click(function (e) {
    e.preventDefault();
    $(".add-banner-form").ajaxSubmit(common.options);
});
