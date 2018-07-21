<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
    <title>Lattes - Onepage Multipurpose Bootstrap HTML</title>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <!-- Custom styles for this template -->
    <link href="css/owl.carousel.css" rel="stylesheet">
    <link href="css/owl.theme.default.min.css"  rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="js/ie-emulation-modes-warning.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- THIS LINE -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/cbpAnimatedHeader.js"></script>
    <script src="js/theme-scripts.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>
    <script src='https://www.google.com/recaptcha/api.js'></script>
    <script src="js/knockout.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/knockout-validation/2.0.3/knockout.validation.min.js"></script>
    <script src="js/jquery.steps.min.js"></script>
    <!--own script -->
    <script src="js/helper.js"></script>
    <script src="js/sending.js"></script>
    <script src="js/validation.js"></script>
    <script src="js/knockout-setup.js"></script>
    <link href="css/socialMedia.css" rel="stylesheet">
    <link href="css/helper.css" rel="stylesheet">
    <link href="css/text.css" rel="stylesheet">
    <link href="css/colors.css" rel="stylesheet">
    <link href="css/margins.css" rel="stylesheet">
    <link href="css/jquery-steps.css" rel="stylesheet">
</head>
<sec:csrfMetaTags />
<script>
var knockoutValidationSettings = {
    insertMessages: true,
    decorateElement: true,
    errorMessageClass: 'validationMessage',
    errorElementClass: 'error',
    errorClass: 'error',
    errorsAsTitle: true,
    parseInputAttributes: false,
    messagesOnModified: true,
    decorateElementOnModified: true,
    decorateInputElement: true
};
</script>