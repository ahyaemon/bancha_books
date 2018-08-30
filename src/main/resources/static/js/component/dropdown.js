var dropdown = {
    disabled: true,
    target: '.dropdown-content',
    height: 0,
    init: function(){
    },
    show: function(){
        var $target = $(this.target);
        this.height = $target.height();
        $target.css("top", -this.height);
        anime({
            targets: this.target,
            translateY: this.height,
            easing: 'easeInOutQuart',
            duration: 500,
            direction: 'normal',
        });
        this.disabled = false;
    },
    hide: function(){
        anime({
            targets: this.target,
            translateY: -this.height,
            easing: 'easeInOutQuart',
            duration: 500,
            direction: 'normal',
        });
        this.disabled = true;
    }
}

function showDropdown(){
    dropdown.show();
    return false;
}

function hideDropdown(){
    dropdown.hide();
    return false;
}

dropdown.init();