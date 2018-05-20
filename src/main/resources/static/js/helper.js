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

