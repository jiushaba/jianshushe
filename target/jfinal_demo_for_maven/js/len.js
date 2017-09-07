$(function () {
    $("#btnGetLen").click(function () {
        var text = $("#txtSourceLen").val();
        if (text == "") {
            error("请填写要计算长度的字符");
        }
        else {
            var re = /[\u4E00-\u9FA5]/g;
            var match = text.match(re);
            var len = match != null ? match.length : 0;
            $(".length-tip").show().text("字符长度：" + text.length + "，汉字数量：" + len);
        }
    });
});