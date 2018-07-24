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
}
