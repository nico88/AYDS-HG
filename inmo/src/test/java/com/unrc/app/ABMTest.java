package com.unrc.app;

import com.unrc.app.models.User;
import com.unrc.app.models.RealEstate;
import com.unrc.app.models.Owner;
import com.unrc.app.models.Building;
import com.unrc.app.models.OwnersRealEstates;

import com.unrc.app.Owners;
import com.unrc.app.RealEstates;
import com.unrc.app.Buildings;

import org.javalite.activejdbc.Base;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;


public class ABMTest {

    @Before
    public void before(){
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "");
        Base.openTransaction();
    }

    @After
    public void after(){
        Base.rollbackTransaction();
        Base.close();
    }
    
    @Test
    public void testTest(){
		
//AUX Vars
        boolean b;
        int id;

//TEST ABM Owner  
		System.out.println("\n\nTEST ABM Owner");

		id = Owners.add("John2","Doe2","rio cuarto","marcelo t","atlantis","algo@algo.com");
		System.out.println("Agregar OWNER: ID->" + id);
		
		b = Owners.modify(id,"John3","Doe3","rio cuarto","marcelo t","palazzo","algo@algo.com");
		System.out.println("Modificar OWNER: OK->" + b);
		
		Owners.delete(id);
		
		//Owners.modify(1000000,"John3","Doe3","rio cuarto","marcelo t","palazzo","algo@algo.com");


//TEST ABM RealEstate
		System.out.println("\n\nTEST ABM RealEstate");
		
		id = RealEstates.add("John","rio cuarto","rivadavia","","algo@algod.com","");
		System.out.println("Agregar REAL ESTATE: ID->" + id);
		
		b = RealEstates.modify(id,"The Name","The City","The Street","The Neighborhood","el@email.com","ignacioherrero.net");
		System.out.println("Modificar REAL ESTATE: OK->" + b);
		
		RealEstates.delete(id);
		
		//RealEstates.modify(10000,"The Name","The City","The Street","The Neighborhood","el@email.com","ignacioherrero.net");


//TEST OWNER + REAL ESTATE: Relacion Many to Many
		System.out.println("\n\nTEST OWNER + REAL ESTATE: Relacion Many to Many");

		int ido = Owners.add("John2","Doe2","rio cuarto","marcelo t","atlantis","algo@algo.com");
		int idr = RealEstates.add("John","rio cuarto","rivadavia","","algo@algod.com","");

		b = Owners.addRE(ido,idr);
			System.out.println("OWNERS ADD MtM : OK->" + b);
		b = Owners.deleteRE(ido,idr);
			System.out.println("OWNERS RM MtM : OK->" + b);

		b = RealEstates.addOW(idr,ido);
			System.out.println("REAL ESTATE ADD MtM : OK->" + b);
		b = RealEstates.deleteOW(idr,ido);
			System.out.println("REAL ESTATE RM MtM : OK->" + b);


		Owners.delete(ido);
		RealEstates.delete(idr);

//TEST ABM Building
		System.out.println("\n\nTEST ABM Building");
		
		id = Buildings.add("land","rio cuarto","rivadavia","fdfdgdfg","algo@algod.com",5000,"rent",5);
		System.out.println("Agregar Building: ID->" + id);
		
		b = Buildings.modify(id,"land","rio cuarto","rivadavia","fdfdgdfg","algo@algod.com",5000,"rent",3);
		System.out.println("Modificar Building: OK->" + b); 
		
		b = Buildings.delete(id);
		System.out.println("Eliminar Building: OK->" + b); 

		//Buildings.modify(100000,"land","rio cuarto","rivadavia","fdfdgdfg","algo@algod.com",5000,"rent",3); 
		
		System.out.println("\n\n-> END Test ABM\n\n");
    }

}
