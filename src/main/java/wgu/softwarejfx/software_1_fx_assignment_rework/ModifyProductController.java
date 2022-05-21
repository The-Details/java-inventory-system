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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static javafx.geometry.HPos.CENTER;
import static wgu.softwarejfx.software_1_fx_assignment_rework.Inventory.*;

public class ModifyProductController implements Initializable {

    @FXML
    private Button saveModifiedProductButton;
    @FXML
    private Button cancelModifiedProductButton;
    @FXML
    private Button addModifiedAssociatedPart;
    @FXML
    private Button removeModifiedAssociatedPart;
    @FXML
    private TableView<Part> allPartsModifiedProductMenu;
    @FXML
    private TableView<Part> associatedModifiedProductMenu;
    @FXML
    private TextField modifiedProductId;
    @FXML
    private TextField modifiedProductName;
    @FXML
    private TextField modifiedProductStock;
    @FXML
    private TextField modifiedProductPrice;
    @FXML
    private TextField modifiedProductMax;
    @FXML
    private TextField modifiedProductMin;
    @FXML
    private TableColumn<Part, Integer> allPartsIdColModifiedProduct;
    @FXML
    private TableColumn<Part, Integer> allPartsNameColModifiedProduct;
    @FXML
    private TableColumn<Part, Integer> allPartsStockColModifiedProduct;
    @FXML
    private TableColumn<Part, Integer> allPartsPriceColModifiedProduct;
    @FXML
    private TableColumn<Part, Integer> allPartsIdColModifiedAssociatedPart;
    @FXML
    private TableColumn<Part, Integer> allPartsNameColModifiedAssociatedPart;
    @FXML
    private TableColumn<Part, Integer> allPartsStockColModifiedAssociatedPart;
    @FXML
    private TableColumn<Part, Integer> allPartsPriceColModifiedAssociatedPart;
    private Product modifiedProduct;


    /**
     *
     */
    public void productFieldPrep(){

        modifiedProductId.setPromptText("");
        modifiedProductId.setDisable(true);
        modifiedProductId.setEditable(false);
        modifiedProductName.setText("");
        modifiedProductPrice.setText("");
        modifiedProductStock.setText("");
        modifiedProductMin.setText("");
        modifiedProductMax.setText("");

    }

    /**
     *
     */
    protected void modifiedProductTextFieldSetup(){
        MainMenuController y = new MainMenuController();
        int selectedProduct = y.selectedProduct();
        if(getAllProducts() != null){
            modifiedProductId.setPromptText(String.valueOf(lookupProduct(selectedProduct).getId()));
            modifiedProductId.setDisable(true);
            modifiedProductId.setEditable(false);
            modifiedProductName.setText(lookupProduct(selectedProduct).getName());
            modifiedProductPrice.setText(String.valueOf(lookupProduct(selectedProduct).getPrice()));
            modifiedProductStock.setText(String.valueOf(lookupProduct(selectedProduct).getStock()));
            modifiedProductMin.setText(String.valueOf(lookupProduct(selectedProduct).getMin()));
            modifiedProductMax.setText(String.valueOf(lookupProduct(selectedProduct).getMax()));
        }
        else {
            productFieldPrep();
        }

    }

    /**
     *
     */
    protected void allPartsModifiedProductMenuSetup(){
        allPartsModifiedProductMenu.setItems(getAllParts());
        allPartsIdColModifiedProduct.setCellValueFactory(new PropertyValueFactory<>("id"));
        allPartsNameColModifiedProduct.setCellValueFactory(new PropertyValueFactory<>("name"));
        allPartsStockColModifiedProduct.setCellValueFactory(new PropertyValueFactory<>("stock"));
        allPartsPriceColModifiedProduct.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    /**
     *
     */
    protected void associatedModifiedProductMenuSetup() {
        MainMenuController x = new MainMenuController();
        int selectedProductForModification = x.selectedProduct();
        modifiedProduct = lookupProduct(selectedProductForModification);

        if(modifiedProduct != null){
            associatedModifiedProductMenu.setItems(modifiedProduct.getAllAssociatedParts());
        }

        allPartsIdColModifiedAssociatedPart.setCellValueFactory(new PropertyValueFactory<>("id"));
        allPartsNameColModifiedAssociatedPart.setCellValueFactory(new PropertyValueFactory<>("name"));
        allPartsStockColModifiedAssociatedPart.setCellValueFactory(new PropertyValueFactory<>("stock"));
        allPartsPriceColModifiedAssociatedPart.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    protected void onSaveModifiedProductButtonClick(MouseEvent event) throws IOException {
        if(modifiedProductName.getText().isEmpty() || modifiedProductPrice.getText().isEmpty()
                || modifiedProductStock.getText().isEmpty() || modifiedProductMax.getText().isEmpty()
                || modifiedProductMin.getText().isEmpty()){

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
        if(Integer.parseInt(modifiedProductMin.getText()) > Integer.parseInt(modifiedProductMax.getText())){
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

        else if(Integer.parseInt(modifiedProductStock.getText()) > Integer.parseInt(modifiedProductMax.getText()) || Integer.parseInt(modifiedProductStock.getText()) < Integer.parseInt(modifiedProductMin.getText())){
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

        else if(!modifiedProductName.getText().isEmpty() && Double.parseDouble(modifiedProductPrice.getText()) != 0 && Integer.parseInt(modifiedProductMax.getText()) != 0) {
            saveModifiedProductData();
            saveModifiedProduct(event);
        }
    }

    /**
     *
     */
    protected void saveModifiedProductData(){
        MainMenuController y = new MainMenuController();
        int selectedProduct = y.selectedProduct();
        modifiedProduct = new Product(0,"name",0.0,0,0,0);
        modifiedProduct.setId(selectedProduct);
        modifiedProduct.setName(modifiedProductName.getText());
        modifiedProduct.setPrice(Double.parseDouble(modifiedProductPrice.getText()));
        modifiedProduct.setStock(Integer.parseInt(modifiedProductStock.getText()));
        modifiedProduct.setMin(Integer.parseInt(modifiedProductMin.getText()));
        modifiedProduct.setMax(Integer.parseInt(modifiedProductMax.getText()));
        updateProduct(selectedProduct, modifiedProduct);
        modifiedProduct.getAllAssociatedParts().setAll(associatedModifiedProductMenu.getItems());
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    protected void saveModifiedProduct(MouseEvent event) throws IOException {
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
        cancelModifiedProduct(event);
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    protected void cancelModifiedProduct (MouseEvent event) throws IOException{
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
    protected void addAssociatedPartForModifiedProduct(){
        MainMenuController x = new MainMenuController();
        int selectedProductForModification = x.selectedProduct();
        modifiedProduct = lookupProduct(selectedProductForModification);
        ObservableList<Part> selectedPart = allPartsModifiedProductMenu.getSelectionModel().getSelectedItems();
        for(Part hotFilter : selectedPart){
            modifiedProduct.addAssociatedParts(hotFilter);
        }
        associatedModifiedProductMenu.setItems(modifiedProduct.getAllAssociatedParts());
    }


    /**
     *
     */
    @FXML
    protected void removeAssociatedPartForModifiedProduct(){
        MainMenuController x = new MainMenuController();
        int selectedProductForModification = x.selectedProduct();
        modifiedProduct = lookupProduct(selectedProductForModification);
        ObservableList<Part> selectedPart = associatedModifiedProductMenu.getSelectionModel().getSelectedItems();
        for(Part hotFilter : selectedPart){
            modifiedProduct.deleteAssociatedPart(hotFilter);
        }
        associatedModifiedProductMenu.setItems(modifiedProduct.getAllAssociatedParts());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        modifiedProductTextFieldSetup();
        allPartsModifiedProductMenuSetup();
        associatedModifiedProductMenuSetup();
    }
}
