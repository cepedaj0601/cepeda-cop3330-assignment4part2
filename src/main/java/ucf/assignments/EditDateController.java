package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 part 2 Solution
 *  Copyright 2021 Justin Cepeda
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditDateController implements Initializable{

    //take in selected item
    private Item selectedItem;

    //create variables to take in input
    @FXML private TextField dueDateTextField;

    public void initializeData(Item item){
        //initialize item to change
        selectedItem = item;

        //get the information
        dueDateTextField.setText(selectedItem.getDueDate().toString());
    }

    public void saveButtonClicked(ActionEvent actionEvent) throws IOException {
        //update info


        //return to main scene
        //set up stage information
        Parent helpPageParent = FXMLLoader.load(getClass().getResource("ToDoList.fxml"));

        //create a new scene
        Scene helpPageScene = new Scene(helpPageParent);

        //retrieve the stage information
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(helpPageScene);
        window.show();
    }

    //initialize controller class
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
