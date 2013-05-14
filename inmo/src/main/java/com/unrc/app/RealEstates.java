package com.unrc.app;

import com.unrc.app.models.RealEstate;
import com.unrc.app.models.Owner;

import org.javalite.activejdbc.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RealEstates {
    public static void add(
		String name, 
		String city, 
		String street, 
		String neighborhood, 
		String email,
		String website)
    {
		RealEstate realestate = new RealEstate();
		
        realestate.set("name", name);
        realestate.set("city", city);
        realestate.set("street", street);
        realestate.set("neighborhood",neighborhood);
		realestate.set("email",email);		
		realestate.set("website",website);		
		
		realestate.saveIt();
		
    }
    
    public static void delete(int id){
		RealEstate realestate = new RealEstate();
		realestate = realestate.findById(id);
		
		realestate.delete();
		
    }
    
    public static void modify (
        int    id,
		String name, 
		String city, 
		String street, 
		String neighborhood, 
		String email,
		String website)
	{
		RealEstate realestate = new RealEstate();
		realestate = realestate.findById(id);
		
        realestate.set("name", name);
        realestate.set("city", city);
        realestate.set("street", street);
        realestate.set("neighborhood",neighborhood);
		realestate.set("email",email);		
		realestate.set("website",website);		
		
		realestate.saveIt();
    }
 
 	public static boolean addOW(int id, int o_id){
		return Owners.addRE(o_id,id);
	}
	
	public static boolean deleteOW(int id, int o_id){
		return Owners.deleteRE(o_id, id);
	}

}
