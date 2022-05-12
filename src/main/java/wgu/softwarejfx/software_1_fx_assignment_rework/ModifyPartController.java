package wgu.softwarejfx.software_1_fx_assignment_rework;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static javafx.geometry.HPos.CENTER;
import static wgu.softwarejfx.software_1_fx_assignment_rework.AddPartController.inHouseParts;
import static wgu.softwarejfx.software_1_fx_assignment_rework.AddPartController.outsourcedParts;
import static wgu.softwarejfx.software_1_fx_assignment_rework.Inventory.*;
import static wgu.softwarejfx.software_1_fx_assignment_rework.MainMenuController.allPartsTable;
import static wgu.softwarejfx.software_1_fx_assignment_rework.MainMenuController.selectedPart;

public class ModifyPartController implements Initializable {

    @FXML
    private Button saveModifiedPartButton;
    @FXML
    private Button cancelModifiedPartButton;
    @FXML
    private RadioButton modifiedInHousePartButton;
    @FXML
    private RadioButton modifiedOutsourcedPartButton;
    @FXML
    private Label modifiedPartMachineInfoLabel;
    @FXML
    private Popup conformationMessage;
    @FXML
    private Popup errorMessage;
    @FXML
    private TextField modifiedPartId;
    @FXML
    private TextField modifiedPartName;
    @FXML
    private TextField modifiedPartStock;
    @FXML
    private TextField modifiedPartPrice;
    @FXML
    private TextField modifiedPartMax;
    @FXML
    private TextField modifiedPartMin;
    @FXML
    private TextField modifiedPartMachineInfoTextField;
    private InHouse modifiedInHousePart;
    private Outsourced modifiedOutsourcedPart;


    public static InHouse lookupInHousePart(int partId) {
        return inHouseParts.get(partId);
    }

    public static ObservableList<InHouse> lookupInHousePart(String partName){
        ObservableList<InHouse> searchablePart = FXCollections.observableArrayList();
        for (InHouse partIterator : inHouseParts){
            if (partIterator.getName().equals(partName)) {
                searchablePart.add(partIterator);
            }
        }
        return searchablePart;
    }

    public static Outsourced lookupOutsourcedPart(int partId) {
        return outsourcedParts.get(partId);
    }

    public static ObservableList<Outsourced> lookupOutsourcedPart(String partName){
        ObservableList<Outsourced> searchablePart = FXCollections.observableArrayList();
        for (Outsourced partIterator : outsourcedParts){
            if (partIterator.getName().equals(partName)) {
                searchablePart.add(partIterator);
            }
        }
        return searchablePart;
    }

    protected void modifiedPartTextFieldSetup(){
        String selectedPartName = lookupPart(selectedPart()).getName();
        if (!lookupInHousePart(selectedPartName).isEmpty()){
            modifiedPartId.setPromptText(String.valueOf(lookupInHousePart(lookupInHousePart(selectedPart()).getId())));
            modifiedPartId.setDisable(true);
            modifiedPartId.setEditable(false);
            modifiedPartName.setText(lookupInHousePart(selectedPart()).getName());
            modifiedPartPrice.setText(String.valueOf(lookupInHousePart(selectedPart()).getPrice()));
            modifiedPartStock.setText(String.valueOf(lookupInHousePart(selectedPart()).getStock()));
            modifiedPartMin.setText(String.valueOf(lookupInHousePart(selectedPart()).getMin()));
            modifiedPartMax.setText(String.valueOf(lookupInHousePart(selectedPart()).getMax()));
            modifiedPartMachineInfoTextField.setText(String.valueOf(lookupInHousePart(selectedPart()).getMachineId()));
        }
        else if (!lookupOutsourcedPart(selectedPartName).isEmpty()){
            modifiedPartId.setPromptText(String.valueOf(lookupOutsourcedPart(selectedPart()).getId()));
            modifiedPartId.setDisable(true);
            modifiedPartId.setEditable(false);
            modifiedPartName.setText(lookupOutsourcedPart(selectedPart()).getName());
            modifiedPartPrice.setText(String.valueOf(lookupOutsourcedPart(selectedPart()).getPrice()));
            modifiedPartStock.setText(String.valueOf(lookupOutsourcedPart(selectedPart()).getStock()));
            modifiedPartMin.setText(String.valueOf(lookupOutsourcedPart(selectedPart()).getMin()));
            modifiedPartMax.setText(String.valueOf(lookupOutsourcedPart(selectedPart()).getMax()));
            modifiedPartMachineInfoTextField.setText(String.valueOf(lookupOutsourcedPart(selectedPart()).getCompanyName()));
        }
        else{
            //Part not selected, prevent continuation
            System.out.println("Part not selected");
        }
    }


    @FXML
    protected void onSaveModifiedPartButtonClick(MouseEvent event) throws IOException {
        if (modifiedInHousePartButton.isSelected()){
            if(modifiedPartName.getText().isEmpty() || modifiedPartPrice.getText().isEmpty()
                    || modifiedPartStock.getText().isEmpty() || modifiedPartMax.getText().isEmpty()
                    || modifiedPartMin.getText().isEmpty() || modifiedPartMachineInfoTextField.getText().isEmpty()){

                GridPane conformation = new GridPane();
                Text conformationInfo = new Text("Part Successfully Removed");
                conformationInfo.setFont(new Font(20));
                Button errorInfoCloseButton = new Button("Close");
                conformation.getChildren().add(conformationInfo);
                conformation.getChildren().add(errorInfoCloseButton);
                GridPane.setConstraints(errorInfoCloseButton,0,1,1,1,CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
                GridPane.setConstraints(conformationInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));

                Stage popUp = new Stage();
                Scene conformationScene = new Scene(conformation);
                popUp.setTitle("Conformation");
                popUp.setScene(conformationScene);
                popUp.sizeToScene();
                popUp.show();
            }
            if(Integer.parseInt(modifiedPartMin.getText()) > Integer.parseInt(modifiedPartMax.getText())){
                GridPane error = new GridPane();
                Text errorInfo = new Text("Min & Max Error: Max should be greater then Min");
                errorInfo.setFont(new Font(20));
                Button errorInfoCloseButton = new Button("Close");
                error.getChildren().add(errorInfo);
                error.getChildren().add(errorInfoCloseButton);
                GridPane.setConstraints(errorInfoCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
                GridPane.setConstraints(errorInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));

                Stage popUp = new Stage();
                Scene errorScene = new Scene(error);
                popUp.setTitle("Error");
                popUp.setScene(errorScene);
                popUp.sizeToScene();
                popUp.show();
            }

            else if(Integer.parseInt(modifiedPartStock.getText()) > Integer.parseInt(modifiedPartMax.getText()) || Integer.parseInt(modifiedPartStock.getText()) < Integer.parseInt(modifiedPartMin.getText())){
                GridPane error = new GridPane();
                Text errorInfo = new Text("Stock Error: Stock must be between Min & Max");
                errorInfo.setFont(new Font(20));
                Button errorInfoCloseButton = new Button("Close");
                error.getChildren().add(errorInfo);
                error.getChildren().add(errorInfoCloseButton);
                GridPane.setConstraints(errorInfoCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
                GridPane.setConstraints(errorInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));

                Stage popUp = new Stage();
                Scene errorScene = new Scene(error);
                popUp.setTitle("Error");
                popUp.setScene(errorScene);
                popUp.sizeToScene();
                popUp.show();

            }

            else if(!modifiedPartName.getText().isEmpty() && Double.parseDouble(modifiedPartPrice.getText()) != 0 && Integer.parseInt(modifiedPartMax.getText()) != 0) {
                saveModifiedInHousePart();
                saveModifiedPart(event);
            }
        }
        else if (modifiedOutsourcedPartButton.isSelected()){
            saveModifiedOutsourcedPart();
            saveModifiedPart(event);
        }

    }


    protected void saveModifiedInHousePart(){

        modifiedInHousePart = new InHouse(0,"name",0,0,0,0,0);
        modifiedInHousePart.setName(modifiedPartName.getText());
        modifiedInHousePart.setPrice(Double.parseDouble(modifiedPartPrice.getText()));
        modifiedInHousePart.setStock(Integer.parseInt(modifiedPartStock.getText()));
        modifiedInHousePart.setMax(Integer.parseInt(modifiedPartMax.getText()));
        modifiedInHousePart.setMin(Integer.parseInt(modifiedPartMin.getText()));
        modifiedInHousePart.setMachineId(Integer.parseInt(modifiedPartMachineInfoTextField.getText()));
        updatePart(selectedPart(), modifiedInHousePart);
        allPartsTable.setItems(getAllParts());
    }

    protected void saveModifiedOutsourcedPart(){
        modifiedOutsourcedPart = new Outsourced(0,"name",0,0,0,0,"company");
        modifiedOutsourcedPart.setName(modifiedPartName.getText());
        modifiedOutsourcedPart.setPrice(Double.parseDouble(modifiedPartPrice.getText()));
        modifiedOutsourcedPart.setStock(Integer.parseInt(modifiedPartStock.getText()));
        modifiedOutsourcedPart.setMax(Integer.parseInt(modifiedPartMax.getText()));
        modifiedOutsourcedPart.setMin(Integer.parseInt(modifiedPartMin.getText()));
        modifiedOutsourcedPart.setCompanyName(modifiedPartMachineInfoTextField.getText());
        updatePart(selectedPart(), modifiedOutsourcedPart);
        allPartsTable.setItems(getAllParts());
    }

    protected void saveModifiedPart(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(MainMenuController.class.getResource("MainMenu.fxml")));
        Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onCancelModifiedPartButtonClick(MouseEvent event) throws IOException {
        cancelModifiedPart(event);
    }

    protected void cancelModifiedPart(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(MainMenuController.class.getResource("MainMenu.fxml")));
        Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onModifiedInHouseRadioPart() {
        modifiedPartMachineInfoLabel.setText("Machine ID");
        modifiedOutsourcedPartButton.setSelected(false);
    }
    @FXML
    protected void onModifiedOutsourcedRadioPart() {
        modifiedPartMachineInfoLabel.setText("Company Name");
        modifiedInHousePartButton.setSelected(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        modifiedPartTextFieldSetup();
    }
}
