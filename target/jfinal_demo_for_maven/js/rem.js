$(function () {
    $("#btnToRem").click(function () {
        var text = $("#txtSourceRem").val();
        var rem = $("#txtRemIntalize").val();
        if (text == "") {
            error("请填写要转换的CSS");
        }
        else if (rem == "") {
            error("请填写1rem等于多少px值");
        }
        else if (rem <= 0) {
            error("请填写正确的px值");
        }
        else {
            text = $.format(text, { method: "css" });   // 都转换成多行来比较
            var arr = text.split("\n");
            var sb = '';
            for (var i = 0; i < arr.length; i++) {
                var line = arr[i];
                sb += line.replace(/\d+px/g, function (px) {
                    if ($("#chkIgnoreBorder").is(":checked")) {
                        if (!/border:/ig.test(line)) {
                            return (parseInt(px) / parseInt(rem)) + "rem";
                        }
                        else {
                            return px;
                        }
                    }
                    else {
                        return (parseInt(px) / parseInt(rem)) + "rem";
                    }
                }) + "\n";
            }
            var source = $("#txtSourceRem").val();
            var sourceArr = source.split("\n");
            var len = sourceArr.length;
            if (len > 1) {
                sb = $.format(sb, { method: "css" });
            }
            else {
                sb = $.format(sb, { method: "cssmin" });
            }
            $("#txtDestRem").val(sb);
        }
    });
});