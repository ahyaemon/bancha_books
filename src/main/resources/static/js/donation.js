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

    $('#total-donation').countTo({
        speed: 2500,
        formatter: function (value, options) {
            const formatter = new Intl.NumberFormat('ja-JP');
            return formatter.format(value);
        }
    });
}
