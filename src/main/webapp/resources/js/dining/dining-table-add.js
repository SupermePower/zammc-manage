//提交表单
$('#addDiningTable').click(function (e) {
    e.preventDefault();
    $(".add-dining-table-form").ajaxSubmit(common.options);
});
