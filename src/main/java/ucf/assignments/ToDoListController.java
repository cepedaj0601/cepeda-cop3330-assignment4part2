/*
 *  UCF COP3330 Summer 2021 Assignment 4 part 2 Solution
 *  Copyright 2021 Justin Cepeda
 */
package ucf.assignments;

import com.sun.javafx.logging.PlatformLogger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class ToDoListController implements Initializable {

    //create to do list table settings
    @FXML private TableView<Item> itemTableView;
    @FXML private TableColumn<Item, String> itemColumn;
    @FXML private TableColumn<Item, String> descriptionColumn;
    @FXML private TableColumn<Item, LocalDate> dueDateColumn;
    @FXML private TableColumn<Item, String> completeColumn;

    //create variables used to create new items
    @FXML private TextField itemNameTextField;
    @FXML private TextField itemDescriptionTextField;
    @FXML private DatePicker dueDatePicker;
    @FXML private TextField completedMarkTextField;

    //variable for getting file path
  //  public String filePath = "";

/*

    @FXML
    public void markAsCompleteButtonIsClicked(ActionEvent actionEvent){
        //set the matching item index node to true
    }

    @FXML
    public void loadListButtonClicked(ActionEvent actionEvent) {
        //prompt for the file directory path of the list that the user wants to load
        //search for the file
        //import the file through a file reader
        //scan for the list name
        //store the name in a variable
        //display the name variable in the text field
        //in a loop that repeats until the end of the file, scan for due dates
        //when a date is found, store the date
        //display the date in the item window
        //scan for the item name and store it
        //display the item name in the item window
        //store the item description to be displayed when the item is expanded for the preview window
        //repeat until all items have been loaded
    }
 */



    public void displayAllItemsButtonClicked(ActionEvent actionEvent) {
        //take in all items in the copy of the to do list table
        //set variable equal to the list of all items
        //clear the main to do list
        //repopulate the main list with the elements of the copied tableview
    }

    public void displayCompletedItemsButtonClicked(ActionEvent actionEvent) {
        //take in all items in the copy of the to do list table
        //set variable equal to the list of all items
        //clear the main to do list
        //using a loop, check for the 'C' char in the completeMark column
        //if 'C' char is present, add the item to the main tableview
        //the table should now be repopulated with only completed items
    }

    public void displayIncompleteItemsButtonClicked(ActionEvent actionEvent) {
        //take in all items in the copy of the to do list table
        //set variable equal to the list of all items
        //clear the main to do list
        //using a loop, check for the 'I' char in the completeMark column
        //if 'I' char is present, add the item to the main tableview
        //the table should now be repopulated with only incomplete items
    }

    public void addNewItemButtonClicked(ActionEvent actionEvent) {
        //create a new item
        Item newItem = new Item(itemNameTextField.getText(), itemDescriptionTextField.getText(),
                dueDatePicker.getValue(), completedMarkTextField.getText());

        //get all list items
        //add new item to list
        itemTableView.getItems().add(newItem);
    }

    public void changeItemNameCellEvent(TableColumn.CellEditEvent editedCell){
        //edit the name of an item
        //get the current value
        Item itemSelected = itemTableView.getSelectionModel().getSelectedItem();

        //update the value to entered text
        itemSelected.setItemName(editedCell.getNewValue().toString());
    }


    public void changeItemDescriptionCellEvent(TableColumn.CellEditEvent editedCell){
        //edit the name of an item
        //get the current value
        Item itemSelected = itemTableView.getSelectionModel().getSelectedItem();

        //update the value to entered text
        itemSelected.setItemDescription(editedCell.getNewValue().toString());
    }
/*
    public void changeDueDateCellEvent(TableColumn.CellEditEvent editedCell){
        //edit the name of an item
        //get the current value
        Item itemSelected = itemTableView.getSelectionModel().getSelectedItem();

        //update the value to entered text
        itemSelected.setDueDate(LocalDate.parse(editedCell.getNewValue().toString()));
    }

 */



    public void changeCompletedMarkCellEvent(TableColumn.CellEditEvent editedCell){
        //edit the name of an item
        //get the current value
        Item itemSelected = itemTableView.getSelectionModel().getSelectedItem();

        //update the value to entered text
        itemSelected.setCompletedMark(editedCell.getNewValue().toString());
    }

    public void expandItemButtonClicked(ActionEvent actionEvent) throws IOException {
        //pass by the selected item and its info

        //set up stage information
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ExpandItem.fxml"));
        Parent expandItemParent = loader.load();

        //create a new scene
        Scene expandItemScene = new Scene(expandItemParent);

        //get the controller and call its method
        ExpandItemController controller = loader.getController();
        controller.initializeData(itemTableView.getSelectionModel().getSelectedItem());

        //retrieve the stage information
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(expandItemScene);
        window.show();
    }

    public void helpButtonClicked(ActionEvent actionEvent) throws IOException {
        //set up stage information
        Parent helpPageParent = FXMLLoader.load(getClass().getResource("HelpPage.fxml"));

        //create a new scene
        Scene helpPageScene = new Scene(helpPageParent);

        //retrieve the stage information
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(helpPageScene);
        window.show();
    }

    //initialize controller class
    @Override
    public void initialize (URL url, ResourceBundle resources) {

        //set up the columns of the table
        itemColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("itemDescription"));
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        completeColumn.setCellValueFactory(new PropertyValueFactory<>("completedMark"));

        //load in some information
        itemTableView.setItems(getItems());

        //update the list to permit for changes of the item names and descriptions
        itemTableView.setEditable(true);
        itemColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        descriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        completeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
      //  dueDateColumn.setCellFactory(TextFieldTableCell.forTableColumn());


        //allow the user to select multiple items for deletion
        itemTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    //take in selected item
 //   private Item selectedItem;

    //create variables for each display label
//    @FXML private Label dueDateLabel;

    public void editDateButtonClicked(ActionEvent actionEvent) throws IOException {
 /*       //set up stage information
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("EditDate.fxml"));
        Parent editDateParent = loader.load();

        //create a new scene
        Scene editDateScene = new Scene(editDateParent);

        //get the controller and call its method
        ExpandItemController controller = loader.getController();
        controller.initializeData(itemTableView.getSelectionModel().getSelectedItem());

        //retrieve the stage information
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(editDateScene);
        window.show();

  */
    }

    public void deleteItemButtonClicked(ActionEvent actionEvent) {
        //get list of all items
        ObservableList<Item> selectedRows, allItems;
        allItems = itemTableView.getItems();

        //get list of all selected items
        selectedRows = itemTableView.getSelectionModel().getSelectedItems();

        //in a for loop the size of the item list, remove the selected items from the item list
        for (Item item: selectedRows) {
            allItems.remove(item);
        }
    }

    @FXML
    public void clearListButtonClicked(ActionEvent actionEvent) {
        //get the list of all items
        //using a java function, clear the list
        itemTableView.getItems().clear();
    }

    public ObservableList<Item> getItems(){
        //set up list
        ObservableList<Item> items = FXCollections.observableArrayList();

        //return an ObservableList of Item Objects
        return items;
    }

    @FXML
    public void exportListButtonClicked(ActionEvent actionEvent/*, ObservableList<Item> items*/) throws IOException {
/*
        //take in table info


        //set up stage information
        Parent helpPageParent = FXMLLoader.load(getClass().getResource("FilePathGetterController.fxml"));

        //create a new scene
        Scene helpPageScene = new Scene(helpPageParent);

        //retrieve the stage information
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(helpPageScene);
        window.show();

 */
    }





}
