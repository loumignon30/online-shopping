<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<!-- calling breadscrum css file. the one use on bootstrap.css not working -->

<link href="${css}/breadcrumb.css" rel="stylesheet" type="text/css">
<div class = "container">

<!-- BreadCrumb component -->

	<div class="row">
	
		<div  class="col-xs-12">
		
			<ul class="breadcrumb">
			
				<li><a href="${contextRoot}/home">Home</a>
				<li><a href="${contextRoot}/show/all/products">Products</a>
				<li class="active">${product.name}</li>
				
			</ul>
		
		</div>
	
	</div>
	
	
	<!-- now we are displaying our product -->

	<div class="row"></div>
	
	<!-- we are going to dispay the product image -->
	
		<div class="col-xs-12 col-sm-4">  <!-- col-sm-4 = to display on extra small devices -->
		
			<div class="thumbnail">
			
				<img src="${images}/${product.code}.jpg" class="img img-responsive"/>
			
			</div>
			
		
		</div>
		
		<!-- we are going to dispay the product description -->
		
		<div class="col-xs-12 col-sm-8">  <!-- col-sm-4 = to display on small devices -->
		
			
				<h3>${product.name}</h3>
				<hr/>
				
				
				<p>${product.description}</p>
				<hr/>
				
				<h4>Price: <strong>&#8364; ${product.unit_price}</strong></h4>
				<hr/>
								
				<c:choose>
					
					<c:when test="${product.quantity < 1}">
					
						<h6>Qty. Available: <span style="color:red">Out of Stock!</span></h6>
						
					</c:when>
					<c:otherwise>
					
						<h6>Qty. Available: ${product.quantity}</h6>
						
					</c:otherwise>
					
				</c:choose>
				
				
				<c:choose>
					
					<c:when test="${product.quantity < 1}">
					
				<a href= "javascript:void(0)" class="btn btn-success disabled"><strike>
				<span class="glyphicon glyphicon-shopping-cart"></span>Add to cart</strike></a>
				
					</c:when>
					<c:otherwise>
					
				<a href= "${contextRoot}/cart/add/${product.id}/product" class="btn btn-success">
				<span class="glyphicon glyphicon-shopping-cart"></span>Add to cart</a>
				
						
					</c:otherwise>
					
				</c:choose>
				
				<hr/>
				
				<%-- <a href= "${contextRoot}/cart/add/${product.id}/product" class="btn btn-success">
				<span class="glyphicon glyphicon-shopping-cart"></span>Add to cart</a>
				 --%>
				<a href= "${contextRoot}/show_all_products" class="btn btn-primary">Back</a>
				
		</div>

</div>