$(function () {
    $("#btnXmlEntity").click(function () {
        var text = $("#txtSourceXmlEntity").val();
        var type = $("#selXmlCate").val();
        if (text == "") {
            error("请填写xml");
        }
        else {
            if (text.length >= CONST_MAX_LENGTH) {
                error("xml内容不能超过10000个字符");
            }
            else {
                $.ajax({
                    type: "POST",
                    url: "/fun/xmltoobject",
                    data: { text: text, type: type },
                    success: function (slt) {
                        if (slt && slt.Flag) {
                            $("#txtDestXmlEntity").val(slt.Data);
                        }
                        else {
                            if (slt.Message) {
                                error(slt.Message);
                            } else {
                                error(slt);
                            }
                        }
                    }
                });
            }
        }
    });
});