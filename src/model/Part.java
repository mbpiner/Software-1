package model;

public abstract class Part {

    private int partID, stock, min, max;
    private double price;
    private String name;


    //constructor
    public Part() {

    }


    public Part(int partID, String name, int stock, int min, int max, double price) {
        this.setID(partID);
        this.setName(name);
        this.setStock(stock);
        this.setMin(min);
        this.setMax(max);
        this.setPrice(price);

    }


    public void setID(int partID) {
        this.partID = partID;
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
        return this.partID;
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


}
