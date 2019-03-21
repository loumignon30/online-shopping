CREATE TABLE ctegory(

	id IDENTITY,
	name VARCHAR(255),
	description VARCHAR(255),
	image_url VARCHAR(255),
	is_active BOOLEAN
	
	CONSTRAINT Pk_category_id PRIMARY KEY (id)
	
);