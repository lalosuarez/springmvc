<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	
	<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
	
	<title><decorator:title default="myapp"/></title>
        
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script>
    <script type="text/javascript" src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
    <script type="text/javascript" src="../../js/app.js"></script>
    
    <link rel="stylesheet"  href="https://code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css" />
    <link rel="stylesheet"  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" />
    <link rel="stylesheet"  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css" />
    <link rel="stylesheet"  href="../../css/style.css" />
    
    <decorator:head/>
</head>
<body id="page-home" ng-app="app">
    <div id="page" class="content">

        <nav class="navbar navbar-default">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#main-menu">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">RedMetro</a>
            </div>


            <div class="collapse navbar-collapse" id="main-menu">
                <ul class="nav navbar-nav">
                    <li><a href="<c:url value='../lineas/list'/>">Líneas</a></li>
                </ul>
                <ul class="nav navbar-nav">
                    <li><a href="<c:url value='../estaciones/list'/>">Estaciones</a></li>
                </ul>                                                                                                    
            </div>

        </nav>

        <div id="content">
            <div id="main">
            	<decorator:body/>
                <hr />
            </div>
        </div>
        
        <div id="footer"></div>
        
    </div>
</body>
</html>
