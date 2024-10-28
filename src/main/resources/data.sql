INSERT INTO customer (id,name,customer_since) VALUES (1,'Zouheir','1989-07-03');
INSERT INTO customer (id,name,customer_since) VALUES (2,'Ahmed','1972-08-13');

INSERT INTO product (id,name,price,in_stock) VALUES (1,'Bim',2.34,true);
INSERT INTO product (id,name,price,in_stock) VALUES (2,'Chocolate',5.32,true);

INSERT INTO comment (id,text,product_id) VALUES (1,'Bim is good',1);
INSERT INTO comment (id,text,product_id) VALUES (2,'Chocolate is the best',2);

INSERT INTO orders (id,date,customer_id) VALUES (1,'2023-05-23',2);
INSERT INTO orders (id,date,customer_id) VALUES (2,'2023-03-28',1);

INSERT INTO order_line (id,amount,purchase_price,product_id,order_id) VALUES (1,3,10.99,2,1);
INSERT INTO order_line (id,amount,purchase_price,product_id,order_id) VALUES (2,5,4.99,1,2);
