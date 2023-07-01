/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_controller;

import java.net.URL;
import javafx.scene.control.Alert;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Product;
import model.Part;
import model.Inventory;
import model.OutsourcedPart;
import model.InHousePart;

        
/**
 * FXML Controller class
 *
 * @author Mason
 */
public class AddProductController implements Initializable {

    
        
    
    
    public TableColumn allPartsIDCol;
    public TableColumn allPartsNameCol;
    public TableColumn allPartsInvCol;
    public TableColumn allPartsPriceCol;
    public TableView allPartsTable;
    
    public TableColumn newIDCol;
    public TableColumn newNameCol;
    public TableColumn newInvCol;
    public TableColumn newPriceCol;
    public TableView newTable;
    
    
   @FXML private TextField id; 
   @FXML private TextField name;
   @FXML private TextField inv; 
   @FXML private TextField price; 
   @FXML private TextField min; 
   @FXML private TextField max;
   
   @FXML private TextField allPartsSearchField;
   
   
   @FXML private Button deleteButton;
   @FXML private Button cancelButton; 
    
   static ObservableList<Part> tempAssociatedPartsList = FXCollections.observableArrayList();
           
   private ObservableList<Product> tempProduct = FXCollections.observableArrayList();
    
    
    //int productID, String name, int stock, int min, int max, double price)
    @FXML
    private Button addAssociatedPartButton;
    @FXML
    private Button saveProductButton;
    
    
    
    @FXML public javafx.scene.control.Button exitButton;
    
    
    
    
    
@FXML
private void exitButtonPushed(){
    // get a handle to the stage
    Stage stage = (Stage) exitButton.getScene().getWindow();
    // do what you have to do
    stage.close();
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @FXML
     public void saveProductButtonPushed(ActionEvent actionEvent) {
        System.out.println("save Clicked");

        
        //list.getSelectionModel().getSelectedIndices()
        
        
        //System.out.println(tempProduct.getSelectionModel().getSelectedIndices());
        
        //Inventory inventory = new Inventory();
        
  if(inv.getText().isEmpty() || price.getText().isEmpty() || name.getText().isEmpty() ){
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error adding product");
            alert.setHeaderText("Error adding product in inventory!");
            alert.setContentText("All products must have a name, price, and inventory level!");
            alert.showAndWait();
            return;
        
        }      
        
        
        
        
        
        
        
        int productID = Integer.parseInt(id.getText());
        String productName = name.getText();
        int productInv = Integer.parseInt(inv.getText());
        double productPrice = Double.parseDouble(price.getText());
        int productMin = Integer.parseInt(min.getText());
        int productMax = Integer.parseInt(max.getText());
  
    
        //pretty sure I need to run this in main() once everything is going, may need to uncomment it if its not getting executed in time in main() at this point.
        //Inventory inventory = new Inventory();
        
        
        
        if(productMax <= productMin){
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error adding product");
            alert.setHeaderText("Error adding product in inventory!");
            alert.setContentText("Maximum inventory level must be greater than minimum inventory level!");
            alert.showAndWait();
            return;
        
        } 
 
        
        Product product = new Product(productID, productName, productInv, productMin, productMax, productPrice);
        
        //tempProduct.add(product);
         
        /*
       

           public static void updateDataChart(){
    for (MyData data : myObservableList) {
        if ( data.isLucky() ) // or whatever is your condition
            dataLineChart.getData().add(data);
    }
}
    
        */
        
        
        
        
       /*
    for(Part part : tempAssociatedPartsList) {
            product.setAssociatedPart(part);
            System.out.println(part.getName());
            */
       
       
       
    
    tempAssociatedPartsList.forEach((part)-> {product.setAssociatedPart(part);});
    
        
    Inventory.addProduct(product);
    product.getAssociatedParts();
    tempAssociatedPartsList.clear();
    
    
    
    System.out.println(product.getAssociatedParts());
        
        
        //product.setAssociatedPart(tempAssociatedPartsList);
        
        
        
        //tempAssociatedPartsList();
        
        
        //System.out.println(tempProduct.select());
        
        //int onedd=tempProduct.getSelectionModel().getSelectedItems();  
        
        
        
        
        //Product tempProduct = new Product();
        //tempProduct.addProduct(product);
        
        
        
        //System.out.println(Inventory.getAllProducts());
        
        //ObservableList<Product> tempProduct = FXCollections.observableArrayList();
        
        //tempProduct
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //newTable.setItems(tempProduct);
        
        
        
        
        
        
        
        
        
        
        
        
        
        //may need to uncomment this also... if as ^^^^
        //inventory.addProduct(product);

    }
    
     
     /*
     public void saveButtonPushed(ActionEvent actionEvent) {
        System.out.println("Save Clicked");

        BasketballPlayer SP = (BasketballPlayer) allTable.getSelectionModel().getSelectedItem();
        if(SP == null)
            return;

        allPlayers.remove(SP);
        fewPlayers.add(SP);
    }
     
     */
    
    
     
     
     
     
    @FXML
     public void addAssociatedPartButtonPushed(ActionEvent actionEvent) {
         
        Part selectedPart = (Part) allPartsTable.getSelectionModel().getSelectedItem();
        int selectedPartIndex = Inventory.getAllParts().indexOf(selectedPart);
        
        tempAssociatedPartsList.add(selectedPart);
        
     }
     
     
     
     //public void addAssociatedPartButtonPushed(ActionEvent actionEvent) {
       // System.out.println("associated part button Clicked");

        //Inventory.addProduct(tempProduct);
        
        
        
        
        
        
        
        
        //Inventory inventory = new Inventory();
        
        
        /*
        int productID = Integer.parseInt(id.getText());
        String productName = name.getText();
        int productInv = Integer.parseInt(inv.getText());
        double productPrice = Double.parseDouble(price.getText());
        int productMin = Integer.parseInt(min.getText());
        int productMax = Integer.parseInt(max.getText());
          */
    
        //pretty sure I need to run this in main() once everything is going, may need to uncomment it if its not getting executed in time in main() at this point.
        //Inventory inventory = new Inventory();
        
        //Product product = new Product(productID, productName, productInv, productMin, productMax, productPrice);
        //Inventory.addProduct(product);
        
        /*
        System.out.println(Inventory.getAllProducts());
        
        newTable.setItems(Inventory.getAllProducts());
        */
        //may need to uncomment this also... if as ^^^^
        //inventory.addProduct(product);

    //}
    
    
    
    
   
    
     
     
      public void deletePartButtonPushed(ActionEvent actionEvent) {
         Part deletePart = (Part) newTable.getSelectionModel().getSelectedItem();
 
        tempAssociatedPartsList.remove(deletePart);

     }
     
     
     
     
     
     
    
    
    
    
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        
        
        
        /*
        
        public TableColumn newIDCol;
    public TableColumn newNameCol;
    public TableColumn newInvCol;
    public TableColumn newPriceCol;
    public TableView newTable;
        
        
    public Product(int productID, String name, int stock, int min, int max, double price)
        
        
        
        
        
          newIDCol.setCellValueFactory(cellData -> cellData.getValue().productIDProperty());
        
        
                    inventory.getAllProducts()

                    product.getID();
        
        
        
        */
        
            allPartsIDCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
            allPartsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            allPartsInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
            allPartsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
            allPartsTable.setItems(Inventory.getAllParts());
            
            
            newIDCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
            newNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            newInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
            newPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
            newTable.setItems(tempAssociatedPartsList);
            
            
            
            
            
            //part search
            
            
            ObservableList<Part> partData = Inventory.getAllParts();
            FilteredList<Part> filteredPartData = new FilteredList<>(partData, p -> true);
            allPartsSearchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredPartData.setPredicate(part -> {  if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
            
            
                if(Inventory.isInteger(newValue, 10)){
                    int newValueInt = Integer.parseInt(newValue);
                    System.out.println("IS INTEGER..." + part.getID());
                    return part.getID() == newValueInt;
                } else {
                String lowerCaseFilter = newValue.toLowerCase();
                System.out.println("IS STR..." + part.getName());
                return part.getName().toLowerCase().contains(lowerCaseFilter);
                }
            });
        });

            SortedList<Part> sortedPartData = new SortedList<>(filteredPartData);
            sortedPartData.comparatorProperty().bind(allPartsTable.comparatorProperty());
            allPartsTable.setItems(sortedPartData);
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
        
        
        
        
        
        
        
    }    
    
}
