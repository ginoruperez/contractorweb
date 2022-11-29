CREATE DATABASE contractordb;

use contractordb;

DROP table if exists user_role;
DROP table if exists role;
DROP table if exists user;

CREATE TABLE user (id int NOT NULL auto_increment,
firstname varchar(20),
lastname varchar(20),
email VARCHAR(100),
password varchar(100),
subscription varchar(20),
PRIMARY KEY (id),
UNIQUE KEY (email)
);

DROP table if exists contractor; 

create table contractor (
id int PRIMARY KEY NOT NULL AUTO_INCREMENT, 
name varchar(30), 
location varchar(50),
specialties varchar(50),
size int,
rate decimal(7,2),
owner varchar(50));


INSERT INTO contractor (name,location,specialties,size,rate,owner) values ('Dogs With Tools', 'Smallville', 'Roofing',7,'25.00','123');
INSERT INTO contractor (name,location,specialties,size,rate,owner) values ('Hamner & Tong', 'Smallville', 'Drywall, Roofing',10,'85.00','12345');


CREATE TABLE ROLE 
(
ID INT NOT NULL AUTO_INCREMENT,
NAME VARCHAR(20),
PRIMARY KEY (ID)
);

create table user_role(
user_id int,
role_id int,
FOREIGN KEY (user_id)
REFERENCES user(id),
FOREIGN KEY (role_id)
REFERENCES role(id)
);

insert into role values(1,'ADMIN');
insert into role values(2,'ADMIN');


-- exclude this, run after adding user with password
insert into user_role values(1,1);
insert into user_role values(2,1);


