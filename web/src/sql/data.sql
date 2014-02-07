INSERT INTO brands(id,brand_code,brand_name) VALUES (nextval('seq_brand'), 'BRAND_CODE1','BRAND_NAME1');
INSERT INTO categories(id,category_code,category_name) VALUES (nextval('seq_category'),'CATEGORY_CODE1','CATEGORY_NAME1');
INSERT INTO products(id,description,picture_link,product_code, product_name,brand_id, category_id, banner_link,price) VALUES (nextval('seq_product'),'desc','http://cdn4.steampowered.com/v/gfx/apps/237890/capsule_sm_120.jpg?t=1391535415',
'PRODUCT_CODE1','PRODUCT_NAME1',1,1,'http://cdn4.steampowered.com/v/gfx/apps/25000/ss_488f92057ef9739d73f734be8dbc8766921374a3.600x338.jpg?t=1387494130',100);
INSERT INTO users(id,address, email, firstname, lastname,password,username, role ) VALUES 
  (nextval('seq_user'),'address','email','firstname','lastname','admin','admin','ADMIN');
INSERT INTO users(id,address, email, firstname, lastname,password,username, role ) VALUES
  (nextval('seq_user'),'address','email','firstname','lastname','user','user','USER');