START TRANSACTION;

DROP TABLE IF EXISTS owners_real_estates;
DROP TABLE IF EXISTS buildings;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS real_estates;
DROP TABLE IF EXISTS owners;


CREATE TABLE users(
  id  int(11) NOT NULL auto_increment PRIMARY KEY,
  email VARCHAR(60) NOT NULL,
  first_name VARCHAR(56) NOT NULL,
  last_name VARCHAR(56) NOT NULL
);

CREATE TABLE real_estates(
  id  int(11) NOT NULL auto_increment PRIMARY KEY,
  name VARCHAR(60) NOT NULL,
  city VARCHAR(56) NOT NULL DEFAULT 'rio cuarto',
  street VARCHAR(56) NOT NULL,
  neighborhood varchar(50),
  email varchar(60) NOT NULL,
  website varchar(30)
);

CREATE TABLE owners(
  id  int(11) NOT NULL auto_increment PRIMARY KEY,
  first_name VARCHAR(56) NOT NULL,
  last_name VARCHAR(56) NOT NULL,
  city VARCHAR(56) NOT NULL DEFAULT 'rio cuarto',
  street VARCHAR(56) NOT NULL,
  neighborhood varchar(50),
  email varchar(60) NOT NULL
);

CREATE TABLE buildings(
  id  int(11) NOT NULL auto_increment PRIMARY KEY,
  type ENUM('land','farm','house','apartment','office','garage') NOT NULL,
  city VARCHAR(56) NOT NULL DEFAULT 'rio cuarto',
  street VARCHAR(56) NOT NULL,
  neighborhood varchar(50),
  description TEXT,
  price int(6) UNSIGNED NOT NULL,
  operation ENUM('rent','sale') NOT NULL,

  owner_id int(11),
  INDEX owner (owner_id),
  FOREIGN KEY (owner_id) REFERENCES owners(id) ON DELETE CASCADE
);

CREATE TABLE owners_real_estates(
  owner_id int(11),
  real_estate_id int(11),
  
  PRIMARY KEY (owner_id, real_estate_id),
  
  INDEX owner (owner_id),
  FOREIGN KEY (owner_id) REFERENCES owners(id) ON DELETE CASCADE,
  
  INDEX real_estate (real_estate_id),
  FOREIGN KEY (real_estate_id) REFERENCES real_estates(id) ON DELETE CASCADE
);

COMMIT;
