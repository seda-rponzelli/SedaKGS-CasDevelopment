<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://template.seda.it/tags" prefix="x"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/Seda.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/timepicker/jquery-ui-timepicker-addon.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="${x:theme('css')}"/>">
     <link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
      <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
      <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script> 

<script src="<c:url value="/resources/menuTree/javaScript/menuTree.js"/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/menuTree/menuCss/mktree.css"/>">

<script src="<c:url value="/resources/timepicker/jquery-ui-timepicker-addon.js"/>"></script>

<script>
	$(document).ready(function() {
		// date picker i18N
		$.datepicker
				.setDefaults($.datepicker.regional["${pageContext.response.locale}"]);
	});
</script>


<title>${x:i18n('application.title')}</title>
</head>

<body dir="${x:i18ndir()}">
	<div class="container">
		<div class="header">
			<div class="headerLeft">
				<x:include parameter="headerLeft" />
			</div>
			<div class="headerRight">
				<x:include parameter="headerRight" />
			</div>
		</div>
		<div class="middle">
			<div class="contentRight">
				<x:include parameter="content" />
			</div>
		</div>	
			<x:include parameter="footer" />
	</div>
</body>
</html>
