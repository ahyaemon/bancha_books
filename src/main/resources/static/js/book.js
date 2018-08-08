var bookPage = {
    sentenceId: null
};

function show($e){
    $e.css("display", "block");
}

function hide($e){
    $e.css("display", "none");
}

function openSentence(sentenceId){
    // TODO ajaxでsentenceを取得して、はめ込んでからshow modal
    var data = JSON.stringify({
        'sentenceId': sentenceId
    });

    function done(data){
        $(".modal__container").html(data);
        MicroModal.show("modal-1");
    }

    function fail(e){
        console.log(e);
    }

    doAjax("/book/getSentence", data, done, fail);

}

function submitComment(sentenceId){
    var $sentenceItem = $("#sentence-item-" + sentenceId);
    var name = $sentenceItem.find(".input-name").val();
    var comment = $sentenceItem.find(".input-comment").val();
    var data = {
        'sentenceId': sentenceId,
        'name':name,
        'comment':comment
    };
    data = JSON.stringify(data);

    function done(data, status, xhr){
        $sentenceItem.find(".comment-part").html(data);
        console.log("SUCCESS!!");
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

MicroModal.init({
    openTrigger: 'data-custom-open',
    disableScroll: false,
    awaitCloseAnimation: true
});
