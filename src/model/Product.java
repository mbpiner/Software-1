package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Product {

    private ObservableList<Part> associatedParts = FXCollections.observableArrayList();
    private int productID, stock, min, max;
    private double price;
    private String name;


    //constructor
    public Product() {

    }


    public Product(int productID, String name, int stock, int min, int max, double price) {
        this.setID(productID);
        this.setName(name);
        this.setStock(stock);
        this.setMin(min);
        this.setMax(max);
        this.setPrice(price);
    }


    public void setID(int productID) {
        this.productID = productID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public int getID() {
        return this.productID;
    }

    public String getName() {
        return this.name;
    }

    public int getStock() {
        return this.stock;
    }

    public int getMin() {
        return this.min;
    }

    public int getMax() {
        return this.max;
    }

    public double getPrice() {
        return this.price;
    }


    public void setAssociatedPart(Part part) {

        this.associatedParts.add(part);

    }

    public boolean deleteAssociatedPart(Part part) {


        return this.associatedParts.remove(part);


    }


    public ObservableList<Part> getAssociatedParts() {

        return this.associatedParts;


    }


}
