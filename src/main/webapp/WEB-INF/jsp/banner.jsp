<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="setup.jsp"/>
        <script>
            $(document).ready(function() {
                redirect("btn", '${url}');
                $(".panel").hide().fadeIn(5000);
                <c:if test="${not empty username}">
                    findAndReplace("username", "${username}");
                </c:if>
            });

            function findAndReplace(find, replace){
                var html = $("#body").html();
                var name = "\${" + find + "}";
                $("#body").html(html.replace(name, replace));
            }
        </script>
        <style>
            .lg-heading{
                min-height: 60px;
            }
            .lg-body{
                min-height: 80px;
            }
            .display-inline{
                display: inline;
            }
        </style>
    </head>
    <div class="outer">
        <section class="black-background inner">
            <div class="panel panel-default centerTroughPage">
                <div class="panel-heading lg-heading">
                </div>
                <div id="body" class="panel-body center-text lg-body nice-body">
                    ${message}
                </div>
                <div class="center-text" style="padding-bottom: 15px">
                    <button class="page-scroll btn btn-xl">Go!</button>
                </div>
                <div class="panel-heading lg-heading">
                </div>
            </div>
        </section>
    </div>
</html>