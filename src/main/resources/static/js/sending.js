/**
 * Created by Marcin on 27.12.2017.
 */
var SendObject = function(options){
    var properties = {
        url: '',
        type: '',
        data: '',
        success: ''
    }
    this.construct = function(options){
        $.extend(properties , options);
    }
    this.send = function(){
        var firstParameter = properties.data != null ? (properties.data.length > 0 ? properties.data[0] : null) : null;
        var secondParameter = properties.data != null ? (properties.data.length > 1 ? properties.data[1] : null) : null;
        $.ajax({
            url: properties.url,
            type: properties.type,
            data: {
                first: firstParameter,
                second: secondParameter,
            },
            success: function (data) {
                properties.success(data);
            }
        });
    }
    this.construct(options);
}

function prepareSending(document){
    var csrfHeader = $("meta[name='_csrf_header']").attr("content");
    var csrfToken  = $("meta[name='_csrf']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(csrfHeader, csrfToken);
    });
}

function redirect(className, url){
    $("."+className).on("click", function () {
        location.href = '/' + url;
    });
}