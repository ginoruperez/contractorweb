CREATE DATABASE contractordb;

use contractordb;

DROP table if exists user;

CREATE TABLE user (id int NOT NULL auto_increment,
first_name varchar(20),
last_name varchar(20),
email VARCHAR(20),
password varchar(20),
PRIMARY KEY (id),
UNIQUE KEY (email)
);


DROP table if exists contractor; 

create table contractor (
id int PRIMARY KEY, 
name varchar(30), 
location varchar(50),
specialties varchar(50),
size int,
rate varchar(10),
owner varchar(10));


INSERT INTO contractor values (1, 'Dogs With Tools', 'Smallville', 'Roofing',7,'$25.00','123');
INSERT INTO contractor values (2, 'Hamner & Tong', 'Smallville', 'Drywall, Roofing',10,'$85.00','12345');

