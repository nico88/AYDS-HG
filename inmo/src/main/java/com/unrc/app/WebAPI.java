package com.unrc.app;

//Modelo ActiveJDBC
import com.unrc.app.models.*;

//ActiveJDBC
import org.javalite.activejdbc.Base;

//Controladores de datos
import com.unrc.app.Buildings;
import com.unrc.app.RealEstates;
import com.unrc.app.Owners;


public class WebAPI {
	private void connect(){
		if (!Base.hasConnection()){
			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "");	
			System.out.println("---> Se conecto a la base de datos."+Base.connection()+"\n");
		}
	}
	
    public String getOwners(String city)
    {
		connect();
		return Owners.getOwnersByCity(city);
    }

    public String getRealEstates(String city)
    {
		connect();
		return RealEstates.getRealEstatesByCity(city);
    }
    
    public String getBuildings(
		String type,
		String city,
		String pMin,
		String pMax
	){
		connect();
		return Buildings.getBuildings(type.split(","),city,pMin,pMax);
	}    

    public String getBuildingTypes()
    {
		connect();
		return Buildings.getBuildingTypes();
    }

    public String addOwner(		
		String first_name, 
		String last_name, 
		String city, 
		String street, 
		String neighborhood, 
		String email)
    {
		int id;
		
		connect();
		try{
			id = Owners.add(first_name, last_name, city, street, neighborhood, email);
		}catch(Exception e){
			return "{\"msg\":\"Sorry, an error occurred while processing your request\"}";
		}
		
		return "{\"msg\":\"Inserción OK (Nuevo ID:"+id+")\"}";
    }


    public String addRealEstate(		
		String name, 
		String website, 
		String email,
		String city, 
		String street, 
		String neighborhood)
    {
		int id;

		connect();
		try{
			id = RealEstates.add(name, city, street, neighborhood, email, website);
		}catch(Exception e){
			return "{\"msg\":\"Sorry, an error occurred while processing your request\"}";
		}
		
		return "{\"msg\":\"Inserción OK (Nuevo ID:"+id+")\"}";
    }    
}
