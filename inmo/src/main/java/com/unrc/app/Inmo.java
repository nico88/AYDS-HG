package com.unrc.app;

import com.unrc.app.WebAPI;

import org.javalite.activejdbc.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static spark.Spark.*;
import spark.*;

public class Inmo {
	public static WebAPI api = new WebAPI();
	
	private static String makeJSONP(String fnCallback, String json){
		if (fnCallback != null && fnCallback != ""){
			return fnCallback+"("+json+")";
		}else{
			return json;
		}
	}
	
    public static void main( String[] args ){
			
      get(new Route("/owners") {
         @Override
         public Object handle(Request request, Response response) {
            return makeJSONP(request.queryParams("callback"), api.getOwners(request.queryParams("city")));
         }
      });

      get(new Route("/real-estates") {
         @Override
         public Object handle(Request request, Response response) {
            return makeJSONP(request.queryParams("callback"),api.getRealEstates(request.queryParams("city")));
         }
      });

      get(new Route("/buildings") {
         @Override
         public Object handle(Request request, Response response) {
            //check type is land|farm|house|apartment|office|garage
            //check city is [:alpha:]+
            //check pmax and pmin is [:digit:]+
			
			
            String aux = api.getBuildings(
				request.queryParams("type"),
				request.queryParams("city"),
				request.queryParams("pMin"),
				request.queryParams("pMax")
			);
            
            return makeJSONP(request.queryParams("callback"),aux);
         }
      });

      get(new Route("/houseandapartments") {
         @Override
         public Object handle(Request request, Response response) {
			
            String aux = api.getBuildings("house,appartment",
				request.queryParams("city"),
				request.queryParams("pMin"),
				request.queryParams("pMax")
			);
            
            return makeJSONP(request.queryParams("callback"),aux);
         }
      });

      get(new Route("/buildingtypes") {
         @Override
         public Object handle(Request request, Response response) {
            return makeJSONP(request.queryParams("callback"),api.getBuildingTypes());
         }
      });


	/*
	 * La app que testea el server no corre en el mismo dominio y viola las restricciones de 
	 * crossdomain. Por esta razón tiene que utilizar jsonp, pero no permite hacer POSTs.
	 * Para solucionar este inconveniente y poder testear la app, lo reemplazamos por GET.
	 */
      get(new Route("/post/owners") {
         @Override
         public Object handle(Request request, Response response) {
			
            String aux = api.addOwner(
				request.queryParams("first_name"),
				request.queryParams("last_name"),
				request.queryParams("city"),
				request.queryParams("street"),
				request.queryParams("neighborhood"),
				request.queryParams("email")
            );
            
            return makeJSONP(request.queryParams("callback"),aux);
         }
      });
      
      
      get(new Route("/post/realestates") {
         @Override
         public Object handle(Request request, Response response) {
			
            String aux = api.addRealEstate(
				request.queryParams("name"),
				request.queryParams("website"),
				request.queryParams("email"),
				request.queryParams("city"),
				request.queryParams("street"),
				request.queryParams("neighborhood")
            );
            
            return makeJSONP(request.queryParams("callback"),aux);
         }
      });      
      
      

    }
}
