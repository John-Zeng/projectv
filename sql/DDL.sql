drop table cart;
drop table order_item;
drop table order_form;
drop table delivery_info;
drop table sale_info;
drop table user;
drop table seller;

create table seller
    (id          int auto_increment,
     name        varchar(20),
     password    varchar(30),
     primary key (id)	
    );

create table user
    (id              int auto_increment,
     username        varchar(20) not null,
     pay_pwd         char(40) not null,
     password        char(40) not null,
     salt            char(10) not null,
     email           varchar(30),
     telephone       varchar(20),
     birthday        date,
     gender          tinyint check (gender in (0,1)),
     balance         int check (balance >= 0),
     primary key (id)
    );

create table sale_info
    (id              int auto_increment,
     company_id      int,
     brand_id        int,
     mvo_cmdt_id     int,
     seller_id       int,
     name            varchar(20) not null,
     img_address     varchar(10) not null,
     price           int not null check (price >= 0),
     description     text not null,
     state           tinyint check (state in (0,1)),
     primary key (id),
     foreign key (seller_id) references seller (id) 
        on delete cascade
    );

create table delivery_info
    (id              int auto_increment, 
     user_id         int,
     name            varchar(20) not null,
     address         varchar(81) not null,
     phone           varchar(20) not null,
     phostcode       varchar(10) not null,
     primary key (id),
     foreign key (user_id) references user (id)
        on delete cascade                
    );

create table order_form
    (id              int auto_increment, 
     order_id        int,
     consumer_id     int,
     receiver_delivery_info_id     int,
     creation_time     datetime not null,
     total           int not null check (total >= 0),
     notes           varchar(81),
     primary key (id),
     foreign key (consumer_id) references user (id)
        on delete cascade
    );

create table order_item
	(id              int auto_increment,
	 sale_info_id    int,
	 order_id        int,
	 count           int not null check (count >= 0),
	 notes           varchar(81),
	 state           tinyint not null check (state in (1,2,3,4)),
	 primary key (id),
	 foreign key (sale_info_id) references sale_info (id)
	    on delete cascade,
	 foreign key (order_id) references order_form (id)
	    on delete cascade
	);

create table cart
    (user_id         int,
     sale_info_id    int,
     quantity        int not null check (quantity >= 0), 
     primary key (user_id, sale_info_id),	
     foreign key (user_id) references user (id)
        on delete cascade,
     foreign key (sale_info_id) references sale_info (id)
    );
