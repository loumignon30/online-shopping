
$(function(){
	
	// solving the a tive menu problem
	switch(menu){
	
	case 'About us':
		$('#about').addClass('active');   // taken from navbar.jsp list of elements <li id="about" class="nav-item">
		break;
		
	case 'About us':
		$('#about').addClass('active');   // taken from navbar.jsp list of elements <li id="about" class="nav-item">
		break;
		
	case 'Contact us':
		$('#contact').addClass('active');   // taken from navbar.jsp list of elements <li id="contact" class="nav-item">
		break;
	default:
		$('#home').addClass('active');
		break;
	}
});