package wgu.softwarejfx.software_1_fx_assignment_rework;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static wgu.softwarejfx.software_1_fx_assignment_rework.TestZone.testMethod;


/**
 * The java doc folder can be found at this path:  'src/main/resources.
 *
 *
 * A future enhancement that will be made to improve the functionality of the code will be separating the UI elements from the functional elements of the code as well as adding security by implementing a simple login form that will be displayed on runtime
 */
public class Inventory extends Application {

    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    /**
     *
     * @param newPart
     * This method adds parts to the all parts observable list
     */
    public static void addPart(Part newPart) {
        allParts.add(newPart);
    }

    /**
     *
     * @param partId
     * This method lookup part by taking a part's ID and returning the part
     *
     * @return
     * This method will return the requested part
     */
    public static Part lookupPart(int partId) {
        return allParts.get(partId);
    }

    /**
     *
     * @param partName
     * This method lookup part by taking a part's name and returning the part
     *
     * @return
     * This method will return the requested part
     */
    public static ObservableList<Part> lookupPart(String partName){
        ObservableList<Part> searchablePart = FXCollections.observableArrayList();
        for (Part partIterator : allParts){
            if (partIterator.getName().equals(partName)) {
                searchablePart.add(partIterator);
            }
        }
        return searchablePart;
    }

    /**
     *
     * @param index
     * This method will take a known part index and use it in-conjunction with the remaining existing part data
     *
     * @param selectedPart
     * This method will take existing part data and update it based on user input
     */
    public static void updatePart(int index, Part selectedPart){
        String name = selectedPart.getName();
        int stock = selectedPart.getStock();
        double price = selectedPart.getPrice();
        int min = selectedPart.getMin();
        int max = selectedPart.getMax();

        if (allParts.get(index) != null){
            allParts.get(index).setName(name);
            allParts.get(index).setPrice(price);
            allParts.get(index).setStock(stock);
            allParts.get(index).setMin(min);
            allParts.get(index).setMax(max);
        }
    }

    /**
     *
     * @param selectedPart
     * This method will take existing part data and delete it
     * @return
     * This method will take existing part data and remove the data from the observable list using the remove function of the list
     */
    public static boolean deletePart(Part selectedPart){
        return allParts.remove(selectedPart);
    }

    /**
     *
     * @param newProduct
     * This method adds parts to the all products observable list
     */
    public static void addProduct(Product newProduct) {
        allProducts.add(newProduct);
    }

    /**
     *
     * @param productId
     * This method lookup part by taking a product's ID and returning the product
     *
     * @return
     * This method will return the requested product
     *
     */
    public static Product lookupProduct(int productId) {
        return allProducts.get(productId);
    }

    /**
     *
     * @param productName
     * This method lookup part by taking a product's name and returning the product
     *
     * @return
     * This method will return the requested product
     *
     */
    public static ObservableList<Product> lookupProduct(String productName){
        ObservableList<Product> searchableProduct = FXCollections.observableArrayList();
        for (Product productIterator : allProducts){
            if(productIterator.getName().equals(productName)){
                searchableProduct.add(productIterator);
            }
        }
        return searchableProduct;
    }

    /**
     *
     * @param index
     * This method will take a known product index and use it in-conjunction with the remaining existing product data
     *
     * @param selectedProduct
     * This method will take existing product data and update it based on user input
     *
     */
    public static void updateProduct(int index, Product selectedProduct){
        String name = selectedProduct.getName();
        int stock = selectedProduct.getStock();
        double price = selectedProduct.getPrice();
        int min = selectedProduct.getMin();
        int max = selectedProduct.getMax();

        if (allProducts.get(index) != null){
            allProducts.get(index).setName(name);
            allProducts.get(index).setPrice(price);
            allProducts.get(index).setStock(stock);
            allProducts.get(index).setMin(min);
            allProducts.get(index).setMax(max);
        }
    }

    /**
     *
     * @param selectedProduct
     * This method will take existing product data and delete it
     *
     * @return
     * This method will take existing product data and remove the data from the observable list using the remove function of the list
     *
     */
    public static boolean deleteProduct(Product selectedProduct){
        allProducts.remove(selectedProduct);
        return true;
    }

    /**
     *
     * @return
     * This method will return all parts
     *
     */
    public static ObservableList<Part> getAllParts(){
        return allParts;
    }

    /**
     *
     * @return
     * This method will return all product
     */
    public static ObservableList<Product> getAllProducts(){
        return allProducts;
    }

    public static Scene toastyScene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Inventory.class.getResource("MainMenu.fxml"));
        toastyScene = new Scene(fxmlLoader.load());
        stage.setTitle("Inventory Management System");
        stage.setScene(toastyScene);
        stage.show();
    }



    /**
     *
     * @param args
     * This method runs the program
     *
     *
     * A future enhancement that will be made to improve the functionality of the code will be separating the UI elements
     * from the functional elements of the code as well as adding security by implementing a simple login form that will be displayed on runtime
     */
    public static void main(String[] args) {
        launch();
//        testMethod();
    }
}