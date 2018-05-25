//提交表单
$('#editRechargePackage').click(function (e) {
    e.preventDefault();
    $(".edit-recharge-package-form").ajaxSubmit(common.options);
});
