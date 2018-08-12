var spinner = {
    elem: $("<div id='spinner' class='spinner_container'>"),
    init: function(){
        var spinner = $("<div class='siimple-spinner siimple-spinner--dark siimple-spinner--large'>");
        this.elem.html(spinner);
    },
    start: function(selector){
        var $selector = $(selector);
        this.elem.width($selector.width());
        this.elem.height($selector.height());
        $(selector).prepend(this.elem);
    },
    stop: function(){
        $("#spinner").remove();
    }
}

spinner.init();