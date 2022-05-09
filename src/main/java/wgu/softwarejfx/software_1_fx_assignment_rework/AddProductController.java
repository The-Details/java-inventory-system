package wgu.softwarejfx.software_1_fx_assignment_rework;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static javafx.geometry.HPos.CENTER;
import static wgu.softwarejfx.software_1_fx_assignment_rework.Inventory.*;
import static wgu.softwarejfx.software_1_fx_assignment_rework.MainMenuController.allProductsTable;

public class AddProductController {

    @FXML
    private static Button saveNewProductButton;
    @FXML
    private static Button cancelNewProductButton;
    @FXML
    private static Button addNewAssociatedPart;
    @FXML
    private static Button removeNewAssociatedPart;
    @FXML
    private static TableView<Part> allPartsNewProductMenu;
    @FXML
    private static TableView<Part> associatedNewProductMenu;
    @FXML
    private static Popup conformationMessage;
    @FXML
    private static Popup errorMessage;
    @FXML
    private static TextField newProductId;
    @FXML
    private static TextField newProductName;
    @FXML
    private static TextField newProductStock;
    @FXML
    private static TextField newProductPrice;
    @FXML
    private static TextField newProductMax;
    @FXML
    private static TextField newProductMin;
    public static Product newProduct;
    public static int newId;

    public static void newProductTextFieldSetup(){
        newProductId.setPromptText("Auto Generated");
        newProductId.setDisable(true);
        newProductId.setEditable(false);
        newProductName.clear();
        newProductPrice.clear();
        newProductStock.clear();
        newProductMin.clear();
        newProductMax.clear();
    }

    @FXML
    void onSaveModifiedProductButtonClick() throws IOException {
        setNewProductTextFieldData();
    }

    public static void setNewProductTextFieldData(){
        newProduct = new Product(0,"name",0.0,0,0,0);
        newProduct.setId(newId);
        newProduct.setName(newProductName.getText());
        newProduct.setPrice(Double.parseDouble(newProductPrice.getText()));
        newProduct.setStock(Integer.parseInt(newProductStock.getText()));
        newProduct.setMin(Integer.parseInt(newProductMin.getText()));
        newProduct.setMax(Integer.parseInt(newProductMax.getText()));
        addProduct(newProduct);
        allProductsTable.setItems(getAllProducts());
        ++newId;
    }

    @FXML
    void onCancelModifiedProductButtonClick(MouseEvent event) throws IOException{
        cancelNewProduct(event);
    }

    protected static void cancelNewProduct (MouseEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(MainMenuController.class.getResource("MainMenu.fxml")));
        Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected static void addAssociatedPartForModifiedProduct(){
        ObservableList<Part> selectedPart = allPartsNewProductMenu.getSelectionModel().getSelectedItems();
        for(Part hotFilter : selectedPart){
            newProduct.addAssociatedParts(hotFilter);
        }
        associatedNewProductMenu.setItems(newProduct.getAllAssociatedParts());
    }

    @FXML
    protected static void removeAssociatedPartForModifiedProduct(){
        ObservableList<Part> selectedPart = associatedNewProductMenu.getSelectionModel().getSelectedItems();
        for(Part hotFilter : selectedPart){
            newProduct.deleteAssociatedPart(hotFilter);
        }
        associatedNewProductMenu.setItems(newProduct.getAllAssociatedParts());
    }
}
