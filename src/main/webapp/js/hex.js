$(function () {
    var vm = new Vue({
        el: '#app',
        data: {
            r: 255,
            g: 255,
            b: 255,
            hex: 'ffffff'
        },
        methods: {
            rgbChange: function () {
                this.r = this.checkcolor(this.r);
                this.g = this.checkcolor(this.g);
                this.b = this.checkcolor(this.b);
                this.hex = this.colorRGB2Hex(this.r + "," + this.g + "," + this.b);
            },
            hexChange: function () {
                if (this.hex == "") {
                    this.r = 0;
                    this.g = 0;
                    this.b = 0;
                }
                else {
                    var arr = this.colorHex2RGB('#' + this.hex);
                    this.r = arr[0];
                    this.g = arr[1];
                    this.b = arr[2];
                }
            },
            colorRGB2Hex: function (color) {
                var rgb = color.split(',');
                var r = parseInt(rgb[0]);
                var g = parseInt(rgb[1]);
                var b = parseInt(rgb[2]);
                var hex = ((1 << 24) + (r << 16) + (g << 8) + b).toString(16).slice(1);
                return hex;
            },
            colorHex2RGB: function (hex) {
                var reg = /^#([0-9a-fA-f]{3}|[0-9a-fA-f]{6})$/;
                var sColor = hex.toLowerCase();
                if (sColor && reg.test(sColor)) {
                    if (sColor.length === 4) {
                        var sColorNew = '#';
                        for (var i = 1; i < 4; i += 1) {
                            sColorNew += sColor.slice(i, i + 1).concat(sColor.slice(i, i + 1));
                        }
                        sColor = sColorNew;
                    }
                    //处理六位的颜色值
                    var sColorChange = [];
                    for (var i = 1; i < 7; i += 2) {
                        sColorChange.push(parseInt('0x' + sColor.slice(i, i + 2)));
                    }
                    return sColorChange;
                } else {
                    return [0, 0, 0];
                }
            },
            checkcolor: function (color) {
                var slt = 0;
                if (color) {
                    var num = parseInt(color);
                    if (num < 0) {
                        slt = 0;
                    } else if (num > 255) {
                        slt = 255;
                    }
                    else {
                        slt = num;
                    }
                }
                return slt;
            }
        }
    });
});