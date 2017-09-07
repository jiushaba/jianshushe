$(function () {
    $("#btnGetUpper").click(function () {
        var text = $("#txtSourceUpper").val();
        if (text == "") {
            error("请填写要转换大写的内容");
        }
        else {
            $("#txtDestUpper").val(text.toUpperCase());
        }
    });

    $("#btnGetLower").click(function () {
        var text = $("#txtSourceUpper").val();
        if (text == "") {
            error("请填写要转换小写的内容");
        }
        else {
            $("#txtDestUpper").val(text.toLowerCase());
        }
    });
});