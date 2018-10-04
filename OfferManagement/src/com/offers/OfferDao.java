package com.offers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.offers.Offer;

public class OfferDao {
	
	//Method to get all offers and creates new file 

	public List<Offer> getAllOffers(){
	      List<Offer> offerList = null;
	      try {
	         File file = new File("OffersList.dat");
	         if (!file.exists()) {
	        	 Offer offer = new Offer(1, "Mobile Phone","300","2018-10-08");
	        	 offerList = new ArrayList<Offer>();
	        	 offerList.add(offer);
	            saveOfferList(offerList);		
	         }
	         else{
	        	 
	            FileInputStream fis = new FileInputStream(file);
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            offerList = (List<Offer>) ois.readObject();
	             ois.close();

	                    }
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      }		
	      return offerList;
	   }
	

	// method to add new offer in the file
	
	   public int addOffer(Offer pOffer){
	      List<Offer> offerList = getAllOffers();
	      boolean offerExists = false;
	      for(Offer offer: offerList){
	         if(offer.getId() == pOffer.getId()){
	            offerExists = true;
	            break;
	         }
	      }		
	      if(!offerExists){
	         offerList.add(pOffer);
	         saveOfferList(offerList);
	         return 1;
	      }
	      return 0;
	   }
	   
	   //method to update existing offer

	   public int updateOffer(Offer pOffer){
	      List<Offer> offerList = getAllOffers();

	      for(Offer offer: offerList){
	         if(offer.getId() == pOffer.getId()){
	            int index = offerList.indexOf(offer);			
	            offerList.set(index, pOffer);
	            saveOfferList(offerList);
	            return 1;
	         }
	      }		
	      return 0;
	   }

	    // method to delete an offer
	   public int deleteOffer(int id){
	      List<Offer> offerList = getAllOffers();

	      for(Offer offer: offerList){
	         if(offer.getId() == id){
	            int index = offerList.indexOf(offer);			
	            offerList.remove(index);
	            saveOfferList(offerList);
	            return 1;  
	         }
	      }		
	      return 0;
	   }
       
	   //method to write all offers into the file
	   private void saveOfferList(List<Offer> offerList){
	      try {
	         File file = new File("OffersList.dat");
	         FileOutputStream fos;

	         fos = new FileOutputStream(file);

	         ObjectOutputStream oos = new ObjectOutputStream(fos);		
	         oos.writeObject(offerList);
	         oos.close();
	      } catch (FileNotFoundException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	   }

}
