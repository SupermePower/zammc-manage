//提交表单
$('#addRechargePackage').click(function (e) {
    e.preventDefault();
    $(".add-recharge-package-form").ajaxSubmit(common.options);
});
