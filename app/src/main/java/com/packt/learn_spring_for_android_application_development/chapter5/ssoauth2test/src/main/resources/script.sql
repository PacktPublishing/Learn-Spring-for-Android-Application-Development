create table user (id bigint not null auto_increment, age integer, first_name varchar(255), last_name varchar(255), password varchar(255), salary bigint, username varchar(255), primary key (id)) engine=MyISAM;
INSERT INTO user (age, first_name, last_name,password,salary,username) values (23, 'admin', 'admin','$2a$04$EZzbSqieYfe/nFWfBWt2KeCdyq0UuDEM1ycFF8HzmlVR6sbsOnw7u',12345,'admin');
