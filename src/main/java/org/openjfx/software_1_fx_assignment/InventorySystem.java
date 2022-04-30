package org.openjfx.software_1_fx_assignment;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.function.Predicate;


import static javafx.geometry.HPos.CENTER;
import static javafx.geometry.HPos.LEFT;

/**
 * The java doc folder can be found at this path:  src/main/resources/org/openjfx/software_1_fx_assignment
 *
 *
 * A future enhancement that will be made to improve the functionality of the code will be separating the UI elements from the functional elements of the code as well as adding security by implementing a simple login form that will be displayed on runtime
 */
public class InventorySystem extends Application {

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
     *This method lookup part by taking a part's name and returning the part
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


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    //Events Methods &  Related Fields
    public static Scene toastyScene;
    public static Stage toastyStage;

    public static String newPartName;
    public static double newPartPrice;
    public static int newPartStock;
    public static int newPartMin;
    public static int newPartMax;
    public static String modifyPartName;
    public static double modifyPartPrice;
    public static int modifyPartStock;
    public static int modifyPartMin;
    public static int modifyPartMax;

    public static String newProductName;
    public static double newProductPrice;
    public static int newProductStock;
    public static int newProductMin;
    public static int newProductMax;
    public static String modifyProductName;
    public static double modifyProductPrice;
    public static int modifyProductStock;
    public static int modifyProductMin;
    public static int modifyProductMax;


    /**
     *
     * @param stock
     * The new part stock takes the new part's stock text-field to verify whether the appropriate data type has been entered
     *
     * @return
     * If the right data type is entered it will return that data type otherwise it will return 0
     */

    //Validators
        public static int newPartStock(TextField stock){
            try{
                newPartStock = Integer.parseInt(stock.getText());
                return newPartStock;
            }catch(NumberFormatException e){
                GridPane error = new GridPane();
                Text errorInfo = new Text("Part Inventory Error: Input Value must be a whole number");
                errorInfo.setFont(new Font(20));
                Button errorInfoCloseButton = new Button("Close");
                error.getChildren().add(errorInfo);
                error.getChildren().add(errorInfoCloseButton);
                GridPane.setConstraints(errorInfoCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
                GridPane.setConstraints(errorInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));
                closeProgram(errorInfoCloseButton);
                Stage popUp = new Stage();
                Scene errorScene = new Scene(error);
                popUp.setTitle("Error");
                popUp.setScene(errorScene);
                popUp.sizeToScene();
                popUp.show();
                return 0;
            }
        }

    /**
     *
     * @param min
     * The new part min takes the new part's min text-field to verify whether the appropriate data type has been entered
     *
     * @return
     * If the right data type is entered it will return that data type otherwise it will return 0
     */
    public static int newPartMin(TextField min){
            try{
                newPartMin = Integer.parseInt(min.getText());
                return newPartMin;
            }catch(NumberFormatException e){
                GridPane error = new GridPane();
                Text errorInfo = new Text("Part Min Error: Input Value must be a whole number");
                errorInfo.setFont(new Font(20));
                Button errorInfoCloseButton = new Button("Close");
                error.getChildren().add(errorInfo);
                error.getChildren().add(errorInfoCloseButton);
                GridPane.setConstraints(errorInfoCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
                GridPane.setConstraints(errorInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));
                closeProgram(errorInfoCloseButton);
                Stage popUp = new Stage();
                Scene errorScene = new Scene(error);
                popUp.setTitle("Error");
                popUp.setScene(errorScene);
                popUp.sizeToScene();
                popUp.show();
                return 0;
            }
        }

    /**
     *
     * @param max
     * The new part max takes the new part's max text-field to verify whether the appropriate data type has been entered
     *
     * @return
     * If the right data type is entered it will return that data type otherwise it will return 0
     */
    public static int newPartMax(TextField max){
            try{
                newPartMax = Integer.parseInt(max.getText());
                return newPartMax;
            }catch(NumberFormatException e){
                GridPane error = new GridPane();
                Text errorInfo = new Text("Part Max Error: Input Value must be a whole number");
                errorInfo.setFont(new Font(20));
                Button errorInfoCloseButton = new Button("Close");
                error.getChildren().add(errorInfo);
                error.getChildren().add(errorInfoCloseButton);
                GridPane.setConstraints(errorInfoCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
                GridPane.setConstraints(errorInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));
                closeProgram(errorInfoCloseButton);
                Stage popUp = new Stage();
                Scene errorScene = new Scene(error);
                popUp.setTitle("Error");
                popUp.setScene(errorScene);
                popUp.sizeToScene();
                popUp.show();
                return 0;
            }
        }

    /**
     *
     * @param price
     * The new part price takes the new part's price text-field to verify whether the appropriate data type has been entered
     *
     * @return
     * If the right data type is entered it will return that data type otherwise it will return 0
     */
    public static double newPartPrice(TextField price){
            try{
                newPartPrice = Double.parseDouble(price.getText());
                return newPartPrice;
            }catch(NumberFormatException e){
                GridPane error = new GridPane();
                Text errorInfo = new Text("Part Price Error: Input Value must be a decimal");
                errorInfo.setFont(new Font(20));
                Button errorInfoCloseButton = new Button("Close");
                error.getChildren().add(errorInfo);
                error.getChildren().add(errorInfoCloseButton);
                GridPane.setConstraints(errorInfoCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
                GridPane.setConstraints(errorInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));
                closeProgram(errorInfoCloseButton);
                Stage popUp = new Stage();
                Scene errorScene = new Scene(error);
                popUp.setTitle("Error");
                popUp.setScene(errorScene);
                popUp.sizeToScene();
                popUp.show();
                return 0;
            }
        }

    /**
     *
     * @param name
     * The new part name takes the new part's name text-field to verify whether the appropriate data type has been entered
     *
     * @return
     * If the right data type is entered it will return that data type otherwise it will return null
     */
    public static String newPartName(TextField name){
                try{
                    newPartName = name.getText();
                    return newPartName;
                }catch(NumberFormatException e){
                    GridPane error = new GridPane();
                    Text errorInfo = new Text("Part Name Error: Input Value must be a alpha-numeric characters");
                    errorInfo.setFont(new Font(20));
                    Button errorInfoCloseButton = new Button("Close");
                    error.getChildren().add(errorInfo);
                    error.getChildren().add(errorInfoCloseButton);
                    GridPane.setConstraints(errorInfoCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
                    GridPane.setConstraints(errorInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));
                    closeProgram(errorInfoCloseButton);
                    Stage popUp = new Stage();
                    Scene errorScene = new Scene(error);
                    popUp.setTitle("Error");
                    popUp.setScene(errorScene);
                    popUp.sizeToScene();
                    popUp.show();
                    return null;
                }
            }

    /**
     *
     * @param stock
     * The new product stock takes the new product's stock text-field to verify whether the appropriate data type has been entered
     *
     * @return
     * If the right data type is entered it will return that data type otherwise it will return 0
     */
    public static int newProductStock(TextField stock){
            try{
                newProductStock = Integer.parseInt(stock.getText());
                return newProductStock;
            }catch(NumberFormatException e){
                GridPane error = new GridPane();
                Text errorInfo = new Text("Product Inventory Error: Input Value must be a whole number");
                errorInfo.setFont(new Font(20));
                Button errorInfoCloseButton = new Button("Close");
                error.getChildren().add(errorInfo);
                error.getChildren().add(errorInfoCloseButton);
                GridPane.setConstraints(errorInfoCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
                GridPane.setConstraints(errorInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));
                closeProgram(errorInfoCloseButton);
                Stage popUp = new Stage();
                Scene errorScene = new Scene(error);
                popUp.setTitle("Error");
                popUp.setScene(errorScene);
                popUp.sizeToScene();
                popUp.show();
                return 0;
            }
        }

    /**
     *
     * @param min
     * The new product min takes the new product's min text-field to verify whether the appropriate data type has been entered
     *
     * @return
     * If the right data type is entered it will return that data type otherwise it will return 0
     */
    public static int newProductMin(TextField min){
            try{
                newProductMin = Integer.parseInt(min.getText());
                return newProductMin;
            }catch(NumberFormatException e){
                GridPane error = new GridPane();
                Text errorInfo = new Text("Product Min Error: Input Value must be a whole number");
                errorInfo.setFont(new Font(20));
                Button errorInfoCloseButton = new Button("Close");
                error.getChildren().add(errorInfo);
                error.getChildren().add(errorInfoCloseButton);
                GridPane.setConstraints(errorInfoCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
                GridPane.setConstraints(errorInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));
                closeProgram(errorInfoCloseButton);
                Stage popUp = new Stage();
                Scene errorScene = new Scene(error);
                popUp.setTitle("Error");
                popUp.setScene(errorScene);
                popUp.sizeToScene();
                popUp.show();
                return 0;
            }
        }

    /**
     *
     * @param max
     * The new product max takes the new product's max text-field to verify whether the appropriate data type has been entered
     *
     * @return
     * If the right data type is entered it will return that data type otherwise it will return 0
     */
    public static int newProductMax(TextField max){
            try{
                newProductMax = Integer.parseInt(max.getText());
                return newProductMax;
            }catch(NumberFormatException e){
                GridPane error = new GridPane();
                Text errorInfo = new Text("Product Max Error: Input Value must be a whole number");
                errorInfo.setFont(new Font(20));
                Button errorInfoCloseButton = new Button("Close");
                error.getChildren().add(errorInfo);
                error.getChildren().add(errorInfoCloseButton);
                GridPane.setConstraints(errorInfoCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
                GridPane.setConstraints(errorInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));
                closeProgram(errorInfoCloseButton);
                Stage popUp = new Stage();
                Scene errorScene = new Scene(error);
                popUp.setTitle("Error");
                popUp.setScene(errorScene);
                popUp.sizeToScene();
                popUp.show();
                return 0;
            }
        }

    /**
     *
     * @param price
     * The new product price takes the new product's price text-field to verify whether the appropriate data type has been entered
     *
     * @return
     * If the right data type is entered it will return that data type otherwise it will return 0
     */
    public static double newProductPrice(TextField price){
            try{
                newProductPrice = Double.parseDouble(price.getText());
                return newProductPrice;
            }catch(NumberFormatException e){
                GridPane error = new GridPane();
                Text errorInfo = new Text("Product Price Error: Input Value must be a decimal");
                errorInfo.setFont(new Font(20));
                Button errorInfoCloseButton = new Button("Close");
                error.getChildren().add(errorInfo);
                error.getChildren().add(errorInfoCloseButton);
                GridPane.setConstraints(errorInfoCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
                GridPane.setConstraints(errorInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));
                closeProgram(errorInfoCloseButton);
                Stage popUp = new Stage();
                Scene errorScene = new Scene(error);
                popUp.setTitle("Error");
                popUp.setScene(errorScene);
                popUp.sizeToScene();
                popUp.show();
                return 0;
            }
        }

    /**
     *
     * @param name
     * The new product name takes the new product's name text-field to verify whether the appropriate data type has been entered
     *
     * @return
     * If the right data type is entered it will return that data type otherwise it will return null
     */
    public static String newProductName(TextField name){
            try{
                newProductName = name.getText();
                return newProductName;
            }catch(NumberFormatException e){
                GridPane error = new GridPane();
                Text errorInfo = new Text("Product Name Error: Input Value must be a alpha-numeric characters");
                errorInfo.setFont(new Font(20));
                Button errorInfoCloseButton = new Button("Close");
                error.getChildren().add(errorInfo);
                error.getChildren().add(errorInfoCloseButton);
                GridPane.setConstraints(errorInfoCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
                GridPane.setConstraints(errorInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));
                closeProgram(errorInfoCloseButton);
                Stage popUp = new Stage();
                Scene errorScene = new Scene(error);
                popUp.setTitle("Error");
                popUp.setScene(errorScene);
                popUp.sizeToScene();
                popUp.show();
                return null;
            }
        }

    /**
     *
     * @param stock
     * The modified part stock takes the modified part's stock text-field to verify whether the appropriate data type has been entered
     *
     * @return
     * If the right data type is entered it will return that data type otherwise it will return 0
     */
        public static int modifyPartStock(TextField stock){
            try{
                modifyPartStock = Integer.parseInt(stock.getText());
                return modifyPartStock;
            }catch(NumberFormatException e){
                GridPane error = new GridPane();
                Text errorInfo = new Text("Part Inventory Error: Input Value must be a whole number");
                errorInfo.setFont(new Font(20));
                Button errorInfoCloseButton = new Button("Close");
                error.getChildren().add(errorInfo);
                error.getChildren().add(errorInfoCloseButton);
                GridPane.setConstraints(errorInfoCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
                GridPane.setConstraints(errorInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));
                closeProgram(errorInfoCloseButton);
                Stage popUp = new Stage();
                Scene errorScene = new Scene(error);
                popUp.setTitle("Error");
                popUp.setScene(errorScene);
                popUp.sizeToScene();
                popUp.show();
                return 0;
            }
        }

    /**
     *
     * @param min
     * The modified part min takes the modified part's min text-field to verify whether the appropriate data type has been entered
     *
     * @return
     * If the right data type is entered it will return that data type otherwise it will return 0
     */
    public static int modifyPartMin(TextField min){
            try{
                modifyPartMin = Integer.parseInt(min.getText());
                return modifyPartMin;
            }catch(NumberFormatException e){
                GridPane error = new GridPane();
                Text errorInfo = new Text("Part Min Error: Input Value must be a whole number");
                errorInfo.setFont(new Font(20));
                Button errorInfoCloseButton = new Button("Close");
                error.getChildren().add(errorInfo);
                error.getChildren().add(errorInfoCloseButton);
                GridPane.setConstraints(errorInfoCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
                GridPane.setConstraints(errorInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));
                closeProgram(errorInfoCloseButton);
                Stage popUp = new Stage();
                Scene errorScene = new Scene(error);
                popUp.setTitle("Error");
                popUp.setScene(errorScene);
                popUp.sizeToScene();
                popUp.show();
                return 0;
            }
        }

    /**
     *
     * @param max
     * The modified part max takes the modified part's max text-field to verify whether the appropriate data type has been entered
     *
     * @return
     * If the right data type is entered it will return that data type otherwise it will return 0
     */
    public static int modifyPartMax(TextField max){
            try{
                modifyPartMax = Integer.parseInt(max.getText());
                return modifyPartMax;
            }catch(NumberFormatException e){
                GridPane error = new GridPane();
                Text errorInfo = new Text("Part Max Error: Input Value must be a whole number");
                errorInfo.setFont(new Font(20));
                Button errorInfoCloseButton = new Button("Close");
                error.getChildren().add(errorInfo);
                error.getChildren().add(errorInfoCloseButton);
                GridPane.setConstraints(errorInfoCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
                GridPane.setConstraints(errorInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));
                closeProgram(errorInfoCloseButton);
                Stage popUp = new Stage();
                Scene errorScene = new Scene(error);
                popUp.setTitle("Error");
                popUp.setScene(errorScene);
                popUp.sizeToScene();
                popUp.show();
                return 0;
            }
        }

    /**
     *
     * @param price
     * The modified part price takes the modified part's price text-field to verify whether the appropriate data type has been entered
     *
     * @return
     * If the right data type is entered it will return that data type otherwise it will return 0
     */
    public static double modifyPartPrice(TextField price){
            try{
                modifyPartPrice = Double.parseDouble(price.getText());
                return modifyPartPrice;
            }catch(NumberFormatException e){
                GridPane error = new GridPane();
                Text errorInfo = new Text("Price Error: Input Value must be a decimal");
                errorInfo.setFont(new Font(20));
                Button errorInfoCloseButton = new Button("Close");
                error.getChildren().add(errorInfo);
                error.getChildren().add(errorInfoCloseButton);
                GridPane.setConstraints(errorInfoCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
                GridPane.setConstraints(errorInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));
                closeProgram(errorInfoCloseButton);
                Stage popUp = new Stage();
                Scene errorScene = new Scene(error);
                popUp.setTitle("Error");
                popUp.setScene(errorScene);
                popUp.sizeToScene();
                popUp.show();
                return 0;
            }
        }

    /**
     *
     * @param name
     * The modified part name takes the modified part's name text-field to verify whether the appropriate data type has been entered
     *
     * @return
     * If the right data type is entered it will return that data type otherwise it will return null
     */
    public static String modifyPartName(TextField name){
            try{
                modifyPartName = name.getText();
                return modifyPartName;
            }catch(NumberFormatException e){
                GridPane error = new GridPane();
                Text errorInfo = new Text("Name Error: Input Value must be a alpha-numeric characters");
                errorInfo.setFont(new Font(20));
                Button errorInfoCloseButton = new Button("Close");
                error.getChildren().add(errorInfo);
                error.getChildren().add(errorInfoCloseButton);
                GridPane.setConstraints(errorInfoCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
                GridPane.setConstraints(errorInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));
                closeProgram(errorInfoCloseButton);
                Stage popUp = new Stage();
                Scene errorScene = new Scene(error);
                popUp.setTitle("Error");
                popUp.setScene(errorScene);
                popUp.sizeToScene();
                popUp.show();
                return null;
            }
        }

    /**
     *
     * @param stock
     * The modified product stock takes the new product's stock text-field to verify whether the appropriate data type has been entered
     *
     * @return
     * If the right data type is entered it will return that data type otherwise it will return 0
     */
    public static int modifyProductStock(TextField stock){
            try{
                modifyProductStock = Integer.parseInt(stock.getText());
                return modifyProductStock;
            }catch(NumberFormatException e){
                GridPane error = new GridPane();
                Text errorInfo = new Text("Product Inventory Error: Input Value must be a whole number");
                errorInfo.setFont(new Font(20));
                Button errorInfoCloseButton = new Button("Close");
                error.getChildren().add(errorInfo);
                error.getChildren().add(errorInfoCloseButton);
                GridPane.setConstraints(errorInfoCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
                GridPane.setConstraints(errorInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));
                closeProgram(errorInfoCloseButton);
                Stage popUp = new Stage();
                Scene errorScene = new Scene(error);
                popUp.setTitle("Error");
                popUp.setScene(errorScene);
                popUp.sizeToScene();
                popUp.show();
                return 0;
            }
        }

    /**
     *
     * @param min
     * The modified product min takes the modified product's min text-field to verify whether the appropriate data type has been entered
     *
     * @return
     * If the right data type is entered it will return that data type otherwise it will return 0
     */
    public static int modifyProductMin(TextField min){
            try{
                modifyProductMin = Integer.parseInt(min.getText());
                return modifyProductMin;
            }catch(NumberFormatException e){
                GridPane error = new GridPane();
                Text errorInfo = new Text("Product Min Error: Input Value must be a whole number");
                errorInfo.setFont(new Font(20));
                Button errorInfoCloseButton = new Button("Close");
                error.getChildren().add(errorInfo);
                error.getChildren().add(errorInfoCloseButton);
                GridPane.setConstraints(errorInfoCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
                GridPane.setConstraints(errorInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));
                closeProgram(errorInfoCloseButton);
                Stage popUp = new Stage();
                Scene errorScene = new Scene(error);
                popUp.setTitle("Error");
                popUp.setScene(errorScene);
                popUp.sizeToScene();
                popUp.show();
                return 0;
            }
        }

    /**
     *
     * @param max
     * The modified product max takes the new product's max text-field to verify whether the appropriate data type has been entered
     *
     * @return
     * If the right data type is entered it will return that data type otherwise it will return 0
     */
    public static int modifyProductMax(TextField max){
            try{
                modifyProductMax = Integer.parseInt(max.getText());
                return modifyProductMax;
            }catch(NumberFormatException e){
                GridPane error = new GridPane();
                Text errorInfo = new Text("Product Max Error: Input Value must be a whole number");
                errorInfo.setFont(new Font(20));
                Button errorInfoCloseButton = new Button("Close");
                error.getChildren().add(errorInfo);
                error.getChildren().add(errorInfoCloseButton);
                GridPane.setConstraints(errorInfoCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
                GridPane.setConstraints(errorInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));
                closeProgram(errorInfoCloseButton);
                Stage popUp = new Stage();
                Scene errorScene = new Scene(error);
                popUp.setTitle("Error");
                popUp.setScene(errorScene);
                popUp.sizeToScene();
                popUp.show();
                return 0;
            }
        }

    /**
     *
     * @param price
     * The modified product price takes the modified product's price text-field to verify whether the appropriate data type has been entered
     *
     * @return
     * If the right data type is entered it will return that data type otherwise it will return 0
     */
    public static double modifyProductPrice(TextField price){
            try{
                modifyProductPrice = Double.parseDouble(price.getText());
                return modifyProductPrice;
            }catch(NumberFormatException e){
                GridPane error = new GridPane();
                Text errorInfo = new Text("Price Error: Input Value must be a decimal");
                errorInfo.setFont(new Font(20));
                Button errorInfoCloseButton = new Button("Close");
                error.getChildren().add(errorInfo);
                error.getChildren().add(errorInfoCloseButton);
                GridPane.setConstraints(errorInfoCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
                GridPane.setConstraints(errorInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));
                closeProgram(errorInfoCloseButton);
                Stage popUp = new Stage();
                Scene errorScene = new Scene(error);
                popUp.setTitle("Error");
                popUp.setScene(errorScene);
                popUp.sizeToScene();
                popUp.show();
                return 0;
            }
        }

    /**
     *
     * @param name
     * The modified product name takes the modified product's name text-field to verify whether the appropriate data type has been entered
     *
     * @return
     * If the right data type is entered it will return that data type otherwise it will return null
     */
    public static String modifyProductName(TextField name){
            try{
                modifyProductName = name.getText();
                return modifyProductName;
            }catch(NumberFormatException e){
                GridPane error = new GridPane();
                Text errorInfo = new Text("Name Error: Input Value must be an alphanumeric string");
                errorInfo.setFont(new Font(20));
                Button errorInfoCloseButton = new Button("Close");
                error.getChildren().add(errorInfo);
                error.getChildren().add(errorInfoCloseButton);
                GridPane.setConstraints(errorInfoCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
                GridPane.setConstraints(errorInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));
                closeProgram(errorInfoCloseButton);
                Stage popUp = new Stage();
                Scene errorScene = new Scene(error);
                popUp.setTitle("Error");
                popUp.setScene(errorScene);
                popUp.sizeToScene();
                popUp.show();
                return null;
            }
        }

    /**
     *
     * @param theNewScene
     * This method accepts theNewScene as a place it will go to
     * @param theMainScene
     * This method accepts theMainScene as a place it will return to
     * @param theOpenButton
     * This method accepts a button that will be used to go to theNewScene
     * @param theCloseButton
     * This method accepts a button that will be used to return to theMainScene
     */
        //Scene Change
        public static void sceneChanger(GridPane theNewScene, GridPane theMainScene,Button theOpenButton,Button theCloseButton){
            theOpenButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> toastyScene.setRoot(theNewScene));
            theCloseButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> toastyScene.setRoot(theMainScene));
        }

    /**
     *
     * @param theButton
     * This method accepts a button that will be used to close the currently open stage or node
     */
    //Close Program
        public static void closeProgram(Button theButton){
            theButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                Node source = (Node) event.getSource();
                Stage popUp = (Stage) source.getScene().getWindow();
                popUp.close();
            });
        }

    public static ObservableList<InHouse> inHouseParts = FXCollections.observableArrayList();
    public static ObservableList<Outsourced> outsourcedParts = FXCollections.observableArrayList();
    /**
     *
     * @param itemType
     * This method accepts a toggle group that will be used to determine which part type is being added
     * @param inHouse
     * This method accepts a radio button that is part of the toggle group, and it will be used in conjunction with the toggle group to determine the part type
     * @param outsourced
     * This method accepts a radio button that is part of the toggle group, and it will be used in conjunction with the toggle group to determine the part type
     * @param idSetter
     * This method accepts a button that will be used to perform some housekeeping on the text-fields
     * @param id
     * This method accepts a text-field that will be used to collect the part id
     * @param name
     * This method accepts a text-field that will be used to collect the part name
     * @param price
     * This method accepts a text-field that will be used to collect the part price
     * @param stock
     * This method accepts a text-field that will be used to collect the part stock
     * @param min
     * This method accepts a text-field that will be used to collect the part min
     * @param max
     * This method accepts a text-field that will be used to collect the part max
     * @param machineInfo
     * This method accepts a text-field that will be used to collect the machine information
     * @param addMachineId
     * This method accepts the machine info's text label and uses it to change the text displayed when the part type changes
     * @param saveButton
     * This method accepts a button that will be used to add new part the list as well as verify part data before submission
     * @param conformationSceneSuccess
     * This method accepts a grid pane that will be used to display success info
     * @param conformationSceneFailed
     * This method accepts a grid pane that will be used to display failed info
     * @param newPartsTable
     * This method accepts components table that will be manipulated in the process af add a new part
     */
        //Add Part TextField Use

        public static void saveNewPart(ToggleGroup itemType, RadioButton inHouse, RadioButton outsourced,
                                       Button idSetter, TextField id, TextField name, TextField price,
                                       TextField stock, TextField min, TextField max, TextField machineInfo, Text addMachineId,
                                       Button saveButton, GridPane conformationSceneSuccess, GridPane conformationSceneFailed,
                                        TableView<Part> newPartsTable) {

            idSetter.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                id.setPromptText("Auto Generated");
                id.setDisable(true);
                id.setEditable(false);
                name.clear();
                price.clear();
                stock.clear();
                min.clear();
                max.clear();
                machineInfo.clear();
            });

            itemType.selectedToggleProperty().addListener((observableValue, toggle, newToggle) -> {
                if (newToggle == inHouse){
                    addMachineId.setText("Machine ID");
                }
                else if (newToggle == outsourced){
                    addMachineId.setText("Company Name");
                }
                else {
                    addMachineId.setText("Machine ID");
                }
            });


            saveButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                RadioButton tt = (RadioButton) itemType.getSelectedToggle();
                String itemTypeText = tt.getText();

                if(newPartMin(min) > newPartMax(max)){
                    GridPane error = new GridPane();
                    Text errorInfo = new Text("Min & Max Error: Max should be greater then Min");
                    errorInfo.setFont(new Font(20));
                    Button errorInfoCloseButton = new Button("Close");
                    error.getChildren().add(errorInfo);
                    error.getChildren().add(errorInfoCloseButton);
                    GridPane.setConstraints(errorInfoCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
                    GridPane.setConstraints(errorInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));
                    closeProgram(errorInfoCloseButton);
                    Stage popUp = new Stage();
                    Scene errorScene = new Scene(error);
                    popUp.setTitle("Error");
                    popUp.setScene(errorScene);
                    popUp.sizeToScene();
                    popUp.show();
                }
                else if(newPartStock(stock) > newPartMax(max) || newPartStock(stock) < newPartMin(min)){
                    GridPane error = new GridPane();
                    Text errorInfo = new Text("Stock Error: Stock must be between Min & Max");
                    errorInfo.setFont(new Font(20));
                    Button errorInfoCloseButton = new Button("Close");
                    error.getChildren().add(errorInfo);
                    error.getChildren().add(errorInfoCloseButton);
                    GridPane.setConstraints(errorInfoCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
                    GridPane.setConstraints(errorInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));
                    closeProgram(errorInfoCloseButton);
                    Stage popUp = new Stage();
                    Scene errorScene = new Scene(error);
                    popUp.setTitle("Error");
                    popUp.setScene(errorScene);
                    popUp.sizeToScene();
                    popUp.show();
                }

                else if (itemTypeText.equals("In-House") && (newPartName(name) != null && newPartPrice(price) != 0 && newPartMax(max) != 0)){
                    int newMachineInfo = Integer.parseInt(machineInfo.getText());
                    InHouse newInHousePart = new InHouse(allParts.size()+1, newPartName(name), newPartPrice(price), newPartStock(stock), newPartMin(min), newPartMax(max),newMachineInfo);
                    newInHousePart.setMachineId(newMachineInfo);
                    addPart(newInHousePart);
                    newPartsTable.setItems(getAllParts());
                    inHouseParts.add(newInHousePart);
                    toastyScene.setRoot(conformationSceneSuccess);
                }
                else if(itemTypeText.equals("Outsourced") && (newPartName(name) != null && newPartPrice(price) != 0 && newPartMax(max) != 0)) {
                    String newMachineInfo = machineInfo.getText();
                    Outsourced newOutsourcedPart = new Outsourced(allParts.size()+1, newPartName(name), newPartPrice(price), newPartStock(stock), newPartMin(min), newPartMax(max), newMachineInfo);
                    newOutsourcedPart.setCompanyName(newMachineInfo);
                    addPart(newOutsourcedPart);
                    newPartsTable.setItems(getAllParts());
                    outsourcedParts.add(newOutsourcedPart);
                    toastyScene.setRoot(conformationSceneSuccess);
                }
                else {
                    toastyScene.setRoot(conformationSceneFailed);
                }

            });
        }


        public static Product newProduct;
        //Add Product TextField Use


    /**
     *
     * @param idSetter
     * This method accepts a button that will be used to perform some housekeeping on the text-fields
     * @param id
     * This method accepts a text-field that will be used to collect the product id
     * @param name
     * This method accepts a text-field that will be used to collect the product name
     * @param price
     * This method accepts a text-field that will be used to collect the product price
     * @param stock
     * This method accepts a text-field that will be used to collect the product stock
     * @param min
     * This method accepts a text-field that will be used to collect the product min
     * @param max
     * This method accepts a text-field that will be used to collect the product max
     * @param saveButton
     * This method accepts a button that will be used to add new part the list as well as verify part data before submission
     * @param addSelectedPartButton
     * This method accepts a button that will be used to add parts to the associated parts table
     * @param removeSelectedPartButton
     * This method accepts a button that will be used to remove parts from the associated parts table
     * @param conformationSceneSuccess
     * This method accepts a grid pane that will be used to display success info
     * @param conformationSceneFailed
     * This method accepts a grid pane that will be used to display failed info
     * @param partsTable
     * This method accepts components table that will be manipulated in the process af add a new product
     * @param associatedPartsTable
     * This method accepts components table that will be manipulated in the process af add a new product
     * @param productTableView
     * This method accepts components table that will be manipulated in the process af add a new product
     */
        public static void saveNewProduct(
                                       Button idSetter, TextField id, TextField name, TextField price, TextField stock, TextField min, TextField max,
                                       Button saveButton, Button addSelectedPartButton, Button removeSelectedPartButton,
                                       GridPane conformationSceneSuccess, GridPane conformationSceneFailed,
                                       TableView<Part> partsTable, TableView<Part> associatedPartsTable, TableView<Product> productTableView, TextField searchbar){

            idSetter.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                id.setPromptText("Auto Generated");
                id.setDisable(true);
                id.setEditable(false);
                name.clear();
                price.clear();
                stock.clear();
                min.clear();
                max.clear();
                associatedPartsTable.getItems().clear();
            });
            newProduct = new Product(0,"name",0.0,0,0,0);
            addSelectedPartButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                newProduct.setId(allProducts.size()+1);
                newProduct.setName(newProductName(name));
                newProduct.setPrice(newProductPrice(price));
                newProduct.setStock(newProductStock(stock));
                newProduct.setMin(newProductMin(min));
                newProduct.setMax(newProductMax(max));

                ObservableList<Part> selectedPart = partsTable.getSelectionModel().getSelectedItems();
                    for(Part hotFilter : selectedPart){
                        newProduct.addAssociatedParts(hotFilter);
                    }
                    associatedPartsTable.setItems(newProduct.getAllAssociatedParts());

            });

            removeSelectedPartButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                ObservableList<Part> selectedPart = associatedPartsTable.getSelectionModel().getSelectedItems();
                for(Part hotFilter : selectedPart){
                    newProduct.deleteAssociatedPart(hotFilter);
                }
                associatedPartsTable.setItems(newProduct.getAllAssociatedParts());
            });

            saveButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

                if(newProductMin(min) > newProductMax(max)){
                    GridPane error = new GridPane();
                    Text errorInfo = new Text("Min & Max Error: Max should be greater then Min");
                    errorInfo.setFont(new Font(20));
                    Button errorInfoCloseButton = new Button("Close");
                    error.getChildren().add(errorInfo);
                    error.getChildren().add(errorInfoCloseButton);
                    GridPane.setConstraints(errorInfoCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
                    GridPane.setConstraints(errorInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));
                    closeProgram(errorInfoCloseButton);
                    Stage popUp = new Stage();
                    Scene errorScene = new Scene(error);
                    popUp.setTitle("Error");
                    popUp.setScene(errorScene);
                    popUp.sizeToScene();
                    popUp.show();
                }
               else if(newProductStock(stock) > newProductMax(max) || newProductStock(stock) < newProductMin(min)){
                    GridPane error = new GridPane();
                    Text errorInfo = new Text("Stock Error: Stock must be between Min & Max");
                    errorInfo.setFont(new Font(20));
                    Button errorInfoCloseButton = new Button("Close");
                    error.getChildren().add(errorInfo);
                    error.getChildren().add(errorInfoCloseButton);
                    GridPane.setConstraints(errorInfoCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
                    GridPane.setConstraints(errorInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));
                    closeProgram(errorInfoCloseButton);
                    Stage popUp = new Stage();
                    Scene errorScene = new Scene(error);
                    popUp.setTitle("Error");
                    popUp.setScene(errorScene);
                    popUp.sizeToScene();
                    popUp.show();
                }


               else if(newProductName(name) != null && newProductPrice(price) != 0 && newProductMax(max) != 0){
                    newProduct.setId(allProducts.size()+1);
                    newProduct.setName(newProductName(name));
                    newProduct.setPrice(newProductPrice(price));
                    newProduct.setStock(newProductStock(stock));
                    newProduct.setMin(newProductMin(min));
                    newProduct.setMax(newProductMax(max));
                    addProduct(newProduct);
                    productTableView.setItems(allProducts);
                    searchProduct(searchbar,productTableView);
                    toastyScene.setRoot(conformationSceneSuccess);
                }else {
                    toastyScene.setRoot(conformationSceneFailed);
                }



            });
        }


    /**
     *
     * @param theButton
     * This method accepts a button that will be used to delete the selected part
     * @param conformationSceneSuccess
     * This method accepts a grid pane that will be used to display success info
     * @param partsTable
     * This method accepts components table that will be manipulated in the process of removing a part
     */
    //Delete Part
        public static void deleteSelectedPart(Button theButton, GridPane conformationSceneSuccess,TableView<Part> partsTable){
                theButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                    ObservableList<Part> selectedPart = partsTable.getSelectionModel().getSelectedItems();
                    if (partsTable.getSelectionModel().getSelectedItems() != null) {
                        for (Part hotFilter : selectedPart) {
                            deletePart(hotFilter);
                            partsTable.setItems(getAllParts());
                            toastyScene.setRoot(conformationSceneSuccess);
                        }
                    }

                });
            }


    /**
     *
     * @param theButton
     * This method accepts a button that will be used to delete the selected product
     * @param conformationSceneSuccess
     * This method accepts a grid pane that will be used to display success info
     * @param productsTable
     * This method accepts components table that will be manipulated in the process of removing a product
     */
    //Delete Product
        public static void deleteSelectedProduct(Button theButton, GridPane conformationSceneSuccess,TableView<Product> productsTable){
        theButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ObservableList<Product> selectedPart = productsTable.getSelectionModel().getSelectedItems();
            if (productsTable.getSelectionModel().getSelectedItems() != null) {
                for (Product hotFilter : selectedPart) {
                    deleteProduct(hotFilter);
                    hotFilter.getAllAssociatedParts().clear();
                    productsTable.setItems(getAllProducts());
                    toastyScene.setRoot(conformationSceneSuccess);
                }
            }
        });
    }

    /**
     *
     */
        public static int existingPartID;

    /**
     *
     * @param partType
     * This method accepts a toggle group that will be used to determine which part type is being added
     * @param idSetter
     * This method accepts a button that will be used to perform some housekeeping on the text-fields
     * @param inHouse
     * This method accepts a radio button that is part of the toggle group, and it will be used in conjunction with the toggle group to determine the part type
     * @param outsourced
     * This method accepts a radio button that is part of the toggle group, and it will be used in conjunction with the toggle group to determine the part type
     * @param id
     * This method accepts a text-field that will be used to collect the part id
     * @param name
     * This method accepts a text-field that will be used to collect the part name
     * @param price
     * This method accepts a text-field that will be used to collect the part price
     * @param stock
     * This method accepts a text-field that will be used to collect the part stock
     * @param min
     * This method accepts a text-field that will be used to collect the part min
     * @param max
     * This method accepts a text-field that will be used to collect the part max
     * @param machineInfo
     * This method accepts a text-field that will be used to collect the machine information
     * @param modifyMachineID
     * This method accepts the machine info's text label and uses it to change the text displayed when the part type changes
     * @param saveButton
     * This method accepts a button that will be used to add new part the list as well as verify part data before submission
     * @param conformationSceneSuccess
     * This method accepts a grid pane that will be used to display success info
     * @param conformationSceneFailed
     * This method accepts a grid pane that will be used to display failed info
     * @param partsTableView
     * This method accepts components table that will be manipulated in the process of updating a part
     */
        //Modify Part
        public static void modifyPart(ToggleGroup partType, Button idSetter, RadioButton inHouse, RadioButton outsourced,
                                      TextField id, TextField name, TextField price,
                                      TextField stock, TextField min, TextField max, TextField machineInfo, Text modifyMachineID,
                                      Button saveButton, GridPane conformationSceneSuccess, GridPane conformationSceneFailed, TableView<Part> partsTableView){

            idSetter.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                String testy = String.valueOf(partsTableView.getSelectionModel().selectedItemProperty().get().getId());
                if(!testy.isEmpty()){
                    existingPartID = partsTableView.getSelectionModel().selectedItemProperty().get().getId();
                    id.setText(String.valueOf(existingPartID));
                    id.setEditable(false);
                    id.setDisable(true);
                    name.setText(partsTableView.getSelectionModel().selectedItemProperty().get().getName());
                    price.setText(String.valueOf(partsTableView.getSelectionModel().selectedItemProperty().get().getPrice()));
                    stock.setText(String.valueOf(partsTableView.getSelectionModel().selectedItemProperty().get().getStock()));
                    min.setText(String.valueOf(partsTableView.getSelectionModel().selectedItemProperty().get().getMin()));
                    max.setText(String.valueOf(partsTableView.getSelectionModel().selectedItemProperty().get().getMax()));

                    if(Objects.equals(partsTableView.getSelectionModel().selectedItemProperty().get().getName(), inHouseParts.get(existingPartID - 1).getName())){
                        machineInfo.setText(String.valueOf(inHouseParts.get(existingPartID-1).getMachineId()));
                    }
                    else if(Objects.equals(partsTableView.getSelectionModel().selectedItemProperty().get().getName(), outsourcedParts.get(existingPartID - 1).getName())){
                        machineInfo.setText(String.valueOf(outsourcedParts.get(existingPartID-1).getCompanyName()));
                    }


                }else{
                    toastyScene.setRoot(conformationSceneFailed);
                }
            });

            partType.selectedToggleProperty().addListener((observableValue, toggle, newToggle) -> {
                if (newToggle == inHouse){
                    modifyMachineID.setText("Machine ID");
                }
                else if (newToggle == outsourced){
                    modifyMachineID.setText("Company Name");
                }
                else {
                    modifyMachineID.setText("Machine ID");
                }
            });


            saveButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                RadioButton tt = (RadioButton) partType.getSelectedToggle();
                String itemTypeText = tt.getText();

                if(modifyPartMin(min) > modifyPartMax(max)){
                    GridPane error = new GridPane();
                    Text errorInfo = new Text("Min & Max Error: Max should be greater then Min");
                    errorInfo.setFont(new Font(20));
                    Button errorInfoCloseButton = new Button("Close");
                    error.getChildren().add(errorInfo);
                    error.getChildren().add(errorInfoCloseButton);
                    GridPane.setConstraints(errorInfoCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
                    GridPane.setConstraints(errorInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));
                    closeProgram(errorInfoCloseButton);
                    Stage popUp = new Stage();
                    Scene errorScene = new Scene(error);
                    popUp.setTitle("Error");
                    popUp.setScene(errorScene);
                    popUp.sizeToScene();
                    popUp.show();
                }
                else if(modifyPartStock(stock) > modifyPartMax(max) || modifyPartStock(stock) < modifyPartMin(min)){
                    GridPane error = new GridPane();
                    Text errorInfo = new Text("Stock Error: Stock must be between Min & Max");
                    errorInfo.setFont(new Font(20));
                    Button errorInfoCloseButton = new Button("Close");
                    error.getChildren().add(errorInfo);
                    error.getChildren().add(errorInfoCloseButton);
                    GridPane.setConstraints(errorInfoCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
                    GridPane.setConstraints(errorInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));
                    closeProgram(errorInfoCloseButton);
                    Stage popUp = new Stage();
                    Scene errorScene = new Scene(error);
                    popUp.setTitle("Error");
                    popUp.setScene(errorScene);
                    popUp.sizeToScene();
                    popUp.show();
                }

                else if (itemTypeText.equals("In-House") && (newPartName(name) != null && newPartPrice(price) != 0 && newPartMax(max) != 0)){
                    int newMachineInfo = Integer.parseInt(machineInfo.getText());
                    InHouse newPart = new InHouse(existingPartID,modifyPartName(name),modifyPartPrice(price),modifyPartStock(stock),modifyPartMin(min),modifyPartMax(max),newMachineInfo);
                    updatePart(existingPartID,newPart);
                    toastyScene.setRoot(conformationSceneSuccess);
                }
                else if(itemTypeText.equals("Outsourced") && (newPartName(name) != null && newPartPrice(price) != 0 && newPartMax(max) != 0)){
                    String newMachineInfo = machineInfo.getText();
                    Outsourced newPart = new Outsourced(existingPartID,modifyPartName(name),modifyPartPrice(price),modifyPartStock(stock),modifyPartMin(min),modifyPartMax(max),newMachineInfo);
                    updatePart(existingPartID,newPart);
                    toastyScene.setRoot(conformationSceneSuccess);
                }
                else{
                    toastyScene.setRoot(conformationSceneFailed);
                }
            });
        }

    /**
     *
     */
    public static int existingProductID;

    /**
     *
     * @param id
     * This method accepts a text-field that will be used to collect the part id
     * @param name
     * This method accepts a text-field that will be used to collect the part name
     * @param price
     * This method accepts a text-field that will be used to collect the part price
     * @param stock
     * This method accepts a text-field that will be used to collect the part stock
     * @param min
     * This method accepts a text-field that will be used to collect the part min
     * @param max
     * This method accepts a text-field that will be used to collect the part max
     * @param saveButton
     * This method accepts a button that will be used to add new part the list as well as verify product data before submission
     * @param addSelectedPartButton
     * This method accepts a button that will be used to add parts to the associated parts table
     * @param removeSelectedPartButton
     * This method accepts a button that will be used to remove parts from the associated parts table
     * @param modifyButton
     * This method accepts a button that will be used to perform some housekeeping on the text-fields
     * @param conformationSceneSuccess
     * This method accepts a grid pane that will be used to display success info
     * @param conformationSceneFailed
     * This method accepts a grid pane that will be used to display failed info
     * @param partsTable
     * This method accepts components table that will be manipulated in the process af add a modified product
     * @param associatedPartsTable
     * This method accepts components table that will be manipulated in the process af add a modified product
     * @param productsTable
     * This method accepts components table that will be manipulated in the process af add a modified product
     */
        //Modify Product
        public static void modifyProduct(TextField id, TextField name, TextField price,
                                      TextField stock, TextField min, TextField max,
                                      Button saveButton, Button addSelectedPartButton, Button removeSelectedPartButton, Button modifyButton,
                                      GridPane conformationSceneSuccess, GridPane conformationSceneFailed,
                                      TableView<Part> partsTable, TableView<Part> associatedPartsTable,
                                      TableView<Product> productsTable){

            modifyButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                String testy = String.valueOf(productsTable.getSelectionModel().selectedItemProperty().get().getId());
                if(!testy.isEmpty()){
                    existingProductID = productsTable.getSelectionModel().selectedItemProperty().get().getId();
                    id.setPromptText(String.valueOf(existingProductID));
                    id.setEditable(false);
                    id.setDisable(true);
                    name.setText(productsTable.getSelectionModel().selectedItemProperty().get().getName());
                    price.setText(String.valueOf(productsTable.getSelectionModel().selectedItemProperty().get().getPrice()));
                    stock.setText(String.valueOf(productsTable.getSelectionModel().selectedItemProperty().get().getStock()));
                    min.setText(String.valueOf(productsTable.getSelectionModel().selectedItemProperty().get().getMin()));
                    max.setText(String.valueOf(productsTable.getSelectionModel().selectedItemProperty().get().getMax()));

                    associatedPartsTable.setItems(newProduct.getAllAssociatedParts());
                }else{
                    toastyScene.setRoot(conformationSceneFailed);
                }

            });

            addSelectedPartButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                ObservableList<Part> selectedPart = partsTable.getSelectionModel().getSelectedItems();
                for(Part hotFilter : selectedPart){
                    newProduct.addAssociatedParts(hotFilter);
                }
                associatedPartsTable.setItems(newProduct.getAllAssociatedParts());
            });

            removeSelectedPartButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                ObservableList<Part> selectedPart = associatedPartsTable.getSelectionModel().getSelectedItems();
                for(Part hotFilter : selectedPart){
                    newProduct.deleteAssociatedPart(hotFilter);
                }
                associatedPartsTable.setItems(newProduct.getAllAssociatedParts());
            });

            saveButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

                if(modifyProductMin(min) > modifyProductMax(max)){
                    GridPane error = new GridPane();
                    Text errorInfo = new Text("Min & Max Error: Max should be greater then Min");
                    errorInfo.setFont(new Font(20));
                    Button errorInfoCloseButton = new Button("Close");
                    error.getChildren().add(errorInfo);
                    error.getChildren().add(errorInfoCloseButton);
                    GridPane.setConstraints(errorInfoCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
                    GridPane.setConstraints(errorInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));
                    closeProgram(errorInfoCloseButton);
                    Stage popUp = new Stage();
                    Scene errorScene = new Scene(error);
                    popUp.setTitle("Error");
                    popUp.setScene(errorScene);
                    popUp.sizeToScene();
                    popUp.show();
                }

                else if(modifyProductStock(stock) > modifyProductMax(max) || modifyProductStock(stock) < modifyProductMin(min)){
                    GridPane error = new GridPane();
                    Text errorInfo = new Text("Stock Error: Stock must be between Min & Max");
                    errorInfo.setFont(new Font(20));
                    Button errorInfoCloseButton = new Button("Close");
                    error.getChildren().add(errorInfo);
                    error.getChildren().add(errorInfoCloseButton);
                    GridPane.setConstraints(errorInfoCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
                    GridPane.setConstraints(errorInfo, 0,0,1,1,CENTER, VPos.CENTER,Priority.ALWAYS,Priority.ALWAYS, new Insets(25));
                    closeProgram(errorInfoCloseButton);
                    Stage popUp = new Stage();
                    Scene errorScene = new Scene(error);
                    popUp.setTitle("Error");
                    popUp.setScene(errorScene);
                    popUp.sizeToScene();
                    popUp.show();
                }

                else if(modifyProductName(name) != null && modifyProductPrice(price) != 0 && modifyProductMax(max) != 0) {
                    productsTable.getItems().set(productsTable.getSelectionModel().selectedItemProperty().get().getId()-1,newProduct);
                    toastyScene.setRoot(conformationSceneSuccess);

                    newProduct.setName(modifyProductName(name));
                    newProduct.setPrice(modifyProductPrice(price));
                    newProduct.setStock(modifyProductStock(stock));
                    newProduct.setMin(modifyProductMin(min));
                    newProduct.setMax(modifyProductMax(max));

                    updatePart(existingPartID,newProduct);

                }
                else{
                    toastyScene.setRoot(conformationSceneFailed);
                }

            });
        }

    /**
     *
     * @param searchText
     * This method accepts a string that will be used to find a desired part
     * @return
     * This method will return that string in real time to a different method
     *
     */
    public static Predicate<Part> createPartPredicate(String searchText){
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
    public static Predicate<Product> createProductPredicate(String searchText){
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
    public static boolean searchFindsPart(Part part, String searchText){
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
    public static boolean searchFindsProduct(Product product, String searchText){
        return (product.getName().toLowerCase().contains(searchText)) ||
                (Integer.valueOf(product.getId()).toString().equals(searchText));
    }


    /**
     *
     * @param searchBar
     * This method accepts a text-field that will be used to search for a particular part
     * @param partTableView
     * This method will display any matching part within a row of the table
     */
        public static void searchPart(TextField searchBar, TableView<Part> partTableView){
            try{

                FilteredList<Part> partsFilteredList = new FilteredList<>(FXCollections.observableList(allParts));
                partTableView.setItems(partsFilteredList);

                searchBar.textProperty().addListener(((observable, oldValue, newValue) ->
                        partsFilteredList.setPredicate(createPartPredicate(newValue))));

            }
            catch (NullPointerException e){
                partTableView.setItems(getAllParts());
            }
        }

    /**
     *
     * @param searchBar
     * This method accepts a text-field that will be used to search for a particular product
     * @param productTableView
     * This method will display any matching product within a row of the table
     */
    public static void searchProduct(TextField searchBar, TableView<Product> productTableView){
        try{

            FilteredList<Product> productsFilteredList = new FilteredList<>(FXCollections.observableList(allProducts));
            productTableView.setItems(productsFilteredList);

            searchBar.textProperty().addListener(((observable, oldValue, newValue) ->
                    productsFilteredList.setPredicate(createProductPredicate(newValue))));

        }
        catch (NullPointerException e){
            productTableView.setItems(getAllProducts());
        }
    }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    public void start(Stage stage) throws IOException {
        toastyStage = stage;

        //Grid Creation
        GridPane mainMenuGrid = new GridPane();
        GridPane partsGrid = new GridPane();
        GridPane productsGrid = new GridPane();
        GridPane partButtonGrid = new GridPane();
        GridPane productButtonGrid = new GridPane();
        GridPane exitButtonGrid = new GridPane();
        GridPane mainMenuTitleGrid = new GridPane();
        GridPane partTitleGrid = new GridPane();
        GridPane productTitleGrid = new GridPane();
        GridPane mainMenuPartSearchBar = new GridPane();
        GridPane addProductMenuSearchBar = new GridPane();
        GridPane modifyProductMenuSearchBar = new GridPane();
        GridPane productSearchBar = new GridPane();
        GridPane partsTable = new GridPane();
        GridPane productsTable = new GridPane();

        //Main Menu Setup
        mainMenuGrid.getChildren().add(mainMenuTitleGrid);
        mainMenuGrid.getChildren().add(partsGrid);
        mainMenuGrid.getChildren().add(productsGrid);
        mainMenuGrid.getChildren().add(exitButtonGrid);
        GridPane.setMargin(mainMenuGrid, new Insets(15));
        mainMenuGrid.setMinSize(1000,600);
        GridPane.setConstraints(mainMenuTitleGrid, 0, 0, 1, 1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(15));
        GridPane.setConstraints(partsGrid, 0, 1, 1, 1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(15));
        GridPane.setConstraints(productsGrid, 1, 1, 1, 1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(15));

        //Part Grid Setup
        partsGrid.getChildren().add(partTitleGrid);
        partsGrid.getChildren().add(mainMenuPartSearchBar);
        partsGrid.getChildren().add(partsTable);
        partsGrid.getChildren().add(partButtonGrid);
        GridPane.setConstraints(partTitleGrid,0,0,1,1,HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(15));
        GridPane.setConstraints(mainMenuPartSearchBar,1, 0,1,1,HPos.RIGHT, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(15));
        GridPane.setConstraints(partsTable, 0,1,GridPane.REMAINING,1,HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(15));
        GridPane.setConstraints(partButtonGrid,1,2,1,1,HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(15));

        //Product Grid Setup
        productsGrid.getChildren().add(productTitleGrid);
        productsGrid.getChildren().add(productSearchBar);
        productsGrid.getChildren().add(productsTable);
        productsGrid.getChildren().add(productButtonGrid);
        GridPane.setConstraints(productTitleGrid,0,0,1,1,HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(15));
        GridPane.setConstraints(productSearchBar,1, 0,1,1,HPos.RIGHT, VPos.CENTER,Priority.SOMETIMES, Priority.SOMETIMES, new Insets(15));
        GridPane.setConstraints(productsTable, 0,1,GridPane.REMAINING,1,HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(15));
        GridPane.setConstraints(productButtonGrid,1,2,1,1,HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(15));

        //Main Menu Title Setup
        Text mainMenuTitle = new Text("Inventory Management System");
        mainMenuTitle.setFont(new Font(30));
        mainMenuTitleGrid.getChildren().add(mainMenuTitle);
        GridPane.setConstraints(mainMenuTitle, 0,0,1,1, LEFT, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS);


        //Parts Title Setup
        Text partsTitle = new Text( "Parts");
        partsTitle.setFont(new Font(25));
        partTitleGrid.getChildren().add(partsTitle);

        //Product Title Setup
        Text productsTitle = new Text("Products");
        productsTitle.setFont(new Font(25));
        productTitleGrid.getChildren().add(productsTitle);


        //Parts SearchBar Setup
        TextField partsSearchBar = new TextField();
        partsSearchBar.setPromptText("Search by Part ID or Name");
        mainMenuPartSearchBar.getChildren().add(partsSearchBar);

        TextField addProductSearchBar = new TextField();
        addProductSearchBar.setPromptText("Search by Part ID or Name");
        addProductMenuSearchBar.getChildren().add(addProductSearchBar);

        TextField modifyProductSearchBar = new TextField();
        modifyProductSearchBar.setPromptText("Search by Product ID or Name");
        modifyProductMenuSearchBar.getChildren().add(modifyProductSearchBar);

        //Products SearchBar Setup
        TextField productsSearchBar = new TextField();
        productsSearchBar.setPromptText("Search by Product ID or Name");
        productSearchBar.getChildren().add(productsSearchBar);


        //Part Table Setup

            TableView<Part> partsTableView;
 
            TableColumn<Part, Integer> idColumn = new TableColumn<>("ID");
            idColumn.setMinWidth(115);
            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

            TableColumn<Part, String> nameColumn = new TableColumn<>("Name");
            nameColumn.setMinWidth(115);
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

            TableColumn<Part, Double> priceColumn = new TableColumn<>("Price");
            priceColumn.setMinWidth(115);
            priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

            TableColumn<Part, Integer> stockColumn = new TableColumn<>("Stock");
            stockColumn.setMinWidth(115);
            stockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));

            TableColumn<Part, Integer> minColumn = new TableColumn<>("Min");
            minColumn.setMinWidth(115);
            minColumn.setCellValueFactory(new PropertyValueFactory<>("min"));

            TableColumn<Part, Integer> maxColumn = new TableColumn<>("Max");
            maxColumn.setMinWidth(115);
            maxColumn.setCellValueFactory(new PropertyValueFactory<>("max"));

            partsTableView = new TableView<>();
            partsTableView.setItems(getAllParts());
            partsTableView.getColumns().add(idColumn);
            partsTableView.getColumns().add(nameColumn);
            partsTableView.getColumns().add(priceColumn);
            partsTableView.getColumns().add(stockColumn);
            partsTableView.getColumns().add(minColumn);
            partsTableView.getColumns().add(maxColumn);
            partsTable.getChildren().add(partsTableView);


        //Product Table Setup

        TableView<Product> productsTableView;

        TableColumn<Product, Integer> productIdColumn = new TableColumn<>("ID");
        productIdColumn.setMinWidth(115);
        productIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Product, String> productNameColumn = new TableColumn<>("Name");
        productNameColumn.setMinWidth(115);
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product, Double> productPriceColumn = new TableColumn<>("Price");
        productPriceColumn.setMinWidth(115);
        productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Product, Integer> productStockColumn = new TableColumn<>("Stock");
        productStockColumn.setMinWidth(115);
        productStockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));

        TableColumn<Product, Integer> productMinColumn = new TableColumn<>("Min");
        productMinColumn.setMinWidth(115);
        productMinColumn.setCellValueFactory(new PropertyValueFactory<>("min"));

        TableColumn<Product, Integer> productMaxColumn = new TableColumn<>("Max");
        productMaxColumn.setMinWidth(115);
        productMaxColumn.setCellValueFactory(new PropertyValueFactory<>("max"));

        productsTableView = new TableView<>();
        productsTableView.setItems(getAllProducts());
        productsTableView.getColumns().add(productIdColumn);
        productsTableView.getColumns().add(productNameColumn);
        productsTableView.getColumns().add(productPriceColumn);
        productsTableView.getColumns().add(productStockColumn);
        productsTableView.getColumns().add(productMinColumn);
        productsTableView.getColumns().add(productMaxColumn);
        productsTable.getChildren().add(productsTableView);

        //Part Grid Button Setup
            Button addPartButton = new Button("Add");
            Button modifyPartButton = new Button("Modify");
            Button deletePartButton = new Button("Delete");
            partButtonGrid.getChildren().addAll(addPartButton, modifyPartButton, deletePartButton);
            GridPane.setConstraints(addPartButton, 0,0);
            GridPane.setConstraints(modifyPartButton, 1, 0);
            GridPane.setConstraints(deletePartButton, 2, 0);
            partButtonGrid.setHgap(10);



        //Product Grid Button Setup
            Button addProductButton = new Button("Add");
            Button modifyProductButton = new Button("Modify");
            Button deleteProductButton = new Button("Delete");
            productButtonGrid.getChildren().addAll(addProductButton, modifyProductButton, deleteProductButton);
            GridPane.setConstraints(addProductButton, 0,0);
            GridPane.setConstraints(modifyProductButton, 1, 0);
            GridPane.setConstraints(deleteProductButton, 2, 0);
            productButtonGrid.setHgap(10);


        //Main Menu Exit Button Setup
            Button exitButton = new Button("Exit");
            mainMenuGrid.getChildren().add(exitButton);
            GridPane.setConstraints(exitButton, 1, 2, 1,1, HPos.RIGHT, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(15));


        //Add Product & Part Menus

            //Add New Product & Part Menu Super Grid
            GridPane addNewPartGrid = new GridPane();
            GridPane addPartMinTextHybrid = new GridPane();
            GridPane addProductMinTextHybrid = new GridPane();
            GridPane addProductMenuGrid = new GridPane();

            //Modify Product & Part Menu Super Grid
            GridPane modifyPartGrid = new GridPane();
            GridPane modifyPartMinTextHybrid = new GridPane();
            GridPane modifyProductMinTextHybrid = new GridPane();
            GridPane modifyProductMenuGrid = new GridPane();


            //Part Title Text Grids
            GridPane addPartTitleGrid = new GridPane();
            GridPane addPartIdTitleTextGrid = new GridPane();
            GridPane addPartNameTitleTextGrid = new GridPane();
            GridPane addPartStockTitleTextGrid = new GridPane();
            GridPane addPartPriceTitleTextGrid = new GridPane();
            GridPane addPartMinTitleTextGrid = new GridPane();
            GridPane addPartMaxTitleTextGrid = new GridPane();
            GridPane addPartMachineIdTitleTextGrid = new GridPane();

            GridPane modifyPartTitleGrid = new GridPane();
            GridPane modifyPartIdTitleTextGrid = new GridPane();
            GridPane modifyPartNameTitleTextGrid = new GridPane();
            GridPane modifyPartStockTitleTextGrid = new GridPane();
            GridPane modifyPartPriceTitleTextGrid = new GridPane();
            GridPane modifyPartMinTitleTextGrid = new GridPane();
            GridPane modifyPartMaxTitleTextGrid = new GridPane();
            GridPane modifyPartMachineIdTitleTextGrid = new GridPane();

            //Product Title Text Grids
            GridPane addProductTitleGrid = new GridPane();
            GridPane addProductIdTitleTextGrid = new GridPane();
            GridPane addProductNameTitleTextGrid = new GridPane();
            GridPane addProductStockTitleTextGrid = new GridPane();
            GridPane addProductPriceTitleTextGrid = new GridPane();
            GridPane addProductMinTitleTextGrid = new GridPane();
            GridPane addProductMaxTitleTextGrid = new GridPane();

            GridPane modifyProductTitleGrid = new GridPane();
            GridPane modifyProductIdTitleTextGrid = new GridPane();
            GridPane modifyProductNameTitleTextGrid = new GridPane();
            GridPane modifyProductStockTitleTextGrid = new GridPane();
            GridPane modifyProductPriceTitleTextGrid = new GridPane();
            GridPane modifyProductMinTitleTextGrid = new GridPane();
            GridPane modifyProductMaxTitleTextGrid = new GridPane();


            //Part TextField Grids
            GridPane addPartNameTextFieldGrid = new GridPane();
            GridPane addPartStockTextFieldGrid = new GridPane();
            GridPane addPartPriceTextFieldGrid = new GridPane();
            GridPane addPartIdTextFieldGrid = new GridPane();
            GridPane addPartMinTextFieldGrid = new GridPane();
            GridPane addPartMaxTextFieldGrid = new GridPane();
            GridPane addPartMachineIdTextFieldGrid = new GridPane();

            GridPane modifyPartNameTextFieldGrid = new GridPane();
            GridPane modifyPartStockTextFieldGrid = new GridPane();
            GridPane modifyPartPriceTextFieldGrid = new GridPane();
            GridPane modifyPartIdTextFieldGrid = new GridPane();
            GridPane modifyPartMinTextFieldGrid = new GridPane();
            GridPane modifyPartMaxTextFieldGrid = new GridPane();
            GridPane modifyPartMachineIdTextFieldGrid = new GridPane();


            //Product TextField Grids
            GridPane addProductIdTextFieldGrid = new GridPane();
            GridPane addProductNameTextFieldGrid = new GridPane();
            GridPane addProductPriceTextFieldGrid = new GridPane();
            GridPane addProductStockTextFieldGrid = new GridPane();
            GridPane addProductMinTextFieldGrid = new GridPane();
            GridPane addProductMaxTextFieldGrid = new GridPane();

            GridPane modifyProductIdTextFieldGrid = new GridPane();
            GridPane modifyProductNameTextFieldGrid = new GridPane();
            GridPane modifyProductPriceTextFieldGrid = new GridPane();
            GridPane modifyProductStockTextFieldGrid = new GridPane();
            GridPane modifyProductMinTextFieldGrid = new GridPane();
            GridPane modifyProductMaxTextFieldGrid = new GridPane();





            //Button Grids
            GridPane inHousePartGrid = new GridPane();
            GridPane outsourcedPartGrid = new GridPane();
            GridPane editPartButtonGrid = new GridPane();

            GridPane modifyInHousePartGrid = new GridPane();
            GridPane modifyOutsourcedPartGrid = new GridPane();
            GridPane editModifiedPartButtonGrid = new GridPane();


        // <------------ Add New Part Menu Super Grid Setup Beginning -------------> //


            addNewPartGrid.getChildren().addAll(addPartTitleGrid, inHousePartGrid,
                    outsourcedPartGrid, addPartIdTitleTextGrid, addPartIdTextFieldGrid,
                    addPartNameTitleTextGrid, addPartNameTextFieldGrid, addPartStockTitleTextGrid,
                    addPartStockTextFieldGrid, addPartPriceTitleTextGrid, addPartPriceTextFieldGrid,
                    addPartMinTextHybrid, addPartMaxTitleTextGrid,
                    addPartMaxTextFieldGrid,addPartMachineIdTitleTextGrid, addPartMachineIdTextFieldGrid,editPartButtonGrid);
            GridPane.setMargin(addNewPartGrid, new Insets(5,5,5,5));
            addNewPartGrid.setMinSize(600,700);

            GridPane.setConstraints(addNewPartGrid,0,0,2,1);

        addPartMinTextHybrid.getChildren().addAll(addPartMinTitleTextGrid, addPartMinTextFieldGrid);
        GridPane.setConstraints(addPartMinTitleTextGrid, 0,0, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES);
        GridPane.setConstraints(addPartMinTextFieldGrid, 1,0, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES);
        ColumnConstraints superColWidth1 =new ColumnConstraints();
        superColWidth1.setPercentWidth(20);
        ColumnConstraints superColWidth2 =new ColumnConstraints();
        superColWidth2.setPercentWidth(35);
        ColumnConstraints superColWidth3 =new ColumnConstraints();
        superColWidth3.setPercentWidth(45);

        addNewPartGrid.getColumnConstraints().addAll(superColWidth1,superColWidth2,superColWidth3);
        addNewPartGrid.setPadding(new Insets(30));

            GridPane.setConstraints(addPartTitleGrid, 0,0, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
            GridPane.setConstraints(inHousePartGrid, 1,0, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
            GridPane.setConstraints(outsourcedPartGrid, 2,0, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
            GridPane.setConstraints(addPartIdTitleTextGrid, 0,1, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
            GridPane.setConstraints(addPartIdTextFieldGrid, 1,1, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
            GridPane.setConstraints(addPartNameTitleTextGrid, 0,2, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
            GridPane.setConstraints(addPartNameTextFieldGrid, 1,2, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
            GridPane.setConstraints(addPartStockTitleTextGrid, 0,3, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
            GridPane.setConstraints(addPartStockTextFieldGrid, 1,3, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
            GridPane.setConstraints(addPartPriceTitleTextGrid, 0,4, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
            GridPane.setConstraints(addPartPriceTextFieldGrid, 1,4, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
            GridPane.setConstraints(addPartMinTextHybrid, 2,5, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
            GridPane.setConstraints(addPartMaxTitleTextGrid, 0,5, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
            GridPane.setConstraints(addPartMaxTextFieldGrid, 1,5, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
            GridPane.setConstraints(addPartMachineIdTitleTextGrid, 0,6, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
            GridPane.setConstraints(addPartMachineIdTextFieldGrid, 1,6, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
            GridPane.setConstraints(editPartButtonGrid, 2,7, 1,1, HPos.RIGHT, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));


        // <------------ Add New Part Menu Super Grid Setup End -------------> //



        // <------------ Add New Part Title Text Grid Setup Beginning -------------> //


            Text addPartTitle = new Text("Add Part");
                addPartTitle.setFont(new Font(15));
            Text idTitleText = new Text("ID");
                idTitleText.setFont(new Font(15));
            Text nameTitleText = new Text("Name");
                nameTitleText.setFont(new Font(15));
            Text invTitleText = new Text("Inv.");
                invTitleText.setFont(new Font(15));
            Text priceTitleText = new Text("Price");
                priceTitleText.setFont(new Font(15));
            Text minTitleText = new Text("Min");
                minTitleText.setFont(new Font(15));
            Text maxTitleText = new Text("Max");
                maxTitleText.setFont(new Font(15));
            Text machineIdTitleText = new Text("Machine ID");
                machineIdTitleText.setFont(new Font(15));
            addPartTitleGrid.getChildren().add(addPartTitle);
            addPartIdTitleTextGrid.getChildren().add(idTitleText);
            addPartNameTitleTextGrid.getChildren().add(nameTitleText);
            addPartStockTitleTextGrid.getChildren().add(invTitleText);
            addPartPriceTitleTextGrid.getChildren().add(priceTitleText);
            addPartMinTitleTextGrid.getChildren().addAll(minTitleText);
            addPartMaxTitleTextGrid.getChildren().add(maxTitleText);
            addPartMachineIdTitleTextGrid.getChildren().add(machineIdTitleText);


        // <------------ Add New Part Title Text Grid Setup End -------------> //



        // <------------ Add New Part Title TextField Grid Setup Beginning -------------> //


            TextField addPartNameTextField = new TextField();
            TextField addPartStockTextField = new TextField();
            TextField addPartIdTextField = new TextField();
            TextField addPartPriceTextField = new TextField();
            TextField addPartMinTextField = new TextField();
            TextField addPartMaxTextField = new TextField();
            TextField addPartMachineIdText = new TextField();
            addPartNameTextFieldGrid.getChildren().add(addPartNameTextField);
            addPartStockTextFieldGrid.getChildren().add(addPartStockTextField);
            addPartIdTextFieldGrid.getChildren().add(addPartIdTextField);
            addPartPriceTextFieldGrid.getChildren().add(addPartPriceTextField);
            addPartMinTextFieldGrid.getChildren().addAll(addPartMinTextField);
            addPartMaxTextFieldGrid.getChildren().add(addPartMaxTextField);
            addPartMachineIdTextFieldGrid.getChildren().add(addPartMachineIdText);


        // <------------ Add New Part Title TextField Grid Setup End -------------> //




        // <------------ Add New Part Button Grid Setup Beginning -------------> //


            ToggleGroup partType = new ToggleGroup();
            RadioButton inHousePart = new RadioButton("In-House");
            RadioButton outsourcedPart = new RadioButton("Outsourced");
            inHousePart.setToggleGroup(partType);
            outsourcedPart.setToggleGroup(partType);
            Button saveNewPart = new Button("Save");
            Button cancelNewPart = new Button("Cancel");
            editPartButtonGrid.getChildren().addAll(saveNewPart, cancelNewPart);
            GridPane.setConstraints(saveNewPart,0,0);
            GridPane.setConstraints(cancelNewPart,1,0);
            inHousePartGrid.getChildren().add(inHousePart);
            outsourcedPartGrid.getChildren().add(outsourcedPart);
            editPartButtonGrid.setHgap(25);


        // <------------ Add New Part Button Grid Setup End -------------> //




        // <------------ Add New Product Menu Setup Beginning -------------> //


        // <------------ Add New Product Menu Super Grid Setup Beginning -------------> //


        GridPane addNewProductGrid = new GridPane();

        addProductMenuGrid.getChildren().add(addNewProductGrid);

        GridPane.setMargin(addNewProductGrid, new Insets(5,5,5,5));
        addNewProductGrid.setMinSize(600,700);

        addProductMinTextHybrid.getChildren().addAll(addProductMinTitleTextGrid, addProductMinTextFieldGrid);
        GridPane.setConstraints(addProductMinTitleTextGrid, 0,0, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES);
        GridPane.setConstraints(addProductMinTextFieldGrid, 1,0, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES);

        addNewProductGrid.setPadding(new Insets(30));

        GridPane.setConstraints(addProductTitleGrid, 0,0, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
        GridPane.setConstraints(addProductIdTitleTextGrid, 0,1, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
        GridPane.setConstraints(addProductIdTextFieldGrid, 1,1, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
        GridPane.setConstraints(addProductNameTitleTextGrid, 0,2, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
        GridPane.setConstraints(addProductNameTextFieldGrid, 1,2, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
        GridPane.setConstraints(addProductStockTitleTextGrid, 0,3, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
        GridPane.setConstraints(addProductStockTextFieldGrid, 1,3, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
        GridPane.setConstraints(addProductPriceTitleTextGrid, 0,4, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
        GridPane.setConstraints(addProductPriceTextFieldGrid, 1,4, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
        GridPane.setConstraints(addProductMinTextHybrid, 2,5, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
        GridPane.setConstraints(addProductMaxTitleTextGrid, 0,5, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
        GridPane.setConstraints(addProductMaxTextFieldGrid, 1,5, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));



        // <------------ Add New Product Menu Super Grid Setup End -------------> //



        // <------------ Add New Product Menu Sub-Grids Setup Beginning -------------> //


                addNewProductGrid.getChildren().addAll(addProductTitleGrid,
                addProductIdTitleTextGrid, addProductIdTextFieldGrid,
                addProductNameTitleTextGrid, addProductNameTextFieldGrid, addProductStockTitleTextGrid,
                addProductStockTextFieldGrid, addProductPriceTitleTextGrid, addProductPriceTextFieldGrid,
                addProductMinTextHybrid, addProductMaxTitleTextGrid, addProductMaxTextFieldGrid);

            // <------------ Add New Product Title Text Grid Setup Beginning -------------> //


            Text addProductTitle = new Text("Add Product");
            addProductTitle.setFont(new Font(15));

            Text addProductIdTitleText = new Text("ID");
            addProductIdTitleText.setFont(new Font(15));

            Text addProductNameTitleText = new Text("Name");
            addProductNameTitleText.setFont(new Font(15));

            Text addProductStockTitleText = new Text("Inv.");
            addProductStockTitleText.setFont(new Font(15));

            Text addProductPriceTitleText = new Text("Price");
            addProductPriceTitleText.setFont(new Font(15));

            Text addProductMinTitleText = new Text("Min");
            addProductMinTitleText.setFont(new Font(15));

            Text addProductMaxTitleText = new Text("Max");
            addProductMaxTitleText.setFont(new Font(15));

            addProductTitleGrid.getChildren().add(addProductTitle);
            addProductIdTitleTextGrid.getChildren().add(addProductIdTitleText);
            addProductNameTitleTextGrid.getChildren().add(addProductNameTitleText);
            addProductStockTitleTextGrid.getChildren().add(addProductStockTitleText);
            addProductPriceTitleTextGrid.getChildren().add(addProductPriceTitleText);
            addProductMinTitleTextGrid.getChildren().addAll(addProductMinTitleText);
            addProductMaxTitleTextGrid.getChildren().add(addProductMaxTitleText);


            // <------------ Add New Product Title Text Grid Setup End -------------> //



            // <------------ Add New Product Title TextField Grid Setup Beginning -------------> //


            TextField addProductNameTextField = new TextField();
            TextField addProductStockTextField = new TextField();
            TextField addProductIdTextField = new TextField();
            TextField addProductPriceTextField = new TextField();
            TextField addProductMinTextField = new TextField();
            TextField addProductMaxTextField = new TextField();

            addProductNameTextFieldGrid.getChildren().add(addProductNameTextField);
            addProductStockTextFieldGrid.getChildren().add(addProductStockTextField);
            addProductIdTextFieldGrid.getChildren().add(addProductIdTextField);
            addProductPriceTextFieldGrid.getChildren().add(addProductPriceTextField);
            addProductMinTextFieldGrid.getChildren().addAll(addProductMinTextField);
            addProductMaxTextFieldGrid.getChildren().add(addProductMaxTextField);


            // <------------ Add New Product Title TextField Grid Setup End -------------> //


            // <------------ Add New Product Button Grid Setup Beginning -------------> //


            GridPane addProductButtonCage = new GridPane();

            Button addAssociatedPartButton = new Button("Add");
            Button removeAssociatedPartButton = new Button("Remove Associated Part");
            Button saveNewProduct = new Button("Save");
            Button cancelNewProduct = new Button("Cancel");

            addProductButtonCage.getChildren().addAll(removeAssociatedPartButton, saveNewProduct, cancelNewProduct);

            GridPane.setConstraints(removeAssociatedPartButton, 0,0,2,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES);
            GridPane.setConstraints(saveNewProduct, 0,1,1,1, HPos.RIGHT, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(0,15,0,0));
            GridPane.setConstraints(cancelNewProduct, 1,1,1,1, LEFT, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES);

            addProductButtonCage.setHgap(25);
            addProductButtonCage.setVgap(15);


            // <------------ Add New Product Button Grid Setup End -------------> //



            // <------------ Add New Product Associated Parts Grid Setup Beginning -------------> //

                GridPane addNewProductCleanerFixerUpper = new GridPane();
                GridPane associatedPartGrid = new GridPane();
                GridPane associatedPartsTableGrid = new GridPane();
                GridPane associatablePartsTableGrid = new GridPane();
                GridPane associatablePartsGrid = new GridPane();

                addProductMenuGrid.getChildren().add(addNewProductCleanerFixerUpper);


                // Associatable Parts (All Parts) Grid
                TableView<Part> associatablePartsTable = new TableView<>(allParts);

                TableColumn<Part, Integer> associatableProductIdColumn = new TableColumn<>("ID");
                associatableProductIdColumn.setMinWidth(115);
                associatableProductIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

                TableColumn<Part, String> associatableProductNameColumn = new TableColumn<>("Name");
                associatableProductNameColumn.setMinWidth(115);
                associatableProductNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

                TableColumn<Part, Double> associatableProductPriceColumn = new TableColumn<>("Price");
                associatableProductPriceColumn.setMinWidth(115);
                associatableProductPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

                TableColumn<Part, Integer> associatableProductStockColumn = new TableColumn<>("Stock");
                associatableProductStockColumn.setMinWidth(115);
                associatableProductStockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));

                associatablePartsTableGrid.getChildren().add(associatablePartsTable);
                associatablePartsTable.setItems(getAllParts());
                associatablePartsTable.getColumns().add(associatableProductIdColumn);
                associatablePartsTable.getColumns().add(associatableProductNameColumn);
                associatablePartsTable.getColumns().add(associatableProductPriceColumn);
                associatablePartsTable.getColumns().add(associatableProductStockColumn);

                associatablePartsGrid.getChildren().addAll(addProductSearchBar, associatablePartsTableGrid, addAssociatedPartButton);

                addNewProductCleanerFixerUpper.getChildren().add(associatablePartsGrid);

                GridPane.setConstraints(associatablePartsGrid, 1,0,1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
                GridPane.setConstraints(associatablePartsTable,0,1,1,1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(5,5,5,5));
                GridPane.setConstraints(addProductSearchBar, 0,0,1,1, HPos.RIGHT, VPos.CENTER, Priority.NEVER, Priority.SOMETIMES, new Insets(15));
                GridPane.setConstraints(associatablePartsTableGrid, 0,1,1,1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(5,5,5,5));
                GridPane.setConstraints(addAssociatedPartButton,0,2,1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));

                // Associated Parts Grid
                TableView<Part> associatedPartsTable = new TableView<>();

                TableColumn<Part, Integer> associatedProductIdColumn = new TableColumn<>("ID");
                associatedProductIdColumn.setMinWidth(115);
                associatedProductIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

                TableColumn<Part, String> associatedProductNameColumn = new TableColumn<>("Name");
                associatedProductNameColumn.setMinWidth(115);
                associatedProductNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

                TableColumn<Part, Double> associatedProductPriceColumn = new TableColumn<>("Price");
                associatedProductPriceColumn.setMinWidth(115);
                associatedProductPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

                TableColumn<Part, Integer> associatedProductStockColumn = new TableColumn<>("Stock");
                associatedProductStockColumn.setMinWidth(115);
                associatedProductStockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));

                associatedPartsTable.getColumns().add(associatedProductIdColumn);
                associatedPartsTable.getColumns().add(associatedProductNameColumn);
                associatedPartsTable.getColumns().add(associatedProductPriceColumn);
                associatedPartsTable.getColumns().add(associatedProductStockColumn);

                associatedPartsTableGrid.getChildren().add(associatedPartsTable);
                associatedPartGrid.getChildren().addAll(associatedPartsTable, addProductButtonCage);

                GridPane.setConstraints(associatedPartsTable, 0,0,1,1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(5,5,5,5));
                GridPane.setConstraints(addProductButtonCage,0,1,1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));

                addNewProductCleanerFixerUpper.getChildren().add(associatedPartGrid);

                GridPane.setConstraints(associatedPartGrid, 1,1,1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));

            // <------------ Add New Product Associated Parts Grid Setup End -------------> //


                ColumnConstraints mPMGColumn1 = new ColumnConstraints();
                ColumnConstraints mPMGColumn2 = new ColumnConstraints();
                mPMGColumn1.setPercentWidth(50);
                mPMGColumn2.setPercentWidth(50);
                addProductMenuGrid.setMinSize(500,400);
                addProductMenuGrid.setMaxSize(1500,800);


                addProductMenuGrid.getColumnConstraints().addAll(mPMGColumn1, mPMGColumn1);
                GridPane.setConstraints(addNewProductGrid, 0,0,1,1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(5,5,5,5));

                GridPane.setConstraints(addNewProductCleanerFixerUpper,1,0,1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));

        // <------------ Add New Product Menu Sub-Grids Setup End -------------> //


        // <------------ Add New Product Menu Setup End -------------> //





        // <------------ Modify Part Menu Setup Beginning -------------> //


          // <------------ Modify Part Menu Super Grid Setup Beginning -------------> //


                    modifyPartGrid.getChildren().addAll(modifyPartTitleGrid, modifyInHousePartGrid,
                            modifyOutsourcedPartGrid, modifyPartIdTitleTextGrid, modifyPartIdTextFieldGrid,
                            modifyPartNameTitleTextGrid, modifyPartNameTextFieldGrid, modifyPartStockTitleTextGrid,
                            modifyPartStockTextFieldGrid, modifyPartPriceTitleTextGrid, modifyPartPriceTextFieldGrid,
                            modifyPartMinTextHybrid, modifyPartMaxTitleTextGrid,
                            modifyPartMaxTextFieldGrid,modifyPartMachineIdTitleTextGrid, modifyPartMachineIdTextFieldGrid,editModifiedPartButtonGrid);
                    GridPane.setMargin(addNewPartGrid, new Insets(5,5,5,5));
                    modifyPartGrid.setMinSize(600,700);

                modifyPartMinTextHybrid.getChildren().addAll(modifyPartMinTitleTextGrid, modifyPartMinTextFieldGrid);
                GridPane.setConstraints(modifyPartMinTitleTextGrid, 0,0, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES);
                GridPane.setConstraints(modifyPartMinTextFieldGrid, 1,0, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES);
                ColumnConstraints superColWidth1modify = new ColumnConstraints();
                superColWidth1.setPercentWidth(20);
                ColumnConstraints superColWidth2modify = new ColumnConstraints();
                superColWidth2.setPercentWidth(35);
                ColumnConstraints superColWidth3modify = new ColumnConstraints();
                superColWidth3.setPercentWidth(45);

                modifyPartGrid.getColumnConstraints().addAll(superColWidth1modify,superColWidth2modify,superColWidth3modify);
                modifyPartGrid.setPadding(new Insets(30));

                    GridPane.setConstraints(modifyPartTitleGrid, 0,0, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
                    GridPane.setConstraints(modifyInHousePartGrid, 1,0, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
                    GridPane.setConstraints(modifyOutsourcedPartGrid, 2,0, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
                    GridPane.setConstraints(modifyPartIdTitleTextGrid, 0,1, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
                    GridPane.setConstraints(modifyPartIdTextFieldGrid, 1,1, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
                    GridPane.setConstraints(modifyPartNameTitleTextGrid, 0,2, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
                    GridPane.setConstraints(modifyPartNameTextFieldGrid, 1,2, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
                    GridPane.setConstraints(modifyPartStockTitleTextGrid, 0,3, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
                    GridPane.setConstraints(modifyPartStockTextFieldGrid, 1,3, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
                    GridPane.setConstraints(modifyPartPriceTitleTextGrid, 0,4, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
                    GridPane.setConstraints(modifyPartPriceTextFieldGrid, 1,4, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
                    GridPane.setConstraints(modifyPartMinTextHybrid, 2,5, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
                    GridPane.setConstraints(modifyPartMaxTitleTextGrid, 0,5, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
                    GridPane.setConstraints(modifyPartMaxTextFieldGrid, 1,5, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
                    GridPane.setConstraints(modifyPartMachineIdTitleTextGrid, 0,6, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
                    GridPane.setConstraints(modifyPartMachineIdTextFieldGrid, 1,6, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
                    GridPane.setConstraints(editModifiedPartButtonGrid, 2,7, 1,1, HPos.RIGHT, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));


                // <------------ Modify Part Menu Super Grid Setup End -------------> //



                // <------------ Modify Part Title Text Grid Setup Beginning -------------> //


                    Text modifyPartTitle = new Text("Modify Part");
                        modifyPartTitle.setFont(new Font(15));

                    Text modifyIdTitleText = new Text("ID");
                        modifyIdTitleText.setFont(new Font(15));

                    Text modifyNameTitleText = new Text("Name");
                        modifyNameTitleText.setFont(new Font(15));

                    Text modifyStockTitleText = new Text("Inv.");
                        modifyStockTitleText.setFont(new Font(15));

                    Text modifyPriceTitleText = new Text("Price");
                        modifyPriceTitleText.setFont(new Font(15));

                    Text modifyMinTitleText = new Text("Min");
                        modifyMinTitleText.setFont(new Font(15));

                    Text modifyMaxTitleText = new Text("Max");
                        modifyMaxTitleText.setFont(new Font(15));

                    Text modifyMachineIdTitleText = new Text("Machine ID");
                        modifyMachineIdTitleText.setFont(new Font(15));

                    modifyPartTitleGrid.getChildren().add(modifyPartTitle);
                    modifyPartIdTitleTextGrid.getChildren().add(modifyIdTitleText);
                    modifyPartNameTitleTextGrid.getChildren().add(modifyNameTitleText);
                    modifyPartStockTitleTextGrid.getChildren().add(modifyStockTitleText);
                    modifyPartPriceTitleTextGrid.getChildren().add(modifyPriceTitleText);
                    modifyPartMinTitleTextGrid.getChildren().addAll(modifyMinTitleText);
                    modifyPartMaxTitleTextGrid.getChildren().add(modifyMaxTitleText);
                    modifyPartMachineIdTitleTextGrid.getChildren().add(modifyMachineIdTitleText);


                // <------------ Modify Part Title Text Grid Setup End -------------> //



                // <------------ Modify Part Title TextField Grid Setup Beginning -------------> //


                    TextField modifyPartNameTextField = new TextField();
                    TextField modifyPartStockTextField = new TextField();
                    TextField modifyPartIdTextField = new TextField();
                    TextField modifyPartPriceTextField = new TextField();
                    TextField modifyPartMinTextField = new TextField();
                    TextField modifyPartMaxTextField = new TextField();
                    TextField modifyPartMachineIdTextField = new TextField();
                    modifyPartNameTextFieldGrid.getChildren().add(modifyPartNameTextField);
                    modifyPartStockTextFieldGrid.getChildren().add(modifyPartStockTextField);
                    modifyPartIdTextFieldGrid.getChildren().add(modifyPartIdTextField);
                    modifyPartPriceTextFieldGrid.getChildren().add(modifyPartPriceTextField);
                    modifyPartMinTextFieldGrid.getChildren().addAll(modifyPartMinTextField);
                    modifyPartMaxTextFieldGrid.getChildren().add(modifyPartMaxTextField);
                    modifyPartMachineIdTextFieldGrid.getChildren().add(modifyPartMachineIdTextField);


                // <------------ Modify Part Title TextField Grid Setup End -------------> //




                // <------------ Modify Part Button Grid Setup Beginning -------------> //


                    ToggleGroup modifyPartType = new ToggleGroup();
                    RadioButton modifyInHousePart = new RadioButton("In-House");
                    RadioButton modifyOutsourcedPart = new RadioButton("Outsourced");
                    modifyInHousePart.setToggleGroup(modifyPartType);
                    modifyOutsourcedPart.setToggleGroup(modifyPartType);
                    Button saveModifiedPart = new Button("Save");
                    Button cancelModifiedPart = new Button("Cancel");
                    editModifiedPartButtonGrid.getChildren().addAll(saveModifiedPart, cancelModifiedPart);
                    GridPane.setConstraints(saveModifiedPart,0,0);
                    GridPane.setConstraints(cancelModifiedPart,1,0);
                    modifyInHousePartGrid.getChildren().add(modifyInHousePart);
                    modifyOutsourcedPartGrid.getChildren().add(modifyOutsourcedPart);
                    editModifiedPartButtonGrid.setHgap(25);


                // <------------ Modify Part Button Grid Setup End -------------> //


        // <------------ Modify Part Menu Setup End -------------> //



        // <------------ Modify Product Menu Setup Beginning -------------> //


                // <------------ Modify Product Menu Super Grid Setup Beginning -------------> //


                GridPane modifyProductGrid = new GridPane();

                modifyProductMenuGrid.getChildren().add(modifyProductGrid);

                GridPane.setMargin(modifyProductGrid, new Insets(5,5,5,5));
                modifyProductGrid.setMinSize(600,700);

                modifyProductMinTextHybrid.getChildren().addAll(modifyProductMinTitleTextGrid, modifyProductMinTextFieldGrid);
                GridPane.setConstraints(modifyProductMinTitleTextGrid, 0,0, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES);
                GridPane.setConstraints(modifyProductMinTextFieldGrid, 1,0, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES);

                modifyProductGrid.setPadding(new Insets(30));

                GridPane.setConstraints(modifyProductTitleGrid, 0,0, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
                GridPane.setConstraints(modifyProductIdTitleTextGrid, 0,1, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
                GridPane.setConstraints(modifyProductIdTextFieldGrid, 1,1, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
                GridPane.setConstraints(modifyProductNameTitleTextGrid, 0,2, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
                GridPane.setConstraints(modifyProductNameTextFieldGrid, 1,2, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
                GridPane.setConstraints(modifyProductStockTitleTextGrid, 0,3, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
                GridPane.setConstraints(modifyProductStockTextFieldGrid, 1,3, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
                GridPane.setConstraints(modifyProductPriceTitleTextGrid, 0,4, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
                GridPane.setConstraints(modifyProductPriceTextFieldGrid, 1,4, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
                GridPane.setConstraints(modifyProductMinTextHybrid, 2,5, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
                GridPane.setConstraints(modifyProductMaxTitleTextGrid, 0,5, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
                GridPane.setConstraints(modifyProductMaxTextFieldGrid, 1,5, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));



                // <------------ Modify Product Menu Super Grid Setup End -------------> //



                // <------------ Modify Product Menu Sub-Grids Setup Beginning -------------> //


                        modifyProductGrid.getChildren().addAll(modifyProductTitleGrid,
                        modifyProductIdTitleTextGrid, modifyProductIdTextFieldGrid,
                        modifyProductNameTitleTextGrid, modifyProductNameTextFieldGrid, modifyProductStockTitleTextGrid,
                        modifyProductStockTextFieldGrid, modifyProductPriceTitleTextGrid, modifyProductPriceTextFieldGrid,
                        modifyProductMinTextHybrid, modifyProductMaxTitleTextGrid, modifyProductMaxTextFieldGrid);

                    // <------------ Modify Product Title Text Grid Setup Beginning -------------> //


                    Text modifyProductTitle = new Text("Add Product");
                    modifyProductTitle.setFont(new Font(15));

                    Text modifyProductIdTitleText = new Text("ID");
                    modifyProductIdTitleText.setFont(new Font(15));

                    Text modifyProductNameTitleText = new Text("Name");
                    modifyProductNameTitleText.setFont(new Font(15));

                    Text modifyProductStockTitleText = new Text("Inv.");
                    modifyProductStockTitleText.setFont(new Font(15));

                    Text modifyProductPriceTitleText = new Text("Price");
                    modifyProductPriceTitleText.setFont(new Font(15));

                    Text modifyProductMinTitleText = new Text("Min");
                    modifyProductMinTitleText.setFont(new Font(15));

                    Text modifyProductMaxTitleText = new Text("Max");
                    modifyProductMaxTitleText.setFont(new Font(15));

                    modifyProductTitleGrid.getChildren().add(modifyProductTitle);
                    modifyProductIdTitleTextGrid.getChildren().add(modifyProductIdTitleText);
                    modifyProductNameTitleTextGrid.getChildren().add(modifyProductNameTitleText);
                    modifyProductStockTitleTextGrid.getChildren().add(modifyProductStockTitleText);
                    modifyProductPriceTitleTextGrid.getChildren().add(modifyProductPriceTitleText);
                    modifyProductMinTitleTextGrid.getChildren().addAll(modifyProductMinTitleText);
                    modifyProductMaxTitleTextGrid.getChildren().add(modifyProductMaxTitleText);


                    // <------------ Modify Product Title Text Grid Setup End -------------> //



                    // <------------ Modify Product Title TextField Grid Setup Beginning -------------> //


                    TextField modifyProductNameTextField = new TextField();
                    TextField modifyProductStockTextField = new TextField();
                    TextField modifyProductIdTextField = new TextField();
                    TextField modifyProductPriceTextField = new TextField();
                    TextField modifyProductMinTextField = new TextField();
                    TextField modifyProductMaxTextField = new TextField();

                    modifyProductNameTextFieldGrid.getChildren().add(modifyProductNameTextField);
                    modifyProductStockTextFieldGrid.getChildren().add(modifyProductStockTextField);
                    modifyProductIdTextFieldGrid.getChildren().add(modifyProductIdTextField);
                    modifyProductPriceTextFieldGrid.getChildren().add(modifyProductPriceTextField);
                    modifyProductMinTextFieldGrid.getChildren().addAll(modifyProductMinTextField);
                    modifyProductMaxTextFieldGrid.getChildren().add(modifyProductMaxTextField);


                    // <------------ Modify Product Title TextField Grid Setup End -------------> //


                    // <------------ Modify Product Button Grid Setup Beginning -------------> //


                    GridPane modifyProductButtonCage = new GridPane();

                    Button addAssociatedPartButtonModify = new Button("Add");
                    Button removeAssociatedPartButtonModify = new Button("Remove Associated Part");
                    Button saveModifiedProduct = new Button("Save");
                    Button cancelModifiedProduct = new Button("Cancel");

                    modifyProductButtonCage.getChildren().addAll(removeAssociatedPartButtonModify, saveModifiedProduct, cancelModifiedProduct);

                    GridPane.setConstraints(removeAssociatedPartButtonModify, 0,0,2,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES);
                    GridPane.setConstraints(saveModifiedProduct, 0,1,1,1, HPos.RIGHT, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(0,15,0,0));
                    GridPane.setConstraints(cancelModifiedProduct, 1,1,1,1, LEFT, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES);

                    modifyProductButtonCage.setHgap(25);
                    modifyProductButtonCage.setVgap(15);


                    // <------------ Modify Product Button Grid Setup End -------------> //



                    // <------------ Modify Product Associated Parts Grid Setup Beginning -------------> //


                        GridPane modifyProductCleanerFixerUpper = new GridPane();
                        GridPane associatedPartGridModify = new GridPane();
                        GridPane associatedPartsTableGridModify = new GridPane();
                        GridPane associatablePartsTableGridModify = new GridPane();
                        GridPane associatablePartsGridModify = new GridPane();

                        modifyProductMenuGrid.getChildren().add(modifyProductCleanerFixerUpper);

                        // Associatable Parts (All Parts) Grid
                        TableView<Part> associatablePartsTableModify = new TableView<>();
                        associatablePartsTableGridModify.getChildren().add(associatablePartsTableModify);
                        associatablePartsGridModify.getChildren().addAll(modifyProductSearchBar, associatablePartsTableGridModify, addAssociatedPartButtonModify);

                        TableColumn<Part, Integer> associatableModifyProductIdColumn = new TableColumn<>("ID");
                        associatableModifyProductIdColumn.setMinWidth(115);
                        associatableModifyProductIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

                        TableColumn<Part, String> associatableModifyProductNameColumn = new TableColumn<>("Name");
                        associatableModifyProductNameColumn.setMinWidth(115);
                        associatableModifyProductNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

                        TableColumn<Part, Double> associatableModifyProductPriceColumn = new TableColumn<>("Price");
                        associatableModifyProductPriceColumn.setMinWidth(115);
                        associatableModifyProductPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

                        TableColumn<Part, Integer> associatableModifyProductStockColumn = new TableColumn<>("Stock");
                        associatableModifyProductStockColumn.setMinWidth(115);
                        associatableModifyProductStockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));

                        associatablePartsTableModify.setItems(getAllParts());
                        associatablePartsTableModify.getColumns().add(associatableModifyProductIdColumn);
                        associatablePartsTableModify.getColumns().add(associatableModifyProductNameColumn);
                        associatablePartsTableModify.getColumns().add(associatableModifyProductPriceColumn);
                        associatablePartsTableModify.getColumns().add(associatableModifyProductStockColumn);

                        modifyProductCleanerFixerUpper.getChildren().add(associatablePartsGridModify);

                        GridPane.setConstraints(associatablePartsGridModify, 1,0,1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
                        GridPane.setConstraints(associatablePartsTableModify,0,1,1,1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(5,5,5,5));
                        GridPane.setConstraints(modifyProductSearchBar, 0,0,1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(15));
                        GridPane.setConstraints(associatablePartsTableGridModify, 0,1,1,1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(5,5,5,5));
                        GridPane.setConstraints(addAssociatedPartButtonModify,0,2,1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));

                        // Associated Parts Grid
                        TableView<Part> associatedPartsTableModify = new TableView<>();

                        associatedPartsTableGridModify.getChildren().add(associatedPartsTableModify);
                        associatedPartGridModify.getChildren().addAll(associatedPartsTableModify, modifyProductButtonCage);

                        TableColumn<Part, Integer> associatedModifyProductIdColumn = new TableColumn<>("ID");
                        associatedModifyProductIdColumn.setMinWidth(115);
                        associatedModifyProductIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

                        TableColumn<Part, String> associatedModifyProductNameColumn = new TableColumn<>("Name");
                        associatedModifyProductNameColumn.setMinWidth(115);
                        associatedModifyProductNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

                        TableColumn<Part, Double> associatedModifyProductPriceColumn = new TableColumn<>("Price");
                        associatedModifyProductPriceColumn.setMinWidth(115);
                        associatedModifyProductPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

                        TableColumn<Part, Integer> associatedModifyProductStockColumn = new TableColumn<>("Stock");
                        associatedModifyProductStockColumn.setMinWidth(115);
                        associatedModifyProductStockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));

                        associatedPartsTableModify.getColumns().add(associatedModifyProductIdColumn);
                        associatedPartsTableModify.getColumns().add(associatedModifyProductNameColumn);
                        associatedPartsTableModify.getColumns().add(associatedModifyProductPriceColumn);
                        associatedPartsTableModify.getColumns().add(associatedModifyProductStockColumn);

                        GridPane.setConstraints(associatedPartsTableModify, 0,0,1,1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(5,5,5,5));
                        GridPane.setConstraints(modifyProductButtonCage,0,1,1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));

                        modifyProductCleanerFixerUpper.getChildren().add(associatedPartGridModify);

                        GridPane.setConstraints(associatedPartGridModify, 1,1,1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));


                    // <------------ Modify Product Associated Parts Grid Setup End -------------> //


                        ColumnConstraints mPMGColumn1Modify = new ColumnConstraints();
                        ColumnConstraints mPMGColumn2Modify = new ColumnConstraints();
                        mPMGColumn1Modify.setPercentWidth(50);
                        mPMGColumn2Modify.setPercentWidth(50);
                        modifyProductMenuGrid.setMinSize(500,400);
                        modifyProductMenuGrid.setMaxSize(1500,800);


                        modifyProductMenuGrid.getColumnConstraints().addAll(mPMGColumn1Modify, mPMGColumn1Modify);
                        GridPane.setConstraints(modifyProductGrid, 0,0,1,1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(5,5,5,5));
                        GridPane.setConstraints(modifyProductCleanerFixerUpper,1,0,1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));

                // <------------ Modify Product Menu Sub-Grids Setup End -------------> //


        // <------------ Modify Product Menu Setup End -------------> //




        GridPane conAddGood = new GridPane();
        Text conAddGoodInfo = new Text("Addition Successful");
        Button conAddGoodCloseButton = new Button("Close");
        conAddGoodInfo.setFont(new Font(20));
        conAddGood.getChildren().add(conAddGoodInfo);
        conAddGood.getChildren().add(conAddGoodCloseButton);
        sceneChanger(mainMenuGrid,mainMenuGrid,conAddGoodCloseButton,conAddGoodCloseButton);
        GridPane.setConstraints(conAddGoodInfo,0,0,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(25));
        GridPane.setConstraints(conAddGoodCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));

        GridPane conAddBad = new GridPane();
        Text conAddBadInfo = new Text("Addition Unsuccessful");
        Button conAddBadCloseButton = new Button("Close");
        conAddBadInfo.setFont(new Font(20));
        conAddBad.getChildren().add(conAddBadInfo);
        conAddBad.getChildren().add(conAddBadCloseButton);
        sceneChanger(mainMenuGrid,mainMenuGrid,conAddBadCloseButton,conAddBadCloseButton);
        GridPane.setConstraints(conAddBadInfo,0,0,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(25));
        GridPane.setConstraints(conAddBadCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));

        GridPane conModifyGood = new GridPane();
        Text conModifyGoodInfo = new Text("Modification Successful");
        Button conModifyGoodCloseButton = new Button("Close");
        conModifyGoodInfo.setFont(new Font(20));
        conModifyGood.getChildren().add(conModifyGoodInfo);
        conModifyGood.getChildren().add(conModifyGoodCloseButton);
        sceneChanger(mainMenuGrid,mainMenuGrid,conModifyGoodCloseButton,conModifyGoodCloseButton);
        GridPane.setConstraints(conModifyGoodInfo,0,0,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(25));
        GridPane.setConstraints(conModifyGoodCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));

        GridPane conModifyBad = new GridPane();
        Text conModifyBadInfo = new Text("Modification Unsuccessful");
        Button conModifyBadCloseButton = new Button("Close");
        conModifyBadInfo.setFont(new Font(20));
        conModifyBad.getChildren().add(conModifyBadInfo);
        conModifyBad.getChildren().add(conModifyBadCloseButton);
        sceneChanger(mainMenuGrid,mainMenuGrid,conModifyBadCloseButton,conModifyBadCloseButton);
        GridPane.setConstraints(conModifyBadInfo,0,0,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(25));
        GridPane.setConstraints(conModifyBadCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));

        GridPane partDeletion = new GridPane();
        Text partDeletionInfo = new Text("Deletion Successful");
        Button partDeletionCloseButton = new Button("Close");
        partDeletionInfo.setFont(new Font(20));
        partDeletion.getChildren().add(partDeletionInfo);
        partDeletion.getChildren().add(partDeletionCloseButton);
        sceneChanger(mainMenuGrid,mainMenuGrid,partDeletionCloseButton,partDeletionCloseButton);
        GridPane.setConstraints(partDeletionInfo,0,0,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(25));
        GridPane.setConstraints(partDeletionCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));

        GridPane productDeletion = new GridPane();
        Text productDeletionInfo = new Text("Deletion Successful");
        Button productDeletionCloseButton = new Button("Close");
        productDeletionInfo.setFont(new Font(20));
        productDeletion.getChildren().add(productDeletionInfo);
        productDeletion.getChildren().add(productDeletionCloseButton);
        sceneChanger(mainMenuGrid,mainMenuGrid,productDeletionCloseButton,productDeletionCloseButton);
        GridPane.setConstraints(productDeletionInfo,0,0,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(25));
        GridPane.setConstraints(productDeletionCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));

        //Event Testing Site

        searchPart(partsSearchBar,partsTableView);
        searchPart(addProductSearchBar,associatablePartsTable);
        searchPart(modifyProductSearchBar,associatablePartsTableModify);
        searchProduct(productsSearchBar,productsTableView);

        sceneChanger(addNewPartGrid, mainMenuGrid,addPartButton, cancelNewPart);
        sceneChanger(modifyPartGrid, mainMenuGrid,modifyPartButton, cancelModifiedPart);
        saveNewPart(partType, inHousePart, outsourcedPart,addPartButton,addPartIdTextField,addPartNameTextField,addPartPriceTextField,addPartStockTextField,addPartMinTextField,addPartMaxTextField,addPartMachineIdText, machineIdTitleText,saveNewPart,conAddGood, conAddBad, partsTableView);
        modifyPart(modifyPartType, modifyPartButton,modifyInHousePart,modifyOutsourcedPart,modifyPartIdTextField,modifyPartNameTextField,modifyPartPriceTextField,modifyPartStockTextField,modifyPartMinTextField,modifyPartMaxTextField,modifyPartMachineIdTextField, modifyMachineIdTitleText,saveModifiedPart,conModifyGood, conModifyBad,partsTableView);
        deleteSelectedPart(deletePartButton, partDeletion,partsTableView);

        sceneChanger(addProductMenuGrid, mainMenuGrid,addProductButton, cancelNewProduct);
        sceneChanger(modifyProductMenuGrid, mainMenuGrid,modifyProductButton, cancelModifiedProduct);
        saveNewProduct(addProductButton,addProductIdTextField,addProductNameTextField,addProductPriceTextField,addProductStockTextField,addProductMinTextField,addProductMaxTextField,saveNewProduct,addAssociatedPartButton,removeAssociatedPartButton,conAddGood, conAddBad,associatablePartsTable,associatedPartsTable, productsTableView, productsSearchBar);
        modifyProduct(modifyProductIdTextField,modifyProductNameTextField,modifyProductPriceTextField,modifyProductStockTextField,modifyProductMinTextField,modifyProductMaxTextField,saveModifiedProduct,addAssociatedPartButtonModify,removeAssociatedPartButtonModify,modifyProductButton,conModifyGood,conModifyBad,partsTableView,associatedPartsTableModify,productsTableView);
        deleteSelectedProduct(deleteProductButton,productDeletion,productsTableView);

        closeProgram(exitButton);

        toastyScene = new Scene(mainMenuGrid);
        toastyStage.setTitle("Inventory Management System");
        toastyStage.setScene(toastyScene);
        toastyStage.sizeToScene();
        toastyStage.show();
    }



//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
    }
}
