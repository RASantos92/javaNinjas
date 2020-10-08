  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Time</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="jumbotron">  
        	<div class="col mx-auto bg-dark">
        		<div class="col-8 mx-auto bg-light">
        			<h1>${ninja.name}</h1>
        			<h2>Home Town: ${ninja.hometown}</h2>
        			<h3>Skill Level: ${ninja.level}</h3>
        			<a href="/ninjas/${ninja.id}" class="btn btn-sm btn-secondary">Edit Ninja</a>
        			<a href="/ninja/destroy/${ninja.id}" class="btn btn-sm btn-secondary">Kill ninja</a>
        			<a href="/" class="btn btn-sm btn-secondary">Go Home</a>
        		</div>
        	</div>
        </div>
    </div>
</body>
</html>