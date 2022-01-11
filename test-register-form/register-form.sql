drop database if exists `register-form`;
create database if not exists `register-form`;

use `register-form`;

drop table if exists `user`;

create table if not exists `user`(
id int auto_increment primary key,
name varchar(10) not null,
password varchar(128) not null,
hobby varchar(128) not null
)character set utf8;
