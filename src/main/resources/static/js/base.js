$(function(){
    $(".number-format").each(function(i, e){
        var $e = $(e);
        var text = $e.text();
        var fixedText = text.replace( /(\d)(?=(\d\d\d)+(?!\d))/g, '$1,');
        $e.text(fixedText);
    });
});