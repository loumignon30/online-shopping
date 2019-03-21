$(function() {

	// solving the a tive menu problem
	switch (menu) { // we are storing the title inside de menu (title of
					// category)

	case 'About us':
		$('#about').addClass('active'); // taken from navbar.jsp list of
										// elements <li id="about"
										// class="nav-item">
		break;

	case 'About us':
		$('#about').addClass('active'); // taken from navbar.jsp list of
										// elements <li id="about"
										// class="nav-item">
		break;

	case 'Contact us':
		$('#contact').addClass('active'); // taken from navbar.jsp list of
											// elements <li id="contact"
											// class="nav-item">
		break;
	case 'All Products':
		$('#listProducts').addClass('active'); // taken from navbar <li id =
												// "listProducts"
												// class="nav-item">
	default:
		if (menu == "Home")
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active'); // we are getting the category name
											// inside the menu. We are passing
											// it as a title and the title is
											// stored inside the menu
		break;
	}

	// code for Jquery dataTable
	// create dataset
	// var products = [
	//		
	// ['1', 'ABC'],
	// ['2', 'QTR'],
	// ['3', 'TYG'],
	// ['4', 'YUJ'],
	// ['5', 'FVD'],
	// ['6', 'RER'],
	// ['7', 'YVES'],
	// ['8', 'ABFC']
	//		
	// ];
	//	
	var $table = $('#productListTable'); // from lisProducts.jsp

	// execute the below code where we have a table
	if ($table.length) {

		var jsonUrl = '';
		if (window.categoryId == '') {

			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {

			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}

		$table.DataTable({

			lengthMenu : [ [ 3, 5, 10, -1 ],
					[ '3 Records', '5 Records', '10 Record', 'ALL' ] ],
			pageLength : 5,
			// data:products // getting data from product var

			ajax : {

				url : jsonUrl,
				dataSrc : ''
			},
			columns : [   // se json postame fields. need to change the columns name on listProducts.js

				{
					data : 'code',
					mRender: function(data, type, row){
						
						return '<img src="' + window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg">';
					}
					
				}, 
				
			{
				data : 'name'
			}, 
			{
				data : 'brand'

			}, 
			
			{
//				
				data : 'unit_price',
				mRender: function(data, type, row){
					return '&#8364;' + data  // euro symbol html = &#8364; dollar = &#36				}
				}
			}, 
			
			{
				data : 'quantity',
				mRender: function(data, type, row){
					
					if(data < 1){
						
						return '<span style="color:red">Out of Stock!</span>';
					}
					return data;
				}

			}, 
			
			{
				
				data: 'id',
				bSortable: false,
				mRender: function(data, type, row){
					
					var str = '';
					str += '<a href = "'+window.contextRoot+'/show_'+data+'_product" class="btn btn-primary">View</a> &#160';  //&#160 add space
					
					if(row.quantity <1){
						str += '<a href = "javascript:void(0)" class="btn btn-success disabled">Cart</a>';
						
					}else{
						str += '<a href = "'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-primary">Cart</a>';
						
						
					}
					
//					str += '<a href = "'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><span class="fas fa-camera-retro"></span></a> &#160';  //&#160 add space
//					str += '<a href = "'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-sucess"><span class="glyphicon glyphicon-shopping-cart"></a>';
//					
					return str;
				}
			},
			
			]

		})

	}

});