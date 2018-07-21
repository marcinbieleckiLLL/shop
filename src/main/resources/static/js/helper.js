function doPasswordShowHideImage() {
    setPasswordShowHideImagePosition();
    $(window).on('resize', function(){
        setPasswordShowHideImagePosition();
    });
    handleShowHideEffect();
}

function setPasswordShowHideImagePosition(){
    var y = $('#password').offset().top + 2;
    var x = $('#password').offset().left;
    var width = $('#password').innerWidth() + x - 30;
    $('#pwdImage').offset({ top : y, left : width});
}

function handleShowHideEffect(){
    $('#pwdImage').on("click", function () {
        var x = $('#password');
        if(x.attr('type') == "password")
            x.attr('type', 'text');
        else if(x.attr('type') == "text")
            x.attr('type', 'password');
    })
}

function setupProgressBar(){
    $("ul[role='tablist']").append("<div class=\"progress-bar\"></div>");
    $("ul[role='tablist']").append("<div class=\"progress-bar-color\"></div>");
    resizeProgressBar();
    $(window).on('resize', function(){
       resizeProgressBar();
    });
}

function resizeProgressBar(){
    $("ul[role='tablist']").find("li").each(function(index, item){
        $( this ).css("z-index", "3");
        $( this ).css("position", "relative");
        var newMargin =  (1 - window.innerWidth/screen.width) * - 37;
        $( this ).css("transform", "translateX(" + newMargin + "px)");
    });
}

