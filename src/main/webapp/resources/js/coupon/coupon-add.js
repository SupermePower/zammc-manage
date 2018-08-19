//提交表单
$('#addCoupon').click(function (e) {
    e.preventDefault();
    var tags = $('.tag').text();
    var property = $('#form-field-tags').val();
    property = tags;
    $(".add-coupon-form").ajaxSubmit(common.options);
});