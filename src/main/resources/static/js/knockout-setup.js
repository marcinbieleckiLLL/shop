/**
 * Created by Marcin on 17.06.2018.
 */
//validation
ko.validation.rules['isAlreadyInDatabase'] = {
    validator: function(val, data) {
        var a = isAlreadyInDatabase(val, data.url);
        return a;
    },
    message: function (data) {
        return "This " + data.messageParam + " is already in database!"
    }
};
ko.validation.registerExtenders();


function isAlreadyInDatabase(val, url){
    var isAlreadyInDatabase = false;
    return new SendObject({
        url: url,
        type: "post",
        data: [val],
        success: self.callback,
        async: true,
        returnedValue: isAlreadyInDatabase
    }).send();
};
function callback(data){return data;}