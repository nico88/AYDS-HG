package com.unrc.app;

import com.unrc.app.models.Building;
import com.unrc.app.models.Owner;

import org.javalite.activejdbc.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Buildings {
	
    public static int add(
		String type, 
		String city,
		String street,
		String neighborhood,
		String description,
		int price,
		String operation,
		int id_owner
    ){
		Owner o = new Owner();
		o = o.findById(id_owner);
		
		if (o == null){
			throw new IllegalArgumentException("Ingreso un ID de Owner no válido.");
		}
		
		Building b = new Building();
		b.set("type",type);
		b.set("city",city);
		b.set("street",street);
		b.set("neighborhood",neighborhood);
		b.set("description",description);
		b.set("price",price);
		b.set("operation",operation);
		b.set("owner_id",id_owner);
		
		b.saveIt();
		
		return b.getInteger("id");
    }
    
    public static boolean modify (
		int id,
		String type, 
		String city,
		String street,
		String neighborhood,
		String description,
		int price,
		String operation,
		int id_owner
    ){
		Building b = new Building();
		b = b.findById(id);
		
		if (b == null){
			throw new IllegalArgumentException("Ingreso un ID de BUILDING no válido.");
		}
		
		if (b.getInteger("owner_id") != id_owner){
			Owner o = new Owner();
			o = o.findById(id_owner);
			
			if (o == null){
				throw new IllegalArgumentException("Ingreso un ID de Owner no válido.");
			}
			
			b.set("owner_id",id_owner);
		}
		
		b.set("type",type);
		b.set("city",city);
		b.set("street",street);
		b.set("neighborhood",neighborhood);
		b.set("description",description);
		b.set("price",price);
		b.set("operation",operation);
		
		return b.saveIt();
    }

    public static boolean delete(int id){
		Building b = new Building();
		b = b.findById(id);
		
		System.out.println("ELIMINANDO: "+id);
		
		if (b == null){
			throw new IllegalArgumentException("Ingreso un ID de BUILDING no válido:"+id);
		}
		
		return b.delete();		
    }
    
}
