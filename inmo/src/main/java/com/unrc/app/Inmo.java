package com.unrc.app;

import com.unrc.app.models.User;
import com.unrc.app.models.RealEstate;
import com.unrc.app.models.Owner;
import com.unrc.app.models.Building;
import com.unrc.app.models.OwnersRealEstates;

import com.unrc.app.Owners;
import com.unrc.app.RealEstates;


import org.javalite.activejdbc.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Inmo {
    public static void main( String[] args )
    {
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "");
        
//		Owners.add("John2","Doe2","rio cuarto","marcelo t","atlantis","algo@algo.com");
//		Owners.delete(1);
//      Owners.modify(2,"John3","Doe3","rio cuarto","marcelo t","palazzo","algo@algo.com");

//      RealEstates.add("John","rio cuarto","rivadavia","","algo@algod.com","");
//      RealEstates.delete(2);
//      RealEstates.modify(1,"The Name","The City","The Street","The Neighborhood","el@email.com","ignacioherrero.net");

//		Owners.addRE(2,1);
//		Owners.deleteRE(2,1);


//		RealEstates.addOW(1,2);
//		RealEstates.deleteOW(1,2);
		
    }
}
