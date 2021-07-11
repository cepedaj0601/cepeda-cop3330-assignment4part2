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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ExpandItemController implements Initializable{

    //take in selected item
    private Item selectedItem;

    //create variables for each display label
    @FXML private Label dueDateLabel;
    @FXML private Label itemNameLabel;
    @FXML private Label itemDescriptionLabel;
    @FXML private Label itemStatusLabel;

    public void initializeData(Item item){
        //initialize item to expand
        selectedItem = item;

        //get the information
        dueDateLabel.setText(selectedItem.getDueDate().toString());
        itemNameLabel.setText(selectedItem.getItemName());
        itemDescriptionLabel.setText(selectedItem.getItemDescription());
        itemStatusLabel.setText(selectedItem.getCompletedMark());
    }

    public void backButtonClicked(ActionEvent actionEvent) throws IOException {
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
