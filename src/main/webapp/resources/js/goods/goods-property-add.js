//提交表单
$('#addGoodsProperty').click(function (e) {
    e.preventDefault();
    var tags = $('.tag').text();
    var property = $('#form-field-tags').val();
    property = tags;
    $(".add-goods-property-form").ajaxSubmit(common.options);
});