var spinner = {
    elem: $("<div class='spinner_container'>"),
    init: function(){
        var spinner = $("<div class='siimple-spinner siimple-spinner--dark siimple-spinner--large'>");
        this.elem.html(spinner);
        $("body").prepend(this.elem);
    },
    start: function(){
        this.elem.css("display", "block");
    },
    stop: function(){
        this.elem.css("display", "none");
    }
}

spinner.init();