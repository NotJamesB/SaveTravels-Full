<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>reserve</title>
</head>
<body>
	<h1 class="txt-primary">Expense Details</h1> 
	<p>
	<h3>Expense Name: ${expense.name}</h3>
	<p>
	<h3>Expense Description: ${expense.description}</h3>
	<p>
	<h3>Vendor: ${expense.vendor}</h3>
	<p>
	<h3>Amount Spent: ${expense.price}</h3>
	<p>
	<a href="/expense">Go Back</a>
</body>
</html>