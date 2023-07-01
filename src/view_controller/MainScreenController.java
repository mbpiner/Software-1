package view_controller;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import model.Product;
import model.Part;
import model.Inventory;
import model.OutsourcedPart;
import model.InHousePart;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

//Inventory inventory = new Inventory();


public class MainScreenController implements Initializable {

    @FXML public static Inventory inventory;
    
    private static Part modifyPart;
    private static int modifyPartIndex;
    private static Product modifyProduct;
    private static int modifyProductIndex;
    
    private static int modifyProductID;
    
    /*
    
    @FXML
    private Label TitleLabelMain;

    @FXML
    private Button AddPartsButtonMain;

    @FXML
    private TextField PartsSearchFieldMain;

    @FXML
    private TableView<?> PartsTableViewMain;

    @FXML
    private TableColumn PartIDColMain;

    @FXML
    private TableColumn PartNameColMain;

    @FXML
    private TableColumn PartInvColMain;

    @FXML
    private TableColumn PartPriceColMain;

    @FXML
    private Button AddProductsButtonMain;

    @FXML
    private TextField ProductsSearchFieldMain;

    @FXML
    private TableView<?> ProductsTableViewMain;

    @FXML
    private TableColumn ProductNameColMain;

    @FXML
    private TableColumn ProductInvColMain;

    @FXML
    private TableColumn ProductPriceColMain;

    @FXML
    private TableColumn ProductIDColMain;

    @FXML
    private Button ExitButtonMain;
    

    */
    
    
    
    
    
    
    @FXML
    private Label TitleLabelMain;

    @FXML
    private Button AddPartsButtonMain;

    @FXML private TextField PartsSearchFieldMain;

    @FXML
    private TableView PartsTableViewMain;

    @FXML
    private TableColumn PartIDColMain;

    @FXML
    private TableColumn PartNameColMain;

    @FXML
    private TableColumn PartInvColMain;

    @FXML
    private TableColumn PartPriceColMain;

    @FXML
    private Button AddProductsButtonMain;
    
     @FXML
    private Button ModifyProductsButtonMain;
     
     
     @FXML
    private Button ModifyPartsButtonMain;
     
     
    @FXML
    private TextField ProductsSearchFieldMain;

    @FXML
    private TableView ProductsTableViewMain;

    @FXML
    private TableColumn ProductNameColMain;

    @FXML
    private TableColumn ProductInvColMain;

    @FXML
    private TableColumn ProductPriceColMain;

    @FXML
    private TableColumn ProductIDColMain;

    @FXML
    private Button ExitButtonMain;
    
    @FXML
    private Button ClearButtonMain;
    
    
    
    @FXML
    public void exitButtonPushed(){
    
        System.exit(0);
    
    }
    
    
    
    
    //private ObservableList<InHousePart> tempInHousePart = FXCollections.observableArrayList();
    //private ObservableList<OutsourcedPart> tempOutsourcedPart = FXCollections.observableArrayList();
    
    //static ObservableList<Part> partList = FXCollections.observableArrayList();
    //static ObservableList<Product> productList = FXCollections.observableArrayList();
    
    
    
    
    
    /*
try {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Demo.fxml"));
    Parent root1 = (Parent) fxmlLoader.load();
    Stage stage = new Stage();
    stage.initModality(Modality.APPLICATION_MODAL);
    stage.initStyle(StageStyle.UNDECORATED);
    stage.setTitle("ABC");
    stage.setScene(new Scene(root1));  
    stage.show();
}
    
    */
    
    
    
    
    
    public static int partToModifyIndex() {
        return modifyPartIndex;
    }

    public static int productToModifyIndex() {
        return modifyProductIndex;
    }
    
    
    
     public static int productToModifyID() {
        return modifyProductID;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    public void openAddProductWindow(ActionEvent event) throws Exception {               
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view_controller/AddProduct.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        
         //stage.initOwner(primaryStage);
         stage.initModality(Modality.APPLICATION_MODAL);

            // Specifies the owner Window (parent) for new window
            //stage.initOwner(primaryStage);
          
    
            
            
        
        stage.setScene(new Scene(root1));  
        stage.show();
    } catch(Exception e) {
        e.printStackTrace();
    }
}
    
    
    
    
    
    
    
    public void openAddPartWindow(ActionEvent event) throws Exception {               
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view_controller/AddPart.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        
         //stage.initOwner(primaryStage);
         stage.initModality(Modality.APPLICATION_MODAL);

            // Specifies the owner Window (parent) for new window
            //stage.initOwner(primaryStage);
        
        stage.setScene(new Scene(root1));  
        stage.show();
    } catch(Exception e) {
        e.printStackTrace();
    }
}
    
    
    
    
    
    
     
    public void openModifyProductWindow(ActionEvent event) throws Exception {               
    try {
        
        
        modifyProduct = (Product) ProductsTableViewMain.getSelectionModel().getSelectedItem();
        modifyProductIndex = Inventory.getAllProducts().indexOf(modifyProduct);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view_controller/ModifyProduct.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        
         //stage.initOwner(primaryStage);
         stage.initModality(Modality.APPLICATION_MODAL);

            // Specifies the owner Window (parent) for new window
            //stage.initOwner(primaryStage);
        
        stage.setScene(new Scene(root1));  
        stage.show();
    } catch(Exception e) {
        e.printStackTrace();
    }
}
    
    
    
    public void openModifyPartWindow(ActionEvent event) throws Exception {               
    try {
        
        
        modifyPart = (Part) PartsTableViewMain.getSelectionModel().getSelectedItem();
        modifyPartIndex = Inventory.getAllParts().indexOf(modifyPart);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view_controller/ModifyPart.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        
         //stage.initOwner(primaryStage);
         stage.initModality(Modality.APPLICATION_MODAL);

            // Specifies the owner Window (parent) for new window
            //stage.initOwner(primaryStage);
        
        stage.setScene(new Scene(root1));  
        stage.show();
    } catch(Exception e) {
        e.printStackTrace();
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    
    
     @FXML
    void modifyProductsPushed(ActionEvent event) throws IOException {
        
        modifyProduct = (Product) ProductsTableViewMain.getSelectionModel().getSelectedItem();
        modifyProductIndex = Inventory.getAllProducts().indexOf(modifyProduct);
        modifyProductID = modifyProduct.getID();
        Parent modifyProducts = FXMLLoader.load(getClass().getResource("ModifyProduct.fxml"));
        
        Scene scene = new Scene(modifyProducts);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setScene(scene);
        window.show();
    }
    
    
    */
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //ProductsTableViewMain;
    
    
    
    
    
    
    
    //"clear" we'll use as refresh for now
    
    
    
     
     public void deleteProductButtonPushed(ActionEvent actionEvent) {

 Product deleteProduct = (Product) ProductsTableViewMain.getSelectionModel().getSelectedItem();
 
        Inventory.deleteProduct(deleteProduct);
       
        
        //System.out.println(Inventory.getAllProducts());
        
        //ProductsTableViewMain.setItems(Inventory.getAllProducts());
        
  
    }
     
     
     
     public void deletePartButtonPushed(ActionEvent actionEvent) {
         Part deletePart = (Part) PartsTableViewMain.getSelectionModel().getSelectedItem();
 
        Inventory.deletePart(deletePart);

     
     
     
     
     }
     
     
     
     
    
    
    
    
    
    
    
    
    /*
    
 
    public void handle(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("/view_controller/AddProduct.fxml"));
            Stage stage = new Stage();
            stage.setTitle("My New Stage Title");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    
    
    */
    
    
    
    
    
    
    
    
    
    
    
     //@Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        
        
        
        
        //added
            ProductsTableViewMain.setItems(Inventory.getAllProducts());
    //end added
    
    
    
            ProductIDColMain.setCellValueFactory(new PropertyValueFactory<>("ID"));
            ProductNameColMain.setCellValueFactory(new PropertyValueFactory<>("name"));
            ProductInvColMain.setCellValueFactory(new PropertyValueFactory<>("stock"));
            ProductPriceColMain.setCellValueFactory(new PropertyValueFactory<>("price"));
            
            
            
            PartsTableViewMain.setItems(Inventory.getAllParts());
            
            
            PartIDColMain.setCellValueFactory(new PropertyValueFactory<>("ID"));
            PartNameColMain.setCellValueFactory(new PropertyValueFactory<>("name"));
            PartInvColMain.setCellValueFactory(new PropertyValueFactory<>("stock"));
            PartPriceColMain.setCellValueFactory(new PropertyValueFactory<>("price"));
        
       ////////////////product search
            
            
            ObservableList<Product> prodData = Inventory.getAllProducts();
            FilteredList<Product> filteredData = new FilteredList<>(prodData, p -> true);
            ProductsSearchFieldMain.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(product -> {  if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
            
            
                if(Inventory.isInteger(newValue, 10)){
                    
                    int newValueInt = Integer.parseInt(newValue);
                    return product.getID() == newValueInt;
                } else 
                
                {
                String lowerCaseFilter = newValue.toLowerCase();
                
                
                return product.getName().toLowerCase().contains(lowerCaseFilter);
                }

            });
        });

            SortedList<Product> sortedProdData = new SortedList<>(filteredData);
            sortedProdData.comparatorProperty().bind(ProductsTableViewMain.comparatorProperty());
            ProductsTableViewMain.setItems(sortedProdData);
            
            
            
            ////////////////////part search
            
            
            
            
            ObservableList<Part> partData = Inventory.getAllParts();
            FilteredList<Part> filteredPartData = new FilteredList<>(partData, p -> true);
            PartsSearchFieldMain.textProperty().addListener((observable, oldValue, newValue) -> {
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
            sortedPartData.comparatorProperty().bind(PartsTableViewMain.comparatorProperty());
            PartsTableViewMain.setItems(sortedPartData);
           
    }   
    
    
    
    
    
    
    
    
    
    
    
    
    
}