function openComment(sentenceId){
    var cls = "sentence-item-selected";
    var $sentenceItem = $("#sentence-item-" + sentenceId);
    var $commentSection = $sentenceItem.find(".sec-comment");
    if($sentenceItem.hasClass(cls)){
        $sentenceItem.removeClass(cls);
        $commentSection.css("display", "none");
    }
    else{
        $sentenceItem.addClass(cls);
        $commentSection.css("display", "block");        
    }
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
    doAjax("/book/createComment", data, function(data, status, xhr){
        $sentenceItem.find(".comment-list").html(data);
        console.log("SUCCESS!!");
        console.log({data:data, status:status, xhr:xhr});
    });
}

function doAjax(url, data, fnDone){
    $.ajax({
        url: url,
        type:'POST',
        data: data,
        dataType: "html",
        contentType: 'application/json',
    })
    .done(fnDone)
    .fail( (e) => {
        console.log("ERROR!!");
        console.log(e);
    })    
}