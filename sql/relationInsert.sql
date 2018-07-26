delete from cart;
delete from order_item;
delete from order_form;
delete from delivery_info;
delete from sale_info;
delete from user;
delete from seller;

insert into seller (name, password) values ("Mary", "123");

insert into user (username, pay_pwd, password, salt, email, telephone, birthday, gender, balance) values("Bob","123","456","789","bob@pv.com","1384194310","2017-07-06",1,123);