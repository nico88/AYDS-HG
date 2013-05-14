package com.unrc.app;

import com.unrc.app.models.Building;

import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.javalite.test.jspec.JSpec.the;

public class BuildingSpec{

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
    public void shouldValidateMandatoryFields(){

        Building building = new Building();

        //check errors
        the(building).shouldNotBe("valid");
        the(building.errors().get("type")).shouldBeEqual("value is missing");
        the(building.errors().get("city")).shouldBeEqual("value is missing");
        the(building.errors().get("street")).shouldBeEqual("value is missing");
        the(building.errors().get("price")).shouldBeEqual("value is missing");
        the(building.errors().get("operation")).shouldBeEqual("value is missing");

        //set missing values
        building.set("type", "house");
        building.set("city", "rio cuarto");
        building.set("street", "bs as");
        building.set("price", "2000");
        building.set("price", 3000);
        building.set("operation", "rent");
		
        //all is good:
        the(building).shouldBe("valid");
    }
}
