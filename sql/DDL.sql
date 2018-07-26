drop table cart;
drop table order_item;
drop table order_form;
drop table delivery_info;
drop table sale_info;
drop table user;
drop table seller;

create table seller
    (id              int auto_increment,
     email           varchar(30),
     password        varchar(30),
     telephone       varchar(30),
     username        varchar(20),
     balance         int,
     pay_pwd         varchar(50),
     primary key (id)   
    );

create table user
    (id              int auto_increment,
     username        varchar(20),
     pay_pwd         char(40),
     password        char(40),
     salt            char(10),
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
     description     text,
     image           varchar(20),
     mvo_cmdt_id     int,
     name            varchar(20),
     price           int check (price >= 0),
     quantity        int,
     seller_id       int,
     brand_id        int,
     shop_id         int,
     state           tinyint check (state in (0,1)),
     primary key (id),
     foreign key (seller_id) references seller (id) 
        on delete set null 
    );

create table delivery_info
    (id              int auto_increment, 
     user_id         int,
     name            varchar(20),
     address         varchar(81),
     phone           varchar(20),
     phostcode       varchar(10),
     primary key (id),
     foreign key (user_id) references user (id)
        on delete set null             
    );

create table order_form
    (id              int auto_increment, 
     order_id        int,
     creation_time   datetime,
     consumer_id     int,
     delivery_id     int,
     notes           text,
     total           int check (total >= 0),
     primary key (id),
     foreign key (consumer_id) references user (id)
        on delete set null 
    );

create table order_item
    (id              int auto_increment,
     count           int check (count >= 0),
     notes           text,
     order_id        int,
     sale_info_id    int,
     state           tinyint check (state in (1,2,3,4)),
     primary key (id),
     foreign key (sale_info_id) references sale_info (id)
        on delete set null
    );

create table cart
    (user_id         int,
     sale_info_id    int,
     quantity        int check (quantity >= 0), 
     primary key (user_id, sale_info_id),   
     foreign key (user_id) references user (id)
        on delete cascade,
     foreign key (sale_info_id) references sale_info (id)
    );
