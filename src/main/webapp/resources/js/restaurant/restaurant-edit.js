//提交表单
$('#editRestaurant').click(function (e) {
    e.preventDefault();
    $(".edit-restaurant-form").ajaxSubmit(common.options);
});
