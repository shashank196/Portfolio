create database portfolio;

use portfolio;


drop table userTable;
drop table transactions;
drop table compute;
drop table stock_market;


create table userTable(
	emailID varchar(30) primary key,
    userName varchar(20) NOT null,
    phoneNo bigint
);

create table transactions(
	transactionId bigint auto_increment primary key,
	type varchar(5) check (type='BUY' or type='SELL'),
	price decimal(10,4), 
    quantity bigint,
    date date,
    emailId varchar(40) references userTable(emailId),
    stock varchar(20)
);

create table compute(
	emailId varchar(40) references userTable(emailId),
    stock varchar(20) references transactions(stock),
    buy_amount decimal(12,4),
    sell_amount decimal(12,4),
    buy_count integer,
    total_buy decimal(12,4),
    buy_quantity bigint,
    sell_quantity bigint,
    primary key(emailId,stock)
);


select * from userTable;

select * from transactions;

select * from compute;

select * from stock_market;

create table stock_market(
	stock_name varchar(20) primary key,
    price double
);

truncate table stock_market;
