
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />  <!-- calling breadscrum css file. the one use on bootstrap.css not working -->

<link href="${css}/breadcrumb.css" rel="stylesheet" type="text/css">

<div class="container">

	<div class="row">

		<!--  this first column would display sidebar.jsp -->
		<div class="col-md-3">

			<%@include file="./shared/sidebar.jsp"%>

		</div>

		<!-- his second column to display the actual products -->
		<div class="col-md-9">

			<!-- we are adding a breadcrumb to test aour page. To display: -->
			<!-- Home/category/Mobile on the page. displaying category of product like Mobile ... -->

			<!-- adding breadcrumb component-->

			<div class="row">

				<div class="col-lg-12">

					<c:if test="${userClickAllProducts == true}">

						<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active"> All products</li>
						</ol>
					</c:if>
					
					<c:if test="${userClickCategoryProducts == true}">
					
						<<ul class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
						</ul>
					</c:if>

				</div>

			</div>

		</div>

	</div>

</div>