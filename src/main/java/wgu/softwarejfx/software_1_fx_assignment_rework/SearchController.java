package wgu.softwarejfx.software_1_fx_assignment_rework;

import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;

import java.util.function.Predicate;


public class SearchController {

    /**
     *
     * @param searchText
     * This method accepts a string that will be used to find a desired part
     * @return
     * This method will return that string in real time to a different method
     *
     */
    protected static Predicate<Part> createPartPredicate(String searchText){
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
    protected static Predicate<Product> createProductPredicate(String searchText){
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
    protected static boolean searchFindsPart(Part part, String searchText){
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
    protected static boolean searchFindsProduct(Product product, String searchText){
        return (product.getName().toLowerCase().contains(searchText)) ||
                (Integer.valueOf(product.getId()).toString().equals(searchText));
    }


    //    /**
//     *
//     * @param searchBar
//     * This method accepts a text-field that will be used to search for a particular part
//     * @param partTableView
//     * This method will display any matching part within a row of the table
//     */
//    @FXML
//    protected static void searchPart(){
//        try{
//            FilteredList<Part> partsFilteredList = new FilteredList<>(FXCollections.observableList(getAllParts()));
//            allPartsTable.setItems(partsFilteredList);
//
//            partsSearchBar.textProperty().addListener(((observable, oldValue, newValue) ->
//                    partsFilteredList.setPredicate(createPartPredicate(newValue))));
//        }
//        catch (NullPointerException e){
//            allPartsTable.setItems(getAllParts());
//        }
//    }

    //    /**
//     *
//     * @param searchBar
//     * This method accepts a text-field that will be used to search for a particular product
//     * @param productTableView
//     * This method will display any matching product within a row of the table
//     */
//    @FXML
//    protected static void searchProduct(){
//        try{
//            FilteredList<Product> productsFilteredList = new FilteredList<>(FXCollections.observableList(getAllProducts()));
//            allProductsTable.setItems(productsFilteredList);
//
//            productsSearchBar.textProperty().addListener(((observable, oldValue, newValue) ->
//                    productsFilteredList.setPredicate(createProductPredicate(newValue))));
//        }
//        catch (NullPointerException e){
//            allProductsTable.setItems(getAllProducts());
//        }
//    }
}
