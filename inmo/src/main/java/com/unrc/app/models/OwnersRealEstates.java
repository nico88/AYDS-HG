package com.unrc.app.models;

import org.javalite.activejdbc.Model;

public class OwnersRealEstates extends Model {
  static{
	  validatePresenceOf("owner_id");
      validatePresenceOf("real_estate_id");
  }
}
