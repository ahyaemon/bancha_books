function openComment(elem){
    var id = elem.id;
    var sentenceId = id.split("-")[1];
    var $commentSection = $("#comment-" + sentenceId);
    var display = $commentSection.css("display");
    if(display == "none"){
        $commentSection.css("display", "block");
    }
    else{
        $commentSection.css("display", "none");
    }
}

function submitComment(elem){
    var id = elem.id;
    var sentenceId = id.split("-")[2];
    var name = $("#input-name-" + sentenceId).val();
    var comment = $("#input-comment-" + sentenceId).val();
    var data = {
        'sentenceId': sentenceId,
        'name':name,
        'comment':comment
    };
    data = JSON.stringify(data);

    $.ajax({
        url:'/book/createComment',
        type:'POST',
        data: data,
        dataType: "html",
        contentType: 'application/json',
    })
    .done( (data, status, xhr) => {
        $("#comment-list-" + sentenceId).html(data);
        console.log("SUCCESS!!");
        console.log({data:data, status:status, xhr:xhr});
    })
    .fail( (e) => {
        console.log("ERROR!!");
        console.log(e);
    })
}