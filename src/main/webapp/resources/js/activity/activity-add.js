//提交表单
$('#addActivity').click(function (e) {
    e.preventDefault();
    $(".add-activity-form").ajaxSubmit(common.options);
});
