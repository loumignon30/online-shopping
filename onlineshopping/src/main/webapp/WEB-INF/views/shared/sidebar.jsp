
<h1 class="my-4">Shop Name</h1>

<div class="list-group">
	<c:forEach items="${categories}" var="category">

		<!--  <a href="${contextRoot}/show/all/category/${category.id}/products" class="list-group-item">${category.name}</a>  -->
		<a href="${contextRoot}/showcategory_${category.id}_products" class="list-group-item" id ="a_${category.name}">${category.name}</a>
		<!-- see navbar.jsp where we get productid =  <a class="nav-link" href="${contextRoot}/show/all./products">View Products</a> -->
		

	</c:forEach>

</div>
