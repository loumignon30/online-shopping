<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<!-- this resources are coming from dispatcher-servlet mvc:resources -->
<spring:url var="js" value="/resources/js" />
<!-- this resources are coming from dispatcher-servlet mvc:resources -->
<spring:url var="jquery" value="/resources/jquery" />
<!-- this resources are coming from dispatcher-servlet mvc:resources -->
<spring:url var="images" value="/resources/images" />
<!-- this resources are coming from dispatcher-servlet mvc:resources -->

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />


<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online shopping - ${title} </title>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>

	<!-- Navigation -->
	<%@include file="./shared/navbar.jsp"%>

	<!-- Page Content -->
	
	<!-- user cliques home -->
	
	<c:if test="${userClickHome == true  }">
		<%@include file="homep.jsp"%>
	</c:if>
	
	
	<!-- user cliques home -->
	<c:if test="${userClickAbout == true  }">
		<%@include file="about.jsp"%>
		
	</c:if>
	
	<!-- user cliques home -->
	<c:if test="${userClickContact == true  }">
		<%@include file="contact.jsp"%>
	</c:if>
	
	

	<!-- /.container -->

	<!-- Footer -->
	<%@include file="./shared/footer.jsp"%>

	<!-- Bootstrap core JavaScript -->
	<script src="${jquery}/jquery.min.js"></script>
	<script src="${js}/bootstrap.bundle.min.js"></script>

</body>

</html>

