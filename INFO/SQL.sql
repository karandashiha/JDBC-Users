Створення бази даних:


CREATE DATABASE demo_db;

Створення таблиці:

CREATE TABLE IF NOT EXISTS users
( id INTEGER NOT NULL AUTO_INCREMENT,
  firstName VARCHAR(128) NOT NULL,
  lastName VARCHAR(128) NOT NULL,
  email VARCHAR(128) NOT NULL,
  PRIMARY KEY (id)
);

