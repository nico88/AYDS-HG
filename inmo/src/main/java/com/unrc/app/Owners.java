package com.unrc.app;

import java.util.List;

import com.unrc.app.models.RealEstate;
import com.unrc.app.models.Owner;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.LazyList;
/*
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
*/

public class Owners {
    public static int add(
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
		
		return owner.getInteger("id");

    }
    
    public static void delete(int id){
		Owner owner = new Owner();
		owner = owner.findById(id);

		if (owner == null){
			throw new IllegalArgumentException("Ingreso un ID de OWNER no válido.");
		}		
		
		owner.deleteCascade();
    }
    
    public static boolean modify (
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
		
		if (owner == null){
			throw new IllegalArgumentException("Ingreso un ID de OWNER no válido.");
		}		
		
        owner.set("first_name", first_name);
        owner.set("last_name", last_name);
        owner.set("city", city);
        owner.set("street", street);
        owner.set("neighborhood",neighborhood);
		owner.set("email",email);		
		
		owner.saveIt();		
		
		return owner.saveIt();
    }
 
	private static boolean addRemoveRE(int id, int r_id, boolean add){
		Owner o = new Owner();
		o = o.findById(id);
		
		if (o != null){
			RealEstate r = new RealEstate();
			r = r.findById(r_id);
			
			if (r != null){
				Boolean resultado = true;
				try{
					if (add){
						o.add(r);
					}else{
						o.remove(r);
					}
				}catch(Exception e){
					System.out.println(e);
					resultado = false;
				}				
				return resultado;
			}else{
				//NO ENCONTRO EL REAL ESTATE
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

	public static String getOwnersByCity(String city){
		//Busco los Owners
		String where = "";
		if (city != ""){where = "city='"+city+"'";}
		
		LazyList<Owner> ownerList = Owner.where(where).include(RealEstate.class);
		
		return ownerList.toJson(false,"id","first_name","email","street","last_name","neighborhood","city");
	}
	
}
