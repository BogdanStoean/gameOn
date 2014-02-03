INSERT INTO brands(id,brand_code,brand_name) VALUES (nextval('seq_brand'), 'BRAND_CODE1','BRAND_NAME1');
INSERT INTO categories(id,category_code,category_name) VALUES (nextval('seq_category'),'CATEGORY_CODE1','CATEGORY_NAME1');
INSERT INTO products(id,description,picture_link,product_code, product_name,brand_id, category_id)
VALUES (nextval('seq_product'),'desc','link','PRODUCT_CODE1','PRODUCT_NAME1',1,1);