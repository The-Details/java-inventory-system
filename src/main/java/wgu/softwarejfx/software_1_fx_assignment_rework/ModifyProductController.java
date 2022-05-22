package wgu.softwarejfx.software_1_fx_assignment_rework;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
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
import java.util.function.Predicate;

import static javafx.geometry.HPos.CENTER;
import static wgu.softwarejfx.software_1_fx_assignment_rework.Inventory.*;

public class ModifyProductController implements Initializable {

    @FXML
    private TextField partsSearchBarModifiedProductMenu;
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


    private final int productIndex;

    public ModifyProductController(int productIndex){
        this.productIndex = productIndex;
    }

    /**
     * This method is responsible for the setting up of Modify Product Menu in the event a product is NOT selected for modification.
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
     * This method is responsible for preemptively setting up the modified product fields in the modified product menu.
     */
    protected void modifiedProductTextFieldSetup(){
        int selectedProduct = productIndex;
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
     * This method sets up the all parts tableview located on the modified product menu.
     */
    protected void allPartsModifiedProductMenuSetup(){
        allPartsModifiedProductMenu.setItems(getAllParts());
        allPartsIdColModifiedProduct.setCellValueFactory(new PropertyValueFactory<>("id"));
        allPartsNameColModifiedProduct.setCellValueFactory(new PropertyValueFactory<>("name"));
        allPartsStockColModifiedProduct.setCellValueFactory(new PropertyValueFactory<>("stock"));
        allPartsPriceColModifiedProduct.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    /**
     * This method sets up the associated parts tableview located on the modified product menu.
     */
    protected void associatedModifiedProductMenuSetup() {
        modifiedProduct = lookupProduct(productIndex);

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
     * This method is responsible for saving modified products to the all products collection.
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
     * This method is responsible for taking the data from the textfields and updating the product.
     */
    protected void saveModifiedProductData(){
        modifiedProduct = new Product(0,"name",0.0,0,0,0);
        modifiedProduct.setId(productIndex);
        modifiedProduct.setName(modifiedProductName.getText());
        modifiedProduct.setPrice(Double.parseDouble(modifiedProductPrice.getText()));
        modifiedProduct.setStock(Integer.parseInt(modifiedProductStock.getText()));
        modifiedProduct.setMin(Integer.parseInt(modifiedProductMin.getText()));
        modifiedProduct.setMax(Integer.parseInt(modifiedProductMax.getText()));
        updateProduct(productIndex, modifiedProduct);
        modifiedProduct.getAllAssociatedParts().setAll(associatedModifiedProductMenu.getItems());
    }

    /**
     *
     * @param event
     * This method is responsible for changing the scene from the Modify Product Menu back to the Main Menu after adding a modified product.
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
     * This redundant method is responsible for changing the scene from the Modify Product Menu back to the Main Menu after canceling a modified part.
     * @throws IOException
     */
    @FXML
    protected void onCancelModifiedProductButtonClick(MouseEvent event) throws IOException{
        cancelModifiedProduct(event);
    }

    /**
     *
     * @param event
     * This method is responsible for changing the scene from the Modify Product Menu back to the Main Menu after canceling a modified part.
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
     * This method is responsible for adding parts to be associated with the current product.
     */
    @FXML
    protected void addAssociatedPartForModifiedProduct(){
        modifiedProduct = lookupProduct(productIndex);
        ObservableList<Part> selectedPart = allPartsModifiedProductMenu.getSelectionModel().getSelectedItems();
        for(Part hotFilter : selectedPart){
            modifiedProduct.addAssociatedParts(hotFilter);
        }
        associatedModifiedProductMenu.setItems(modifiedProduct.getAllAssociatedParts());
    }


    /**
     * This method is responsible for removing parts to from associated with the current product.
     */
    @FXML
    protected void removeAssociatedPartForModifiedProduct(){
        modifiedProduct = lookupProduct(productIndex);
        ObservableList<Part> selectedPart = associatedModifiedProductMenu.getSelectionModel().getSelectedItems();
        for(Part hotFilter : selectedPart){
            modifiedProduct.deleteAssociatedPart(hotFilter);
        }
        associatedModifiedProductMenu.setItems(modifiedProduct.getAllAssociatedParts());
    }


    /**
     *
     * @param searchText
     * This method accepts a string that will be used to find a desired product
     * @return
     * This method will return that string in real time to a different method
     *
     */
    protected Predicate<Part> createPartPredicateModifiedProductMenu(String searchText){
        return part -> {
            if (searchText == null || searchText.isEmpty()) return true;
            return searchFindsProductModifiedPartMenu(part, searchText);
        };
    }

    /**
     *
     * @param part
     * This method uses this parameter to access the product class' methods
     * @param searchText
     * This method uses the provided string to find a product that matches the string
     * @return
     * This method returns the matching product, if any
     */
    protected boolean searchFindsProductModifiedPartMenu(Part part, String searchText){
        return (part.getName().toLowerCase().contains(searchText)) ||
                (Integer.valueOf(part.getId()).toString().equals(searchText));
    }

    /**
     * This method accepts a text-field that will be used to search for a particular product. This method will display any matching product within a row of the table.
     */
    protected void searchPartModifiedProductMenu(){
        try{
            FilteredList<Part> partsFilteredList = new FilteredList<>(FXCollections.observableList(getAllParts()));
            allPartsModifiedProductMenu.setItems(partsFilteredList);

            partsSearchBarModifiedProductMenu.textProperty().addListener(((observable, oldValue, newValue) ->
                    partsFilteredList.setPredicate(createPartPredicateModifiedProductMenu(newValue))));
        }
        catch (NullPointerException e){
            allPartsModifiedProductMenu.setItems(getAllParts());
        }
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        modifiedProductTextFieldSetup();
        allPartsModifiedProductMenuSetup();
        associatedModifiedProductMenuSetup();
        searchPartModifiedProductMenu();
    }
}
