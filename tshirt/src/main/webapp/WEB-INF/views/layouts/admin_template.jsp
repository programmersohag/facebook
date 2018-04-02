<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet"
	href="<c:url value='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css'/>" />
<link rel="stylesheet"
	href="<c:url value='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'/>" />
<%-- <link rel="stylesheet" href="<c:url value='resources/css/app-style.css'/>" /> --%>
<title><tiles:getAsString name="title" /></title>

<style type="text/css">
</style>
</head>

<body>
	<div class="container-fluid">
		<div class="row">
			<header>
				<tiles:insertAttribute name="header" />
			</header>
		</div>
		<div class="row">
			<section class="col-md-4">
				<tiles:insertAttribute name="menu" />
			</section>

			<section class="col-md-8">
				<tiles:insertAttribute name="body" />
			</section>
		</div>
		<div class="row">
			<footer>
				<tiles:insertAttribute name="footer" />
			</footer>
		</div>
	</div>
	<%-- <script src="<c:url value='/webjars/jquery/3.2.1/jquery.min.js'/>"></script> --%>
	<script
		src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script
		src="<c:url value='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js'/>"></script>
</body>
</html>