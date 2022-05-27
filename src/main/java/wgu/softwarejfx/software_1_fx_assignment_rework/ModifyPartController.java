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

    private final int partIndex;
    private final String partName;

    public ModifyPartController(int partIndex, String partName){
        this.partIndex = partIndex;
        this.partName = partName;
    }


    /**
     *
     * @param partId
     * This method lookup part by taking a part's ID and returning the part
     * @return
     * This method will return the requested part
     */
    public InHouse lookupInHousePart(int partId) {
        return inHouseParts.get(partId);
    }

    /**
     *
     * @param partName
     * This method lookup part by taking a part's name and returning the part
     * @return
     * This method will return the requested part
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
     * This method lookup part by taking a part's ID and returning the part
     * @return
     * This method will return the requested part
     */
    public Outsourced lookupOutsourcedPart(int partId) {
        return outsourcedParts.get(partId);
    }

    /**
     *
     * @param partName
     * This method lookup part by taking a part's name and returning the part
     * @return
     * This method will return the requested part
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
     * This method will take a known part index and use it in-conjunction with the remaining existing part data
     * @param selectedPart
     * This method will take existing part data and update it based on user input
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
     * This method will take a known part index and use it in-conjunction with the remaining existing part data
     * @param selectedPart
     * This method will take existing part data and update it based on user input
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
     * This method is responsible for the setting up of Modify Part Menu in the event a part is NOT selected for modification.
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
     * This method is responsible for the setting up of Modify Part Menu in the event the all parts collections is not null and a part is selected for modification.
     */
    protected void modifiedPartTextFieldSetup(){
        if (!getAllParts().isEmpty()) {
            int selectedPart = partIndex;
                if (!lookupInHousePart(partName).isEmpty()) {
                    modifiedInHousePartButton.setSelected(true);
                    modifiedOutsourcedPartButton.setSelected(false);
                    modifiedPartId.setPromptText(String.valueOf(lookupInHousePart(partName).get(0).getId()));
                    modifiedPartId.setDisable(true);
                    modifiedPartId.setEditable(false);
                    modifiedPartName.setText(lookupInHousePart(partName).get(0).getName());
                    modifiedPartPrice.setText(String.valueOf(lookupInHousePart(partName).get(0).getPrice()));
                    modifiedPartStock.setText(String.valueOf(lookupInHousePart(partName).get(0).getStock()));
                    modifiedPartMin.setText(String.valueOf(lookupInHousePart(partName).get(0).getMin()));
                    modifiedPartMax.setText(String.valueOf(lookupInHousePart(partName).get(0).getMax()));
                    modifiedPartMachineInfoTextField.setText(String.valueOf(lookupInHousePart(partName).get(0).getMachineId()));
                } else if (!lookupOutsourcedPart(partName).isEmpty()) {
                    modifiedPartMachineInfoLabel.setText("Company Name");
                    modifiedInHousePartButton.setSelected(false);
                    modifiedOutsourcedPartButton.setSelected(true);
                    modifiedPartId.setPromptText(String.valueOf(lookupOutsourcedPart(partName).get(0).getId()));
                    modifiedPartId.setDisable(true);
                    modifiedPartId.setEditable(false);
                    modifiedPartName.setText(lookupOutsourcedPart(partName).get(0).getName());
                    modifiedPartPrice.setText(String.valueOf(lookupOutsourcedPart(partName).get(0).getPrice()));
                    modifiedPartStock.setText(String.valueOf(lookupOutsourcedPart(partName).get(0).getStock()));
                    modifiedPartMin.setText(String.valueOf(lookupOutsourcedPart(partName).get(0).getMin()));
                    modifiedPartMax.setText(String.valueOf(lookupOutsourcedPart(partName).get(0).getMax()));
                    modifiedPartMachineInfoTextField.setText(String.valueOf(lookupOutsourcedPart(partName).get(0).getCompanyName()));
                } else {
                    GridPane conformation = new GridPane();
                    Text conformationInfo = new Text("Part not selected");
                    conformationInfo.setFont(new Font(20));
                    conformation.getChildren().add(conformationInfo);
                    GridPane.setConstraints(conformationInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));
                    Stage popUp = new Stage();
                    Scene conformationScene = new Scene(conformation);
                    popUp.setTitle("Error");
                    popUp.setScene(conformationScene);
                    popUp.sizeToScene();
                    popUp.show();
                }
        }
        else {
            partFieldPrep();
        }
    }


    /**
     *
     * @param event
     * This method is repsonsible for saving the modified part after the fields and the data within the fields have been checked for invalidation.
     * @throws IOException
     */
    @FXML
    protected void onSaveModifiedPartButtonClick(MouseEvent event) throws IOException {
        try {
            if (modifiedInHousePartButton.isSelected()) {
                if (modifiedPartName.getText().isEmpty() || modifiedPartPrice.getText().isEmpty()
                        || modifiedPartStock.getText().isEmpty() || modifiedPartMax.getText().isEmpty()
                        || modifiedPartMin.getText().isEmpty() || modifiedPartMachineInfoTextField.getText().isEmpty()) {

                    GridPane conformation = new GridPane();
                    Text conformationInfo = new Text("One or More Part Field(s) left Empty");
                    conformationInfo.setFont(new Font(20));
                    conformation.getChildren().add(conformationInfo);
                    GridPane.setConstraints(conformationInfo, 0, 0, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(25));
                    Stage popUp = new Stage();
                    Scene conformationScene = new Scene(conformation);
                    popUp.setTitle("Error");
                    popUp.setScene(conformationScene);
                    popUp.sizeToScene();
                    popUp.show();
                }
                if (Integer.parseInt(modifiedPartMin.getText()) > Integer.parseInt(modifiedPartMax.getText())) {
                    GridPane error = new GridPane();
                    Text errorInfo = new Text("Min & Max Error: Max should be greater then Min");
                    errorInfo.setFont(new Font(20));
                    error.getChildren().add(errorInfo);
                    GridPane.setConstraints(errorInfo, 0, 0, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(25));
                    Stage popUp = new Stage();
                    Scene errorScene = new Scene(error);
                    popUp.setTitle("Error");
                    popUp.setScene(errorScene);
                    popUp.sizeToScene();
                    popUp.show();
                } else if (Integer.parseInt(modifiedPartStock.getText()) > Integer.parseInt(modifiedPartMax.getText()) || Integer.parseInt(modifiedPartStock.getText()) < Integer.parseInt(modifiedPartMin.getText())) {
                    GridPane error = new GridPane();
                    Text errorInfo = new Text("Stock Error: Stock must be between Min & Max");
                    errorInfo.setFont(new Font(20));
                    error.getChildren().add(errorInfo);
                    GridPane.setConstraints(errorInfo, 0, 0, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(25));
                    Stage popUp = new Stage();
                    Scene errorScene = new Scene(error);
                    popUp.setTitle("Error");
                    popUp.setScene(errorScene);
                    popUp.sizeToScene();
                    popUp.show();

                } else if (!modifiedPartName.getText().isEmpty() && Double.parseDouble(modifiedPartPrice.getText()) != 0 && Integer.parseInt(modifiedPartMax.getText()) != 0) {
                    saveModifiedInHousePart();
                    saveModifiedPart(event);

                    GridPane conformation = new GridPane();
                    Text conformationInfo = new Text("Part Successfully Modified");
                    conformationInfo.setFont(new Font(20));
                    conformation.getChildren().add(conformationInfo);
                    GridPane.setConstraints(conformationInfo, 0, 0, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(25));
                    Stage popUp = new Stage();
                    Scene conformationScene = new Scene(conformation);
                    popUp.setTitle("Conformation");
                    popUp.setScene(conformationScene);
                    popUp.sizeToScene();
                    popUp.show();
                }
            } else if (modifiedOutsourcedPartButton.isSelected()) {
                saveModifiedOutsourcedPart();
                saveModifiedPart(event);

                GridPane conformation = new GridPane();
                Text conformationInfo = new Text("Part Successfully Modified");
                conformationInfo.setFont(new Font(20));
                conformation.getChildren().add(conformationInfo);
                GridPane.setConstraints(conformationInfo, 0, 0, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(25));
                Stage popUp = new Stage();
                Scene conformationScene = new Scene(conformation);
                popUp.setTitle("Conformation");
                popUp.setScene(conformationScene);
                popUp.sizeToScene();
                popUp.show();
            }
        }catch(NumberFormatException e){
            GridPane conformation = new GridPane();
            Text conformationInfo = new Text("One or More Part Field(s) has a non-numerical value and must be changed to a numerical one");
            conformationInfo.setFont(new Font(20));
            conformation.getChildren().add(conformationInfo);
            GridPane.setConstraints(conformationInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));

            Stage popUp = new Stage();
            Scene conformationScene = new Scene(conformation);
            popUp.setTitle("Error");
            popUp.setScene(conformationScene);
            popUp.sizeToScene();
            popUp.show();
        }
    }

    /**
     * This method is responsible for taking the data from the textfields and updating the outsourced part.
     */
    protected void saveModifiedInHousePart(){
        try {
            InHouse modifiedInHousePart = new InHouse(0, "name", 0, 0, 0, 0, 0);
            modifiedInHousePart.setName(modifiedPartName.getText());
            modifiedInHousePart.setPrice(Double.parseDouble(modifiedPartPrice.getText()));
            modifiedInHousePart.setStock(Integer.parseInt(modifiedPartStock.getText()));
            modifiedInHousePart.setMax(Integer.parseInt(modifiedPartMax.getText()));
            modifiedInHousePart.setMin(Integer.parseInt(modifiedPartMin.getText()));
            modifiedInHousePart.setMachineId(Integer.parseInt(modifiedPartMachineInfoTextField.getText()));

            updateInHousePart(inHouseTest(lookupInHousePart(partName)),modifiedInHousePart);

            updatePart(partIndex, modifiedInHousePart);
        }catch (Exception e){
            System.out.println("shit prequel");
        }
    }

    int inHouseTest(ObservableList<InHouse> observableList){
        int inHoT = 0;
        for (InHouse theTaeto : observableList){
            inHoT = inHouseParts.indexOf(theTaeto);
        }
        return inHoT;
    }

    int outsourcedTest(ObservableList<Outsourced> observableList){
        int outS = 0;
        for (Outsourced theTahto : observableList){
            outS = outsourcedParts.indexOf(theTahto);
        }
        return outS;
    }


    /**
     * This method is responsible for taking the data from the textfields and updating the outsourced part.
     */
    protected void saveModifiedOutsourcedPart(){
        try {
            Outsourced modifiedOutsourcedPart = new Outsourced(0, "name", 0, 0, 0, 0, "company");
            modifiedOutsourcedPart.setName(modifiedPartName.getText());
            modifiedOutsourcedPart.setPrice(Double.parseDouble(modifiedPartPrice.getText()));
            modifiedOutsourcedPart.setStock(Integer.parseInt(modifiedPartStock.getText()));
            modifiedOutsourcedPart.setMax(Integer.parseInt(modifiedPartMax.getText()));
            modifiedOutsourcedPart.setMin(Integer.parseInt(modifiedPartMin.getText()));
            modifiedOutsourcedPart.setCompanyName(modifiedPartMachineInfoTextField.getText());

            updateOutsourcedPart(outsourcedTest(lookupOutsourcedPart(partName)),modifiedOutsourcedPart);

            updatePart(partIndex, modifiedOutsourcedPart);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("shit the sequel");
        }

    }

    /**
     *
     * @param event
     * This method is responsible for the changing the scene from the Modify Part Menu back to the Main Menu after adding a modified part.
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
     * This redundant method is responsible for the changing the scene from the Modify Part Menu back to the Main Menu after canceling a modified part.
     * @throws IOException
     */
    @FXML
    protected void onCancelModifiedPartButtonClick(MouseEvent event) throws IOException {
        cancelModifiedPart(event);
    }

    /**
     *
     * @param event
     * This method is responsible for the changing the scene from the Modify Part Menu back to the Main Menu after canceling a modified part.
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
     *This method is responsible for setting up the Radio Button and Part Origin Label on the Modify Part Menu for an inHouse Part.
     */
    @FXML
    protected void onModifiedInHouseRadioPart() {
        modifiedPartMachineInfoLabel.setText("Machine ID");
        modifiedOutsourcedPartButton.setSelected(false);
    }

    /**
     * This method is responsible for setting up the Radio Button and Part Origin Label on the Modify Part Menu for an outsourced Part.
     */
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
