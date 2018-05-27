//提交表单
$('#editGoodsCate').click(function (e) {
    e.preventDefault();
    $(".edit-goods-cate-form").ajaxSubmit(common.options);
});
