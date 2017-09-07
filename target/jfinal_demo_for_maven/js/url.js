$(function () {
    $("#btnFormatUrl").click(function () {
        var text = $("#txtSourceUrl").val();
        if (text == "") {
            error("请填写要格式化的URL");
        }
        else {
            var json = '{ ';
            var args = getQueryStringArgs(text);
            for (var key in args) {
                json += "\"" + key + "\"";
                json += ":\"" + args[key] + "\", ";
            }
            json += ' }';
            json = json.replace(',  }', ' }');
            $("#txtDestUrl").val(json);
        }
    });
});