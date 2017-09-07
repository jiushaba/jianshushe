$(function () {
    $(".btnCal").click(function () {
        var val = $(this).attr("data-val");
        switch (val) {
            case "10":
                var text = $("#txt10").val();
                if (text == "") {
                    error("请填写十进制值");
                }
                else {
                    $("#txt2").val(parseFloat(text, 10).toString(2));
                    $("#txt8").val(parseFloat(text, 10).toString(8));
                    $("#txt16").val(parseFloat(text, 10).toString(16));
                }
                break;
            case "2":
                var text = $("#txt2").val();
                if (text == "") {
                    error("请填写二进制值");
                }
                else {
                    $("#txt10").val(parseInt(text, 2).toString(10));
                    $("#txt8").val(parseInt(text, 2).toString(8));
                    $("#txt16").val(parseInt(text, 2).toString(16));
                }
                break;
            case "8":
                var text = $("#txt8").val();
                if (text == "") {
                    error("请填写八进制值");
                }
                else {
                    $("#txt10").val(parseInt(text, 8).toString(10));
                    $("#txt2").val(parseInt(text, 8).toString(2));
                    $("#txt16").val(parseInt(text, 8).toString(16));
                }
                break;
            case "16":
                var text = $("#txt16").val();
                if (text == "") {
                    error("请填写十六进制值");
                }
                else {
                    $("#txt10").val(parseInt(text, 16).toString(10));
                    $("#txt2").val(parseInt(text, 16).toString(2));
                    $("#txt8").val(parseInt(text, 16).toString(8));
                }
                break;
        }
    });
});