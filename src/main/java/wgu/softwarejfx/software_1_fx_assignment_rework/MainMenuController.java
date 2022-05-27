package wgu.softwarejfx.software_1_fx_assignment_rework;

import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import static javafx.geometry.HPos.CENTER;
import static wgu.softwarejfx.software_1_fx_assignment_rework.AddPartController.inHouseParts;
import static wgu.softwarejfx.software_1_fx_assignment_rework.AddPartController.outsourcedParts;
import static wgu.softwarejfx.software_1_fx_assignment_rework.Inventory.*;


/**
 * RUNTIME ERROR: When the user tried to modify or delete a product or part without selecting the product or part to manipulate a IOException was thrown
 * FIX: Catch the exceptions and display error messages
 */
public class MainMenuController implements Initializable {

    @FXML
    public TextField partsSearchBar;
    @FXML
    public TextField productsSearchBar;
    @FXML
    public TableView<Part> allPartsTable = new TableView<>();
    @FXML
    public TableView<Product> allProductsTable = new TableView<>();
    @FXML
    private Button addPartButton;
    @FXML
    public Button modifyPartButton;
    @FXML
    private Button deletePartButton;
    @FXML
    private Button addProductButton;
    @FXML
    private Button modifyProductButton;
    @FXML
    private Button deleteProductButton;
    @FXML
    private Button exitButton;
    @FXML
    private GridPane mainMenu;
    @FXML
    private GridPane addPartMenu;
    @FXML
    private GridPane modifyPartMenu;
    @FXML
    private GridPane addProductMenu;
    @FXML
    private GridPane modifyProductMenu;
    @FXML
    private Popup conformationMessage;
    @FXML
    private Popup errorMessage;
    @FXML
    private TableColumn<Part, Integer> allPartsIdCol = new TableColumn<>();
    @FXML
    private TableColumn<Part, Integer> allPartsNameCol = new TableColumn<>();
    @FXML
    private TableColumn<Part, Integer> allPartsStockCol = new TableColumn<>();
    @FXML
    private TableColumn<Part, Integer> allPartsPriceCol = new TableColumn<>();
    @FXML
    private TableColumn<Part, Integer> allPartsMinCol;
    @FXML
    private TableColumn<Part, Integer> allPartsMaxCol;
    @FXML
    private TableColumn<Product, Integer> allProductsIdCol;
    @FXML
    private TableColumn<Product, Integer> allProductsNameCol;
    @FXML
    private TableColumn<Product, Integer> allProductsStockCol;
    @FXML
    private TableColumn<Product, Integer> allProductsPriceCol;
    @FXML
    private TableColumn<Product, Integer> allProductsMinCol;
    @FXML
    private TableColumn<Product, Integer> allProductsMaxCol;


    private final FXMLLoader mPartLoader;
    private final FXMLLoader mProductLoader;


    /**
     * This constructor provides control over the default no parameter constructor for the: Modify Part and Modify Product classes, allowing parameters
     */
    public MainMenuController(){
        mPartLoader = new FXMLLoader(MainMenuController.class.getResource("ModifyPart.fxml"));
        mProductLoader = new FXMLLoader(MainMenuController.class.getResource("ModifyProduct.fxml"));
        mPartLoader.setControllerFactory(new Callback<Class<?>, Object>() {
        @Override
            public Object call(Class<?> cls){
            if (cls == ModifyPartController.class){
                return new ModifyPartController(getAllParts().indexOf(allPartsTable.getSelectionModel().getSelectedItem()), allPartsTable.getSelectionModel().getSelectedItem().getName());
            }else {
                try{
                    return cls.newInstance();
                } catch (InstantiationException | IllegalAccessException exception){
                    exception.printStackTrace();
                    throw new RuntimeException(exception);
                }
            }
        }
        });

        mProductLoader.setControllerFactory(new Callback<Class<?>, Object>() {
            @Override
            public Object call(Class<?> cls2){
                if (cls2 == ModifyProductController.class){
                    return new ModifyProductController(getAllProducts().indexOf(allProductsTable.getSelectionModel().getSelectedItem()));
                }else {
                    try{
                        return cls2.newInstance();
                    } catch (InstantiationException | IllegalAccessException exception){
                        exception.printStackTrace();
                        throw new RuntimeException(exception);
                    }
                }
            }

        });
    }




    /**
     *
     * @param event
     * This method closes the main Node when called.
     */
    @FXML
    protected void onExitButtonClick(ActionEvent event) {
            Node source = (Node) event.getSource();
            Stage popUp = (Stage) source.getScene().getWindow();
            popUp.close();
    }

    /**
     *
     * @param event
     * This method changes the scene from the Main Menu scene to the Add Part scene.
     * @throws IOException
     */
    @FXML
    protected void onAddNewPartButtonClick(MouseEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(MainMenuController.class.getResource("AddPart.fxml")));
        Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     *
     * @param event
     * This method changes the scene from the Main Menu scene to the Add Product scene.
     * @throws IOException
     */
    @FXML
    protected void onAddNewProductButtonClick(MouseEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(MainMenuController.class.getResource("AddProduct.fxml")));
        Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * RUNTIME ERROR: When the user tried to modify a part without selecting the part to manipulate a IOException was thrown
     * FIX: Catch the exception and display an error message
     * @param event
     * This method changes the scene from the Main Menu scene to the Modify Part scene.
     */
    @FXML
    protected void onModifyPartButtonClick(MouseEvent event){
      try {
          mPartLoader.setController(null);
          mPartLoader.setRoot(null);
          Parent root = mPartLoader.load();
          Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
          Scene scene = new Scene(root);
          stage.setScene(scene);
          stage.show();
      }
      catch (IOException e){
          GridPane conformation = new GridPane();
          Text conformationInfo = new Text("No Part was selected");
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
     * RUNTIME ERROR: When the user tried to modify a product without selecting the product to manipulate a IOException was thrown
     * FIX: Catch the exception and display an error message
     * @param event
     * This method changes the scene from the Main Menu scene to the Modify Product scene.
     */
    @FXML
    protected void onModifyProductButtonClick(MouseEvent event){
        try {
            mProductLoader.setController(null);
            mProductLoader.setRoot(null);
            Parent root = mProductLoader.load();
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            GridPane conformation = new GridPane();
            Text conformationInfo = new Text("No Product was selected");
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
     *  This method sets up the all parts tableview located on the main menu.
     */
    protected void mainMenuPartTableViewSetup(){
        allPartsTable.setItems(getAllParts());
        allPartsIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        allPartsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        allPartsStockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        allPartsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    /**
     *This method sets up the all products tableview located on the main menu.
     */
    protected void mainMenuProductTableViewSetup(){
        allProductsTable.setItems(getAllProducts());
        allProductsIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        allProductsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        allProductsStockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        allProductsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    /**
     * RUNTIME ERROR: When the user tried to delete a part without selecting the part to manipulate an Exception was thrown
     * FIX: Catch the exception and display an error message
     * This method is responsible for the deletion of parts from the all parts tableview located on the main menu.
     */
    @FXML
    protected void deleteSelectedPart(){
        try {
        ModifyPartController modifyPartGateWay = new ModifyPartController(getAllParts().indexOf(allPartsTable.getSelectionModel().getSelectedItem()), allPartsTable.getSelectionModel().getSelectedItem().getName());
            if (allPartsTable.getSelectionModel().getSelectedItem() != null) {
                if (allPartsTable.getItems().size() > 1) {
                    if (allPartsTable.getSelectionModel().getSelectedItem() != null && allPartsTable.getSelectionModel().getSelectedItem().getName().equals(modifyPartGateWay.lookupInHousePart(getAllParts().indexOf(allPartsTable.getSelectionModel().getSelectedItem())).getName())) {
                        deletePart(allPartsTable.getSelectionModel().getSelectedItem());
                        inHouseParts.remove(modifyPartGateWay.inHouseTest(modifyPartGateWay.lookupInHousePart(allPartsTable.getSelectionModel().getSelectedItem().getName())));
                        for (InHouse selectedInHousePart : inHouseParts) {
                            InHouse inHousePartToUpdate = modifyPartGateWay.lookupInHousePart(inHouseParts.indexOf(selectedInHousePart));
                            inHousePartToUpdate.setId(inHouseParts.indexOf(selectedInHousePart) + 1);

                            modifyPartGateWay.updateInHousePart(inHouseParts.indexOf(selectedInHousePart), inHousePartToUpdate);
                            System.out.println(inHousePartToUpdate.getId() + " " + inHousePartToUpdate.getName());
                        }
                        for (Part selectedPart : getAllParts()) {
                            Part partToUpdate = lookupPart(getAllParts().indexOf(selectedPart));
                            partToUpdate.setId(getAllParts().indexOf(selectedPart) + 1);

                            updatePart(getAllParts().indexOf(selectedPart), partToUpdate);
                            allPartsTable.setItems(getAllParts());
                        }
//                    System.out.println("InHouse Parts Updated");
                    } else if (allPartsTable.getSelectionModel().getSelectedItem() != null && allPartsTable.getSelectionModel().getSelectedItem().getName().equals(modifyPartGateWay.lookupOutsourcedPart(getAllParts().indexOf(allPartsTable.getSelectionModel().getSelectedItem())).getName())) {
                        deletePart(allPartsTable.getSelectionModel().getSelectedItem());
                        outsourcedParts.remove(modifyPartGateWay.outsourcedTest(modifyPartGateWay.lookupOutsourcedPart(allPartsTable.getSelectionModel().getSelectedItem().getName())));
                        for (Outsourced selectedInHousePart : outsourcedParts) {
                            Outsourced outsourcedPartToUpdate = modifyPartGateWay.lookupOutsourcedPart(outsourcedParts.indexOf(selectedInHousePart));
                            outsourcedPartToUpdate.setId(outsourcedParts.indexOf(selectedInHousePart) + 1);

                            modifyPartGateWay.updateOutsourcedPart(outsourcedParts.indexOf(selectedInHousePart), outsourcedPartToUpdate);
                        }
                        for (Part selectedPart : getAllParts()) {
                            Part partToUpdate = lookupPart(getAllParts().indexOf(selectedPart));
                            partToUpdate.setId(getAllParts().indexOf(selectedPart) + 1);

                            updatePart(getAllParts().indexOf(selectedPart), partToUpdate);
                            allPartsTable.setItems(getAllParts());
                        }
//                    System.out.println("Outsourced Parts Updated");
                    } else {
                        System.out.println("Nothing Called");
                    }
                } else {
                    deletePart(allPartsTable.getSelectionModel().getSelectedItem());
                }

                allPartsTable.setItems(getAllParts());

                GridPane conformation = new GridPane();
                Text conformationInfo = new Text("Part Successfully Removed");
                conformationInfo.setFont(new Font(20));
                conformation.getChildren().add(conformationInfo);
                GridPane.setConstraints(conformationInfo, 0, 0, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(25));
                Stage popUp = new Stage();
                Scene conformationScene = new Scene(conformation);
                popUp.setTitle("System Message");
                popUp.setScene(conformationScene);
                popUp.sizeToScene();
                popUp.show();

            } else {
                GridPane conformation = new GridPane();
                Text conformationInfo = new Text("Part Deletion Unsuccessful");
                conformationInfo.setFont(new Font(20));
                conformation.getChildren().add(conformationInfo);
                GridPane.setConstraints(conformationInfo, 0, 0, 1, 1, CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(25));
                Stage popUp = new Stage();
                Scene conformationScene = new Scene(conformation);
                popUp.setTitle("System Message");
                popUp.setScene(conformationScene);
                popUp.sizeToScene();
                popUp.show();
            }
        }catch (Exception e){
            GridPane conformation = new GridPane();
            Text conformationInfo = new Text("No Part was selected");
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
     * RUNTIME ERROR: When the user tried to delete a product without selecting the product to manipulate an Exception was thrown
     * FIX: Catch the exception and display an error message
     * This method is responsible for the deletion of products from the all products tableview located on the main menu.
     */
    @FXML
    protected void deleteSelectedProduct(){
        try {
            if (allProductsTable.getSelectionModel().getSelectedItem() != null) {
                if (getAllProducts().size() > 1) {
                    deleteProduct(allProductsTable.getSelectionModel().getSelectedItem());
                    for (Product selectedProduct : getAllProducts()) {
                        Product productToUpdate = lookupProduct(getAllProducts().indexOf(selectedProduct));
                        productToUpdate.setId(getAllProducts().indexOf(selectedProduct) + 1);

                        updateProduct(getAllProducts().indexOf(selectedProduct), productToUpdate);
                        allProductsTable.setItems(getAllProducts());
                    }
                } else {
                    deleteProduct(allProductsTable.getSelectionModel().getSelectedItem());
                    allProductsTable.setItems(getAllProducts());
                }

            }
        }catch (Exception e){
            GridPane conformation = new GridPane();
            Text conformationInfo = new Text("No Product was selected");
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
     *
     * @param searchText
     * This method accepts a string that will be used to find a desired part
     * @return
     * This method will return that string in real time to a different method
     *
     */
    protected Predicate<Part> createPartPredicate(String searchText){
        return part -> {
            if (searchText == null || searchText.isEmpty()) return true;
            return searchFindsPart(part, searchText);
        };
    }

    /**
     *
     * @param searchText
     * This method accepts a string that will be used to find a desired product
     * @return
     * This method will return that string in real time to a different method
     *
     */
    protected Predicate<Product> createProductPredicate(String searchText){
        return product -> {
            if (searchText == null || searchText.isEmpty()) return true;
            return searchFindsProduct(product, searchText);
        };
    }

    /**
     *
     * @param part
     * This method uses this parameter to access the part class' methods
     * @param searchText
     * This method uses the provided string to find a part that matches the string
     * @return
     * This method returns the matching part, if any
     */
    protected boolean searchFindsPart(Part part, String searchText){
        return (part.getName().toLowerCase().contains(searchText)) ||
                (Integer.valueOf(part.getId()).toString().equals(searchText));
    }

    /**
     *
     * @param product
     * This method uses this parameter to access the product class' methods
     * @param searchText
     * This method uses the provided string to find a product that matches the string
     * @return
     * This method returns the matching product, if any
     */
    protected boolean searchFindsProduct(Product product, String searchText){
        return (product.getName().toLowerCase().contains(searchText)) ||
                (Integer.valueOf(product.getId()).toString().equals(searchText));
    }


    /**
     * This method accepts a text-field that will be used to search for a particular part. This method will display any matching part within a row of the table.
     */
    protected void searchPart(){
        try{
            FilteredList<Part> partsFilteredList = new FilteredList<>(FXCollections.observableList(getAllParts()));
            allPartsTable.setItems(partsFilteredList);

            partsSearchBar.textProperty().addListener(((observable, oldValue, newValue) ->
                    partsFilteredList.setPredicate(createPartPredicate(newValue))));
        }
        catch (NullPointerException e){
            allPartsTable.setItems(getAllParts());
        }
    }

    /**
     * This method accepts a text-field that will be used to search for a particular product. This method will display any matching product within a row of the table.
     */
    protected void searchProduct(){
        try{
            FilteredList<Product> productsFilteredList = new FilteredList<>(FXCollections.observableList(getAllProducts()));
            allProductsTable.setItems(productsFilteredList);

            productsSearchBar.textProperty().addListener(((observable, oldValue, newValue) ->
                    productsFilteredList.setPredicate(createProductPredicate(newValue))));
        }
        catch (NullPointerException e){
            allProductsTable.setItems(getAllProducts());
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainMenuPartTableViewSetup();
        mainMenuProductTableViewSetup();
        searchPart();
        searchProduct();
    }
}