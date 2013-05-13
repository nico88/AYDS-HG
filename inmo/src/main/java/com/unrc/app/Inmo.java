package com.unrc.app;

import com.unrc.app.models.User;
import com.unrc.app.models.RealEstate;
import com.unrc.app.models.Owner;
import com.unrc.app.models.Building;
import com.unrc.app.models.OwnersRealEstates;

import org.javalite.activejdbc.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Inmo {
    public static void main( String[] args )
    {
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "");

        User e = new User();
        e.set("email", "user@email.com");
        e.set("first_name", "John");
        e.set("last_name", "Doe");
        e.saveIt();
		
		System.out.println("Paso User");


		
		RealEstate r = new RealEstate();
        r.set("name", "John");
        r.set("city", "rio cuarto");
        r.set("street", "rivadavia");
		r.set("email","algo@algod.com");
		r.saveIt();
		
		System.out.println("Paso RealEstate");


		Owner o = new Owner();
        o.set("first_name", "John");
        o.set("last_name", "Doe");
        o.set("street", "marcelo t");
        o.set("city","atlantis");
		o.set("email","algo@algo.com");
		o.saveIt();
		
		System.out.println("Paso Owner");

		
		Building b = new Building();
		b.set("type", "house");
        b.set("city", "rio cuarto");
        b.set("street", "bs as");
        b.set("price", "3000");
        b.set("operation", "rent");
		
		b.saveIt();
		
		System.out.println("Paso Building");

		
		//Owner add Building.
		o.add(r);
		o.saveIt();
		
        System.out.println("Chan Chan!");
    }
}
