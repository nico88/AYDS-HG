package com.unrc.app;

import com.unrc.app.models.RealEstate;
import com.unrc.app.models.Owner;

import org.javalite.activejdbc.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Owners {
    public static void add(
		String first_name, 
		String last_name, 
		String city, 
		String street, 
		String neighborhood, 
		String email)
    {
		Owner owner = new Owner();
		
        owner.set("first_name", first_name);
        owner.set("last_name", last_name);
        owner.set("city", city);
        owner.set("street", street);
        owner.set("neighborhood",neighborhood);
		owner.set("email",email);		
		
		owner.saveIt();

//		System.out.println(owner.get("id"));
//		System.out.println(owner.get("id").getClass());
    }
    
    public static void delete(int id){
		Owner owner = new Owner();
		owner = owner.findById(id);
		
		owner.delete();
    }
    
    public static void modify (
        int    id,
		String first_name, 
		String last_name, 
		String city, 
		String street, 
		String neighborhood, 
		String email)
	{
		Owner owner = new Owner();
		owner = owner.findById(id);
		
        owner.set("first_name", first_name);
        owner.set("last_name", last_name);
        owner.set("city", city);
        owner.set("street", street);
        owner.set("neighborhood",neighborhood);
		owner.set("email",email);		
		
		owner.saveIt();		
		
		System.out.println(owner.get("id"));
    }
 
	private static boolean addRemoveRE(int id, int r_id, boolean add){
		Owner o = new Owner();
		o = o.findById(id);
		
		if (o != null){
			RealEstate r = new RealEstate();
			r = r.findById(r_id);
			
			if (r != null){
				if (add){
					o.add(r);
				}else{
					o.remove(r);
				}
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}	
	}
 
	public static boolean addRE(int id, int r_id){
		return Owners.addRemoveRE(id,r_id,true);
	}
	
	public static boolean deleteRE(int id, int r_id){
		return Owners.addRemoveRE(id,r_id,false);
	}
	
}
