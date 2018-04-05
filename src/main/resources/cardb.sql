create database cardb
character set utf8
collate utf8_general_ci;

use cardb;

create table music(
_mid varchar(20) not null,
_title varchar(50),
_singer varchar(50),
_album varchar(50),
primary key(_mid)
) engine=InnoDB default charset=utf8;