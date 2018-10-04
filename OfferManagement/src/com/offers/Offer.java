package com.offers;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.json.bind.annotation.*;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "offer")
public class Offer implements Serializable {

   private static final long serialVersionUID = 1L;
   private int id;
   private String name;
   private String price;
   private String expirydate;
   

public Offer(){}

   public Offer(int id, String name, String price, String expirydate){
      this.id = id;
      this.name = name;
      this.expirydate= expirydate;
      this.price=price;
   }

   public String getPrice() {
	return price;
}
   @XmlElement
public void setPrice(String price) {
	this.price = price;
}

public int getId() {
      return id;
   }
   @XmlElement
   public void setId(int id) {
      this.id = id;
   }
   public String getName() {
      return name;
   }
   @XmlElement
      public void setName(String name) {
      this.name = name;
   }

   public String getExpirydate() {
	return expirydate;
}
   @XmlElement
public void setExpirydate(String expirydate) {
	this.expirydate = expirydate;
}
   

   @Override
   public boolean equals(Object object){
      if(object == null){
         return false;
      }else if(!(object instanceof Offer)){
         return false;
      }else {
    	  Offer offer = (Offer)object;
         if(id == offer.getId()
        		 && name.equals(offer.getName())
                 && expirydate.equals(offer.getExpirydate())
              
            )
         {
            return true;
         }			
      }
      return false;
   }	
}
