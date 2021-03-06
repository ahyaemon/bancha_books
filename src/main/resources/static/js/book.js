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
    var data = {
        'bookId': bookPage.bookId,
        'sentenceId': sentenceId,
        'name':name,
        'comment':comment
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
