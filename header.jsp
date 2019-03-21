<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>National Park Geek</title>
    <c:url value="/css/nationalparkgeek.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">
</head>

<body>
    <header>
   		<c:url value="/" var="homePageHref" />
   		<c:url value="/img/trees-up copy.png" var="logoSrc" />
        <a href="${homePageHref}">
        		<img id="logo" src="${logoSrc}" alt="National Parks Geek Logo" />
        </a>
    </header>
    <div>    
        <h1 class="npg">National Park Geek</h1>
        	<c:url value="/homePage" var="homeURL"/>
	        <a href="${homeURL}"><button type="text" class="navButton1">-Home-</button> </a>
	        <c:url value="/survey" var="surveyURL"/>
	        <a href="${surveyURL}"><button type="text" class="navButton2">-Survey-</button></a>
	    
	        
    </div>
    
