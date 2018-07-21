<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="own" uri="http://www.example.org/tags" %>

<!DOCTYPE html>
<html lang="en">
    <jsp:include page="setup.jsp"/>
    <style>
        .navbar-default{
            background-color: #222 !important;
            max-height: 85px;
        }
        .register{
            position: relative;
            top: -31px;
        }
        footer{
            position: fixed;
            left: 0;
            bottom: 0;
            width: 100%;
        }
    </style>
    <script>
        var callback = function (data) {
            data = JSON.parse(data);
            location.replace(data['url']);
        }
        $( document ).ready(function() {
            prepareSending(document);
            doPasswordShowHideImage();
            var providers = ["google", "facebook"];
            $.each( providers, function( index, provider ){
                $("#" + provider).on("click", function(){
                    var url = "/signin/" + provider;
                    var sendObject = new SendObject({
                        url: url,
                        type: "post",
                        data: [],
                        success: callback,
                        async: true
                    });
                    sendObject.send();
                });
            });
        });
    </script>
    <sec:csrfMetaTags />
    <body id="page-top">
    <own:Navbar names="Home,Shop,Register" hrefs="/home,/shop,/register"/>
    <div class="outer m-t-sm">
        <section class="medium-bg inner">
            <div class="panel panel-default inner35">
                <div class="panel-body center-text">
                    <form class="form-horizontal" action="/login" modelAttribute="user" method="post">
                        <div class="form-group center-text">
                            <div class="niceTitle seafoam-color normal-text center w45"
                                 aria-expanded="true" style="position: relative">
                                Log in or
                                <a href="/register" class="seafoam-color-with-dark-hover">
                                    register!
                                </a>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="clearFloat center col-xs-10">
                                <input type="email" class="form-control" id="email" placeholder="Enter email">
                            </div>
                        </div>
                        <div class="form-group m-b-xs">
                            <div class="clearFloat center col-xs-10">
                                <input type="password" class="form-control" id="password" placeholder="Enter password">
                                <img src="images/show_hide_password.png" id="pwdImage" alt="" width="30px" height="30px">
                                <a href="/forgotPassword" class="seafoam-color-with-dark-hover sm-text normal-text pull-right m-r-xxs">
                                    Forgot password?
                                </a>
                            </div>
                        </div>
                        <div class="center-text m-b-xl center w55">
                            <div class="row">
                                <div class="g-recaptcha" data-sitekey="6LfSOlYUAAAAAAOCUVPT2ObakuApzelIGqLD8IQb">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="center-text">
                                <button type="submit" class="page-scroll btn btn-xl seafoam-color-with-light-hover wave-background"
                                        style="display: inline">
                                    <div class="niceTitle normal-text center-text">
                                        Log in!
                                    </div>
                                </button>
                            </div>
                        </div>
                    </form>
                    <div class="row">
                        <div class="center-text m-t-md">
                            <div class="niceTitle seafoam-color normal-text">
                                Log in via:
                            </div>
                            <div class="m-t-md">
                                <i id="facebook" class="fa fa-facebook wave-color-with-light-hover" style="font-size:60px"></i>
                                <i id="google" class="fa fa-google m-l-sm wave-color-with-light-hover" style="font-size:60px"></i>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="center-text m-t-md">
                            <a href="/info" class="niceTitle seafoam-color-with-dark-hover normal-text sm-text">
                                Don't have account? See what you can get by registering!
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
    <jsp:include page="footer.jsp"/>
    </body>
</html>