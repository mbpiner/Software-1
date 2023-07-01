/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_controller;


import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.net.URL;
import java.util.ResourceBundle;
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
import model.Inventory;
import model.Part;
import model.Product;
import model.InHousePart;
import model.OutsourcedPart;
//import static view_controller.AddProductController.tempAssociatedPartsList;


/**
 * FXML Controller class
 *
 * @author Mason
 */
public class ModifyProductController implements Initializable {

    @FXML
    private TextField id;
    @FXML
    private TextField name;
    @FXML
    private TextField inv;
    @FXML
    private TextField price;
    @FXML
    private TextField max;
    @FXML
    private TextField min;
    
    
    @FXML private TextField allPartsSearchField;
    
    
    @FXML
    private Button deleteButton;
    @FXML
    private Button addAssociatedPartButton;
    
    static ObservableList<Part> tempAssociatedPartsList = FXCollections.observableArrayList();
    
    
    
    //static Product product = Inventory.lookupProduct(view_controller.MainScreenController.productToModifyIndex());
    
    
    
    //@FXML
    //public Button exitButton;
    
    @FXML private javafx.scene.control.Button exitButton;
    
    
    @FXML
    private Button saveProductButton;
    @FXML
    private TableView allPartsTable;
    @FXML
    private TableColumn allPartsIDCol;
    @FXML
    private TableColumn allPartsNameCol;
    @FXML
    private TableColumn allPartsInvCol;
    @FXML
    private TableColumn allPartsPriceCol;
    @FXML
    private TableView newTable;
    @FXML
    private TableColumn newIDCol;
    @FXML
    private TableColumn newNameCol;
    @FXML
    private TableColumn newInvCol;
    @FXML
    private TableColumn newPriceCol;

    /**
     * Initializes the controller class.
     */
    
    
    /*
    
     private TextField id;
    @FXML
    private TextField name;
    @FXML
    private TextField inv;
    @FXML
    private TextField price;
    @FXML
    private TextField max;
    @FXML
    private TextField min;
    
    
    */
    
    
    
    
    
    
    
    
    
     
    @FXML
     public void saveProductButtonPushed(ActionEvent actionEvent) {
        System.out.println("save Clicked");

        
        //list.getSelectionModel().getSelectedIndices()
        
        //System.out.println(tempProduct.getSelectionModel().getSelectedIndices());
        
        //Inventory inventory = new Inventory();
        
        if(inv.getText().isEmpty() || price.getText().isEmpty() || name.getText().isEmpty() ){
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error modifying product");
            alert.setHeaderText("Error modifying product in inventory!");
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
        
        
        
           
        if(productMax <= productMin){
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error modifying product");
            alert.setHeaderText("Error modifying product in inventory!");
            alert.setContentText("Maximum inventory level must be greater than minimum inventory level!");
            alert.showAndWait();
            return;
        
        }
        
        
 
  
        
        
        Product product = Inventory.lookupProduct(view_controller.MainScreenController.productToModifyIndex());
    
        //pretty sure I need to run this in main() once everything is going, may need to uncomment it if its not getting executed in time in main() at this point.
        //Inventory inventory = new Inventory();
        
        //Product product = Inventory.lookupProduct(view_controller.MainScreenController.productToModifyIndex());
        
        
        product.getAssociatedParts().forEach((part)-> {tempAssociatedPartsList.add(part);});
        
        
        Product newProduct = new Product(productID, productName, productInv, productMin, productMax, productPrice);
        
        
        tempAssociatedPartsList.forEach((part)-> {newProduct.setAssociatedPart(part);});
        
        
        
       
        Inventory.updateProduct(newProduct, view_controller.MainScreenController.productToModifyIndex());
        
        tempAssociatedPartsList.clear();
        
        
        
        
        
        
        /*
        
        for(Part part : product.getAssociatedParts() ) {
            System.out.println("...part forloop in add -->" + part.getName() + "<--part in for loop in add...\n");
            
}
        */
        
        
        
        
        
        
        
        
        
        
        
        //newTable.setItems(product.getAssociatedParts());
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*
        tempAssociatedPartsList.forEach((part) -> {
            product.setAssociatedPart(part);
        });
        
                
                
        Inventory.updateProduct(product, view_controller.MainScreenController.productToModifyIndex());
        newTable.setItems(product.getAssociatedParts());
        //tempProduct.add(product);
        tempAssociatedPartsList.clear();
        
        */
        //System.out.println(tempProduct.select());
        
        //int onedd=tempProduct.getSelectionModel().getSelectedItems();  
        
        
        
        
        //Product tempProduct = new Product();
        //tempProduct.addProduct(product);
        
        //Inventory.addProduct(product);
        
        //System.out.println(Inventory.getAllProducts());
        
        //ObservableList<Product> tempProduct = FXCollections.observableArrayList();
        
        //tempProduct
        
        
        
        
        
        
        
        
        //newTable.setItems(Inventory.getAllProducts());
        
        
        
        
        
       
        
        
        
        
        
        
        
        
        //newTable.setItems(tempProduct);
        
        
        
        
        
        
        
        
        
        
        
        
        
        //may need to uncomment this also... if as ^^^^
        //inventory.addProduct(product);

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    
     public void exitButtonPushed(ActionEvent event) throws IOException {
        System.out.println("exit Clicked");
    
    
    
    
      Parent addPartViewParent = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
            Scene tableViewScene = new Scene(addPartViewParent);

            // Get Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
    
    
    
}

*/
     
     
     
      public void deletePartButtonPushed(ActionEvent actionEvent) {
         Product product = Inventory.lookupProduct(view_controller.MainScreenController.productToModifyIndex());
         Part deletePart = (Part) newTable.getSelectionModel().getSelectedItem();
 
        //tempAssociatedPartsList.remove(deletePart);
        product.deleteAssociatedPart(deletePart);

     }
     
     
     
     
     
@FXML
private void exitButtonPushed(){
    // get a handle to the stage
    Stage stage = (Stage) exitButton.getScene().getWindow();
    // do what you have to do
    stage.close();
}
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Product product = Inventory.lookupProduct(view_controller.MainScreenController.productToModifyIndex());
        
        //String pidStr = Integer.toString(productID);
        
        //System.out.println(productID);
        
        id.setText(Integer.toString(product.getID()));
        name.setText(product.getName());
        inv.setText(Integer.toString(product.getStock()));
        price.setText(Double.toString(product.getPrice()));
        max.setText(Integer.toString(product.getMax()));
        min.setText(Integer.toString(product.getMin()));
        
        
        
        
        
        
        
        
            allPartsIDCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
            allPartsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            allPartsInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
            allPartsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
            allPartsTable.setItems(Inventory.getAllParts());
            
            
            newIDCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
            newNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            newInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
            newPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
            newTable.setItems(product.getAssociatedParts());
        
        
        
            
            
            
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

    
    
    
    
    
      
    
    
    
    
    
    
    
    
    
    
    
    
    @FXML
    private void addAssociatedPartButtonPushed(ActionEvent event) {
        
        Product product = Inventory.lookupProduct(view_controller.MainScreenController.productToModifyIndex());
        
        Part selectedPart = (Part) allPartsTable.getSelectionModel().getSelectedItem();
        
        int selectedPartIndex = Inventory.getAllParts().indexOf(selectedPart);
        System.out.println("...-->selectedpartname-->\n" + selectedPart.getName() + "...\n" + selectedPartIndex + "...\n");
        
        
        
         //tempAssociatedPartsList.forEach((part)-> {tempAssociatedPartsList.add(part);});
        
        product.setAssociatedPart(selectedPart); 
         
        
        
        //tempAssociatedPartsList.add(selectedPart);

        //Inventory.updateProduct(newProduct, view_controller.MainScreenController.productToModifyIndex());
        
        
        
        
        //tempAssociatedPartsList.add(selectedPart);
        
        
        
        
        
        
        
        
        
        
        
        
        // modifyProduct = (Product) ProductsTableViewMain.getSelectionModel().getSelectedItem();
        //modifyProductIndex = Inventory.getAllProducts().indexOf(modifyProduct);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

  
}
