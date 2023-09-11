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

/**
 * FXML Controller class
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


    @FXML
    private TextField allPartsSearchField;


    @FXML
    private Button deleteButton;
    @FXML
    private Button addAssociatedPartButton;

    static ObservableList<Part> tempAssociatedPartsList = FXCollections.observableArrayList();


    @FXML
    private javafx.scene.control.Button exitButton;


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


    @FXML
    public void saveProductButtonPushed(ActionEvent actionEvent) {


        if (inv.getText().isEmpty() || price.getText().isEmpty() || name.getText().isEmpty()) {

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


        if (productMax <= productMin) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error modifying product");
            alert.setHeaderText("Error modifying product in inventory!");
            alert.setContentText("Maximum inventory level must be greater than minimum inventory level!");
            alert.showAndWait();
            return;

        }


        Product product = Inventory.lookupProduct(view_controller.MainScreenController.productToModifyIndex());

        product.getAssociatedParts().forEach((part) -> {
            tempAssociatedPartsList.add(part);
        });


        Product newProduct = new Product(productID, productName, productInv, productMin, productMax, productPrice);


        tempAssociatedPartsList.forEach((part) -> {
            newProduct.setAssociatedPart(part);
        });


        Inventory.updateProduct(newProduct, view_controller.MainScreenController.productToModifyIndex());

        tempAssociatedPartsList.clear();


    }


    public void deletePartButtonPushed(ActionEvent actionEvent) {
        Product product = Inventory.lookupProduct(view_controller.MainScreenController.productToModifyIndex());
        Part deletePart = (Part) newTable.getSelectionModel().getSelectedItem();

        product.deleteAssociatedPart(deletePart);

    }


    @FXML
    private void exitButtonPushed() {
        // get a handle to the stage
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Product product = Inventory.lookupProduct(view_controller.MainScreenController.productToModifyIndex());

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
            filteredPartData.setPredicate(part -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }


                if (Inventory.isInteger(newValue, 10)) {
                    int newValueInt = Integer.parseInt(newValue);
                    return part.getID() == newValueInt;
                } else {
                    String lowerCaseFilter = newValue.toLowerCase();
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


        product.setAssociatedPart(selectedPart);


    }


}
