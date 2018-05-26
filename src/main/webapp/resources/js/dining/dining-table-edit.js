//提交表单
$('#editDiningTable').click(function (e) {
    e.preventDefault();
    $(".edit-dining-table-form").ajaxSubmit(common.options);
});
