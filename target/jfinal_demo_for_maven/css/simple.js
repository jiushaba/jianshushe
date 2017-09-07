var CONST_MAX_LENGTH = 10000;
$(function () {
    $('#myTab a:first').tab('show');
    $('#myTab a').click(function (e) {
        e.preventDefault();
        $(this).tab('show');
    })
});

function callApi(url, data, callback) {
    if (data != null) {
        data["hiddenToken"] = $("#hiddenToken").val();
    }
    else {
        data = {};
        data["hiddenToken"] = $("#hiddenToken").val();
    }
    $.ajax({
        type: "POST",
        url: url,
        data: data,
        success: function (data) {
            hideError();
            if (callback != null) {
                callback(data);
            }
        }
    });
}

function error(msg) {
    if ($("#errorDiv")) {
        $("#errorDiv").show().text("错误：" + msg);
        setTimeout(function () {
            $("#errorDiv").hide();
        }, 5000);
    }
    else {
        alert(msg);
    }
}

function hideError() {
    $("#errorDiv").hide();
}

// 全角空格为12288，半角空格为32 
// 其他字符半角(33-126)与全角(65281-65374)的对应关系是：均相差65248 
// 半角转换为全角函数 
function ToDBC(txtstring) {
    var tmp = "";
    for (var i = 0; i < txtstring.length; i++) {
        if (txtstring.charCodeAt(i) == 32) {
            tmp = tmp + String.fromCharCode(12288);
        }
        if (txtstring.charCodeAt(i) < 127) {
            tmp = tmp + String.fromCharCode(txtstring.charCodeAt(i) + 65248);
        }
    }
    return tmp;
}

// 全角转换为半角函数 
function ToCDB(str) {
    var tmp = "";
    for (var i = 0; i < str.length; i++) {
        if (str.charCodeAt(i) > 65248 && str.charCodeAt(i) < 65375) {
            tmp += String.fromCharCode(str.charCodeAt(i) - 65248);
        }
        else {
            tmp += String.fromCharCode(str.charCodeAt(i));
        }
    }
    return tmp
}

Date.prototype.format = function (format) {
    var date = {
        "M+": this.getMonth() + 1,
        "d+": this.getDate(),
        "h+": this.getHours(),
        "m+": this.getMinutes(),
        "s+": this.getSeconds(),
        "q+": Math.floor((this.getMonth() + 3) / 3),
        "S+": this.getMilliseconds()
    };
    if (/(y+)/i.test(format)) {
        format = format.replace(RegExp.$1, (this.getFullYear() + '').substr(4 - RegExp.$1.length));
    }
    for (var k in date) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length == 1
                   ? date[k] : ("00" + date[k]).substr(("" + date[k]).length));
        }
    }
    return format;
}

function getQueryStringArgs(url) {
    if (url && url.indexOf("?") > -1) {
        var arr = url.split("?");
        var qs = arr[1],
            args = {},
            items = qs.length ? qs.split("&") : [],
            item = null,
            name = null,
            value = null,
            i = 0,
            len = items.length;
        for (i = 0; i < len; i++) {
            item = items[i].split("=");
            name = decodeURIComponent(item[0]);
            value = decodeURIComponent(item[1]);
            if (name.length) {
                args[name] = value;
            }
        }
        return args;
    }
    return {};
}

function isIp(ip) {
    return /^((?:(?:25[0-5]|2[0-4]\d|((1\d{2})|([1-9]?\d)))\.){3}(?:25[0-5]|2[0-4]\d|((1\d{2})|([1-9]?\d))))$/.test(ip);
}

function isDomain(domain) {
    return /^((http:\/\/)|(https:\/\/))?([a-zA-Z0-9]([a-zA-Z0-9\-]{0,61}[a-zA-Z0-9])?\.)+[a-zA-Z]{2,6}(\/)?$/.test(domain);
}

function isMobile(mobile) {
    return /^1\d{10}$/.test(mobile);
}