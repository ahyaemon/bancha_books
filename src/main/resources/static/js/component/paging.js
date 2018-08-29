function ajaxPagingFirst(id, url, selector){
    var $id = $("#" + id);
    var pageNumber = 1;
    $id.data().page = pageNumber;
    ajaxPaging($id, pageNumber, url, selector);
}

function ajaxPagingPrevious(id, url, selector){
    var $id = $("#" + id);
    var pageNumber = $id.data().page;
    var previousPageNumber = pageNumber - 1;
    $id.data().page = previousPageNumber;
    ajaxPaging($id, previousPageNumber, url, selector);
}

function ajaxPagingNext(id, url, selector){
    var $id = $("#" + id);
    var pageNumber = $("#" + id).data().page;
    var nextPageNumber = pageNumber + 1;
    $id.data().page = nextPageNumber;
    ajaxPaging($id, nextPageNumber, url, selector);
}

function ajaxPaging($id, pageNumber, url, selector){
    var additionalData = $id.data().additional;
    var data = $.extend(
        additionalData,
        { 'pageNumber': pageNumber }
    )
    data = JSON.stringify(data);

    function done(data, status, xhr){
        $(selector).html(data);
    }

    function fail(e){
        console.log(e);
    }

    doAjax(url, data, done, fail);
}