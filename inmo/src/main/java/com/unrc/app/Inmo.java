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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static spark.Spark.*;
import spark.*;

public class Inmo {
    public static void main( String[] args )
    {
      get(new Route("/owners") {
         @Override
         public Object handle(Request request, Response response) {
            String city = request.queryParams("city");
            return "jsonCallback("+"{\"owners\":\""+city+"\"}"+")";
         }
      });


      get(new Route("/real-estates") {
         @Override
         public Object handle(Request request, Response response) {
            String city = request.queryParams("city");
            return "real-estate " + city;
         }
      });

      get(new Route("/buildings") {
         @Override
         public Object handle(Request request, Response response) {
            //check type is land|farm|house|apartment|office|garage
            //check city is [:alpha:]+
            //check pmax and pmin is [:digit:]+
            String type = request.queryParams("type");
            String city = request.queryParams("city");
            String pmin = request.queryParams("pmin");
            String pmax = request.queryParams("pmax");

            return "buildings";
         }
      });

      get(new Route("/land") {
         @Override
         public Object handle(Request request, Response response) {
            //check city is [:alpha:]+
            //check pmax and pmin is [:digit:]+
            String city = request.queryParams("city");
            String pmin = request.queryParams("pmin");
            String pmax = request.queryParams("pmax");

            return "buildings-land";
         }
      });


      get(new Route("/famr") {
         @Override
         public Object handle(Request request, Response response) {
            //check city is [:alpha:]+
            //check pmax and pmin is [:digit:]+
            String city = request.queryParams("city");
            String pmin = request.queryParams("pmin");
            String pmax = request.queryParams("pmax");

            return "buildings-farm";
         }
      });

    }
}
