//提交表单
$('#editNotice').click(function (e) {
    e.preventDefault();
    $(".edit-notice-form").ajaxSubmit(common.options);
});

//修改图片信息
$('.setImage').change(function(e) {
    $('.oldImage').val('');
});