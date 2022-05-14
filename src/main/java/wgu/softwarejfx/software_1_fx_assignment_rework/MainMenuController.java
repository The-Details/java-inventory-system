package wgu.softwarejfx.software_1_fx_assignment_rework;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static wgu.softwarejfx.software_1_fx_assignment_rework.Inventory.*;
import static wgu.softwarejfx.software_1_fx_assignment_rework.ModifyProductController.*;
import static wgu.softwarejfx.software_1_fx_assignment_rework.SceneController.*;

public class MainMenuController implements Initializable {

    @FXML
    public TextField partsSearchBar;
    @FXML
    public TextField productsSearchBar;
    @FXML
    public TableView<Part> allPartsTable;
    @FXML
    public TableView<Product> allProductsTable;
    @FXML
    private Button addPartButton;
    @FXML
    private Button modifyPartButton;
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
    private TableColumn<Part, Integer> allPartsIdCol;
    @FXML
    private TableColumn<Part, Integer> allPartsNameCol;
    @FXML
    private TableColumn<Part, Integer> allPartsStockCol;
    @FXML
    private TableColumn<Part, Integer> allPartsPriceCol;
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


    @FXML
    protected void onExitButtonClick(ActionEvent event) {
            Node source = (Node) event.getSource();
            Stage popUp = (Stage) source.getScene().getWindow();
            popUp.close();
    }

    @FXML
    protected void onAddNewPartButtonClick(MouseEvent event) throws IOException{
        addNewPartSceneChange(event);
    }

    @FXML
    protected void onAddNewProductButtonClick(MouseEvent event) throws IOException{
        addNewProductSceneChange(event);
    }

    @FXML
    protected void onModifyPartButtonClick(MouseEvent event) throws IOException{
        modifyPartSceneChange(event);
        selectedPart();
    }

    @FXML
    protected void onModifyProductButtonClick(MouseEvent event) throws IOException{
        modifyProductSceneChange(event);
    }


    protected void mainMenuPartTableViewSetup(){
        allPartsTable.setItems(getAllParts());
        allPartsIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        allPartsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        allPartsStockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        allPartsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    protected void mainMenuProductTableViewSetup(){
        allProductsTable.setItems(getAllProducts());
        allProductsIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        allProductsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        allProductsStockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        allProductsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    int selectedPart(){
        if(allPartsTable != null) {
            return allPartsTable.getSelectionModel().selectedItemProperty().get().getId();
        }
        else{
            return 0;
        }
    }
    int selectedProduct(){
        if(allProductsTable != null) {
            return allProductsTable.getSelectionModel().selectedItemProperty().get().getId();
        }
        else{
            return 0;
        }
    }

    @FXML // when something is deleted lower the ids for all
    protected void deleteSelectedPart(){
        ObservableList<Part> selectedPart = allPartsTable.getSelectionModel().getSelectedItems();
        if (allPartsTable.getSelectionModel().getSelectedItems() != null) {
            for (Part hotFilter : selectedPart) {
                deletePart(hotFilter);
                allPartsTable.setItems(getAllParts());
            }
        }
    }

    @FXML // when something is deleted lower the ids for all
    protected void deleteSelectedProduct(){
        ObservableList<Product> selectedPart = allProductsTable.getSelectionModel().getSelectedItems();
        if (allProductsTable.getSelectionModel().getSelectedItems() != null) {
            for (Product hotFilter : selectedPart) {
                deleteProduct(hotFilter);
                hotFilter.getAllAssociatedParts().clear();
                allProductsTable.setItems(getAllProducts());
            }
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainMenuPartTableViewSetup();
        mainMenuProductTableViewSetup();
    }
}