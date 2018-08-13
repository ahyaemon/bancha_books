var bookPage = {
    bookId: null,
    sentenceId: null
};

function show($e){
    $e.css("display", "block");
}

function hide($e){
    $e.css("display", "none");
}

function openSentence(sentenceId){
    spinner.start(".sec-content");

    var data = JSON.stringify({
        'bookId': bookPage.bookId,
        'sentenceId': sentenceId
    });

    function done(data){
        $(".modal__container").html(data);
        MicroModal.show("modal-1", {
            onClose: function(modal){
                spinner.stop();
            },
            awaitCloseAnimation: true
        });    
    }

    function fail(e){
        spinner.stop();
        console.log(e);
    }

    doAjax("/book/getSentence", data, done, fail);
}

function submitComment(sentenceId){
    var name = $(".input-name").val();
    var comment = $(".input-comment").val();
    var hasDeleteKey = $(".delete-key-switch").prop("checked");
    var deleteKey = $("#deleteKey").val();
    var data = {
        'bookId': bookPage.bookId,
        'sentenceId': sentenceId,
        'name':name,
        'comment':comment,
        'hasDeleteKey': hasDeleteKey,
        'deleteKey': deleteKey
    };
    data = JSON.stringify(data);

    function done(data, status, xhr){
        $(".modal__container").html(data);
        console.log({data:data, status:status, xhr:xhr});
    }

    function fail(e){
        console.log(e);
    }

    doAjax("/book/createComment", data, done, fail);
}

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

function deleteKeySwitchChanged(target){
    var checked = $(target).prop("checked");
    var $deleteKeyField = $("#delete-key-field");

    if(checked){
        $deleteKeyField.addClass("show");
    }
    else{
        $deleteKeyField.removeClass("show");
    }
}