package com.unrc.app.models;

import org.javalite.activejdbc.Model;

public class Building extends Model {
  static{
	  
	  /*
	       id  int(11) NOT NULL auto_increment PRIMARY KEY,
		   type ENUM('land','farm','house','apartment','office','garage') NOT NULL,
           city VARCHAR(56) NOT NULL DEFAULT 'rio cuarto',
           street VARCHAR(56) NOT NULL,
           neighborhood varchar(50),
           description TEXT,
           price int(6) UNSIGNED NOT NULL,
           operation ENUM('rent','sale') NOT NULL,
           owner_id int(11) NOT NULL,
           INDEX owner (owner_id),
           FOREIGN KEY (owner_id) REFERENCES owners(id) ON DELETE CASCADE
      */
	  
      validatePresenceOf("type");
      validatePresenceOf("city");
      validatePresenceOf("street");
      validatePresenceOf("price");
      validatePresenceOf("operation");
      
      validateRegexpOf("type","land|farm|house|apartment|office|garage");
	  validateRegexpOf("operation","rent|sale");
      
      }
  }
