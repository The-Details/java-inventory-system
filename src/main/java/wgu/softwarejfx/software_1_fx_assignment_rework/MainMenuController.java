package wgu.softwarejfx.software_1_fx_assignment_rework;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;

import static wgu.softwarejfx.software_1_fx_assignment_rework.Inventory.*;
import static wgu.softwarejfx.software_1_fx_assignment_rework.AddPartController.*;
import static wgu.softwarejfx.software_1_fx_assignment_rework.AddProductController.*;
import static wgu.softwarejfx.software_1_fx_assignment_rework.ModifyPartController.*;
import static wgu.softwarejfx.software_1_fx_assignment_rework.ModifyProductController.*;
import static wgu.softwarejfx.software_1_fx_assignment_rework.SceneController.*;

public class MainMenuController {

    @FXML
    public static TextField partsSearchBar;
    @FXML
    public static TextField productsSearchBar;
    @FXML
    public static TableView<Part> allPartsTable;
    @FXML
    public static TableView<Product> allProductsTable;
    @FXML
    private static Button addPartButton;
    @FXML
    private static Button modifyPartButton;
    @FXML
    private static Button deletePartButton;
    @FXML
    private static Button addProductButton;
    @FXML
    private static Button modifyProductButton;
    @FXML
    private static Button deleteProductButton;
    @FXML
    private static Button exitButton;
    @FXML
    private static GridPane mainMenu;
    @FXML
    private static GridPane addPartMenu;
    @FXML
    private static GridPane modifyPartMenu;
    @FXML
    private static GridPane addProductMenu;
    @FXML
    private static GridPane modifyProductMenu;
    @FXML
    private static Popup conformationMessage;
    @FXML
    private static Popup errorMessage;





    @FXML
    protected void onExitButtonClick(ActionEvent event) {
            Node source = (Node) event.getSource();
            Stage popUp = (Stage) source.getScene().getWindow();
            popUp.close();
    }

    @FXML
    void onAddNewPartButtonClick(MouseEvent event) throws IOException{
        newPartTextFieldSetup();
        addNewPartSceneChange(event);
    }

    @FXML
    public void onAddNewProductButtonClick(MouseEvent event) throws IOException{
        newProductTextFieldSetup();
        addNewProductSceneChange(event);

    }

    @FXML
    public void onModifyPartButtonClick(MouseEvent event) throws IOException{
        modifiedPartTextFieldSetup();
        modifyPartSceneChange(event);

    }

    @FXML
    public void onModifyProductButtonClick(MouseEvent event) throws IOException{
        modifiedProductTextFieldSetup();
        modifyProductSceneChange(event);


    }

    void mainMenuPartTableViewSetup(){
        allPartsTable = new TableView<>();
        allPartsTable.setItems(getAllParts());

        TableColumn<Part, Integer> partIdCol = new TableColumn<>("ID");
        partIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Part, Integer> partNameCol = new TableColumn<>("Name");
        partNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Part, Integer> partStockCol = new TableColumn<>("Stock");
        partStockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        TableColumn<Part, Integer> partPriceCol = new TableColumn<>("Price");
        partPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        TableColumn<Part, Integer> partMinCol = new TableColumn<>("Min");
        partMinCol.setCellValueFactory(new PropertyValueFactory<>("min"));
        TableColumn<Part, Integer> partMaxCol = new TableColumn<>("Max");
        partMaxCol.setCellValueFactory(new PropertyValueFactory<>("max"));

        allPartsTable.getColumns().add(partIdCol);
        allPartsTable.getColumns().add(partNameCol);
        allPartsTable.getColumns().add(partStockCol);
        allPartsTable.getColumns().add(partPriceCol);
        allPartsTable.getColumns().add(partMinCol);
        allPartsTable.getColumns().add(partMaxCol);
    }




    @FXML //delete button
    protected static void deleteSelectedPart(){
        ObservableList<Part> selectedPart = allPartsTable.getSelectionModel().getSelectedItems();
        if (allPartsTable.getSelectionModel().getSelectedItems() != null) {
            for (Part hotFilter : selectedPart) {
                deletePart(hotFilter);
                allPartsTable.setItems(getAllParts());
//                toastyScene.setRoot(conformationMessage);
            }
        }
    }

    @FXML //delete button
    protected static void deleteSelectedProduct(){
        ObservableList<Product> selectedPart = allProductsTable.getSelectionModel().getSelectedItems();
        if (allProductsTable.getSelectionModel().getSelectedItems() != null) {
            for (Product hotFilter : selectedPart) {
                deleteProduct(hotFilter);
                hotFilter.getAllAssociatedParts().clear();
                allProductsTable.setItems(getAllProducts());
//                toastyScene.setRoot(conformationMessage);
            }
        }
    }



}