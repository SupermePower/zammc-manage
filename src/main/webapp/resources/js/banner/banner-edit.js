//提交表单
$('#editBanner').click(function (e) {
    e.preventDefault();
    $(".edit-banner-form").ajaxSubmit(common.options);
});

//修改图片信息
$('.setImage').change(function(e) {
    $('.oldImage').val('');
});