CREATE DATABASE library_db;


CREATE TABLE address(
address_id int primary key not null,
country varchar(30) not null,
city varchar(30) not null,
street varchar(40) not null,
house_number varchar(10) not null 
);

CREATE TABLE library(
library_id int primary key not null,
name varchar(30) not null,
address_id int not null,
foreign key(address_id) references address(address_id)
);

CREATE TABLE author(
author_id int primary key not null,
name varchar(40) not null,
birth_date date,
birth_place varchar(50),
nationality varchar(30)
);

CREATE TABLE book(
book_id int primary key not null,
title varchar(30) not null,
author_id int not null,
publish_year int(4),
category varchar(20) not null,
library_id int not null,
foreign key(author_id) references author(author_id),
foreign key(library_id) references library(library_id)
);

CREATE TABLE role(
role_id int primary key not null,
role_name varchar(20) not null
);

CREATE TABLE user(
user_id int primary key not null,
role_id int not null,
username varchar(30) not null,
email varchar(40) not null,
password varchar(20) not null,
birth_date date,
nationality varchar(20),
name varchar(40) not null,
address_id int not null,
foreign key(role_id) references role(role_id),
foreign key(address_id) references address(address_id)
);

CREATE TABLE loan(
book_id int not null,
user_id int not null,
loan_started_date date not null,
loan_ends_date date,
loan_status varchar(20),
foreign key(book_id) references book(book_id),
foreign key(user_id) references user(user_id)
);

CREATE TABLE membership(
user_id int not null,
library_id int not null,
beginning_of_membership date,
foreign key(user_id) references user(user_id),
foreign key(library_id) references library(library_id)
);