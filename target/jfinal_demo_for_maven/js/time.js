$(function () {
    $(".btnCalTime").click(function () {
        var val = $(this).attr("data-val");
        switch (val) {
            case "day":
                var text = $("#txtDay").val();
                if (text == "") {
                    error("请填写天值");
                }
                else {
                    var num = parseFloat(text);
                    $("#txtHour").val(num * 24);
                    $("#txtMinute").val(num * 24 * 60);
                    $("#txtSecond").val(num * 24 * 60 * 60);
                    $("#txtMillisecond").val(num * 24 * 60 * 60 * 1000);
                }
                break;
            case "hour":
                var text = $("#txtHour").val();
                if (text == "") {
                    error("请填写小时值");
                }
                else {
                    var num = parseFloat(text);
                    $("#txtDay").val(extractTime((num / 24).toFixed(4)));
                    $("#txtMinute").val(extractTime(num * 60));
                    $("#txtSecond").val(extractTime(num * 60 * 60));
                    $("#txtMillisecond").val(extractTime(num * 60 * 60 * 1000));
                }
                break;
            case "minute":
                var text = $("#txtMinute").val();
                if (text == "") {
                    error("请填写分钟值");
                }
                else {
                    var num = parseFloat(text);
                    $("#txtDay").val(extractTime((num / 60 / 24).toFixed(4)));
                    $("#txtHour").val(extractTime((num / 60).toFixed(4)));
                    $("#txtSecond").val(extractTime(num * 60));
                    $("#txtMillisecond").val(extractTime(num * 60 * 1000));
                }
                break;
            case "second":
                var text = $("#txtSecond").val();
                if (text == "") {
                    error("请填写秒值");
                }
                else {
                    var num = parseFloat(text);
                    $("#txtDay").val(extractTime((num / 60 / 60 / 24).toFixed(4)));
                    $("#txtHour").val(extractTime((num / 60 / 60).toFixed(4)));
                    $("#txtMinute").val(extractTime((num / 60).toFixed(4)));
                    $("#txtMillisecond").val(extractTime(num * 1000));
                }
                break;
            case "millisecond":
                var text = $("#txtMillisecond").val();
                if (text == "") {
                    error("请填写毫秒值");
                }
                else {
                    var num = parseFloat(text);
                    $("#txtDay").val(extractTime((num / 1000 / 60 / 60 / 24).toFixed(4)));
                    $("#txtHour").val(extractTime((num / 1000 / 60 / 60).toFixed(4)));
                    $("#txtMinute").val(extractTime((num / 1000 / 60).toFixed(4)));
                    $("#txtSecond").val(extractTime(num / 1000));
                }
                break;
        }
    });
});

function extractTime(text) {
    var slt = text;
    if (text.toString().indexOf(".") > 0) {
        var arr = text.toString().split(".");
        if (parseInt(arr[1]) == 0) {
            slt = arr[0];
        }
    }
    return slt;
}