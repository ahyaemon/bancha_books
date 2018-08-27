function encrypt(){
    var data = JSON.stringify({
        "plainText": $("#plain").val()
    });

    function done(data){
        console.log(data);
        $("#encrypted").val(data);
    }

    function fail(e){
        console.log(e);
    }

    doAjax("/admin/crypt/encrypt", data, done, fail);
}
