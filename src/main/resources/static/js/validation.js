/**
 * Created by Marcin on 25.02.2018.
 */

var ValidationPrinter = function(options){
    var properties = {
        validationProperties: ''
    }
    this.construct = function(options){
        $.extend(properties , options);
    }
    this.validate = function(){
        var p = properties.validationProperties;
        $.each(p, function (index, value) {
            var message = value.message;
            $("#"+value.property).addClass("validation");
            $("#"+value.property).parents(".form-group").append(
                "<div class=\"col-sm-offset-2 col-sm-10 validationMessage\">" + "* " + message + "</div>");
        });
    }
    this.construct(options);
}

