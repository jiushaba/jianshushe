$(function () {
    compile();
});
function compile() {
    var text = document.getElementById("content").value;
    var converter = new showdown.Converter();
    var html = converter.makeHtml(text);
    document.getElementById("result").innerHTML = html;
}