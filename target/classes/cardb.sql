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

create table config(
config_id int not null auto_increment,
com_user_id int,
primary key(config_id)
) engine=InnoDB default charset=utf8;

create table testdata(
id int not null auto_increment,
_date varchar(20) not null,
_value int not null,
primary key(id)
) engine=InnoDB default charset=utf8;