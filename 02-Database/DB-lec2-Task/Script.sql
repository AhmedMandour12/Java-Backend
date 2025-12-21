CREATE TABLE Manger (id NUMBER,
name varchar(10),
age number ,
birth_date 	DATE  ,
address varchar(10) )

ALTER TABLE MANGER DROP COLUMN  address

ALTER TABLE MANGER ADD  (city_address varchar(10) , street varchar(10))

ALTER TABLE MANGER RENAME COLUMN name TO full_name;

ALTER TABLE MANGER READ ONLY
 
 
CREATE TABLE Owner AS SELECT id,full_name,birth_date  FROM manger

RENAME MANGER TO MASTER;

DROP TABLE MASTER;
DROP TABLE OWNER;







