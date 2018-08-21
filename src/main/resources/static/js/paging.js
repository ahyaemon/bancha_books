function ajaxPagingFirst(url, selector){
    ajaxPaging(1, url, selector);
}

function ajaxPagingPrevious(currentPageNumber, url, selector){
    ajaxPaging(currentPageNumber - 1, url, selector);
}

function ajaxPagingNext(currentPageNumber, url, selector){
    ajaxPaging(currentPageNumber + 1, url, selector);
}

function ajaxPaging(pageNumber, url, selector){
    var data = {
        'pageNumber': pageNumber,
    };
    data = JSON.stringify(data);

    function done(data, status, xhr){
        $(selector).html(data);
    }

    function fail(e){
        console.log(e);
    }

    doAjax(url, data, done, fail);
}