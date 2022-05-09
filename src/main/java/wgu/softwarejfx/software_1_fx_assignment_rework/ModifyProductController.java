package wgu.softwarejfx.software_1_fx_assignment_rework;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Popup;

import static wgu.softwarejfx.software_1_fx_assignment_rework.Inventory.*;
import static wgu.softwarejfx.software_1_fx_assignment_rework.MainMenuController.allPartsTable;

public class ModifyProductController {


    @FXML
    private static Button saveModifiedProductButton;
    @FXML
    private static Button cancelModifiedProductButton;
    @FXML
    private static Button addModifiedAssociatedPart;
    @FXML
    private static Button removeModifiedAssociatedPart;
    @FXML
    private static TableView<Product> allPartsModifiedProductMenu;
    @FXML
    private static TableView<Part> associatedModifiedProductMenu;
    @FXML
    private static Popup conformationMessage;
    @FXML
    private static Popup errorMessage;
    @FXML
    private static TextField modifiedProductId;
    @FXML
    private static TextField modifiedProductName;
    @FXML
    private static TextField modifiedProductStock;
    @FXML
    private static TextField modifiedProductPrice;
    @FXML
    private static TextField modifiedProductMax;
    @FXML
    private static TextField modifiedProductMin;


    @FXML
    protected static void modifiedProductTextFieldSetup(){
        modifiedProductId.setPromptText("Auto Generated");
        modifiedProductId.setDisable(true);
        modifiedProductId.setEditable(false);
        modifiedProductName.setText(allPartsTable.getSelectionModel().selectedItemProperty().get().getName());
        modifiedProductPrice.setText(String.valueOf(allPartsTable.getSelectionModel().selectedItemProperty().get().getPrice()));
        modifiedProductStock.setText(String.valueOf(allPartsTable.getSelectionModel().selectedItemProperty().get().getStock()));
        modifiedProductMin.setText(String.valueOf(allPartsTable.getSelectionModel().selectedItemProperty().get().getMin()));
        modifiedProductMax.setText(String.valueOf(allPartsTable.getSelectionModel().selectedItemProperty().get().getMax()));
    }


    @FXML
    protected static void getNewProductTextFieldData(){
//       int foundProduct = lookupProduct();
//
//       Product productToUpdate =
//
//        updateProduct(foundProduct, );
    }

    @FXML //add associated part button
    protected static void addAssociatedPartForNewProduct(){

    }

    @FXML //remove associated part button
    protected static void removeAssociatedPartForNewProduct(){

    }
}
