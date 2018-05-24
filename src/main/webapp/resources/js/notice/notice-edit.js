//提交表单
$('#editNotice').click(function (e) {
    e.preventDefault();
    $(".edit-notice-form").ajaxSubmit(common.options);
});
