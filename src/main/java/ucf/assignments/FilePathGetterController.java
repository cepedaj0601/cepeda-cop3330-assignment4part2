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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FilePathGetterController implements Initializable {

    public String filePath;

    @FXML private TextField filePathTextField;

    public void saveButtonClicked(Item item) throws IOException {

        //get string
        filePath = filePathTextField.getText();

        //copy tableview to txt
        //export to string location
        //use java function to output the array as a text file
        FileWriter writer = new FileWriter(filePath);
        for () {
            writer.write();
        }
        writer.close();

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
    public void initialize (URL url, ResourceBundle resources) {

    }

}
