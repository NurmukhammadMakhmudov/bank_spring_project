drop table if exists card_info;
drop table if exists users;



-- Creating Users Schema
create table users
(
    id         SERIAL NOT NULL PRIMARY KEY,
    role_name    VARCHAR(10) ,
    first_name VARCHAR(50)  NOT NULL,
    last_name  VARCHAR(50)  NOT NULL,
    email      VARCHAR(255) UNIQUE NOT NULL ,
    pass_word  VARCHAR(255) NOT NULL,
    phone_number VARCHAR(25),
    isActive BOOLEAN NOT NULL

);

--Creating Card info Schema

create table card_info
(
    id SERIAL UNIQUE PRIMARY KEY ,
    user_id BIGINT REFERENCES users (id),
    email  VARCHAR(255) NOT NULL ,
    bank_account_number VARCHAR(255) UNIQUE,
    full_name VARCHAR(255),
    card_number VARCHAR(255),
    creation_date DATE,
    date_of_expiration DATE,
    cvv VARCHAR(15),
    cash  FLOAT NOT NULL

);












