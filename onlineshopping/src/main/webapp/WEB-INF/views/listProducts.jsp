
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<!-- calling breadscrum css file. the one use on bootstrap.css not working -->

<link href="${css}/breadcrumb.css" rel="stylesheet" type="text/css">
<link href="${css}/fontawesome.css" rel="stylesheet" type="text/css">
<link href="${css}/glyphiconFile.css" rel="stylesheet" />
<link href="${css}/webfonts/glyphiconFile.css" rel="stylesheet" />

<div class="container">

	<div class="row">

		<!--  this first column would display sidebar.jsp -->
		<div class="col-md-3">

			<%@include file="./shared/sidebar.jsp"%>

		</div>

		<!-- his second column to display the actual products -->
		<div class="col-md-9">

			<!-- we are adding a breadcrumb to test our page. To display: -->
			<!-- Home/category/Mobile on the page. displaying category of product like Mobile ... -->

			<!-- adding breadcrumb component-->

			<div class="row">

				<div class="col-lg-12">

					<c:if test="${userClickAllProducts == true}">
					
					<script>
							window.categoryId = '';
					
					</script>

						<ul class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All products</li>
						</ul>
					</c:if>

					<c:if test="${userClickCategoryProducts == true}">
					
					<script>
							window.categoryId = '${category.id}';
					
					</script>

						<ul class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
						</ul>
					</c:if>

				</div>

			</div>
			

			<div class="row">

				<div class="col-xs-12">
					<table id="productListTable" class="table table-striped table-borderd">
						
						<thead>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty. Available</th>
								<th></th>
								
							</tr>
						</thead>
						
						<tfoot>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty. Available</th>
								<th></th>
								
							</tr>
						</tfoot>
						

					</table>

				</div>

			</div>
		</div>

	</div>

</div>