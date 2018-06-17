//提交表单
$('#addGoods').click(function (e) {
    e.preventDefault();
    var tags = $('.tag').text();
    var property = $('#form-field-tags').val();
    property = tags;
    $(".add-goods-form").ajaxSubmit(common.options);
});

$('#singleProduct').click(function () {
    $('.tag').addClass("hidden");
});

$('#specifications').click(function () {
    $('.tag').removeClass("hidden");
});