package wgu.softwarejfx.software_1_fx_assignment_rework;

import javafx.collections.FXCollections;
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

public class AddProductController implements Initializable {

    @FXML
    public TextField partsSearchBarNewProductMenu;
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
     * This method sets up the all parts tableview located on the new product menu.
     */
    protected void allPartsNewProductMenuSetup(){
        allPartsNewProductMenu.setItems(getAllParts());
        allPartsIdColNewProduct.setCellValueFactory(new PropertyValueFactory<>("id"));
        allPartsNameColNewProduct.setCellValueFactory(new PropertyValueFactory<>("name"));
        allPartsStockColNewProduct.setCellValueFactory(new PropertyValueFactory<>("stock"));
        allPartsPriceColNewProduct.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    /**
     * This method sets up the associated parts tableview located on the new product menu.
     */
    protected void associatedNewProductMenuSetup(){
        allPartsIdColNewAssociatedPart.setCellValueFactory(new PropertyValueFactory<>("id"));
        allPartsNameColNewAssociatedPart.setCellValueFactory(new PropertyValueFactory<>("name"));
        allPartsStockColNewAssociatedPart.setCellValueFactory(new PropertyValueFactory<>("stock"));
        allPartsPriceColNewAssociatedPart.setCellValueFactory(new PropertyValueFactory<>("price"));
    }


    /**
     * This method is responsible for preemptively setting up the new product id field as well as the all parts table view
     * in the new product menu.
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
     * This method is responsible for saving new products to the all products collection.
     * @throws IOException
     */
    @FXML
    protected void onSaveNewProductButtonClick(MouseEvent event) throws IOException {
        try{
        if (newProductName.getText().isEmpty() || newProductPrice.getText().isEmpty()
                || newProductStock.getText().isEmpty() || newProductMax.getText().isEmpty()
                || newProductMin.getText().isEmpty()) {

            GridPane conformation = new GridPane();
            Text conformationInfo = new Text("Part Successfully Removed");
            conformationInfo.setFont(new Font(20));
            Button errorInfoCloseButton = new Button("Close");
            conformation.getChildren().add(conformationInfo);
            conformation.getChildren().add(errorInfoCloseButton);
            GridPane.setConstraints(errorInfoCloseButton, 0, 1, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(10));
            GridPane.setConstraints(conformationInfo, 0, 0, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(25));

            Stage popUp = new Stage();
            Scene conformationScene = new Scene(conformation);
            popUp.setTitle("Conformation");
            popUp.setScene(conformationScene);
            popUp.sizeToScene();
            popUp.show();
        }
        if (Integer.parseInt(newProductMin.getText()) > Integer.parseInt(newProductMax.getText())) {
            GridPane error = new GridPane();
            Text errorInfo = new Text("Min & Max Error: Max should be greater then Min");
            errorInfo.setFont(new Font(20));
            Button errorInfoCloseButton = new Button("Close");
            error.getChildren().add(errorInfo);
            error.getChildren().add(errorInfoCloseButton);
            GridPane.setConstraints(errorInfoCloseButton, 0, 1, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(10));
            GridPane.setConstraints(errorInfo, 0, 0, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(25));

            Stage popUp = new Stage();
            Scene errorScene = new Scene(error);
            popUp.setTitle("Error");
            popUp.setScene(errorScene);
            popUp.sizeToScene();
            popUp.show();
        } else if (Integer.parseInt(newProductStock.getText()) >= Integer.parseInt(newProductMax.getText()) || Integer.parseInt(newProductStock.getText()) <= Integer.parseInt(newProductMin.getText())) {
            GridPane error = new GridPane();
            Text errorInfo = new Text("Stock Error: Stock must be between Min & Max");
            errorInfo.setFont(new Font(20));
            Button errorInfoCloseButton = new Button("Close");
            error.getChildren().add(errorInfo);
            error.getChildren().add(errorInfoCloseButton);
            GridPane.setConstraints(errorInfoCloseButton, 0, 1, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(10));
            GridPane.setConstraints(errorInfo, 0, 0, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(25));

            Stage popUp = new Stage();
            Scene errorScene = new Scene(error);
            popUp.setTitle("Error");
            popUp.setScene(errorScene);
            popUp.sizeToScene();
            popUp.show();

        } else if (!newProductName.getText().isEmpty() && Double.parseDouble(newProductPrice.getText()) != 0 && Integer.parseInt(newProductMax.getText()) != 0) {
            saveNewProductData();
            saveNewProduct(event);
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
     * This method is responsible for taking the data from the textfields and inserting it into an instance of a product Object
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
     * This method is responsible for the changing the scene from the Add Product Menu back to the Main Menu after adding a new product.
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
     * This redundant method is responsible for changing the scene from the Add Product Menu back to the Main Menu after canceling a new product.
     * @throws IOException
     */
    @FXML
    protected void onCancelModifiedProductButtonClick(MouseEvent event) throws IOException{
        cancelNewProduct(event);
    }

    /**
     *
     * @param event
     * This method is responsible for changing the scene from the Add Product Menu back to the Main Menu after canceling a new product.
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
     * This method is responsible for adding parts to be associated with the current product.
     */
    @FXML
    protected void addAssociatedPartForNewProduct(){
       associatedNewProductMenu.getItems().add(allPartsNewProductMenu.getSelectionModel().getSelectedItem());
    }

    /**
     * This method is responsible for removing parts to from associated with the current product.
     */
    @FXML
    protected void removeAssociatedPartForNewProduct(){
        associatedNewProductMenu.getItems().remove(allPartsNewProductMenu.getSelectionModel().getSelectedItem());
    }


    /**
     *
     * @param searchText
     * This method accepts a string that will be used to find a desired product
     * @return
     * This method will return that string in real time to a different method
     *
     */
    protected Predicate<Part> createPartPredicateNewProductMenu(String searchText){
        return part -> {
            if (searchText == null || searchText.isEmpty()) return true;
            return searchFindsProductNewPartMenu(part, searchText);
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
    protected boolean searchFindsProductNewPartMenu(Part part, String searchText){
        return (part.getName().toLowerCase().contains(searchText)) ||
                (Integer.valueOf(part.getId()).toString().equals(searchText));
    }

    /**
     * This method accepts a text-field that will be used to search for a particular product. This method will display any matching product within a row of the table.
     */
    protected void searchPartNewProductMenu(){
        try{
            FilteredList<Part> partsFilteredList = new FilteredList<>(FXCollections.observableList(getAllParts()));
            allPartsNewProductMenu.setItems(partsFilteredList);

            partsSearchBarNewProductMenu.textProperty().addListener(((observable, oldValue, newValue) ->
                    partsFilteredList.setPredicate(createPartPredicateNewProductMenu(newValue))));
        }
        catch (NullPointerException e){
            allPartsNewProductMenu.setItems(getAllParts());
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        newProductTextFieldSetup();
        allPartsNewProductMenuSetup();
        associatedNewProductMenuSetup();
        searchPartNewProductMenu();
    }
}
