/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Mason
 */
public class Mbp_c482 extends Application {
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        
        Parent root = FXMLLoader.load(getClass().getResource("/view_controller/MainScreen.fxml"));
        
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
  
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
        
        
        //Inventory inventory = new Inventory();
            
        
        
        /* some testing...
        
        
        Inventory inventory = new Inventory();
        Product explorer = new Product(0001, "explorer", 1, 0, 100, 1500);
        Part tires = new InHousePart(1001, "tires", 100, 0, 1000, 125, 0002);
        
        inventory.addProduct(explorer);
        inventory.addPart(tires);
        
        explorer.setAssociatedPart(tires);
        
        explorer.getAssociatedParts();
        explorer.deleteAssociatedPart(1001);
        explorer.getAssociatedParts();
   
        */
        
 
        
        
        
        
        
        
        
    }
    
    
   
    
}
