package com.unrc.app;

import com.unrc.app.models.Owner;

import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.javalite.test.jspec.JSpec.the;

public class OwnerSpec{

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

        Owner owner = new Owner();

        //check errors
        the(owner).shouldNotBe("valid");
        the(owner.errors().get("first_name")).shouldBeEqual("value is missing");
        the(owner.errors().get("last_name")).shouldBeEqual("value is missing");
        the(owner.errors().get("city")).shouldBeEqual("value is missing");
        the(owner.errors().get("street")).shouldBeEqual("value is missing");
        the(owner.errors().get("email")).shouldBeEqual("value is missing");

        //set missing values
        owner.set("first_name", "John");
        owner.set("last_name", "Doe");
        owner.set("street", "marcelo t");
        owner.set("city","atlantis");
		owner.set("email","algo@algo.com");

		System.out.println("\n\n"+owner.toString()+"\n\n");
		
        //all is good:
        the(owner).shouldBe("valid");
    }
}
