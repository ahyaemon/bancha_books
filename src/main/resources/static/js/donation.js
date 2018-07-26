window.onload = function(){
    if(donated){
        anime({
            targets: '#card-donated',
            translateY: 700,
            easing: 'easeInOutQuart',
            duration: 5000,
            direction: 'normal',
        });
    }

    $('div[name="yen"]').click(function(e) {
        let yen = $(e.currentTarget).data('yen');
        $("#amount").val(yen);
    });
}
