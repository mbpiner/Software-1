/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author Mason
 */
public class Product {
    
    private ObservableList<Part> associatedParts = FXCollections.observableArrayList();
    private int productID, stock, min, max;
    private double price;
    private String name;
    
    
    
   
    
    //constructor
    public Product(){
    
    }
    
    
    public Product(int productID, String name, int stock, int min, int max, double price){
        this.setID(productID);
        this.setName(name);
        this.setStock(stock);
        this.setMin(min);
        this.setMax(max);
        this.setPrice(price);
    }
    

   
    
    public void setID(int productID){
        this.productID = productID;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setStock(int stock){
        this.stock = stock;
    }
    
    public void setMin(int min){
        this.min = min;
    }
    
    public void setMax(int max){
        this.max = max;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    
    
    
    
    
    
    
    
     public int getID(){
        return this.productID;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getStock(){
        return this.stock;
    }
    
    public int getMin(){
        return this.min;
    }
    
    public int getMax(){
        return this.max;
    }
    
    public double getPrice(){
        return this.price;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    public void setAssociatedPart(Part part){
    
        this.associatedParts.add(part);
        
    }
    
    
   
    //this will need testing like the method removing a product...
    //will we be able to pass in an object aka a specific instance of Part that is in the ObserveableList associatedPart?
    //or would it be better to go by some unique characteristic such as ID or name?
    //if we do the former, use declaration below...
    //public boolean deleteAssociatedPart(Part associatedPart){
    
    
    
    
    
    
    
    public boolean deleteAssociatedPart(Part part){
        
        //if we can pass in the objects directly this could be the one-line solution...
        //going to comment it out because solution below is probably better...
        //return this.associatedParts.remove(associatedPart);
        
        
        
       return this.associatedParts.remove(part);
        
        /*It complained "int cannot be dereferenced" because I used .equals so I changed it to below.
            
        may need to use a String/name in the end...
        
        
        return associatedParts.removeIf(part -> part.getID().equals(associatedPartID));
        */
        
        
        
        
         //return associatedParts.removeIf(part -> part.getID() == associatedPartID);
        
        
        //products.removeIf(product -> product.name.equals("Corn"));
        
        
        /*or maybe something like this?


 public boolean removeAssociatedPart(int partID) {
        for (Part p : associatedParts) {
            if (p.getPartID() == partID) {
                associatedParts.remove(p);
                return true;
            }
        }
        
        return false;
    }








*/
    }
    
    
    public ObservableList<Part> getAssociatedParts(){
        
        //gets ALL associated parts.
        //System.out.println(this.associatedParts);
        return this.associatedParts;
        
        
    }
    
    
    /*
    
        public void setAssociatedParts(ObservableList<Part>){
        
        //gets ALL associated parts.
        //System.out.println(this.associatedParts);
        
        
    }

*/
    
    
    
    
    
  
    
    
    
    
    
    
    
    
    
    
    
    
    //
    //products.removeIf(product -> product.name.equals("Corn"));
    //
    
    
    
    
    
    
    
    
    
    
    
    
    
}
