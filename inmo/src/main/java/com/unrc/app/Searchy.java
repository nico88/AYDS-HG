package com.unrc.app;

import com.unrc.app.models.User;
import com.unrc.app.models.RealEstate;
import com.unrc.app.models.Owner;
import com.unrc.app.models.Building;
import com.unrc.app.models.OwnersRealEstates;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.javalite.activejdbc.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Searchy {
    public static String owners(String city)
    {
		//Buscar todos los Owners de city
		return "";
    }
    
    public static String realEstates(String city)
    {
		//Buscar todos los Real Estates de city
		return "";
    }
    
    public static String buildings(
		String[] type,
		String city,
		String pMin,
		String pMax
	)
    {
		//Buscar los Buildings que sean de algun type, esten en city, y su costo sea entre pMin y pMax
		return "";
    }    
}
