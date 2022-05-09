package wgu.softwarejfx.software_1_fx_assignment_rework;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static wgu.softwarejfx.software_1_fx_assignment_rework.Inventory.addPart;
import static wgu.softwarejfx.software_1_fx_assignment_rework.Inventory.getAllParts;
import static wgu.softwarejfx.software_1_fx_assignment_rework.MainMenuController.allPartsTable;

public class AddPartController {

    @FXML
    private static Button saveNewPartButton;
    @FXML
    private static Button cancelNewPartButton;
    @FXML
    private static ToggleGroup newPartType;
    @FXML
    private static RadioButton newInHousePartButton;
    @FXML
    private static RadioButton newOutsourcedPartButton;
    @FXML
    private static Label newPartMachineInfoLabel;
    @FXML
    private static Popup conformationMessage;
    @FXML
    private static Popup errorMessage;
    @FXML
    private static TextField newPartId;
    @FXML
    private static TextField newPartName;
    @FXML
    private static TextField newPartStock;
    @FXML
    private static TextField newPartPrice;
    @FXML
    private static TextField newPartMax;
    @FXML
    private static TextField newPartMin;
    @FXML
    private static TextField newPartMachineInfoTextField;
    public static ObservableList<InHouse> inHouseParts = FXCollections.observableArrayList();
    public static ObservableList<Outsourced> outsourcedParts = FXCollections.observableArrayList();
    public static InHouse newInHousePart;
    public static Outsourced newOutsourcedPart;

    public static void newPartTextFieldSetup(){
        newPartId = new TextField();
        newPartName = new TextField();
        newPartPrice = new TextField();
        newPartStock = new TextField();
        newPartMin = new TextField();
        newPartMax = new TextField();
        newPartMachineInfoTextField = new TextField();
        newPartId.setPromptText("Auto Generated");
        newPartId.setDisable(true);
        newPartId.setEditable(false);
        newPartName.clear();
        newPartPrice.clear();
        newPartStock.clear();
        newPartMin.clear();
        newPartMax.clear();
        newPartMachineInfoTextField.clear();
    }




    @FXML
    public void onSaveNewPartButtonClick(){

//        if (){
//
//        }
//        else if (){
//
//        }
    }

    protected static void saveNewInHousePart(){
        newInHousePart = new InHouse(0,"name",0,0,0,0,0);
        newInHousePart.setName(newPartName.getText());
        newInHousePart.setPrice(Double.parseDouble(newPartPrice.getText()));
        newInHousePart.setStock(Integer.parseInt(newPartStock.getText()));
        newInHousePart.setMax(Integer.parseInt(newPartMax.getText()));
        newInHousePart.setMin(Integer.parseInt(newPartMin.getText()));
        newInHousePart.setMachineId(Integer.parseInt(newPartMachineInfoTextField.getText()));
        addPart(newInHousePart);
        allPartsTable.setItems(getAllParts());
    }

    protected static void saveNewOutsourcedPart(){
        newOutsourcedPart = new Outsourced(0,"name",0,0,0,0,"company");
        newOutsourcedPart.setName(newPartName.getText());
        newOutsourcedPart.setPrice(Double.parseDouble(newPartPrice.getText()));
        newOutsourcedPart.setStock(Integer.parseInt(newPartStock.getText()));
        newOutsourcedPart.setMax(Integer.parseInt(newPartMax.getText()));
        newOutsourcedPart.setMin(Integer.parseInt(newPartMin.getText()));
        newOutsourcedPart.setCompanyName(newPartMachineInfoTextField.getText());
        addPart(newOutsourcedPart);
        allPartsTable.setItems(getAllParts());
    }



    @FXML
    public void onCancelNewPartButtonClick(MouseEvent event) throws IOException {
        cancelNewPart(event);
    }

    //add, cancel & save buttons
    protected static void cancelNewPart(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(MainMenuController.class.getResource("MainMenu.fxml")));
        Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML //radio button actions new part menu
    protected  static void radioToggleNewPartMenu(){
        newPartType.selectedToggleProperty().addListener((observableValue, toggle, newToggle) -> {
            if (newToggle == newInHousePart){
                newPartMachineInfoLabel.setText("Machine ID");
            }
            else if (newToggle == newOutsourcedPart){
                newPartMachineInfoLabel.setText("Company Name");
            }
            else {
                newPartMachineInfoLabel.setText("Machine ID");
            }
        });
    }
}
