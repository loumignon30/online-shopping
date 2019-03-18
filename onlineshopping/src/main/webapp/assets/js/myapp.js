
$(function(){
	
	// solving the a tive menu problem
	switch(menu){   // we are storing the title inside de menu (title of category)
	
	case 'About us':
		$('#about').addClass('active');   // taken from navbar.jsp list of elements <li id="about" class="nav-item">
		break;
		
	case 'About us':
		$('#about').addClass('active');   // taken from navbar.jsp list of elements <li id="about" class="nav-item">
		break;
		
	case 'Contact us':
		$('#contact').addClass('active');   // taken from navbar.jsp list of elements <li id="contact" class="nav-item">
		break;
	case 'All Products':
		$('#listProducts').addClass('active'); // taken from navbar <li id = "listProducts" class="nav-item">
	default:
		$('#listProducts').addClass('active');
	$('#a_' + menu).addClass('active');   // we are getting the category name inside the menu. We are passing it as a title and the title is stored inside the menu
		break;
	}
});