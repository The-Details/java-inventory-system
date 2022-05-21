package wgu.softwarejfx.software_1_fx_assignment_rework;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
import static wgu.softwarejfx.software_1_fx_assignment_rework.MainMenuController.*;

public class AddProductController implements Initializable {

    @FXML
    private Button saveNewProductButton;
    @FXML
    private Button cancelNewProductButton;
    @FXML
    private Button addNewAssociatedPart;
    @FXML
    private Button removeNewAssociatedPart;
    @FXML
    private TableView<Part> allPartsNewProductMenu;
    @FXML
    private TableView<Part> associatedNewProductMenu;
    @FXML
    private TextField newProductId;
    @FXML
    private TextField newProductName;
    @FXML
    private TextField newProductStock;
    @FXML
    private TextField newProductPrice;
    @FXML
    private TextField newProductMax;
    @FXML
    private TextField newProductMin;
    @FXML
    private TableColumn<Part, Integer> allPartsIdColNewProduct;
    @FXML
    private TableColumn<Part, Integer> allPartsNameColNewProduct;
    @FXML
    private TableColumn<Part, Integer> allPartsStockColNewProduct;
    @FXML
    private TableColumn<Part, Integer> allPartsPriceColNewProduct;
    @FXML
    private TableColumn<Part, Integer> allPartsIdColNewAssociatedPart;
    @FXML
    private TableColumn<Part, Integer> allPartsNameColNewAssociatedPart;
    @FXML
    private TableColumn<Part, Integer> allPartsStockColNewAssociatedPart;
    @FXML
    private TableColumn<Part, Integer> allPartsPriceColNewAssociatedPart;
    private Product newProduct;


    /**
     *
     */
    protected void allPartsNewProductMenuSetup(){
        allPartsNewProductMenu.setItems(getAllParts());
        allPartsIdColNewProduct.setCellValueFactory(new PropertyValueFactory<>("id"));
        allPartsNameColNewProduct.setCellValueFactory(new PropertyValueFactory<>("name"));
        allPartsStockColNewProduct.setCellValueFactory(new PropertyValueFactory<>("stock"));
        allPartsPriceColNewProduct.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    /**
     *
     */
    protected void associatedNewProductMenuSetup(){
        allPartsIdColNewAssociatedPart.setCellValueFactory(new PropertyValueFactory<>("id"));
        allPartsNameColNewAssociatedPart.setCellValueFactory(new PropertyValueFactory<>("name"));
        allPartsStockColNewAssociatedPart.setCellValueFactory(new PropertyValueFactory<>("stock"));
        allPartsPriceColNewAssociatedPart.setCellValueFactory(new PropertyValueFactory<>("price"));
    }


    /**
     *
     */
    protected void newProductTextFieldSetup(){
        newProductId.setPromptText("Auto Generated");
        newProductId.setDisable(true);
        newProductId.setEditable(false);
        allPartsNewProductMenu.setItems(getAllParts());
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    protected void onSaveNewProductButtonClick(MouseEvent event) throws IOException {
            if(newProductName.getText().isEmpty() || newProductPrice.getText().isEmpty()
                    || newProductStock.getText().isEmpty() || newProductMax.getText().isEmpty()
                    || newProductMin.getText().isEmpty()){

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
            if(Integer.parseInt(newProductMin.getText()) > Integer.parseInt(newProductMax.getText())){
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

            else if(Integer.parseInt(newProductStock.getText()) > Integer.parseInt(newProductMax.getText()) || Integer.parseInt(newProductStock.getText()) < Integer.parseInt(newProductMin.getText())){
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

            else if(!newProductName.getText().isEmpty() && Double.parseDouble(newProductPrice.getText()) != 0 && Integer.parseInt(newProductMax.getText()) != 0) {
                saveNewProductData();
                saveNewProduct(event);
            }


    }

    /**
     *
     */
    protected void saveNewProductData(){
        newProduct = new Product(0,"name",0.0,0,0,0);
        newProduct.setId(getAllProducts().size() + 1);
        newProduct.setName(newProductName.getText());
        newProduct.setPrice(Double.parseDouble(newProductPrice.getText()));
        newProduct.setStock(Integer.parseInt(newProductStock.getText()));
        newProduct.setMin(Integer.parseInt(newProductMin.getText()));
        newProduct.setMax(Integer.parseInt(newProductMax.getText()));
        addProduct(newProduct);
        newProduct.getAllAssociatedParts().addAll(associatedNewProductMenu.getItems());
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    protected void saveNewProduct(MouseEvent event) throws IOException {
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
    protected void onCancelModifiedProductButtonClick(MouseEvent event) throws IOException{
        cancelNewProduct(event);
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    protected void cancelNewProduct (MouseEvent event) throws IOException{
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
    protected void addAssociatedPartForNewProduct(){
       associatedNewProductMenu.getItems().add(allPartsNewProductMenu.getSelectionModel().getSelectedItem());
    }

    /**
     *
     */
    @FXML
    protected void removeAssociatedPartForNewProduct(){
        associatedNewProductMenu.getItems().remove(allPartsNewProductMenu.getSelectionModel().getSelectedItem());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        newProductTextFieldSetup();
        allPartsNewProductMenuSetup();
        associatedNewProductMenuSetup();
    }
}
