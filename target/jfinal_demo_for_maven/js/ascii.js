$(function () {
    $("#btnAsciiEncode").click(function () {
        var text = $("#txtSourceAscii").val();
        if (text == "") {
            error("请填写要编码的内容");
        }
        else {
            var a = new Ascii();
            $("#txtDestAscii").val(a.encode(text));
        }
    });

    $("#btnAsciiDecode").click(function () {
        var text = $("#txtDestAscii").val();
        if (text == "") {
            error("请填写要解码的内容");
        }
        else {
            var a = new Ascii();
            $("#txtSourceAscii").val(a.decode(text));
        }
    });
});

function Ascii() {
    this.encode = function (content) {
        var result = '';
        for (var i = 0; i < content.length; i++)
            result += '&#' + content.charCodeAt(i) + ';';
        return result;
    }
    this.decode = function (content) {
        var code = content.match(/&#(\d+);/g);
        result = '';
        for (var i = 0; i < code.length; i++)
            result += String.fromCharCode(code[i].replace(/[&#;]/g, ''));
        return result;
    }
}