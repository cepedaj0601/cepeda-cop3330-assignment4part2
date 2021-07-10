/*
 *  UCF COP3330 Summer 2021 Assignment 4 part 2 Solution
 *  Copyright 2021 Justin Cepeda
 */
package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOError;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

public class ToDoListController implements Initializable {

    //create to do list table settings
    @FXML private TableView<Item> itemTableView;
    @FXML private TableColumn<Item, String> itemColumn;
    @FXML private TableColumn<Item, String> descriptionColumn;
    @FXML private TableColumn<Item, LocalDate> dueDateColumn;
//    @FXML private TableColumn<Item, String> completeColumn;

    //create variables used to create new items
    @FXML private TextField itemNameTextField;
    @FXML private TextField itemDescriptionTextField;
    @FXML private DatePicker dueDatePicker;

/*
    @FXML
    private TextField resultDisplay;

    @FXML
    public void expandItem(ActionEvent actionEvent) {
        //open a new window
        //print the due date of the item
        //on a new line, print the name of the item
        //on a new line print the description of the item, with an additional new line each time the window size is
            //reached
    }

    @FXML
    public void areYouSure(ActionEvent actionEvent) {
        //open a new window
        //display the text: "Are you sure?"
        //then display two buttons, one labeled Yes, the other No
        //if yes button is clicked, call the yesButtonIsClicked function
        //if no button is clicked, call the noButtonIsClicked function
        //return the value of the called function
        //close the window
    }

    @FXML
    public void yesButtonIsClicked(ActionEvent actionevent) {
        //return boolean value equal to true
    }

    @FXML
    public void noButtonIsClicked(ActionEvent actionevent) {
        //return boolean value equal to false
    }

    @FXML
    public void markAsCompleteButtonIsClicked(ActionEvent actionEvent){
        //set the matching item index node to true
    }

    @FXML
    public void clearDisplay(ActionEvent actionEvent){
        //while the number of preview windows on the grid pane is not equal to 0:
        //check the second grid pane slot (the first is taken up by the addItemButton)
        //if it is not empty, delete the item in the slot
        //return int containing current number of preview windows
    }

    @FXML
    public void allItemsButtonClicked(ActionEvent actionEvent) {
        //call the clearDisplay function
        //in a loop the size of the number of items in the list:
        //create a preview window in the next available slot
        //display the item's due date
        //display the item's name
        //repeat n times
    }

    @FXML
    public void completedItemsButtonClicked(ActionEvent actionEvent) {
        //call the clearDisplay function
        //in a for loop the size of the number of items in the list:
        //check the item's corresponding markAsComplete list node
        //if the stored value is true, create a preview window and display the item's due date and name
        //else, skip the item
        //repeat n times
    }

    @FXML
    public void incompleteItemsButtonClicked(ActionEvent actionEvent) {
        //call the clearDisplay function
        //in a for loop the size of the number of items in the list:
        //check the item's corresponding markAsComplete list node
        //if the stored value is false, create a preview window and display the item's due date and name
        //else, skip the item
        //repeat n times
    }

    @FXML
    public void deleteCurrentListButtonClicked(ActionEvent actionEvent) {
        //call areYouSure function
        //if the return value is yes:
        //delete the listName's list node
        //redirect the previous node to point at the node after the deleted node
        //in a for loop the size of the item name list:
        //delete the last item in the list
        //set the previous node to point to null
        //repeat n times
        //after the list has been cleared, repeat the same for the dueDate list, description list, and the
        //markAsComplete list
    }

    @FXML
    public void exportCurrentListButtonClicked(ActionEvent actionEvent) {
        //take in all stored variables (list name, list items, marked as complete variable, etc)
        //create a new variable that stores the file directory
        //prompt for the file directory path to be stored in a string
        //create a new txt file under the new file directory
        //copy over the list name
        //in a loop the size of the number of items in the list, copy each item due date, name, and description
        //save the new file with the copied elements
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

    public void editItemButtonClicked(ActionEvent actionEvent) {
        //open a new window containing a text field
        //prompt the user to make changes to the item
        //when the save button is clicked, call the saveButtonIsClicked function and stop letting the user enter in
            //characters
        //overwrite the item's variable with the new strings
        //display the new item text field
        //return the new strings
    }




 */

    public void addNewItemButtonClicked(ActionEvent actionEvent) {
        //create a new item
        Item newItem = new Item(itemNameTextField.getText(), itemDescriptionTextField.getText(),
                dueDatePicker.getValue());

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
        itemColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("itemName"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("itemDescription"));
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<Item, LocalDate>("dueDate"));
        //completeColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("complete"));

        //load in some information
        itemTableView.setItems(getItems());

        //update the list to permit for changes of the item names and descriptions
        itemTableView.setEditable(true);
        itemColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        descriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    public ObservableList<Item> getItems(){
        //set up list
        ObservableList<Item> items = FXCollections.observableArrayList();
        items.add(new Item("Walk Dog", "Take Molly outside after lunch.",
                LocalDate.of(2021, Month.JULY, 11)));
        items.add(new Item("Check Oil", "Check the car's oil level before heading out.",
                LocalDate.of(2021, Month.AUGUST, 11)));
        items.add(new Item("Study", "Study for the CIS test by next Tuesday.",
                LocalDate.of(2021, Month.JULY, 13)));

        //return an ObservableList of Item Objects
        return items;
    }



}
