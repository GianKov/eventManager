<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"  %>
<%@ page import = "java.io.*,java.util.*" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <%--<meta CHARSET='utf-8'>--%>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>eventManager</title>
    <!--Angular JS-->

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>

    <!-- jQuery -->
    <script src="<c:url value="/resources/vendor/jquery/jquery.min.js" />"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js" />"></script>
    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="<c:url value="/resources/vendor/font-awesome/css/font-awesome.min.css" />" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
    <!-- Plugin CSS -->
    <link href="<c:url value="/resources/vendor/magnific-popup/magnific-popup.css" />" rel="stylesheet">
    <!-- Theme CSS -->
    <link href="<c:url value="/resources/css/creative.min.css" />" rel="stylesheet">
    <!-- Table CSS -->
    <link href="<c:url value="/resources/css/tableStyle.css" />" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body id="page-top">
<%
    String osp = new String("guest");
    String utente = new String("user");
    if(session.isNew()){
        session.setAttribute(utente,osp);}
%>
<nav id="mainNav" class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">

        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
            </button>
            <a class="navbar-brand page-scroll" href="<c:url value="/" />#page-top">eventManager</a>

        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <%--<input type="hidden" id="pageurl" name="pageurl" value="${requestScope['javax.servlet.forward.request_uri']}">--%>
                <li>
                    <a class="page-scroll" href="<c:url value="/event/eventList"/>#services">Eventi</a>
                </li>
                <li>
                    <a class="page-scroll" href="<c:url value="/"/>#contact">Contattaci</a>
                </li>
                <% if (!(session.getAttribute("user").equals("guest"))) { %>
                    <li><a>Benvenuto <% out.println(session.getAttribute("nomeUser")); %></a></li>
                    <li><a href="<c:url value="/cart/getCart" />">Carrello</a></li>
                    <li><a href="<c:url value="/payment/resume" />">Acquisti</a></li>
                    <li><a href="<c:url value="/logout" />">Logout</a></li>

                <%--<c:if test="${pageContext.request.userPrincipal.name != 'admin'}">--%>

                <%--//</c:if>--%>
                <%--<c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                    <li><a href="<c:url value="/admin" />#portfolio">Admin</a></li>
                </c:if>--%>
                <% } %>
                <% if (session.getAttribute("user").equals("guest")) { %>
                    <li>
                        <a class="page-scroll" href="<c:url value="/login" />#portfolio">Login</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="<c:url value="/registrazione"/>#services">Registrati</a>
                    </li>
                <% } %>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>
</body>