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

<title>Online shopping - ${title}</title>

<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}'
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Readable CSS -->
<link href="${css}/bootstrap-theme.css" rel="stylesheet">

<!-- Bootstrap DataTable CSS -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>

	<div class="wrapper">

		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content -->

		<!-- user cliques home -->

		<div class="content">

			<c:if test="${userClickHome == true  }">  <!-- see the Pagecontroller where we test cliques -->
				<%@include file="homep.jsp"%>
			</c:if>


			<!-- user cliques home -->
			<c:if test="${userClickAbout == true  }">  <!-- see the Pagecontroller where we test cliques -->
				<%@include file="about.jsp"%>

			</c:if>

			<!-- user cliques home -->
			<c:if test="${userClickContact == true  }">  <!-- see the Pagecontroller where we test cliques -->
				<%@include file="contact.jsp"%>
			</c:if>
			
			<!-- user cliques category -->
			<c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">  <!-- see the Pagecontroller where we test cliques -->
				<%@include file="listProducts.jsp"%>
			</c:if>
			
			<!-- user cliques show products -->
			<c:if test="${userClickShowProduct == true}">  <!-- see the Pagecontroller where we test cliques -->
				  <%@include file="singleProduct.jsp"%>  
			</c:if>
			
			

		</div>
		<!-- end of content.  -->

		<!-- /.container -->
		
		
		

		<!-- Footer -->
		 <%@include file="./shared/footer.jsp"%>  
		
		  <script src="${jquery}/jquery.js"></script>

		<script src="${js}/bootstrap.min.js"></script>
		
		<!-- Data table Plugin Downloaed from https://datatables.net/ -->
		<script src="${js}/jquery.dataTables.js"></script>
		
		<!-- Data table Boostrap script -->
		<script src="${js}/dataTables.bootstrap4.js"></script>
		
		

		<!-- self coded javascript (Yves codes)  -->
		<script src="${js}/myapp.js"></script>
		<!-- for the menu to show nav ex: about, contact.  -->
		


	</div>
	<!-- end of div wrapper starting from the body element -->
</body>

</html>

