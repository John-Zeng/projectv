delete from cart;
delete from order_item;
delete from order_form;
delete from delivery_info;
delete from sale_info;
delete from user;
delete from seller;

insert into seller (name, password) values ("Mary", "123");

insert into user (username, pay_pwd, password, salt, email, telephone, birthday, gender, balance) values("Bob","123","456","789","bob@pv.com","1384194310","2017-07-06",1,123);

insert into	sale_info (company_id, brand_id, mvo_cmdt_id,seller_id, name, img_address,price, description,state) values (1,1,1,1,"MacBook", "macbook.jpeg",1549,

	String j = "<b>Specifications</b>:<br>"
                + "=<lu><li>2.2GHz dual-core Intel Core i7 processor, Turbo Boost up to 3.2GHz</li>"
                + "=<li>8GB 1600MHz LPDDR3 memory</li>" + "<li>512GB SSD storage</li>"
                + "=<li>Intel HD Graphics 6000</li>" + "<li>Backlit Keyboard - US English</li></lu>";

