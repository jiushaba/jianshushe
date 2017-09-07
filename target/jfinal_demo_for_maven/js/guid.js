$(function () {
    $("#btnGetGuid").click(function () {
        $.ajax({
            type: "POST",
            url: "/transfer/guidquery",
            data: null,
            success: function (slt) {
                if (slt && slt.ok) {
                    $("#txtSourceGuid").val(slt.data);
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
    });
});