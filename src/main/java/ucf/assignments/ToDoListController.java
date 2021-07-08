/*
 *  UCF COP3330 Summer 2021 Assignment 4 part 2 Solution
 *  Copyright 2021 Justin Cepeda
 */
package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ToDoListController {

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
    public void newListButtonClicked(ActionEvent actionEvent) {
        //all information will be stored in 4 separate linked lists(1 for the list names, one for the dates, one for the
            //item names, one for the item descriptions. Each list will have its own linked list for the dates, names,
            //and descriptions. So 2 lists with 100 items each will be stored in 8 separate linked lists)
        //when button is clicked, create a new node in the nameList list
        //prompt the user for the name of the list
        //store the name in the new node that was created
        //display the name in the listName text field box
        //return the total number of nodes in the list
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
    public void exportAllListsButtonClicked(ActionEvent actionEvent) {
        //take in list counter
        //in a for loop the size of the list counter, do the following:
        //take in all stored variables (list name, list items, marked as complete variable, etc) for the current list
        //create a new variable that stores the file directory
        //prompt for the file directory path to be stored in a string(all lists will be stored here)
        //create a new txt file for the current list under the new file directory
        //copy over the list name
        //in a loop the size of the number of items in the list, copy each item due date, name, and description
        //save the new file with the copied elements
        //repeat n times
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

    @FXML
    public void loadMultipleListsButtonClicked(ActionEvent actionEvent) {
        //prompt for the number of lists the user wants to load
        //store the number
        //in a for loop the size of the number, prompt for the file directory path of the current list that the user wants
            // to load
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
        //repeat n times for each list that needs to be loaded (prompting for the directory path each time)
    }

    public void editNameButtonClicked(ActionEvent actionEvent) {
        //open a new window containing a text field
        //prompt the user to enter in the name of the list
        //when the newline character is detected, stop letting the user enter in characters
        //overwrite the listName variable with the new string
        //display the new string in the list name text field
        //return the new string
    }

    public void addItemButtonClicked(ActionEvent actionEvent) {
        //if this is the first item in the list, create 4 new linked lists, one for the dates, another for the names,
            //one for the descriptions, and the last one to keep track of completed items(it will be initialized as a
            //boolean value equal to false)
        //else, add a new node for each of the 3 linked lists
        //open a new window and prompt for the due date of the item
        //store the due date in the new node of the dueDate list
        //open a new window and prompt for the item name
        //store the item name in the new node of the itemName list
        //open a new window and prompt for the item description
        //store the description in the  new node of the description list
        //close the prompt windows
        //display the item's due date and name in the preview window
        //return the total number of nodes
    }
}
