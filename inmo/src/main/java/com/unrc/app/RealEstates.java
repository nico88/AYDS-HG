package com.unrc.app;

import com.unrc.app.models.RealEstate;
import com.unrc.app.models.Owner;

import org.javalite.activejdbc.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RealEstates {
    public static int add(
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
		
		return realestate.getInteger("id");
    }
    
    public static void delete(int id){
		RealEstate realestate = new RealEstate();
		realestate = realestate.findById(id);

		if (realestate == null){
			throw new IllegalArgumentException("Ingreso un ID de REAL_ESTATE no válido.");
		}
		
		realestate.deleteCascade();
    }
    
    public static boolean modify (
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
		
		if (realestate == null){
			throw new IllegalArgumentException("Ingreso un ID de REAL_ESTATE no válido.");
		}
		
        realestate.set("name", name);
        realestate.set("city", city);
        realestate.set("street", street);
        realestate.set("neighborhood",neighborhood);
		realestate.set("email",email);		
		realestate.set("website",website);		
		
		return realestate.saveIt();
    }
 
 	public static boolean addOW(int id, int o_id){
		return Owners.addRE(o_id,id);
	}
	
	public static boolean deleteOW(int id, int o_id){
		return Owners.deleteRE(o_id, id);
	}

}
