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
import static wgu.softwarejfx.software_1_fx_assignment_rework.Inventory.*;

public class AddPartController implements Initializable {

    @FXML
    private Button saveNewPartButton;
    @FXML
    private Button cancelNewPartButton;
    @FXML
    private RadioButton newInHousePartButton;
    @FXML
    private RadioButton newOutsourcedPartButton;
    @FXML
    private Label newPartMachineInfoLabel;
    @FXML
    private Popup conformationMessage;
    @FXML
    private Popup errorMessage;
    @FXML
    private TextField newPartId;
    @FXML
    private TextField newPartName;
    @FXML
    private TextField newPartStock;
    @FXML
    private TextField newPartPrice;
    @FXML
    private TextField newPartMax;
    @FXML
    private TextField newPartMin;
    @FXML
    private TextField newPartMachineInfoTextField;
    public static ObservableList<InHouse> inHouseParts = FXCollections.observableArrayList();
    public static ObservableList<Outsourced> outsourcedParts = FXCollections.observableArrayList();
    private InHouse newInHousePart;
    private Outsourced newOutsourcedPart;


    /**
     * This method is responsible for preemptively setting up the new part id field.
     */
    protected void newPartTextFieldSetup(){
        newPartId.setPromptText("Auto Generated");
        newPartId.setDisable(true);
        newPartId.setEditable(false);
    }

    /**
     *
     * @param event
     *  This method is responsible for saving new parts to the all parts collection.
     * @throws IOException
     */
    @FXML
    protected void onSaveNewPartButtonClick(MouseEvent event) throws IOException {
        try{
        if (newInHousePartButton.isSelected()){
            if(newPartName.getText().isEmpty() || newPartPrice.getText().isEmpty()
                    || newPartStock.getText().isEmpty() || newPartMax.getText().isEmpty()
                    || newPartMin.getText().isEmpty() || newPartMachineInfoTextField.getText().isEmpty()){

                GridPane conformation = new GridPane();
                Text conformationInfo = new Text("One or More Part Field(s) left Empty");
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
            if(Integer.parseInt(newPartMin.getText()) > Integer.parseInt(newPartMax.getText())){
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

            else if(Integer.parseInt(newPartStock.getText()) > Integer.parseInt(newPartMax.getText()) || Integer.parseInt(newPartStock.getText()) < Integer.parseInt(newPartMin.getText())){
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

            else if(!newPartName.getText().isEmpty() && Double.parseDouble(newPartPrice.getText()) != 0 && Integer.parseInt(newPartMax.getText()) != 0) {
                saveNewInHousePart();
                saveNewPart(event);
            }
        }
        else if (newOutsourcedPartButton.isSelected()){
            if(newPartName.getText().isEmpty() || newPartPrice.getText().isEmpty()
                    || newPartStock.getText().isEmpty() || newPartMax.getText().isEmpty()
                    || newPartMin.getText().isEmpty() || newPartMachineInfoTextField.getText().isEmpty()){

                GridPane conformation = new GridPane();
                Text conformationInfo = new Text("One or More Part Field(s) left Empty");
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
            if(Integer.parseInt(newPartMin.getText()) > Integer.parseInt(newPartMax.getText())){
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

            else if((Integer.parseInt(newPartStock.getText()) >= Integer.parseInt(newPartMax.getText())) || (Integer.parseInt(newPartStock.getText()) <= Integer.parseInt(newPartMin.getText()))){
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
            else if(!newPartName.getText().isEmpty() && Double.parseDouble(newPartPrice.getText()) != 0 && Integer.parseInt(newPartMax.getText()) != 0) {
                saveNewOutsourcedPart();
                saveNewPart(event);
            }
        }
        }
        catch(NumberFormatException e){
            GridPane conformation = new GridPane();
            Text conformationInfo = new Text("One or More Product Field(s) has a non-numerical value and must be changed to a numerical one");
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
     * This method is responsible for taking the data from the textfields and inserting it into an instance of an inHouse Object
     */
    protected void saveNewInHousePart(){
        newInHousePart = new InHouse(0,"name",0,0,0,0,0);
        newInHousePart.setId(getAllParts().size() + 1);
        newInHousePart.setName(newPartName.getText());
        newInHousePart.setPrice(Double.parseDouble(newPartPrice.getText()));
        newInHousePart.setStock(Integer.parseInt(newPartStock.getText()));
        newInHousePart.setMax(Integer.parseInt(newPartMax.getText()));
        newInHousePart.setMin(Integer.parseInt(newPartMin.getText()));
        newInHousePart.setMachineId(Integer.parseInt(newPartMachineInfoTextField.getText()));
        inHouseParts.add(newInHousePart);
        addPart(newInHousePart);
    }


    /**
     * This method is responsible for taking the data from the textfields and inserting it into an instance of an outsourced Object
     */
    protected void saveNewOutsourcedPart(){
            newOutsourcedPart = new Outsourced(0,"name",0,0,0,0,"company");
            newOutsourcedPart.setId(getAllParts().size() + 1);
            newOutsourcedPart.setName(newPartName.getText());
            newOutsourcedPart.setPrice(Double.parseDouble(newPartPrice.getText()));
            newOutsourcedPart.setStock(Integer.parseInt(newPartStock.getText()));
            newOutsourcedPart.setMax(Integer.parseInt(newPartMax.getText()));
            newOutsourcedPart.setMin(Integer.parseInt(newPartMin.getText()));
            newOutsourcedPart.setCompanyName(newPartMachineInfoTextField.getText());
            outsourcedParts.add(newOutsourcedPart);
            addPart(newOutsourcedPart);
    }

    /**
     *
     * @param event
     * This method is responsible for changing the scene from the Add Part Menu back to the Main Menu after adding a new part.
     * @throws IOException
     */
    protected void saveNewPart(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(MainMenuController.class.getResource("MainMenu.fxml")));
        Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    /**
     *
     * @param event
     * This redundant method is responsible for changing the scene from the Add Part Menu back to the Main Menu after canceling a new part.
     * @throws IOException
     */
    @FXML
    protected void onCancelNewPartButtonClick(MouseEvent event) throws IOException {
        cancelNewPart(event);
    }

    /**
     *
     * @param event
     * This method is responsible for changing the scene from the Add Part Menu back to the Main Menu after canceling a new part.
     * @throws IOException
     */
    protected void cancelNewPart(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(MainMenuController.class.getResource("MainMenu.fxml")));
        Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method is responsible for setting up the Radio Button and Part Origin Label on the Add Part Menu for an inHouse Part.
     */
    @FXML
    protected void onNewInHouseRadioPart() {
        newPartMachineInfoLabel.setText("Machine ID");
        newOutsourcedPartButton.setSelected(false);
    }

    /**
     * This method is responsible for setting up the Radio Button and Part Origin Label on the Add Part Menu for an outsourced Part.
     */
    @FXML
    protected void onNewOutsourcedRadioPart() {
        newPartMachineInfoLabel.setText("Company Name");
        newInHousePartButton.setSelected(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        newPartTextFieldSetup();

    }
}
