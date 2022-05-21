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
     *
     */
    protected void newPartTextFieldSetup(){
        newPartId.setPromptText("Auto Generated");
        newPartId.setDisable(true);
        newPartId.setEditable(false);
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    protected void onSaveNewPartButtonClick(MouseEvent event) throws IOException {
        if (newInHousePartButton.isSelected()){
            if(newPartName.getText().isEmpty() || newPartPrice.getText().isEmpty()
                    || newPartStock.getText().isEmpty() || newPartMax.getText().isEmpty()
                    || newPartMin.getText().isEmpty() || newPartMachineInfoTextField.getText().isEmpty()){

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
            if(Integer.parseInt(newPartMin.getText()) > Integer.parseInt(newPartMax.getText())){
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

            else if(Integer.parseInt(newPartStock.getText()) > Integer.parseInt(newPartMax.getText()) || Integer.parseInt(newPartStock.getText()) < Integer.parseInt(newPartMin.getText())){
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
            if(Integer.parseInt(newPartMin.getText()) > Integer.parseInt(newPartMax.getText())){
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

            else if(Integer.parseInt(newPartStock.getText()) > Integer.parseInt(newPartMax.getText()) || Integer.parseInt(newPartStock.getText()) < Integer.parseInt(newPartMin.getText())){
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
            else if(!newPartName.getText().isEmpty() && Double.parseDouble(newPartPrice.getText()) != 0 && Integer.parseInt(newPartMax.getText()) != 0) {
                saveNewOutsourcedPart();
                saveNewPart(event);
            }
        }

    }


    /**
     *
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
     *
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
     * @throws IOException
     */
    @FXML
    protected void onCancelNewPartButtonClick(MouseEvent event) throws IOException {
        cancelNewPart(event);
    }

    /**
     *
     * @param event
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
     *
     */
    @FXML
    protected void onNewInHouseRadioPart() {
        newPartMachineInfoLabel.setText("Machine ID");
        newOutsourcedPartButton.setSelected(false);
    }

    /**
     *
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
