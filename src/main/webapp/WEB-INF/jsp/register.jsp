<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="own" uri="http://www.example.org/tags" %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="setup.jsp"/>
<script>
$( document ).ready(function() {
    var RegisterViewModel = function() {
        var self = this;
        self.urlForUsername = "/register/validateUsername";
        self.urlForEmail = "/register/validateEmail";

        self.username = ko.observable().extend({ minLength: 5, maxLength: 20, required:true,
            isAlreadyInDatabase: {url: self.urlForUsername, messageParam:"username"}
        });
        self.name = ko.observable().extend({ minLength: 3, maxLength: 20, required:true });
        self.lastName = ko.observable().extend({ minLength: 3, maxLength: 20, required:true });
        self.email = ko.observable().extend({ minLength: 3, maxLength: 40, required:true, email:true,
            isAlreadyInDatabase: {url: self.urlForEmail, messageParam:"email"}
        });
        self.about = ko.observable().extend({ maxLength: 10000 });
        self.passwordFirst = ko.observable().extend({ minLength: 6, maxLength: 15, required:true });
        self.passwordSecond = ko.observable().extend({ minLength: 6, maxLength: 15, required:true });
        self.code = ko.observable().extend({ minLength: 5, maxLength: 5, required:true });

        self.groups = [
            [self.username, self.name, self.lastName, self.email],
            [self.passwordFirst, self.passwordSecond],
            [self.code, self.about]
        ];

        self.getByGroup = function(newIndex){
            return self.groups[newIndex - 1];
        };

        self.getValidationGroup = function(newIndex){
            return ko.validation.group(self.getByGroup(newIndex));
        };

        self.validate = function(newIndex){
            var currentGroup = self.getValidationGroup(newIndex);
            var isValid = !(currentGroup.length == 0);
            if(!isValid)
                currentGroup.showAllMessages(true);
            return isValid;
        };

        self.sendAll = function(){
            return ko.toJSON(self);
        };
    };

    $("#registrationForm").steps({
        headerTag: "h2",
        bodyTag: "section",
        transitionEffect: "slideUp",
        titleTemplate: "#title#",
        onStepChanging: function (event, currentIndex, newIndex){
            if (currentIndex > newIndex) return false;

            var isValid = viewModel.validate(newIndex);
            return isValid;
        },
        onStepChanged: function (event, currentIndex, priorIndex){},
        onFinishing: function (event, currentIndex){
            viewModel.sendAll();
        },
        onFinished: function (event, currentIndex){}
    });
    var viewModel = new RegisterViewModel();
    ko.validation.init(knockoutValidationSettings, true);
    ko.applyBindingsWithValidation(viewModel, $('#dropzone')[0], knockoutValidationSettings);
    setupProgressBar();
    prepareSending(document);
});
</script>
<sec:csrfMetaTags />
<body style="z-index: -3; position: relative !important;">
    <own:Navbar names="Home,Shop,Register" hrefs="/home,/shop,/register"/>
    <div class="outer m-t-sm">
        <section class="medium-bg inner">
            <div class="inner50">
            <form id="registrationForm" class="form-horizontal" action="#">
                <h2>
                    <span class="awesomeCircleImage"><i class="fa fa-user"></i></span>
                </h2>
                <section>
                    <div class="form-group">
                        <label class="control-label col-sm-2" style="padding-top: 0px">Name:</label>
                        <div class="col-sm-10">
                            <input class="form-control" data-bind="value: name" placeholder="Enter name"></input>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" style="padding-top: 0px">Last Name:</label>
                        <div class="col-sm-10">
                            <input class="form-control" data-bind="value: lastName" placeholder="Enter last name"></input>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" style="padding-top: 0px">Username:</label>
                        <div class="col-sm-10">
                            <input class="form-control" data-bind="value: username" placeholder="Enter username"></input>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" style="padding-top: 0px">Email:</label>
                        <div class="col-sm-10">
                            <input class="form-control" data-bind="value: email" placeholder="Enter email"></input>
                        </div>
                    </div>
                </section>
                <h2>
                    <span class="awesomeCircleImage"><i class="fa fa-lock"></i></span>
                </h2>
                <section>
                    <div class="form-group">
                        <label class="control-label col-sm-2" style="padding-top: 0px">Password:</label>
                        <div class="col-sm-10" style="height: 11px">
                            <input id="password" type="password" class="form-control password" data-bind="value: passwordSecond" placeholder="Enter password"></input>
                            <img src="images/show_hide_password.png" id="pwdImage" alt="" width="30px" height="30px">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" path="password" style="padding-top: 0px">Repeat password:</label>
                        <div class="col-sm-10" style="height: 11px">
                            <input id="password2" type="password" class="form-control password" data-bind="value: passwordFirst" placeholder="Enter password"></input>
                            <img src="images/show_hide_password.png" id="pwdImage2" alt="" width="30px" height="30px">
                        </div>
                    </div>
                </section>
                <h2>
                    <span class="awesomeCircleImage"><i class="fa fa-key"></i></span>
                </h2>
                <section>
                </section>
                <h2>
                    <span class="awesomeCircleImage"><i class="fa fa-check-circle"></i></span>
                </h2>
                <section>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <div class="center-text">
                        <button type="submit" class="page-scroll btn btn-xl">Go!</button>
                    </div>
                </section>
            </form>
            </div>
        </section>
    </div>
</body>
</html>