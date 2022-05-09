package wgu.softwarejfx.software_1_fx_assignment_rework;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Popup;

import static wgu.softwarejfx.software_1_fx_assignment_rework.MainMenuController.allPartsTable;

public class ModifyPartController {

    @FXML
    private static Button saveModifiedPartButton;
    @FXML
    private static Button cancelModifiedPartButton;
    @FXML
    private static ToggleGroup modifiedPartType;
    @FXML
    private static RadioButton modifiedInHousePart;
    @FXML
    private static RadioButton modifiedOutsourcedPart;
    @FXML
    private static Label modifiedPartMachineInfo;
    @FXML
    private static Popup conformationMessage;
    @FXML
    private static Popup errorMessage;
    @FXML
    private static TextField modifiedPartId;
    @FXML
    private static TextField modifiedPartName;
    @FXML
    private static TextField modifiedPartStock;
    @FXML
    private static TextField modifiedPartPrice;
    @FXML
    private static TextField modifiedPartMax;
    @FXML
    private static TextField modifiedPartMin;
    @FXML
    private static TextField modifiedPartMachineInfoTextField;

    public static void modifiedPartTextFieldSetup(){
        modifiedPartId = new TextField();
        modifiedPartName = new TextField();
        modifiedPartPrice = new TextField();
        modifiedPartStock = new TextField();
        modifiedPartMin = new TextField();
        modifiedPartMax = new TextField();
        modifiedPartMachineInfoTextField = new TextField();

        modifiedPartId.setPromptText(String.valueOf(allPartsTable.getSelectionModel().selectedItemProperty().get().getId()));
        modifiedPartId.setDisable(true);
        modifiedPartId.setEditable(false);
        modifiedPartName.setText(allPartsTable.getSelectionModel().selectedItemProperty().get().getName());
        modifiedPartPrice.setText(String.valueOf(allPartsTable.getSelectionModel().selectedItemProperty().get().getPrice()));
        modifiedPartStock.setText(String.valueOf(allPartsTable.getSelectionModel().selectedItemProperty().get().getStock()));
        modifiedPartMin.setText(String.valueOf(allPartsTable.getSelectionModel().selectedItemProperty().get().getMin()));
        modifiedPartMax.setText(String.valueOf(allPartsTable.getSelectionModel().selectedItemProperty().get().getMax()));
        modifiedPartMachineInfoTextField.clear();
    }




    @FXML //radio button actions modified part menu
    protected  static void radioToggleModifiedPartMenu(){
        modifiedPartType.selectedToggleProperty().addListener((observableValue, toggle, newToggle) -> {
            if (newToggle == modifiedInHousePart){
                modifiedPartMachineInfo.setText("Machine ID");
            }
            else if (newToggle == modifiedOutsourcedPart){
                modifiedPartMachineInfo.setText("Company Name");
            }
            else {
                modifiedPartMachineInfo.setText("Machine ID");
            }
        });
    }
}
