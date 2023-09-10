package model;


import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {

    private static ObservableList<Part> allParts = FXCollections.observableArrayList(); //partInventory
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList(); //productInventory
    private static int partIDCount = 0;
    private static int productIDCount = 0;

    public Inventory() {

    }

    public static void addProduct(Product newProduct) {
        allProducts.add(newProduct);
    }


    public static void addPart(Part newPart) {
        allParts.add(newPart);

    }


    public static boolean deleteProduct(Product selectedProduct) {
        return allProducts.remove(selectedProduct);

    }


    public static boolean deletePart(Part selectedPart) {
        return allParts.remove(selectedPart);

    }


    public static Product lookupProduct(int productIndex) {
        if (productIndex >= 0 && productIndex < allProducts.size()) {
            return allProducts.get(productIndex);
        } else {
            return null;
        }
    }


    public static Part lookupPart(int partIndex) {
        if (partIndex >= 0 && partIndex < allParts.size()) {
            return allParts.get(partIndex);
        } else {
            return null;
        }
    }


    public static void updateProduct(Product newProduct, int productIndex) {
        if (productIndex >= 0 && productIndex < allProducts.size()) {
            allProducts.set(productIndex, newProduct);
        } else {

        }
    }


    public static void updatePart(Part newPart, int partIndex) {
        if (partIndex >= 0 && partIndex < allParts.size()) {
            allParts.set(partIndex, newPart);
        } else {

        }
    }

    // get length of allParts/allProducts for setting ID's of new parts/products...

    public static int getNumParts() {
        return allParts.size();
    }

    public static int getNumProducts() {
        return allProducts.size();
    }


    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }


    public static boolean isInteger(String s, int radix) {
        if (s.isEmpty()) return false;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '-') {
                if (s.length() == 1) return false;
                else continue;
            }
            if (Character.digit(s.charAt(i), radix) < 0) return false;
        }
        return true;
    }


}
