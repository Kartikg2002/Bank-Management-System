CREATE DATABASE bankmanagement;
USE bankmanagement;

CREATE TABLE signup(
formno VARCHAR(20),
name VARCHAR(50),
fname VARCHAR(50),
dob VARCHAR(50),
gender VARCHAR(50),
email VARCHAR(50),
marital VARCHAR(50),
address VARCHAR(50),
city VARCHAR(50),
state VARCHAR(50),
pin VARCHAR(50)
);

CREATE TABLE signup2(
formno VARCHAR(20),
religion VARCHAR(50),
category VARCHAR(50),
income VARCHAR(50),
education VARCHAR(50),
occupation VARCHAR(50),
pan VARCHAR(50),
aadhar VARCHAR(50),
senoircitizen VARCHAR(50),
existingaccount VARCHAR(50)
);

CREATE TABLE signup3(
formno VARCHAR(20),
accounttype VARCHAR(50),
cardno VARCHAR(50),
pinno VARCHAR(50),
services VARCHAR(100)
);

CREATE TABLE login(
formno VARCHAR(20),
cardno VARCHAR(50),
pinno VARCHAR(50)
);

CREATE TABLE bank(
pin VARCHAR(50),
date VARCHAR(50),
type VARCHAR(50),
amount VARCHAR(50)
);

SELECT * FROM signup;
SELECT * FROM signup2;
SELECT * FROM signup3;
SELECT * FROM login;
SELECT * FROM bank;
truncate signup3;