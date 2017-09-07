$(function () {
	$("#btnTransUnix").click(function () {
		var text = $("#txtSourceUnix").val();
		if (text == "") {
			error("请填写要转换的时间");
		}
		else {
			try {
				var time = Date.parse(text);
				if (!isNaN(time)) {
					$("#txtDestUnix").val(time / 1000);
				}
				else {
					$("#txtDestUnix").val("");
					error("时间格式不正确");
				}
			}
			catch (ex) {
				error(ex);
			}
		}
	});

	$("#btnTransDate").click(function () {
		var text = $("#txtDestUnix").val();
		if (text == "") {
			error("请填写要转换的时间戳");
		}
		else {
			try {
				var stamp = parseFloat(text);
				if (stamp < 0) {
					error("时间戳格式不正确");
				}
				else {
					var newDate = new Date();
					newDate.setTime(stamp * 1000);
					$("#txtSourceUnix").val(newDate.format('yyyy-MM-dd hh:mm:ss'));
				}
			}
			catch (ex) {
				error(ex);
			}
		}
	});
});