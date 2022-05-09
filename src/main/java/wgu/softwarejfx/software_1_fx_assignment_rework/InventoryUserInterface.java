//package wgu.softwarejfx.software_1_fx_assignment_rework;
//
//import javafx.geometry.HPos;
//import javafx.geometry.VPos;
//import javafx.scene.control.*;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.layout.ColumnConstraints;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.Priority;
//import javafx.scene.text.Text;
//
//public class InventoryUserInterface {
//    toastyStage = stage;
//
//    //Grid Creation
//    GridPane mainMenuGrid = new GridPane();
//    GridPane partsGrid = new GridPane();
//    GridPane productsGrid = new GridPane();
//    GridPane partButtonGrid = new GridPane();
//    GridPane productButtonGrid = new GridPane();
//    GridPane exitButtonGrid = new GridPane();
//    GridPane mainMenuTitleGrid = new GridPane();
//    GridPane partTitleGrid = new GridPane();
//    GridPane productTitleGrid = new GridPane();
//    GridPane mainMenuPartSearchBar = new GridPane();
//    GridPane addProductMenuSearchBar = new GridPane();
//    GridPane modifyProductMenuSearchBar = new GridPane();
//    GridPane productSearchBar = new GridPane();
//    GridPane partsTable = new GridPane();
//    GridPane productsTable = new GridPane();
//
//    //Main Menu Setup
//        mainMenuGrid.getChildren().add(mainMenuTitleGrid);
//        mainMenuGrid.getChildren().add(partsGrid);
//        mainMenuGrid.getChildren().add(productsGrid);
//        mainMenuGrid.getChildren().add(exitButtonGrid);
//        GridPane.setMargin(mainMenuGrid, new Insets(15));
//        mainMenuGrid.setMinSize(1000,600);
//        GridPane.setConstraints(mainMenuTitleGrid, 0, 0, 1, 1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(15));
//        GridPane.setConstraints(partsGrid, 0, 1, 1, 1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(15));
//        GridPane.setConstraints(productsGrid, 1, 1, 1, 1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(15));
//
//    //Part Grid Setup
//        partsGrid.getChildren().add(partTitleGrid);
//        partsGrid.getChildren().add(mainMenuPartSearchBar);
//        partsGrid.getChildren().add(partsTable);
//        partsGrid.getChildren().add(partButtonGrid);
//        GridPane.setConstraints(partTitleGrid,0,0,1,1,HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(15));
//        GridPane.setConstraints(mainMenuPartSearchBar,1, 0,1,1,HPos.RIGHT, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(15));
//        GridPane.setConstraints(partsTable, 0,1,GridPane.REMAINING,1,HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(15));
//        GridPane.setConstraints(partButtonGrid,1,2,1,1,HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(15));
//
//    //Product Grid Setup
//        productsGrid.getChildren().add(productTitleGrid);
//        productsGrid.getChildren().add(productSearchBar);
//        productsGrid.getChildren().add(productsTable);
//        productsGrid.getChildren().add(productButtonGrid);
//        GridPane.setConstraints(productTitleGrid,0,0,1,1,HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(15));
//        GridPane.setConstraints(productSearchBar,1, 0,1,1,HPos.RIGHT, VPos.CENTER,Priority.SOMETIMES, Priority.SOMETIMES, new Insets(15));
//        GridPane.setConstraints(productsTable, 0,1,GridPane.REMAINING,1,HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(15));
//        GridPane.setConstraints(productButtonGrid,1,2,1,1,HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(15));
//
//    //Main Menu Title Setup
//    Text mainMenuTitle = new Text("Inventory Management System");
//        mainMenuTitle.setFont(new Font(30));
//        mainMenuTitleGrid.getChildren().add(mainMenuTitle);
//        GridPane.setConstraints(mainMenuTitle, 0,0,1,1, LEFT, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS);
//
//
//    //Parts Title Setup
//    Text partsTitle = new Text( "Parts");
//        partsTitle.setFont(new Font(25));
//        partTitleGrid.getChildren().add(partsTitle);
//
//    //Product Title Setup
//    Text productsTitle = new Text("Products");
//        productsTitle.setFont(new Font(25));
//        productTitleGrid.getChildren().add(productsTitle);
//
//
//    //Parts SearchBar Setup
//    TextField partsSearchBar = new TextField();
//        partsSearchBar.setPromptText("Search by Part ID or Name");
//        mainMenuPartSearchBar.getChildren().add(partsSearchBar);
//
//    TextField addProductSearchBar = new TextField();
//        addProductSearchBar.setPromptText("Search by Part ID or Name");
//        addProductMenuSearchBar.getChildren().add(addProductSearchBar);
//
//    TextField modifyProductSearchBar = new TextField();
//        modifyProductSearchBar.setPromptText("Search by Product ID or Name");
//        modifyProductMenuSearchBar.getChildren().add(modifyProductSearchBar);
//
//    //Products SearchBar Setup
//    TextField productsSearchBar = new TextField();
//        productsSearchBar.setPromptText("Search by Product ID or Name");
//        productSearchBar.getChildren().add(productsSearchBar);
//
//
//    //Part Table Setup
//
//    TableView<Part> partsTableView;
//
//    TableColumn<Part, Integer> idColumn = new TableColumn<>("ID");
//            idColumn.setMinWidth(115);
//            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
//
//    TableColumn<Part, String> nameColumn = new TableColumn<>("Name");
//            nameColumn.setMinWidth(115);
//            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//
//    TableColumn<Part, Double> priceColumn = new TableColumn<>("Price");
//            priceColumn.setMinWidth(115);
//            priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
//
//    TableColumn<Part, Integer> stockColumn = new TableColumn<>("Stock");
//            stockColumn.setMinWidth(115);
//            stockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
//
//    TableColumn<Part, Integer> minColumn = new TableColumn<>("Min");
//            minColumn.setMinWidth(115);
//            minColumn.setCellValueFactory(new PropertyValueFactory<>("min"));
//
//    TableColumn<Part, Integer> maxColumn = new TableColumn<>("Max");
//            maxColumn.setMinWidth(115);
//            maxColumn.setCellValueFactory(new PropertyValueFactory<>("max"));
//
//    partsTableView = new TableView<>();
//            partsTableView.setItems(getAllParts());
//            partsTableView.getColumns().add(idColumn);
//            partsTableView.getColumns().add(nameColumn);
//            partsTableView.getColumns().add(priceColumn);
//            partsTableView.getColumns().add(stockColumn);
//            partsTableView.getColumns().add(minColumn);
//            partsTableView.getColumns().add(maxColumn);
//            partsTable.getChildren().add(partsTableView);
//
//
//    //Product Table Setup
//
//    TableView<Product> productsTableView;
//
//    TableColumn<Product, Integer> productIdColumn = new TableColumn<>("ID");
//        productIdColumn.setMinWidth(115);
//        productIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
//
//    TableColumn<Product, String> productNameColumn = new TableColumn<>("Name");
//        productNameColumn.setMinWidth(115);
//        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//
//    TableColumn<Product, Double> productPriceColumn = new TableColumn<>("Price");
//        productPriceColumn.setMinWidth(115);
//        productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
//
//    TableColumn<Product, Integer> productStockColumn = new TableColumn<>("Stock");
//        productStockColumn.setMinWidth(115);
//        productStockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
//
//    TableColumn<Product, Integer> productMinColumn = new TableColumn<>("Min");
//        productMinColumn.setMinWidth(115);
//        productMinColumn.setCellValueFactory(new PropertyValueFactory<>("min"));
//
//    TableColumn<Product, Integer> productMaxColumn = new TableColumn<>("Max");
//        productMaxColumn.setMinWidth(115);
//        productMaxColumn.setCellValueFactory(new PropertyValueFactory<>("max"));
//
//    productsTableView = new TableView<>();
//        productsTableView.setItems(getAllProducts());
//        productsTableView.getColumns().add(productIdColumn);
//        productsTableView.getColumns().add(productNameColumn);
//        productsTableView.getColumns().add(productPriceColumn);
//        productsTableView.getColumns().add(productStockColumn);
//        productsTableView.getColumns().add(productMinColumn);
//        productsTableView.getColumns().add(productMaxColumn);
//        productsTable.getChildren().add(productsTableView);
//
//    //Part Grid Button Setup
//    Button addPartButton = new Button("Add");
//    Button modifyPartButton = new Button("Modify");
//    Button deletePartButton = new Button("Delete");
//            partButtonGrid.getChildren().addAll(addPartButton, modifyPartButton, deletePartButton);
//            GridPane.setConstraints(addPartButton, 0,0);
//            GridPane.setConstraints(modifyPartButton, 1, 0);
//            GridPane.setConstraints(deletePartButton, 2, 0);
//            partButtonGrid.setHgap(10);
//
//
//
//    //Product Grid Button Setup
//    Button addProductButton = new Button("Add");
//    Button modifyProductButton = new Button("Modify");
//    Button deleteProductButton = new Button("Delete");
//            productButtonGrid.getChildren().addAll(addProductButton, modifyProductButton, deleteProductButton);
//            GridPane.setConstraints(addProductButton, 0,0);
//            GridPane.setConstraints(modifyProductButton, 1, 0);
//            GridPane.setConstraints(deleteProductButton, 2, 0);
//            productButtonGrid.setHgap(10);
//
//
//    //Main Menu Exit Button Setup
//    Button exitButton = new Button("Exit");
//            mainMenuGrid.getChildren().add(exitButton);
//            GridPane.setConstraints(exitButton, 1, 2, 1,1, HPos.RIGHT, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(15));
//
//
//    //Add Product & Part Menus
//
//    //Add New Product & Part Menu Super Grid
//    GridPane addNewPartGrid = new GridPane();
//    GridPane addPartMinTextHybrid = new GridPane();
//    GridPane addProductMinTextHybrid = new GridPane();
//    GridPane addProductMenuGrid = new GridPane();
//
//    //Modify Product & Part Menu Super Grid
//    GridPane modifyPartGrid = new GridPane();
//    GridPane modifyPartMinTextHybrid = new GridPane();
//    GridPane modifyProductMinTextHybrid = new GridPane();
//    GridPane modifyProductMenuGrid = new GridPane();
//
//
//    //Part Title Text Grids
//    GridPane addPartTitleGrid = new GridPane();
//    GridPane addPartIdTitleTextGrid = new GridPane();
//    GridPane addPartNameTitleTextGrid = new GridPane();
//    GridPane addPartStockTitleTextGrid = new GridPane();
//    GridPane addPartPriceTitleTextGrid = new GridPane();
//    GridPane addPartMinTitleTextGrid = new GridPane();
//    GridPane addPartMaxTitleTextGrid = new GridPane();
//    GridPane addPartMachineIdTitleTextGrid = new GridPane();
//
//    GridPane modifyPartTitleGrid = new GridPane();
//    GridPane modifyPartIdTitleTextGrid = new GridPane();
//    GridPane modifyPartNameTitleTextGrid = new GridPane();
//    GridPane modifyPartStockTitleTextGrid = new GridPane();
//    GridPane modifyPartPriceTitleTextGrid = new GridPane();
//    GridPane modifyPartMinTitleTextGrid = new GridPane();
//    GridPane modifyPartMaxTitleTextGrid = new GridPane();
//    GridPane modifyPartMachineIdTitleTextGrid = new GridPane();
//
//    //Product Title Text Grids
//    GridPane addProductTitleGrid = new GridPane();
//    GridPane addProductIdTitleTextGrid = new GridPane();
//    GridPane addProductNameTitleTextGrid = new GridPane();
//    GridPane addProductStockTitleTextGrid = new GridPane();
//    GridPane addProductPriceTitleTextGrid = new GridPane();
//    GridPane addProductMinTitleTextGrid = new GridPane();
//    GridPane addProductMaxTitleTextGrid = new GridPane();
//
//    GridPane modifyProductTitleGrid = new GridPane();
//    GridPane modifyProductIdTitleTextGrid = new GridPane();
//    GridPane modifyProductNameTitleTextGrid = new GridPane();
//    GridPane modifyProductStockTitleTextGrid = new GridPane();
//    GridPane modifyProductPriceTitleTextGrid = new GridPane();
//    GridPane modifyProductMinTitleTextGrid = new GridPane();
//    GridPane modifyProductMaxTitleTextGrid = new GridPane();
//
//
//    //Part TextField Grids
//    GridPane addPartNameTextFieldGrid = new GridPane();
//    GridPane addPartStockTextFieldGrid = new GridPane();
//    GridPane addPartPriceTextFieldGrid = new GridPane();
//    GridPane addPartIdTextFieldGrid = new GridPane();
//    GridPane addPartMinTextFieldGrid = new GridPane();
//    GridPane addPartMaxTextFieldGrid = new GridPane();
//    GridPane addPartMachineIdTextFieldGrid = new GridPane();
//
//    GridPane modifyPartNameTextFieldGrid = new GridPane();
//    GridPane modifyPartStockTextFieldGrid = new GridPane();
//    GridPane modifyPartPriceTextFieldGrid = new GridPane();
//    GridPane modifyPartIdTextFieldGrid = new GridPane();
//    GridPane modifyPartMinTextFieldGrid = new GridPane();
//    GridPane modifyPartMaxTextFieldGrid = new GridPane();
//    GridPane modifyPartMachineIdTextFieldGrid = new GridPane();
//
//
//    //Product TextField Grids
//    GridPane addProductIdTextFieldGrid = new GridPane();
//    GridPane addProductNameTextFieldGrid = new GridPane();
//    GridPane addProductPriceTextFieldGrid = new GridPane();
//    GridPane addProductStockTextFieldGrid = new GridPane();
//    GridPane addProductMinTextFieldGrid = new GridPane();
//    GridPane addProductMaxTextFieldGrid = new GridPane();
//
//    GridPane modifyProductIdTextFieldGrid = new GridPane();
//    GridPane modifyProductNameTextFieldGrid = new GridPane();
//    GridPane modifyProductPriceTextFieldGrid = new GridPane();
//    GridPane modifyProductStockTextFieldGrid = new GridPane();
//    GridPane modifyProductMinTextFieldGrid = new GridPane();
//    GridPane modifyProductMaxTextFieldGrid = new GridPane();
//
//
//
//
//
//    //Button Grids
//    GridPane inHousePartGrid = new GridPane();
//    GridPane outsourcedPartGrid = new GridPane();
//    GridPane editPartButtonGrid = new GridPane();
//
//    GridPane modifyInHousePartGrid = new GridPane();
//    GridPane modifyOutsourcedPartGrid = new GridPane();
//    GridPane editModifiedPartButtonGrid = new GridPane();
//
//
//    // <------------ Add New Part Menu Super Grid Setup Beginning -------------> //
//
//
//            addNewPartGrid.getChildren().addAll(addPartTitleGrid, inHousePartGrid,
//                                                outsourcedPartGrid, addPartIdTitleTextGrid, addPartIdTextFieldGrid,
//                                                addPartNameTitleTextGrid, addPartNameTextFieldGrid, addPartStockTitleTextGrid,
//                                                addPartStockTextFieldGrid, addPartPriceTitleTextGrid, addPartPriceTextFieldGrid,
//                                                addPartMinTextHybrid, addPartMaxTitleTextGrid,
//                                                addPartMaxTextFieldGrid,addPartMachineIdTitleTextGrid, addPartMachineIdTextFieldGrid,editPartButtonGrid);
//            GridPane.setMargin(addNewPartGrid, new Insets(5,5,5,5));
//            addNewPartGrid.setMinSize(600,700);
//
//            GridPane.setConstraints(addNewPartGrid,0,0,2,1);
//
//        addPartMinTextHybrid.getChildren().addAll(addPartMinTitleTextGrid, addPartMinTextFieldGrid);
//        GridPane.setConstraints(addPartMinTitleTextGrid, 0,0, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES);
//        GridPane.setConstraints(addPartMinTextFieldGrid, 1,0, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES);
//    ColumnConstraints superColWidth1 =new ColumnConstraints();
//        superColWidth1.setPercentWidth(20);
//    ColumnConstraints superColWidth2 =new ColumnConstraints();
//        superColWidth2.setPercentWidth(35);
//    ColumnConstraints superColWidth3 =new ColumnConstraints();
//        superColWidth3.setPercentWidth(45);
//
//        addNewPartGrid.getColumnConstraints().addAll(superColWidth1,superColWidth2,superColWidth3);
//        addNewPartGrid.setPadding(new Insets(30));
//
//            GridPane.setConstraints(addPartTitleGrid, 0,0, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
//            GridPane.setConstraints(inHousePartGrid, 1,0, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//            GridPane.setConstraints(outsourcedPartGrid, 2,0, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//            GridPane.setConstraints(addPartIdTitleTextGrid, 0,1, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
//            GridPane.setConstraints(addPartIdTextFieldGrid, 1,1, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//            GridPane.setConstraints(addPartNameTitleTextGrid, 0,2, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
//            GridPane.setConstraints(addPartNameTextFieldGrid, 1,2, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//            GridPane.setConstraints(addPartStockTitleTextGrid, 0,3, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
//            GridPane.setConstraints(addPartStockTextFieldGrid, 1,3, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//            GridPane.setConstraints(addPartPriceTitleTextGrid, 0,4, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
//            GridPane.setConstraints(addPartPriceTextFieldGrid, 1,4, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//            GridPane.setConstraints(addPartMinTextHybrid, 2,5, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
//            GridPane.setConstraints(addPartMaxTitleTextGrid, 0,5, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
//            GridPane.setConstraints(addPartMaxTextFieldGrid, 1,5, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//            GridPane.setConstraints(addPartMachineIdTitleTextGrid, 0,6, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
//            GridPane.setConstraints(addPartMachineIdTextFieldGrid, 1,6, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//            GridPane.setConstraints(editPartButtonGrid, 2,7, 1,1, HPos.RIGHT, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//
//
//    // <------------ Add New Part Menu Super Grid Setup End -------------> //
//
//
//
//    // <------------ Add New Part Title Text Grid Setup Beginning -------------> //
//
//
//    Text addPartTitle = new Text("Add Part");
//                addPartTitle.setFont(new Font(15));
//    Text idTitleText = new Text("ID");
//                idTitleText.setFont(new Font(15));
//    Text nameTitleText = new Text("Name");
//                nameTitleText.setFont(new Font(15));
//    Text invTitleText = new Text("Inv.");
//                invTitleText.setFont(new Font(15));
//    Text priceTitleText = new Text("Price");
//                priceTitleText.setFont(new Font(15));
//    Text minTitleText = new Text("Min");
//                minTitleText.setFont(new Font(15));
//    Text maxTitleText = new Text("Max");
//                maxTitleText.setFont(new Font(15));
//    Text machineIdTitleText = new Text("Machine ID");
//                machineIdTitleText.setFont(new Font(15));
//            addPartTitleGrid.getChildren().add(addPartTitle);
//            addPartIdTitleTextGrid.getChildren().add(idTitleText);
//            addPartNameTitleTextGrid.getChildren().add(nameTitleText);
//            addPartStockTitleTextGrid.getChildren().add(invTitleText);
//            addPartPriceTitleTextGrid.getChildren().add(priceTitleText);
//            addPartMinTitleTextGrid.getChildren().addAll(minTitleText);
//            addPartMaxTitleTextGrid.getChildren().add(maxTitleText);
//            addPartMachineIdTitleTextGrid.getChildren().add(machineIdTitleText);
//
//
//    // <------------ Add New Part Title Text Grid Setup End -------------> //
//
//
//
//    // <------------ Add New Part Title TextField Grid Setup Beginning -------------> //
//
//
//    TextField addPartNameTextField = new TextField();
//    TextField addPartStockTextField = new TextField();
//    TextField addPartIdTextField = new TextField();
//    TextField addPartPriceTextField = new TextField();
//    TextField addPartMinTextField = new TextField();
//    TextField addPartMaxTextField = new TextField();
//    TextField addPartMachineIdText = new TextField();
//            addPartNameTextFieldGrid.getChildren().add(addPartNameTextField);
//            addPartStockTextFieldGrid.getChildren().add(addPartStockTextField);
//            addPartIdTextFieldGrid.getChildren().add(addPartIdTextField);
//            addPartPriceTextFieldGrid.getChildren().add(addPartPriceTextField);
//            addPartMinTextFieldGrid.getChildren().addAll(addPartMinTextField);
//            addPartMaxTextFieldGrid.getChildren().add(addPartMaxTextField);
//            addPartMachineIdTextFieldGrid.getChildren().add(addPartMachineIdText);
//
//
//    // <------------ Add New Part Title TextField Grid Setup End -------------> //
//
//
//
//
//    // <------------ Add New Part Button Grid Setup Beginning -------------> //
//
//
//    ToggleGroup partType = new ToggleGroup();
//    RadioButton inHousePart = new RadioButton("In-House");
//    RadioButton outsourcedPart = new RadioButton("Outsourced");
//            inHousePart.setToggleGroup(partType);
//            outsourcedPart.setToggleGroup(partType);
//    Button saveNewPart = new Button("Save");
//    Button cancelNewPart = new Button("Cancel");
//            editPartButtonGrid.getChildren().addAll(saveNewPart, cancelNewPart);
//            GridPane.setConstraints(saveNewPart,0,0);
//            GridPane.setConstraints(cancelNewPart,1,0);
//            inHousePartGrid.getChildren().add(inHousePart);
//            outsourcedPartGrid.getChildren().add(outsourcedPart);
//            editPartButtonGrid.setHgap(25);
//
//
//    // <------------ Add New Part Button Grid Setup End -------------> //
//
//
//
//
//    // <------------ Add New Product Menu Setup Beginning -------------> //
//
//
//    // <------------ Add New Product Menu Super Grid Setup Beginning -------------> //
//
//
//    GridPane addNewProductGrid = new GridPane();
//
//        addProductMenuGrid.getChildren().add(addNewProductGrid);
//
//        GridPane.setMargin(addNewProductGrid, new Insets(5,5,5,5));
//        addNewProductGrid.setMinSize(600,700);
//
//        addProductMinTextHybrid.getChildren().addAll(addProductMinTitleTextGrid, addProductMinTextFieldGrid);
//        GridPane.setConstraints(addProductMinTitleTextGrid, 0,0, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES);
//        GridPane.setConstraints(addProductMinTextFieldGrid, 1,0, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES);
//
//        addNewProductGrid.setPadding(new Insets(30));
//
//        GridPane.setConstraints(addProductTitleGrid, 0,0, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
//        GridPane.setConstraints(addProductIdTitleTextGrid, 0,1, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
//        GridPane.setConstraints(addProductIdTextFieldGrid, 1,1, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//        GridPane.setConstraints(addProductNameTitleTextGrid, 0,2, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
//        GridPane.setConstraints(addProductNameTextFieldGrid, 1,2, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//        GridPane.setConstraints(addProductStockTitleTextGrid, 0,3, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
//        GridPane.setConstraints(addProductStockTextFieldGrid, 1,3, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//        GridPane.setConstraints(addProductPriceTitleTextGrid, 0,4, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
//        GridPane.setConstraints(addProductPriceTextFieldGrid, 1,4, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//        GridPane.setConstraints(addProductMinTextHybrid, 2,5, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
//        GridPane.setConstraints(addProductMaxTitleTextGrid, 0,5, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
//        GridPane.setConstraints(addProductMaxTextFieldGrid, 1,5, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//
//
//
//    // <------------ Add New Product Menu Super Grid Setup End -------------> //
//
//
//
//    // <------------ Add New Product Menu Sub-Grids Setup Beginning -------------> //
//
//
//                addNewProductGrid.getChildren().addAll(addProductTitleGrid,
//                                                       addProductIdTitleTextGrid, addProductIdTextFieldGrid,
//                                                       addProductNameTitleTextGrid, addProductNameTextFieldGrid, addProductStockTitleTextGrid,
//                                                       addProductStockTextFieldGrid, addProductPriceTitleTextGrid, addProductPriceTextFieldGrid,
//                                                       addProductMinTextHybrid, addProductMaxTitleTextGrid, addProductMaxTextFieldGrid);
//
//    // <------------ Add New Product Title Text Grid Setup Beginning -------------> //
//
//
//    Text addProductTitle = new Text("Add Product");
//            addProductTitle.setFont(new Font(15));
//
//    Text addProductIdTitleText = new Text("ID");
//            addProductIdTitleText.setFont(new Font(15));
//
//    Text addProductNameTitleText = new Text("Name");
//            addProductNameTitleText.setFont(new Font(15));
//
//    Text addProductStockTitleText = new Text("Inv.");
//            addProductStockTitleText.setFont(new Font(15));
//
//    Text addProductPriceTitleText = new Text("Price");
//            addProductPriceTitleText.setFont(new Font(15));
//
//    Text addProductMinTitleText = new Text("Min");
//            addProductMinTitleText.setFont(new Font(15));
//
//    Text addProductMaxTitleText = new Text("Max");
//            addProductMaxTitleText.setFont(new Font(15));
//
//            addProductTitleGrid.getChildren().add(addProductTitle);
//            addProductIdTitleTextGrid.getChildren().add(addProductIdTitleText);
//            addProductNameTitleTextGrid.getChildren().add(addProductNameTitleText);
//            addProductStockTitleTextGrid.getChildren().add(addProductStockTitleText);
//            addProductPriceTitleTextGrid.getChildren().add(addProductPriceTitleText);
//            addProductMinTitleTextGrid.getChildren().addAll(addProductMinTitleText);
//            addProductMaxTitleTextGrid.getChildren().add(addProductMaxTitleText);
//
//
//    // <------------ Add New Product Title Text Grid Setup End -------------> //
//
//
//
//    // <------------ Add New Product Title TextField Grid Setup Beginning -------------> //
//
//
//    TextField addProductNameTextField = new TextField();
//    TextField addProductStockTextField = new TextField();
//    TextField addProductIdTextField = new TextField();
//    TextField addProductPriceTextField = new TextField();
//    TextField addProductMinTextField = new TextField();
//    TextField addProductMaxTextField = new TextField();
//
//            addProductNameTextFieldGrid.getChildren().add(addProductNameTextField);
//            addProductStockTextFieldGrid.getChildren().add(addProductStockTextField);
//            addProductIdTextFieldGrid.getChildren().add(addProductIdTextField);
//            addProductPriceTextFieldGrid.getChildren().add(addProductPriceTextField);
//            addProductMinTextFieldGrid.getChildren().addAll(addProductMinTextField);
//            addProductMaxTextFieldGrid.getChildren().add(addProductMaxTextField);
//
//
//    // <------------ Add New Product Title TextField Grid Setup End -------------> //
//
//
//    // <------------ Add New Product Button Grid Setup Beginning -------------> //
//
//
//    GridPane addProductButtonCage = new GridPane();
//
//    Button addAssociatedPartButton = new Button("Add");
//    Button removeAssociatedPartButton = new Button("Remove Associated Part");
//    Button saveNewProduct = new Button("Save");
//    Button cancelNewProduct = new Button("Cancel");
//
//            addProductButtonCage.getChildren().addAll(removeAssociatedPartButton, saveNewProduct, cancelNewProduct);
//
//            GridPane.setConstraints(removeAssociatedPartButton, 0,0,2,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES);
//            GridPane.setConstraints(saveNewProduct, 0,1,1,1, HPos.RIGHT, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(0,15,0,0));
//            GridPane.setConstraints(cancelNewProduct, 1,1,1,1, LEFT, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES);
//
//            addProductButtonCage.setHgap(25);
//            addProductButtonCage.setVgap(15);
//
//
//    // <------------ Add New Product Button Grid Setup End -------------> //
//
//
//
//    // <------------ Add New Product Associated Parts Grid Setup Beginning -------------> //
//
//    GridPane addNewProductCleanerFixerUpper = new GridPane();
//    GridPane associatedPartGrid = new GridPane();
//    GridPane associatedPartsTableGrid = new GridPane();
//    GridPane associatablePartsTableGrid = new GridPane();
//    GridPane associatablePartsGrid = new GridPane();
//
//                addProductMenuGrid.getChildren().add(addNewProductCleanerFixerUpper);
//
//
//    // Associatable Parts (All Parts) Grid
//    TableView<Part> associatablePartsTable = new TableView<>(allParts);
//
//    TableColumn<Part, Integer> associatableProductIdColumn = new TableColumn<>("ID");
//                associatableProductIdColumn.setMinWidth(115);
//                associatableProductIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
//
//    TableColumn<Part, String> associatableProductNameColumn = new TableColumn<>("Name");
//                associatableProductNameColumn.setMinWidth(115);
//                associatableProductNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//
//    TableColumn<Part, Double> associatableProductPriceColumn = new TableColumn<>("Price");
//                associatableProductPriceColumn.setMinWidth(115);
//                associatableProductPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
//
//    TableColumn<Part, Integer> associatableProductStockColumn = new TableColumn<>("Stock");
//                associatableProductStockColumn.setMinWidth(115);
//                associatableProductStockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
//
//                associatablePartsTableGrid.getChildren().add(associatablePartsTable);
//                associatablePartsTable.setItems(getAllParts());
//                associatablePartsTable.getColumns().add(associatableProductIdColumn);
//                associatablePartsTable.getColumns().add(associatableProductNameColumn);
//                associatablePartsTable.getColumns().add(associatableProductPriceColumn);
//                associatablePartsTable.getColumns().add(associatableProductStockColumn);
//
//                associatablePartsGrid.getChildren().addAll(addProductSearchBar, associatablePartsTableGrid, addAssociatedPartButton);
//
//                addNewProductCleanerFixerUpper.getChildren().add(associatablePartsGrid);
//
//                GridPane.setConstraints(associatablePartsGrid, 1,0,1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//                GridPane.setConstraints(associatablePartsTable,0,1,1,1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(5,5,5,5));
//                GridPane.setConstraints(addProductSearchBar, 0,0,1,1, HPos.RIGHT, VPos.CENTER, Priority.NEVER, Priority.SOMETIMES, new Insets(15));
//                GridPane.setConstraints(associatablePartsTableGrid, 0,1,1,1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(5,5,5,5));
//                GridPane.setConstraints(addAssociatedPartButton,0,2,1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//
//    // Associated Parts Grid
//    TableView<Part> associatedPartsTable = new TableView<>();
//
//    TableColumn<Part, Integer> associatedProductIdColumn = new TableColumn<>("ID");
//                associatedProductIdColumn.setMinWidth(115);
//                associatedProductIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
//
//    TableColumn<Part, String> associatedProductNameColumn = new TableColumn<>("Name");
//                associatedProductNameColumn.setMinWidth(115);
//                associatedProductNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//
//    TableColumn<Part, Double> associatedProductPriceColumn = new TableColumn<>("Price");
//                associatedProductPriceColumn.setMinWidth(115);
//                associatedProductPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
//
//    TableColumn<Part, Integer> associatedProductStockColumn = new TableColumn<>("Stock");
//                associatedProductStockColumn.setMinWidth(115);
//                associatedProductStockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
//
//                associatedPartsTable.getColumns().add(associatedProductIdColumn);
//                associatedPartsTable.getColumns().add(associatedProductNameColumn);
//                associatedPartsTable.getColumns().add(associatedProductPriceColumn);
//                associatedPartsTable.getColumns().add(associatedProductStockColumn);
//
//                associatedPartsTableGrid.getChildren().add(associatedPartsTable);
//                associatedPartGrid.getChildren().addAll(associatedPartsTable, addProductButtonCage);
//
//                GridPane.setConstraints(associatedPartsTable, 0,0,1,1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(5,5,5,5));
//                GridPane.setConstraints(addProductButtonCage,0,1,1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//
//                addNewProductCleanerFixerUpper.getChildren().add(associatedPartGrid);
//
//                GridPane.setConstraints(associatedPartGrid, 1,1,1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//
//    // <------------ Add New Product Associated Parts Grid Setup End -------------> //
//
//
//    ColumnConstraints mPMGColumn1 = new ColumnConstraints();
//    ColumnConstraints mPMGColumn2 = new ColumnConstraints();
//                mPMGColumn1.setPercentWidth(50);
//                mPMGColumn2.setPercentWidth(50);
//                addProductMenuGrid.setMinSize(500,400);
//                addProductMenuGrid.setMaxSize(1500,800);
//
//
//                addProductMenuGrid.getColumnConstraints().addAll(mPMGColumn1, mPMGColumn1);
//                GridPane.setConstraints(addNewProductGrid, 0,0,1,1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(5,5,5,5));
//
//                GridPane.setConstraints(addNewProductCleanerFixerUpper,1,0,1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//
//    // <------------ Add New Product Menu Sub-Grids Setup End -------------> //
//
//
//    // <------------ Add New Product Menu Setup End -------------> //
//
//
//
//
//
//    // <------------ Modify Part Menu Setup Beginning -------------> //
//
//
//    // <------------ Modify Part Menu Super Grid Setup Beginning -------------> //
//
//
//                    modifyPartGrid.getChildren().addAll(modifyPartTitleGrid, modifyInHousePartGrid,
//                                                        modifyOutsourcedPartGrid, modifyPartIdTitleTextGrid, modifyPartIdTextFieldGrid,
//                                                        modifyPartNameTitleTextGrid, modifyPartNameTextFieldGrid, modifyPartStockTitleTextGrid,
//                                                        modifyPartStockTextFieldGrid, modifyPartPriceTitleTextGrid, modifyPartPriceTextFieldGrid,
//                                                        modifyPartMinTextHybrid, modifyPartMaxTitleTextGrid,
//                                                        modifyPartMaxTextFieldGrid,modifyPartMachineIdTitleTextGrid, modifyPartMachineIdTextFieldGrid,editModifiedPartButtonGrid);
//                    GridPane.setMargin(addNewPartGrid, new Insets(5,5,5,5));
//                    modifyPartGrid.setMinSize(600,700);
//
//                modifyPartMinTextHybrid.getChildren().addAll(modifyPartMinTitleTextGrid, modifyPartMinTextFieldGrid);
//                GridPane.setConstraints(modifyPartMinTitleTextGrid, 0,0, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES);
//                GridPane.setConstraints(modifyPartMinTextFieldGrid, 1,0, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES);
//    ColumnConstraints superColWidth1modify = new ColumnConstraints();
//                superColWidth1.setPercentWidth(20);
//    ColumnConstraints superColWidth2modify = new ColumnConstraints();
//                superColWidth2.setPercentWidth(35);
//    ColumnConstraints superColWidth3modify = new ColumnConstraints();
//                superColWidth3.setPercentWidth(45);
//
//                modifyPartGrid.getColumnConstraints().addAll(superColWidth1modify,superColWidth2modify,superColWidth3modify);
//                modifyPartGrid.setPadding(new Insets(30));
//
//                    GridPane.setConstraints(modifyPartTitleGrid, 0,0, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
//                    GridPane.setConstraints(modifyInHousePartGrid, 1,0, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//                    GridPane.setConstraints(modifyOutsourcedPartGrid, 2,0, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//                    GridPane.setConstraints(modifyPartIdTitleTextGrid, 0,1, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
//                    GridPane.setConstraints(modifyPartIdTextFieldGrid, 1,1, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//                    GridPane.setConstraints(modifyPartNameTitleTextGrid, 0,2, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
//                    GridPane.setConstraints(modifyPartNameTextFieldGrid, 1,2, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//                    GridPane.setConstraints(modifyPartStockTitleTextGrid, 0,3, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
//                    GridPane.setConstraints(modifyPartStockTextFieldGrid, 1,3, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//                    GridPane.setConstraints(modifyPartPriceTitleTextGrid, 0,4, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
//                    GridPane.setConstraints(modifyPartPriceTextFieldGrid, 1,4, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//                    GridPane.setConstraints(modifyPartMinTextHybrid, 2,5, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
//                    GridPane.setConstraints(modifyPartMaxTitleTextGrid, 0,5, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
//                    GridPane.setConstraints(modifyPartMaxTextFieldGrid, 1,5, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//                    GridPane.setConstraints(modifyPartMachineIdTitleTextGrid, 0,6, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
//                    GridPane.setConstraints(modifyPartMachineIdTextFieldGrid, 1,6, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//                    GridPane.setConstraints(editModifiedPartButtonGrid, 2,7, 1,1, HPos.RIGHT, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//
//
//    // <------------ Modify Part Menu Super Grid Setup End -------------> //
//
//
//
//    // <------------ Modify Part Title Text Grid Setup Beginning -------------> //
//
//
//    Text modifyPartTitle = new Text("Modify Part");
//                        modifyPartTitle.setFont(new Font(15));
//
//    Text modifyIdTitleText = new Text("ID");
//                        modifyIdTitleText.setFont(new Font(15));
//
//    Text modifyNameTitleText = new Text("Name");
//                        modifyNameTitleText.setFont(new Font(15));
//
//    Text modifyStockTitleText = new Text("Inv.");
//                        modifyStockTitleText.setFont(new Font(15));
//
//    Text modifyPriceTitleText = new Text("Price");
//                        modifyPriceTitleText.setFont(new Font(15));
//
//    Text modifyMinTitleText = new Text("Min");
//                        modifyMinTitleText.setFont(new Font(15));
//
//    Text modifyMaxTitleText = new Text("Max");
//                        modifyMaxTitleText.setFont(new Font(15));
//
//    Text modifyMachineIdTitleText = new Text("Machine ID");
//                        modifyMachineIdTitleText.setFont(new Font(15));
//
//                    modifyPartTitleGrid.getChildren().add(modifyPartTitle);
//                    modifyPartIdTitleTextGrid.getChildren().add(modifyIdTitleText);
//                    modifyPartNameTitleTextGrid.getChildren().add(modifyNameTitleText);
//                    modifyPartStockTitleTextGrid.getChildren().add(modifyStockTitleText);
//                    modifyPartPriceTitleTextGrid.getChildren().add(modifyPriceTitleText);
//                    modifyPartMinTitleTextGrid.getChildren().addAll(modifyMinTitleText);
//                    modifyPartMaxTitleTextGrid.getChildren().add(modifyMaxTitleText);
//                    modifyPartMachineIdTitleTextGrid.getChildren().add(modifyMachineIdTitleText);
//
//
//    // <------------ Modify Part Title Text Grid Setup End -------------> //
//
//
//
//    // <------------ Modify Part Title TextField Grid Setup Beginning -------------> //
//
//
//    TextField modifyPartNameTextField = new TextField();
//    TextField modifyPartStockTextField = new TextField();
//    TextField modifyPartIdTextField = new TextField();
//    TextField modifyPartPriceTextField = new TextField();
//    TextField modifyPartMinTextField = new TextField();
//    TextField modifyPartMaxTextField = new TextField();
//    TextField modifyPartMachineIdTextField = new TextField();
//                    modifyPartNameTextFieldGrid.getChildren().add(modifyPartNameTextField);
//                    modifyPartStockTextFieldGrid.getChildren().add(modifyPartStockTextField);
//                    modifyPartIdTextFieldGrid.getChildren().add(modifyPartIdTextField);
//                    modifyPartPriceTextFieldGrid.getChildren().add(modifyPartPriceTextField);
//                    modifyPartMinTextFieldGrid.getChildren().addAll(modifyPartMinTextField);
//                    modifyPartMaxTextFieldGrid.getChildren().add(modifyPartMaxTextField);
//                    modifyPartMachineIdTextFieldGrid.getChildren().add(modifyPartMachineIdTextField);
//
//
//    // <------------ Modify Part Title TextField Grid Setup End -------------> //
//
//
//
//
//    // <------------ Modify Part Button Grid Setup Beginning -------------> //
//
//
//    ToggleGroup modifyPartType = new ToggleGroup();
//    RadioButton modifyInHousePart = new RadioButton("In-House");
//    RadioButton modifyOutsourcedPart = new RadioButton("Outsourced");
//                    modifyInHousePart.setToggleGroup(modifyPartType);
//                    modifyOutsourcedPart.setToggleGroup(modifyPartType);
//    Button saveModifiedPart = new Button("Save");
//    Button cancelModifiedPart = new Button("Cancel");
//                    editModifiedPartButtonGrid.getChildren().addAll(saveModifiedPart, cancelModifiedPart);
//                    GridPane.setConstraints(saveModifiedPart,0,0);
//                    GridPane.setConstraints(cancelModifiedPart,1,0);
//                    modifyInHousePartGrid.getChildren().add(modifyInHousePart);
//                    modifyOutsourcedPartGrid.getChildren().add(modifyOutsourcedPart);
//                    editModifiedPartButtonGrid.setHgap(25);
//
//
//    // <------------ Modify Part Button Grid Setup End -------------> //
//
//
//    // <------------ Modify Part Menu Setup End -------------> //
//
//
//
//    // <------------ Modify Product Menu Setup Beginning -------------> //
//
//
//    // <------------ Modify Product Menu Super Grid Setup Beginning -------------> //
//
//
//    GridPane modifyProductGrid = new GridPane();
//
//                modifyProductMenuGrid.getChildren().add(modifyProductGrid);
//
//                GridPane.setMargin(modifyProductGrid, new Insets(5,5,5,5));
//                modifyProductGrid.setMinSize(600,700);
//
//                modifyProductMinTextHybrid.getChildren().addAll(modifyProductMinTitleTextGrid, modifyProductMinTextFieldGrid);
//                GridPane.setConstraints(modifyProductMinTitleTextGrid, 0,0, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES);
//                GridPane.setConstraints(modifyProductMinTextFieldGrid, 1,0, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES);
//
//                modifyProductGrid.setPadding(new Insets(30));
//
//                GridPane.setConstraints(modifyProductTitleGrid, 0,0, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
//                GridPane.setConstraints(modifyProductIdTitleTextGrid, 0,1, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
//                GridPane.setConstraints(modifyProductIdTextFieldGrid, 1,1, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//                GridPane.setConstraints(modifyProductNameTitleTextGrid, 0,2, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
//                GridPane.setConstraints(modifyProductNameTextFieldGrid, 1,2, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//                GridPane.setConstraints(modifyProductStockTitleTextGrid, 0,3, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
//                GridPane.setConstraints(modifyProductStockTextFieldGrid, 1,3, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//                GridPane.setConstraints(modifyProductPriceTitleTextGrid, 0,4, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
//                GridPane.setConstraints(modifyProductPriceTextFieldGrid, 1,4, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//                GridPane.setConstraints(modifyProductMinTextHybrid, 2,5, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
//                GridPane.setConstraints(modifyProductMaxTitleTextGrid, 0,5, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,15));
//                GridPane.setConstraints(modifyProductMaxTextFieldGrid, 1,5, 1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//
//
//
//    // <------------ Modify Product Menu Super Grid Setup End -------------> //
//
//
//
//    // <------------ Modify Product Menu Sub-Grids Setup Beginning -------------> //
//
//
//                        modifyProductGrid.getChildren().addAll(modifyProductTitleGrid,
//                                                               modifyProductIdTitleTextGrid, modifyProductIdTextFieldGrid,
//                                                               modifyProductNameTitleTextGrid, modifyProductNameTextFieldGrid, modifyProductStockTitleTextGrid,
//                                                               modifyProductStockTextFieldGrid, modifyProductPriceTitleTextGrid, modifyProductPriceTextFieldGrid,
//                                                               modifyProductMinTextHybrid, modifyProductMaxTitleTextGrid, modifyProductMaxTextFieldGrid);
//
//    // <------------ Modify Product Title Text Grid Setup Beginning -------------> //
//
//
//    Text modifyProductTitle = new Text("Add Product");
//                    modifyProductTitle.setFont(new Font(15));
//
//    Text modifyProductIdTitleText = new Text("ID");
//                    modifyProductIdTitleText.setFont(new Font(15));
//
//    Text modifyProductNameTitleText = new Text("Name");
//                    modifyProductNameTitleText.setFont(new Font(15));
//
//    Text modifyProductStockTitleText = new Text("Inv.");
//                    modifyProductStockTitleText.setFont(new Font(15));
//
//    Text modifyProductPriceTitleText = new Text("Price");
//                    modifyProductPriceTitleText.setFont(new Font(15));
//
//    Text modifyProductMinTitleText = new Text("Min");
//                    modifyProductMinTitleText.setFont(new Font(15));
//
//    Text modifyProductMaxTitleText = new Text("Max");
//                    modifyProductMaxTitleText.setFont(new Font(15));
//
//                    modifyProductTitleGrid.getChildren().add(modifyProductTitle);
//                    modifyProductIdTitleTextGrid.getChildren().add(modifyProductIdTitleText);
//                    modifyProductNameTitleTextGrid.getChildren().add(modifyProductNameTitleText);
//                    modifyProductStockTitleTextGrid.getChildren().add(modifyProductStockTitleText);
//                    modifyProductPriceTitleTextGrid.getChildren().add(modifyProductPriceTitleText);
//                    modifyProductMinTitleTextGrid.getChildren().addAll(modifyProductMinTitleText);
//                    modifyProductMaxTitleTextGrid.getChildren().add(modifyProductMaxTitleText);
//
//
//    // <------------ Modify Product Title Text Grid Setup End -------------> //
//
//
//
//    // <------------ Modify Product Title TextField Grid Setup Beginning -------------> //
//
//
//    TextField modifyProductNameTextField = new TextField();
//    TextField modifyProductStockTextField = new TextField();
//    TextField modifyProductIdTextField = new TextField();
//    TextField modifyProductPriceTextField = new TextField();
//    TextField modifyProductMinTextField = new TextField();
//    TextField modifyProductMaxTextField = new TextField();
//
//                    modifyProductNameTextFieldGrid.getChildren().add(modifyProductNameTextField);
//                    modifyProductStockTextFieldGrid.getChildren().add(modifyProductStockTextField);
//                    modifyProductIdTextFieldGrid.getChildren().add(modifyProductIdTextField);
//                    modifyProductPriceTextFieldGrid.getChildren().add(modifyProductPriceTextField);
//                    modifyProductMinTextFieldGrid.getChildren().addAll(modifyProductMinTextField);
//                    modifyProductMaxTextFieldGrid.getChildren().add(modifyProductMaxTextField);
//
//
//    // <------------ Modify Product Title TextField Grid Setup End -------------> //
//
//
//    // <------------ Modify Product Button Grid Setup Beginning -------------> //
//
//
//    GridPane modifyProductButtonCage = new GridPane();
//
//    Button addAssociatedPartButtonModify = new Button("Add");
//    Button removeAssociatedPartButtonModify = new Button("Remove Associated Part");
//    Button saveModifiedProduct = new Button("Save");
//    Button cancelModifiedProduct = new Button("Cancel");
//
//                    modifyProductButtonCage.getChildren().addAll(removeAssociatedPartButtonModify, saveModifiedProduct, cancelModifiedProduct);
//
//                    GridPane.setConstraints(removeAssociatedPartButtonModify, 0,0,2,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES);
//                    GridPane.setConstraints(saveModifiedProduct, 0,1,1,1, HPos.RIGHT, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(0,15,0,0));
//                    GridPane.setConstraints(cancelModifiedProduct, 1,1,1,1, LEFT, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES);
//
//                    modifyProductButtonCage.setHgap(25);
//                    modifyProductButtonCage.setVgap(15);
//
//
//    // <------------ Modify Product Button Grid Setup End -------------> //
//
//
//
//    // <------------ Modify Product Associated Parts Grid Setup Beginning -------------> //
//
//
//    GridPane modifyProductCleanerFixerUpper = new GridPane();
//    GridPane associatedPartGridModify = new GridPane();
//    GridPane associatedPartsTableGridModify = new GridPane();
//    GridPane associatablePartsTableGridModify = new GridPane();
//    GridPane associatablePartsGridModify = new GridPane();
//
//                        modifyProductMenuGrid.getChildren().add(modifyProductCleanerFixerUpper);
//
//    // Associatable Parts (All Parts) Grid
//    TableView<Part> associatablePartsTableModify = new TableView<>();
//                        associatablePartsTableGridModify.getChildren().add(associatablePartsTableModify);
//                        associatablePartsGridModify.getChildren().addAll(modifyProductSearchBar, associatablePartsTableGridModify, addAssociatedPartButtonModify);
//
//    TableColumn<Part, Integer> associatableModifyProductIdColumn = new TableColumn<>("ID");
//                        associatableModifyProductIdColumn.setMinWidth(115);
//                        associatableModifyProductIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
//
//    TableColumn<Part, String> associatableModifyProductNameColumn = new TableColumn<>("Name");
//                        associatableModifyProductNameColumn.setMinWidth(115);
//                        associatableModifyProductNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//
//    TableColumn<Part, Double> associatableModifyProductPriceColumn = new TableColumn<>("Price");
//                        associatableModifyProductPriceColumn.setMinWidth(115);
//                        associatableModifyProductPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
//
//    TableColumn<Part, Integer> associatableModifyProductStockColumn = new TableColumn<>("Stock");
//                        associatableModifyProductStockColumn.setMinWidth(115);
//                        associatableModifyProductStockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
//
//                        associatablePartsTableModify.setItems(getAllParts());
//                        associatablePartsTableModify.getColumns().add(associatableModifyProductIdColumn);
//                        associatablePartsTableModify.getColumns().add(associatableModifyProductNameColumn);
//                        associatablePartsTableModify.getColumns().add(associatableModifyProductPriceColumn);
//                        associatablePartsTableModify.getColumns().add(associatableModifyProductStockColumn);
//
//                        modifyProductCleanerFixerUpper.getChildren().add(associatablePartsGridModify);
//
//                        GridPane.setConstraints(associatablePartsGridModify, 1,0,1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//                        GridPane.setConstraints(associatablePartsTableModify,0,1,1,1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(5,5,5,5));
//                        GridPane.setConstraints(modifyProductSearchBar, 0,0,1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(15));
//                        GridPane.setConstraints(associatablePartsTableGridModify, 0,1,1,1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(5,5,5,5));
//                        GridPane.setConstraints(addAssociatedPartButtonModify,0,2,1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//
//    // Associated Parts Grid
//    TableView<Part> associatedPartsTableModify = new TableView<>();
//
//                        associatedPartsTableGridModify.getChildren().add(associatedPartsTableModify);
//                        associatedPartGridModify.getChildren().addAll(associatedPartsTableModify, modifyProductButtonCage);
//
//    TableColumn<Part, Integer> associatedModifyProductIdColumn = new TableColumn<>("ID");
//                        associatedModifyProductIdColumn.setMinWidth(115);
//                        associatedModifyProductIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
//
//    TableColumn<Part, String> associatedModifyProductNameColumn = new TableColumn<>("Name");
//                        associatedModifyProductNameColumn.setMinWidth(115);
//                        associatedModifyProductNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//
//    TableColumn<Part, Double> associatedModifyProductPriceColumn = new TableColumn<>("Price");
//                        associatedModifyProductPriceColumn.setMinWidth(115);
//                        associatedModifyProductPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
//
//    TableColumn<Part, Integer> associatedModifyProductStockColumn = new TableColumn<>("Stock");
//                        associatedModifyProductStockColumn.setMinWidth(115);
//                        associatedModifyProductStockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
//
//                        associatedPartsTableModify.getColumns().add(associatedModifyProductIdColumn);
//                        associatedPartsTableModify.getColumns().add(associatedModifyProductNameColumn);
//                        associatedPartsTableModify.getColumns().add(associatedModifyProductPriceColumn);
//                        associatedPartsTableModify.getColumns().add(associatedModifyProductStockColumn);
//
//                        GridPane.setConstraints(associatedPartsTableModify, 0,0,1,1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(5,5,5,5));
//                        GridPane.setConstraints(modifyProductButtonCage,0,1,1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//
//                        modifyProductCleanerFixerUpper.getChildren().add(associatedPartGridModify);
//
//                        GridPane.setConstraints(associatedPartGridModify, 1,1,1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//
//
//    // <------------ Modify Product Associated Parts Grid Setup End -------------> //
//
//
//    ColumnConstraints mPMGColumn1Modify = new ColumnConstraints();
//    ColumnConstraints mPMGColumn2Modify = new ColumnConstraints();
//                        mPMGColumn1Modify.setPercentWidth(50);
//                        mPMGColumn2Modify.setPercentWidth(50);
//                        modifyProductMenuGrid.setMinSize(500,400);
//                        modifyProductMenuGrid.setMaxSize(1500,800);
//
//
//                        modifyProductMenuGrid.getColumnConstraints().addAll(mPMGColumn1Modify, mPMGColumn1Modify);
//                        GridPane.setConstraints(modifyProductGrid, 0,0,1,1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, new Insets(5,5,5,5));
//                        GridPane.setConstraints(modifyProductCleanerFixerUpper,1,0,1,1, HPos.CENTER, VPos.CENTER, Priority.SOMETIMES, Priority.SOMETIMES, new Insets(5,5,5,5));
//
//    // <------------ Modify Product Menu Sub-Grids Setup End -------------> //
//
//
//    // <------------ Modify Product Menu Setup End -------------> //
//
//
//
//
//    GridPane conAddGood = new GridPane();
//    Text conAddGoodInfo = new Text("Addition Successful");
//    Button conAddGoodCloseButton = new Button("Close");
//        conAddGoodInfo.setFont(new Font(20));
//        conAddGood.getChildren().add(conAddGoodInfo);
//        conAddGood.getChildren().add(conAddGoodCloseButton);
//    sceneChanger(mainMenuGrid,mainMenuGrid,conAddGoodCloseButton,conAddGoodCloseButton);
//        GridPane.setConstraints(conAddGoodInfo,0,0,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(25));
//        GridPane.setConstraints(conAddGoodCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
//
//    GridPane conAddBad = new GridPane();
//    Text conAddBadInfo = new Text("Addition Unsuccessful");
//    Button conAddBadCloseButton = new Button("Close");
//        conAddBadInfo.setFont(new Font(20));
//        conAddBad.getChildren().add(conAddBadInfo);
//        conAddBad.getChildren().add(conAddBadCloseButton);
//    sceneChanger(mainMenuGrid,mainMenuGrid,conAddBadCloseButton,conAddBadCloseButton);
//        GridPane.setConstraints(conAddBadInfo,0,0,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(25));
//        GridPane.setConstraints(conAddBadCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
//
//    GridPane conModifyGood = new GridPane();
//    Text conModifyGoodInfo = new Text("Modification Successful");
//    Button conModifyGoodCloseButton = new Button("Close");
//        conModifyGoodInfo.setFont(new Font(20));
//        conModifyGood.getChildren().add(conModifyGoodInfo);
//        conModifyGood.getChildren().add(conModifyGoodCloseButton);
//    sceneChanger(mainMenuGrid,mainMenuGrid,conModifyGoodCloseButton,conModifyGoodCloseButton);
//        GridPane.setConstraints(conModifyGoodInfo,0,0,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(25));
//        GridPane.setConstraints(conModifyGoodCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
//
//    GridPane conModifyBad = new GridPane();
//    Text conModifyBadInfo = new Text("Modification Unsuccessful");
//    Button conModifyBadCloseButton = new Button("Close");
//        conModifyBadInfo.setFont(new Font(20));
//        conModifyBad.getChildren().add(conModifyBadInfo);
//        conModifyBad.getChildren().add(conModifyBadCloseButton);
//    sceneChanger(mainMenuGrid,mainMenuGrid,conModifyBadCloseButton,conModifyBadCloseButton);
//        GridPane.setConstraints(conModifyBadInfo,0,0,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(25));
//        GridPane.setConstraints(conModifyBadCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
//
//    GridPane partDeletion = new GridPane();
//    Text partDeletionInfo = new Text("Deletion Successful");
//    Button partDeletionCloseButton = new Button("Close");
//        partDeletionInfo.setFont(new Font(20));
//        partDeletion.getChildren().add(partDeletionInfo);
//        partDeletion.getChildren().add(partDeletionCloseButton);
//    sceneChanger(mainMenuGrid,mainMenuGrid,partDeletionCloseButton,partDeletionCloseButton);
//        GridPane.setConstraints(partDeletionInfo,0,0,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(25));
//        GridPane.setConstraints(partDeletionCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
//
//    GridPane productDeletion = new GridPane();
//    Text productDeletionInfo = new Text("Deletion Successful");
//    Button productDeletionCloseButton = new Button("Close");
//        productDeletionInfo.setFont(new Font(20));
//        productDeletion.getChildren().add(productDeletionInfo);
//        productDeletion.getChildren().add(productDeletionCloseButton);
//    sceneChanger(mainMenuGrid,mainMenuGrid,productDeletionCloseButton,productDeletionCloseButton);
//        GridPane.setConstraints(productDeletionInfo,0,0,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(25));
//        GridPane.setConstraints(productDeletionCloseButton,0,1,1,1,CENTER,VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS,new Insets(10));
//}
