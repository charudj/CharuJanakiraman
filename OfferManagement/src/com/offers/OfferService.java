package com.offers;


import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


import com.offers.Offer;
import com.offers.OfferDao;

@Path("/OfferService")
public class OfferService {
	
	OfferDao offerDao = new OfferDao();
	   
	   // View all Offers
	   @GET
	   @Path("/offers")
	   @Produces(MediaType.APPLICATION_XML)
	   public List<Offer> getOffers(){
	      return offerDao.getAllOffers();
	   }

	  //jsp calls POST method during create request
	   @POST
	   @Path("/offers")
	   @Produces(MediaType.APPLICATION_XML)
	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	   public List<Offer> createOffer(@FormParam("id") int id,
	      @FormParam("name") String name,@FormParam("price") String price, @FormParam("expirydate") String expirydate,
	      @Context HttpServletResponse servletResponse) throws IOException{
	      Offer offer = new Offer(id, name,price,expirydate);
	      int result = offerDao.addOffer(offer);
	      if(result == 1){
	           	  
	    	  System.out.println("Offer added Sucessfully");
	    	  
	    	 return offerDao.getAllOffers();
	    	         	  	 
	      }   
	          return offerDao.getAllOffers();
	   }
       
	   // jsp Calls PUT method during an update request
	   @PUT
	   @Path("/offers")
	   @Produces(MediaType.APPLICATION_XML)
	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	   public List<Offer> updateOffer(@FormParam("id") int id,
	      @FormParam("name") String name,@FormParam("price") String price, @FormParam("expirydate") String expirydate,
	      @Context HttpServletResponse servletResponse) throws IOException, ParseException{
		   
		     //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          // Date expdate = sdf.parse(expirydate);
          // if(expdate.before(expdate)||expdate.equals(expdate)) {
	      Offer offer = new Offer(id, name,price, expirydate);          
	      int result = offerDao.updateOffer(offer);
	      if(result == 1){
	      	  return offerDao.getAllOffers();
	      }
	      
	      return offerDao.getAllOffers();
           
           }
	   
	   
	   //jsp calls DELETE method during delete request
	   @DELETE
	   @Path("/offers")
	   @Produces(MediaType.APPLICATION_XML)
	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	   public List<Offer> deleteOffer(@FormParam("id") int id){
		  int result = offerDao.deleteOffer(id);
	      if(result == 1){
	    	  
	      	  return offerDao.getAllOffers();
	         
	      }
	      
	      return offerDao.getAllOffers();
	    
	   }

}
