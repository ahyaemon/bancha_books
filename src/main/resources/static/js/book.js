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
        $("#modal-comment").find(".modal__container").html(data);
        MicroModal.show("modal-comment", {
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
        $("#modal-comment").find(".modal__container").html(data);
    }

    function fail(e){
        console.log(e);
    }

    doAjax("/book/createComment", data, done, fail);
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

function commentClicked(sentenceId, commentId){
    bookPage.sentenceId = sentenceId;
    var $form = $("#deleteCommentForm");
    $form.find("#commentId").val(commentId);
    MicroModal.show("modal-delete", {
        awaitCloseAnimation: true
    });
}

function deleteComment(){
    var $form = $("#deleteCommentForm");    
    var sentenceId = bookPage.sentenceId;
    var commentId = $form.find("#commentId").val();
    var deleteKey = $form.find("#deleteKey").val();
    var data = {
        'bookId': bookPage.bookId,
        'sentenceId': sentenceId,
        'commentId': commentId,
        'deleteKey': deleteKey
    };
    data = JSON.stringify(data);

    function done(data, status, xhr){
        if($(data).prop("id") == "deleteCommentDiv"){
            $("#modal-delete").find(".modal__container").html(data);
        }
        else{
            MicroModal.close("modal-delete");
            $("#modal-comment").find(".modal__container").html(data);
        }
    }

    function fail(e){
        console.log(e);
    }

    doAjax("/book/deleteComment", data, done, fail);
}