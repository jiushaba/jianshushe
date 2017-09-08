$(function () {
    $(".file-md5").click(function () {
        $("#md5file").click();
    });

    document.getElementById("md5file").addEventListener("change", function () {
        var fileReader = new FileReader(),
            box = document.getElementById('md5box'),
            blobSlice = File.prototype.mozSlice || File.prototype.webkitSlice || File.prototype.slice,
            file = document.getElementById("md5file").files[0],
            chunkSize = 2097152,
            chunks = Math.ceil(file.size / chunkSize),
            currentChunk = 0,
            bs = fileReader.readAsBinaryString,
            spark = bs ? new SparkMD5() : new SparkMD5.ArrayBuffer();
        fileReader.onload = function (ee) {
            spark.append(ee.target.result);
            currentChunk++;
            if (currentChunk < chunks) {
                loadNext();
            } else {
                box.innerText = spark.end();
            }
        }
        $("#md5filename").text(file.name);
        $("#md5filesize").text(Math.ceil(file.size / 1024) + "KB");

        function loadNext() {
            var start = currentChunk * chunkSize, end = start + chunkSize >= file.size ? file.size : start + chunkSize;
            if (bs) fileReader.readAsBinaryString(blobSlice.call(file, start, end));
            else fileReader.readAsArrayBuffer(blobSlice.call(file, start, end));
        }

        loadNext();
    });
});