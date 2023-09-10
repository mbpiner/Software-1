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
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.stage.Stage;


//FXML Controller class

public class AddPartController implements Initializable {


    @FXML
    private TextField id;
    @FXML
    private TextField name;
    @FXML
    private TextField inv;
    @FXML
    private TextField price;
    @FXML
    private TextField min;
    @FXML
    private TextField max;
    @FXML
    private TextField idOrName;

    @FXML
    private Button saveButton;

    @FXML
    private RadioButton inHouseRadioButton;
    @FXML
    private RadioButton outsourcedRadioButton;

    @FXML
    private Label machineNumberOrCompanyName;

    @FXML
    private ToggleGroup partType;


    private ObservableList<InHousePart> tempInHousePart = FXCollections.observableArrayList();
    private ObservableList<OutsourcedPart> tempOutsourcedPart = FXCollections.observableArrayList();


    private String inHouseOrOutsourced = "outsourced";


    private @FXML Node root;


    @FXML
    public javafx.scene.control.Button exitButton;


    @FXML
    private void exitButtonPushed() {
        // get a handle to the stage
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }


    @FXML
    public void savePartButtonPushed(ActionEvent actionEvent) {


        if (inHouseRadioButton.isSelected()) {


            if (inv.getText().isEmpty() || price.getText().isEmpty() || name.getText().isEmpty()) {
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


            if (partMax <= partMin) {

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


        if (outsourcedRadioButton.isSelected()) {


            if (inv.getText().isEmpty() || price.getText().isEmpty() || name.getText().isEmpty()) {
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


            if (partMax <= partMin) {

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


        }


    }


    /**
     * Initializes the controller class.
     */
    @FXML
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
                    System.out.println(partType);
                    System.out.println("0\n");
                    inHouseOrOutsourced = "inhouse\n";
                    System.out.println(inHouseOrOutsourced);

                }

                if (partType.equals("Outsourced")) {
                    machineNumberOrCompanyName.setText("Company Name");
                    System.out.println(partType);
                    System.out.println("1\n");
                    inHouseOrOutsourced = "outsourced\n";
                    System.out.println(inHouseOrOutsourced);


                }

            }
        });


    }


}



