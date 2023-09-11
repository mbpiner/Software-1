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

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Inventory;
import model.Part;
import model.Product;
import model.InHousePart;
import model.OutsourcedPart;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 */
public class ModifyPartController implements Initializable {

    @FXML
    private RadioButton inHouseRadioButton;
    @FXML
    private ToggleGroup partType;
    @FXML
    private RadioButton outsourcedRadioButton;
    @FXML
    private Label machineNumberOrCompanyName;
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
    private TextField idOrName;
    @FXML
    private TextField min;
    @FXML
    private Button saveButton;

    @FXML
    public javafx.scene.control.Button exitButton;

    /**
     * Initializes the controller class.
     */


    @FXML
    private void exitButtonPushed() {
        // get a handle to the stage
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }


    @FXML
    private void savePartButtonPushed(ActionEvent event) {


        if (inHouseRadioButton.isSelected()) {


            if (inv.getText().isEmpty() || price.getText().isEmpty() || name.getText().isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error modifying part");
                alert.setHeaderText("Error modifying part in inventory!");
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


            if (partMax <= partMin) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error modifying part");
                alert.setHeaderText("Error modifying part in inventory!");
                alert.setContentText("Maximum inventory level must be greater than minimum inventory level!");
                alert.showAndWait();
                return;

            }


            InHousePart inHousePart = new InHousePart(partID, partName, partInv, partMin, partMax, partPrice, machineID);
            Inventory.updatePart(inHousePart, view_controller.MainScreenController.partToModifyIndex());

        }

        if (outsourcedRadioButton.isSelected()) {


            int partID = Integer.parseInt(id.getText());
            String partName = name.getText();
            int partInv = Integer.parseInt(inv.getText());
            double partPrice = Double.parseDouble(price.getText());
            int partMin = Integer.parseInt(min.getText());
            int partMax = Integer.parseInt(max.getText());

            String companyName = idOrName.getText();


            if (partMax <= partMin) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error modifying part");
                alert.setHeaderText("Error modifying part in inventory!");
                alert.setContentText("Maximum inventory level must be greater than minimum inventory level!");
                alert.showAndWait();
                return;

            }


            if (inv.getText().isEmpty() || price.getText().isEmpty() || name.getText().isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error modifying part");
                alert.setHeaderText("Error modifying part in inventory!");
                alert.setContentText("All parts must have a name, price, and inventory level!");
                alert.showAndWait();
                return;

            }


            OutsourcedPart outsourcedPart = new OutsourcedPart(partID, partName, partInv, partMin, partMax, partPrice, companyName);
            Inventory.updatePart(outsourcedPart, view_controller.MainScreenController.partToModifyIndex());


        }


    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {


        inHouseRadioButton.setToggleGroup(partType);
        outsourcedRadioButton.setToggleGroup(partType);
        inHouseRadioButton.setFocusTraversable(false);
        outsourcedRadioButton.setFocusTraversable(false);

        partType.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (partType.getSelectedToggle() != null) {


                RadioButton selectedPartType = (RadioButton) partType.getSelectedToggle();
                String partType = selectedPartType.getText();

                if (partType.equals("In-House")) {
                    machineNumberOrCompanyName.setText("Machine ID");
                }

                if (partType.equals("Outsourced")) {
                    machineNumberOrCompanyName.setText("Company Name");
                }

            }
        });


        Part part = Inventory.lookupPart(view_controller.MainScreenController.partToModifyIndex());


        id.setText(Integer.toString(part.getID()));
        name.setText(part.getName());
        inv.setText(Integer.toString(part.getStock()));
        price.setText(Double.toString(part.getPrice()));
        max.setText(Integer.toString(part.getMax()));
        min.setText(Integer.toString(part.getMin()));


        if (part instanceof InHousePart) {


            machineNumberOrCompanyName.setText("Machine ID");
            InHousePart partInHouse = (InHousePart) part;
            idOrName.setText(Integer.toString(partInHouse.getMachineID()));
            inHouseRadioButton.setSelected(true);


        } else {


            machineNumberOrCompanyName.setText("Company Name");
            OutsourcedPart partOutsourced = (OutsourcedPart) part;
            idOrName.setText(partOutsourced.getCompanyName());
            outsourcedRadioButton.setSelected(true);


        }


    }


}
