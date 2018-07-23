function show($e){
    $e.css("display", "block");
}

function hide($e){
    $e.css("display", "none");
}

function openSentence(sentenceId){
    var $sentenceItem = $("#sentence-item-" + sentenceId);

    // selected付与
    var cls = "sentence-item-selected";
    $sentenceItem.addClass(cls);

    // 表示・非表示の切り替え
    show($sentenceItem.find(".sentence-open"));
    hide($sentenceItem.find(".sentence-close"));
}

function closeSentence(sentenceId){
    var $sentenceItem = $("#sentence-item-" + sentenceId);

    // selected除外
    var cls = "sentence-item-selected";
    $sentenceItem.removeClass(cls);

    // 表示・非表示の切り替え
    hide($sentenceItem.find(".sentence-open"));
    show($sentenceItem.find(".sentence-close"));
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