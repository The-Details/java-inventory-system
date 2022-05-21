package wgu.softwarejfx.software_1_fx_assignment_rework;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static javafx.geometry.HPos.CENTER;
import static wgu.softwarejfx.software_1_fx_assignment_rework.AddPartController.inHouseParts;
import static wgu.softwarejfx.software_1_fx_assignment_rework.AddPartController.outsourcedParts;
import static wgu.softwarejfx.software_1_fx_assignment_rework.Inventory.*;


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

    /**
     *
     * @param partId
     * @return
     */
    public InHouse lookupInHousePart(int partId) {
        return inHouseParts.get(partId);
    }

    /**
     *
     * @param partName
     * @return
     */
    public ObservableList<InHouse> lookupInHousePart(String partName){
        ObservableList<InHouse> searchablePart = FXCollections.observableArrayList();
        for (InHouse partIterator : inHouseParts){
            if (partIterator.getName().equals(partName)) {
                searchablePart.add(partIterator);
            }
        }
        return searchablePart;
    }

    /**
     *
     * @param partId
     * @return
     */
    public Outsourced lookupOutsourcedPart(int partId) {
        return outsourcedParts.get(partId);
    }

    /**
     *
     * @param partName
     * @return
     */
    public ObservableList<Outsourced> lookupOutsourcedPart(String partName){
        ObservableList<Outsourced> searchablePart = FXCollections.observableArrayList();
        for (Outsourced partIterator : outsourcedParts){
            if (partIterator.getName().equals(partName)) {
                searchablePart.add(partIterator);
            }
        }
        return searchablePart;
    }

    /**
     *
     * @param index
     * @param selectedPart
     */
    public void updateInHousePart(int index, InHouse selectedPart){
        String name = selectedPart.getName();
        int stock = selectedPart.getStock();
        double price = selectedPart.getPrice();
        int min = selectedPart.getMin();
        int max = selectedPart.getMax();
        int machineId = selectedPart.getMachineId();

        if (inHouseParts.get(index) != null){
            inHouseParts.get(index).setName(name);
            inHouseParts.get(index).setPrice(price);
            inHouseParts.get(index).setStock(stock);
            inHouseParts.get(index).setMin(min);
            inHouseParts.get(index).setMax(max);
            inHouseParts.get(index).setMachineId(machineId);
        }
    }

    /**
     *
     * @param index
     * @param selectedPart
     */
    public void updateOutsourcedPart(int index, Outsourced selectedPart){
        String name = selectedPart.getName();
        int stock = selectedPart.getStock();
        double price = selectedPart.getPrice();
        int min = selectedPart.getMin();
        int max = selectedPart.getMax();
        String companyName = selectedPart.getCompanyName();

        if (outsourcedParts.get(index) != null){
            outsourcedParts.get(index).setName(name);
            outsourcedParts.get(index).setPrice(price);
            outsourcedParts.get(index).setStock(stock);
            outsourcedParts.get(index).setMin(min);
            outsourcedParts.get(index).setMax(max);
            outsourcedParts.get(index).setCompanyName(companyName);
        }
    }

    /**
     *
     */
    public void partFieldPrep(){
        modifiedInHousePartButton.setSelected(false);
        modifiedOutsourcedPartButton.setSelected(false);
        modifiedPartId.setPromptText("");
        modifiedPartId.setDisable(true);
        modifiedPartId.setEditable(false);
        modifiedPartName.setText("");
        modifiedPartPrice.setText("");
        modifiedPartStock.setText("");
        modifiedPartMin.setText("");
        modifiedPartMax.setText("");
        modifiedPartMachineInfoTextField.setText("");

    }

    /**
     *
     */

    protected void modifiedPartTextFieldSetup(Part selected){
        MainMenuController x = new MainMenuController();
            int selectedPart = getAllParts().indexOf(selected);
            System.out.println(selectedPart + " " + "TESTy");
        if (getAllParts() != null ) {
                String selectedPartName = lookupPart(selectedPart).getName();
                if (!lookupInHousePart(selectedPartName).isEmpty()) {
                    modifiedInHousePartButton.setSelected(true);
                    modifiedOutsourcedPartButton.setSelected(false);
                    modifiedPartId.setPromptText(String.valueOf(lookupInHousePart(selectedPart).getId()));
                    modifiedPartId.setDisable(true);
                    modifiedPartId.setEditable(false);
                    modifiedPartName.setText(lookupInHousePart(selectedPart).getName());
                    modifiedPartPrice.setText(String.valueOf(lookupInHousePart(selectedPart).getPrice()));
                    modifiedPartStock.setText(String.valueOf(lookupInHousePart(selectedPart).getStock()));
                    modifiedPartMin.setText(String.valueOf(lookupInHousePart(selectedPart).getMin()));
                    modifiedPartMax.setText(String.valueOf(lookupInHousePart(selectedPart).getMax()));
                    modifiedPartMachineInfoTextField.setText(String.valueOf(lookupInHousePart(selectedPart).getMachineId()));
                    System.out.println(inHouseParts.indexOf(lookupInHousePart(selectedPart)) + " " + lookupInHousePart(selectedPart).getId() + " " + lookupInHousePart(selectedPart).getName());
                } else if (!lookupOutsourcedPart(selectedPartName).isEmpty()) {
                    modifiedPartMachineInfoLabel.setText("Company Name");
                    modifiedInHousePartButton.setSelected(false);
                    modifiedOutsourcedPartButton.setSelected(true);
                    modifiedPartId.setPromptText(String.valueOf(lookupOutsourcedPart(selectedPart).getId()));
                    modifiedPartId.setDisable(true);
                    modifiedPartId.setEditable(false);
                    modifiedPartName.setText(lookupOutsourcedPart(selectedPart).getName());
                    modifiedPartPrice.setText(String.valueOf(lookupOutsourcedPart(selectedPart).getPrice()));
                    modifiedPartStock.setText(String.valueOf(lookupOutsourcedPart(selectedPart).getStock()));
                    modifiedPartMin.setText(String.valueOf(lookupOutsourcedPart(selectedPart).getMin()));
                    modifiedPartMax.setText(String.valueOf(lookupOutsourcedPart(selectedPart).getMax()));
                    modifiedPartMachineInfoTextField.setText(String.valueOf(lookupOutsourcedPart(selectedPart).getCompanyName()));
                } else {
                    //Part not selected, prevent continuation
                    System.out.println("Part not selected");
                }
        }
        else {
            partFieldPrep();
        }
    }


    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    protected void onSaveModifiedPartButtonClick(MouseEvent event) throws IOException {
        if (modifiedInHousePartButton.isSelected()){
            if(modifiedPartName.getText().isEmpty() || modifiedPartPrice.getText().isEmpty()
                    || modifiedPartStock.getText().isEmpty() || modifiedPartMax.getText().isEmpty()
                    || modifiedPartMin.getText().isEmpty() || modifiedPartMachineInfoTextField.getText().isEmpty()){

                GridPane conformation = new GridPane();
                Text conformationInfo = new Text("Part Successfully Removed");
                conformationInfo.setFont(new Font(20));
                conformation.getChildren().add(conformationInfo);
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
                error.getChildren().add(errorInfo);
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
                error.getChildren().add(errorInfo);
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

    /**
     *
     */
    protected void saveModifiedInHousePart(){
        MainMenuController x = new MainMenuController();
        int selectedPart = getAllParts().indexOf(x.allPartsTable.getSelectionModel().getSelectedItem());
        try {
            InHouse modifiedInHousePart = new InHouse(0, "name", 0, 0, 0, 0, 0);
            modifiedInHousePart.setName(modifiedPartName.getText());
            modifiedInHousePart.setPrice(Double.parseDouble(modifiedPartPrice.getText()));
            modifiedInHousePart.setStock(Integer.parseInt(modifiedPartStock.getText()));
            modifiedInHousePart.setMax(Integer.parseInt(modifiedPartMax.getText()));
            modifiedInHousePart.setMin(Integer.parseInt(modifiedPartMin.getText()));
            modifiedInHousePart.setMachineId(Integer.parseInt(modifiedPartMachineInfoTextField.getText()));
        updatePart(selectedPart, modifiedInHousePart);
        }catch (Exception e){
            System.out.println("shit ");
        }
    }

    /**
     *
     */
    protected void saveModifiedOutsourcedPart(){
        MainMenuController x = new MainMenuController();
        int selectedPart = getAllParts().indexOf(x.allPartsTable.getSelectionModel().getSelectedItem());
        try {
            Outsourced modifiedOutsourcedPart = new Outsourced(0, "name", 0, 0, 0, 0, "company");
            modifiedOutsourcedPart.setName(modifiedPartName.getText());
            modifiedOutsourcedPart.setPrice(Double.parseDouble(modifiedPartPrice.getText()));
            modifiedOutsourcedPart.setStock(Integer.parseInt(modifiedPartStock.getText()));
            modifiedOutsourcedPart.setMax(Integer.parseInt(modifiedPartMax.getText()));
            modifiedOutsourcedPart.setMin(Integer.parseInt(modifiedPartMin.getText()));
            modifiedOutsourcedPart.setCompanyName(modifiedPartMachineInfoTextField.getText());
        updatePart(selectedPart, modifiedOutsourcedPart);
        }catch (Exception e){
            System.out.println("shit the sequel");
        }

    }

    /**
     *
     * @param event
     * @throws IOException
     */
    protected void saveModifiedPart(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(MainMenuController.class.getResource("MainMenu.fxml")));
        Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    protected void onCancelModifiedPartButtonClick(MouseEvent event) throws IOException {
        cancelModifiedPart(event);
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    protected void cancelModifiedPart(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(MainMenuController.class.getResource("MainMenu.fxml")));
        Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     *
     */
    @FXML
    protected void onModifiedInHouseRadioPart() {
        modifiedPartMachineInfoLabel.setText("Machine ID");
        modifiedOutsourcedPartButton.setSelected(false);
    }

    /**
     *
     */
    @FXML
    protected void onModifiedOutsourcedRadioPart() {
        modifiedPartMachineInfoLabel.setText("Company Name");
        modifiedInHousePartButton.setSelected(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        MainMenuController xx = new MainMenuController();
        xx.allPartsTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Part>() {
            @Override
            public void changed(ObservableValue<? extends Part> observableValue, Part part, Part t1) {
                modifiedPartTextFieldSetup(t1);
            }
        });

    }
}
