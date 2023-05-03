<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop Homepage Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value = "/template/web/css/bootstrap.css"/>"
	rel="stylesheet">

<!-- Add custom CSS here -->
<link href="<c:url value = "/template/web/css/shop-homepage.css"/>"
	rel="stylesheet">

</head>

<body>
	<!-- header -->
	<%@ include file="/common/web/header.jsp"%>
	<!-- header -->
	
	<!-- body -->
	<div class="container">
	<decorator:body />

	</div>
	<!-- body -->
	
	
	<!-- foooter -->
	<%@ include file="/common/web/footer.jsp"%>
	<!-- foooter -->
	<!-- JavaScript -->
	<script src="<c:url value = "/template/web/js/jquery-1.10.2.js"/>"></script>
	<script src="<c:url value = "/template/web/js/bootstrap.js"/>"></script>

</body>

</html>