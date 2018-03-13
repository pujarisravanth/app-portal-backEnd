# app-portal-backEnd
Backend provides REST services to front end. For this Spring boot frame work was used

For the database Oracle 11g express db was used

db query for creating signup table : 
```
CREATE TABLE sign_up (
    username VARCHAR(30) UNIQUE,
    email VARCHAR(30) PRIMARY KEY,
    password VARCHAR(30)
);
```
db query for creating user details table : 
```
create table user_details (
    user_id int PRIMARY KEY,
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    email VARCHAR(30),
    address VARCHAR(255),
    city VARCHAR(30),
    state VARCHAR(30),
    country VARCHAR(30),
    pincode VARCHAR(30),
    phone_number VARCHAR(30),
    CONSTRAINT FK_SignupDetails FOREIGN key (email) REFERENCES sign_up(email)
);
```

generate a sequence generator : 
```
CREATE SEQUENCE seq START WITH 1 INCREMENT by 1;
```
