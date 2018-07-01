//提交表单
$('#addRestaurantDetail').click(function (e) {
    e.preventDefault();
    $(".add-restaurant-detail-form").ajaxSubmit(common.options);
});
