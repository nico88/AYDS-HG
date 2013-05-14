package com.unrc.app.models;

import org.javalite.activejdbc.Model;

public class Owner extends Model {
  static{
/*
  id  int(11) NOT NULL auto_increment PRIMARY KEY,
  first_name VARCHAR(56) NOT NULL,
  last_name VARCHAR(56) NOT NULL,
  city VARCHAR(56) NOT NULL DEFAULT "rio cuarto",
  street VARCHAR(56) NOT NULL,
  neighborhood varchar(50),
  email varchar(60) NOT NULL
  */	 
	
	validatePresenceOf("first_name","last_name","city","street","email");
	validateEmailOf("email");

  }
}
