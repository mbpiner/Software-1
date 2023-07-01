/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import model.Inventory;
import model.Product;
import model.Part;
import model.InHousePart;
import model.OutsourcedPart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXML ;
import javafx.scene.Node ;
import javafx.scene.control.Alert;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Mason
 */
public class AddPartController implements Initializable {

    

   @FXML private TextField id; 
   @FXML private TextField name;
   @FXML private TextField inv; 
   @FXML private TextField price; 
   @FXML private TextField min; 
   @FXML private TextField max;
  @FXML private TextField idOrName;
   
   @FXML private Button saveButton; 
   
   @FXML private RadioButton inHouseRadioButton;
   @FXML private RadioButton outsourcedRadioButton; 
   
   @FXML private Label machineNumberOrCompanyName;
    
    @FXML
    private ToggleGroup partType;
    
    
    //do we need different lists for inhouse/outsourced parts??
    
    private ObservableList<InHousePart> tempInHousePart = FXCollections.observableArrayList();
    private ObservableList<OutsourcedPart> tempOutsourcedPart = FXCollections.observableArrayList();
    
    //0 for InHouse, 1 for Outsourced.
    
    private String inHouseOrOutsourced = "outsourced";
    
    
     private @FXML Node root;
    
    
    
    //RadioButton inHouseRadioButton = new RadioButton("Left");
        //RadioButton outsourcedRadioButton = new RadioButton("Right");

    

    
    @FXML public javafx.scene.control.Button exitButton;
    
    
    
    
    
@FXML
private void exitButtonPushed(){
    // get a handle to the stage
    Stage stage = (Stage) exitButton.getScene().getWindow();
    // do what you have to do
    stage.close();
}
    
    
    
   
    
    
    //int productID, String name, int stock, int min, int max, double price)
    
    
    @FXML
     public void savePartButtonPushed(ActionEvent actionEvent) {
        System.out.println("save part Clicked");
        System.out.println(inHouseOrOutsourced);

        
        //list.getSelectionModel().getSelectedIndices()
        
        
        //System.out.println(tempProduct.getSelectionModel().getSelectedIndices());
        
        //Inventory inventory = new Inventory();
        
       
        /*
                                int partID, String name, int stock, int min, int max, double price
                                    
        
            inhouse has int machineID            int partID, String name, int stock, int min, int max, double price, int machineID
            outSourced has string Company Name       int partID, String name, int stock, int min, int max, double price, String companyName
        
        
        
        */
        
        
        
        
        
        //this code here has the NPE problem...
       
        
        
       
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        if(inHouseRadioButton.isSelected()){
            
             System.out.println("...IN INHOUSE IF STATEMENT...\n"); 
             System.out.println(inHouseOrOutsourced);
             System.out.println("...\n"); 
             
            
        
        
        
            
            
            /*
            int machineID = Integer.parseInt(idOrName.getText());
            InHousePart inHousePart = new InHousePart(partID, partName, partInv, partMin, partMax, partPrice, machineID);
            tempPart.add(inHousePart);
            Inventory.addPart(inHousePart);
            
            
            */
            
            
          if(inv.getText().isEmpty() || price.getText().isEmpty() || name.getText().isEmpty() ){
            System.out.println("inv/price/name error...\n");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error adding part");
            alert.setHeaderText("Error adding part in inventory!");
            alert.setContentText("All parts must have a name, price, and inventory level!");
            alert.showAndWait();
            return;
            
          }
           
            
            
            
            
            
            
            
            
        int partID = Integer.parseInt(id.getText());
        String partName = name.getText();
        int partInv = Integer.parseInt(inv.getText());
        double partPrice = Double.parseDouble(price.getText());
        int partMin = Integer.parseInt(min.getText());
        int partMax = Integer.parseInt(max.getText());
        int machineID = Integer.parseInt(idOrName.getText());
        
        
        
        if(partMax <= partMin){
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error adding part");
            alert.setHeaderText("Error adding part in inventory!");
            alert.setContentText("Maximum inventory level must be greater than minimum inventory level!");
            alert.showAndWait();
            return;
        
        }
        
       
        
        
        
        
        
        
            InHousePart inHousePart = new InHousePart(partID, partName, partInv, partMin, partMax, partPrice, machineID);
            tempInHousePart.add(inHousePart);
            Inventory.addPart(inHousePart);
            
            
            
            
            
            
            
            
            
            
        }
     
        
        
        
        
        
         if(outsourcedRadioButton.isSelected()){
        
             
             
             /*
            
            String companyName = idOrName.getText();
            OutsourcedPart outsourcedPart = new OutsourcedPart(partID, partName, partInv, partMin, partMax, partPrice, companyName);
            tempPart.add(outsourcedPart);
            Inventory.addPart(outsourcedPart);
            
            */
            
            
            
            System.out.println("...IN OURSOURCED IF STATEMENT...\n"); 
             System.out.println(inHouseOrOutsourced);
             System.out.println("...\n"); 
            
            if(inv.getText().isEmpty() || price.getText().isEmpty() || name.getText().isEmpty() ){
            System.out.println("inv/price/name error...\n");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error adding part");
            alert.setHeaderText("Error adding part in inventory!");
            alert.setContentText("All parts must have a name, price, and inventory level!");
            alert.showAndWait();
            return;
        
        }
            
        int partID = Integer.parseInt(id.getText());
        String partName = name.getText();
        int partInv = Integer.parseInt(inv.getText());
        double partPrice = Double.parseDouble(price.getText());
        int partMin = Integer.parseInt(min.getText());
        int partMax = Integer.parseInt(max.getText());
        
            String companyName = idOrName.getText();
            
            
            
            
            if(partMax <= partMin){
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error adding part");
            alert.setHeaderText("Error adding part in inventory!");
            alert.setContentText("Maximum inventory level must be greater than minimum inventory level!");
            alert.showAndWait();
            return;
        
        }
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
        
            OutsourcedPart outsourcedPart = new OutsourcedPart(partID, partName, partInv, partMin, partMax, partPrice, companyName);
            tempOutsourcedPart.add(outsourcedPart);
            Inventory.addPart(outsourcedPart);
            
            
              
             System.out.println(outsourcedPart.getID());
            
            
            
            
            
        }
        
        
        
        
        
        //Need to include connection between inHouse/outsourced radio buttons and label text "Machine #" or "Company Name"
        //as well as creating the appropriate part IH/OS using the correct class...
  
    
        //pretty sure I need to run this in main() once everything is going, may need to uncomment it if its not getting executed in time in main() at this point.
        //Inventory inventory = new Inventory();
        
        
        
        
        
        //InHousePart inHousePart = new InHousePart(partID, partName, partInv, partMin, partMax, partPrice, machineID);
        //OutsourcedPart outsourcedPart = new OutsourcedPart(partID, partName, partInv, partMin, partMax, partPrice, companyName);
        
        //tempPart.add(part);

        
        //Inventory.addProduct(product);
        
        
        
         
        
        
        
        //newTable.setItems(Inventory.getAllProducts());
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //make control flow to select one of the below based upon radio button selection.......
        
        
        //InHousePart inHousePart = new InHousePart(partID, partName, partInv, partMin, partMax, partPrice, machineID);
        //OutsourcedPart outsourcedPart = new InHousePart(partID, partName, partInv, partMin, partMax, partPrice, machineID);
        
        
        
        
        
        
        //tempPart.add(part);
        //Inventory.addPart(inHousePart);
        //Inventory.addPart(outsourcedPart);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //System.out.println(tempProduct.select());
        
        //int onedd=tempProduct.getSelectionModel().getSelectedItems();  
        
        
        
        
        //Product tempProduct = new Product();
        //tempProduct.addProduct(part);
        
        
        
        //System.out.println(Inventory.getAllProducts());
        
        //ObservableList<Product> tempProduct = FXCollections.observableArrayList();
        
        //tempProduct
        
        
        
        
        
        
        
        
        //newTable.setItems(Inventory.getAllProducts());
        
        
        
        
        
        
        ///////
        
        
        
        
        
        
        
        //newTable.setItems(tempPart);
        
        
        
        
        //
        //
        //
        //
        //
        //
        //
        
        
        //may need to uncomment this also... if as ^^^^
        //inventory.addProduct(product);

    }
    
    
    
    
     
     
     /*
     
      public void partTypeRadioButtonSelected(ActionEvent actionEvent) {
                System.out.println("radio button Clicked\n");
                
                
                if (inHouseRadioButton.isSelected())
                    {
                        System.out.println("in house radio button Clicked\n");
                        machineNumberOrCompanyName.setText("Machine ID");
                    }
                if (outsourcedRadioButton.isSelected())
                    {
                        
                        System.out.println("outsourced radio button Clicked\n");
                        machineNumberOrCompanyName.setText("Company Name");
                        
                    }
    
                
        }
     
     */
     
     
     
     
     
     
      
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     
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
     
       
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //partType = new ToggleGroup();
        
         inHouseRadioButton.setToggleGroup(partType);
         outsourcedRadioButton.setToggleGroup(partType);
        
        
        //outsourcedRadioButton.setSelected(true);
        
        
        
        inHouseRadioButton.setFocusTraversable(false);
outsourcedRadioButton.setFocusTraversable(false);
        
        
        
       //ToggleGroup partType = new ToggleGroup();
        
        
    //outsourcedRadioButton.setToggleGroup(partType);    
        
            
    //inHouseRadioButton.setToggleGroup(partType);
    
    
    
    
    /*
    
    
    partType.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
        @Override
        public void changed(ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) {

            RadioButton chk = (RadioButton)t1.getToggleGroup().getSelectedToggle(); // Cast object to radio button
            System.out.println("Selected Radio Button - "+chk.getText());
            
            
            

        }
    });
     
*/
    
    //Outsourced
    //In-House
    
    
    
    partType.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
        if (partType.getSelectedToggle() != null){
            //values[0] = partType.getSelectedToggle().getUserData().toString();
            //System.out.println(values[0]);         
            
            
            
                    RadioButton selectedPartType = (RadioButton) partType.getSelectedToggle();
                    String partType = selectedPartType.getText();
                    
                  
                    
                    if(partType.equals("In-House")){
                        machineNumberOrCompanyName.setText("Machine ID");
                        System.out.println(partType);
                        System.out.println("0\n"); 
                        inHouseOrOutsourced = "inhouse\n";
                        System.out.println(inHouseOrOutsourced); 
                            
                    }
                                       
                    if(partType.equals("Outsourced")){
                        machineNumberOrCompanyName.setText("Company Name");
                        System.out.println(partType);
                        System.out.println("1\n");
                        inHouseOrOutsourced = "outsourced\n";
                        System.out.println(inHouseOrOutsourced); 
                          
                        
                    }
                    
        }
    });


}



    
    
   
    
    
    
    
    
    
    
    
    //inHouseRadioButton.setSelected(true);
    
    
    
    
    //RadioButton inHouseRadioButton = (RadioButton) partType.getSelectedToggle();
        
        
        
        
        
        
        
        
    }    

    

