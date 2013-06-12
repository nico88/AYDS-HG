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

	public WebAPI(){
		Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "");	
		System.out.println("---> Se conecto a la base de datos."+Base.connection()+"\n");
	}
	
	public void end(){
		Base.close();
		System.out.println("---> Cerro la conexion con la base de datos.");
	}

    public String getOwners(String city)
    {
		return Owners.getOwnersByCity(city);
    }

    public String getRealEstates(String city)
    {
		return RealEstates.getRealEstatesByCity(city);
    }
    
    public String getBuildings(
		String type,
		String city,
		String pMin,
		String pMax
	){
		return Buildings.getBuildings(type.split(","),city,pMin,pMax);
	}    

    public String getBuildingTypes()
    {
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

		try{
			id = RealEstates.add(name, city, street, neighborhood, email, website);
		}catch(Exception e){
			return "{\"msg\":\"Sorry, an error occurred while processing your request\"}";
		}
		
		return "{\"msg\":\"Inserción OK (Nuevo ID:"+id+")\"}";
    }    
}
