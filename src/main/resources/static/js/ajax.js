function doAjax(url, data, fnDone, fnFail){
    $.ajax({
        url: url,
        type:'POST',
        data: data,
        dataType: "html",
        contentType: 'application/json',
    })
    .done(fnDone)
    .fail(fnFail);
}
