//提交表单
$('#editBanner').click(function (e) {
    e.preventDefault();
    $(".edit-banner-form").ajaxSubmit(common.options);
});
