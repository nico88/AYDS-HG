package com.unrc.app.models;

import org.javalite.activejdbc.Model;

public class RealEstate extends Model {
  static{
/*
  id  int(11) NOT NULL auto_increment PRIMARY KEY,
  name VARCHAR(60) NOT NULL,
  city VARCHAR(56) NOT NULL DEFAULT "rio cuarto",
  street VARCHAR(56) NOT NULL,
  neighborhood varchar(50),
  email varchar(60) NOT NULL,
  website varchar(30)
*/ 
	
	validatePresenceOf("name");
	validatePresenceOf("city");
	validatePresenceOf("street");
	validatePresenceOf("email");
	validateEmailOf("email");

/*	
   if (website != ""){
		validateRegexpOf("website", "^(http\://|https\://)+[\w][\w.-]+\\.[A-Z]{2,3}$");
    }
*/

  }
}
