//提交表单
$('#addNotice').click(function (e) {
    e.preventDefault();
    $(".add-notice-form").ajaxSubmit(common.options);
});
