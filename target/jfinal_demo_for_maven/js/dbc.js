$(function () {
    $("#btnGetDbc").click(function () {
        var text = $("#txtSourceDbc").val();
        if (text == "") {
            error("请填写要转换的字符");
        }
        else {
            $("#txtDestDbc").val(ToDBC(text));
        }
    });

    $("#btnGetDbcBack").click(function () {
        var text = $("#txtDestDbc").val();
        if (text == "") {
            error("请填写要转换的字符");
        }
        else {
            $("#txtSourceDbc").val(ToCDB(text));
        }
    });
});