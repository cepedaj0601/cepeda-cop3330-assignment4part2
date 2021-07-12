package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 part 2 Solution
 *  Copyright 2021 Justin Cepeda
 */

import javafx.beans.property.SimpleStringProperty;
import java.time.LocalDate;

//class for each item of the tableview
public class Item {

    //create data types to hold the names, descriptions, and due dates
    private SimpleStringProperty itemName, itemDescription, completedMark;
    private LocalDate dueDate;


    public Item(String itemName, String itemDescription, LocalDate dueDate, String completedMark) {
        this.itemName = new SimpleStringProperty(itemName);
        this.itemDescription = new SimpleStringProperty(itemDescription);
        this.dueDate = dueDate;
        this.completedMark = new SimpleStringProperty(completedMark);
    }

    public String getItemName() {
        return itemName.get();
    }

    public void setItemName(String itemName) {
        this.itemName = new SimpleStringProperty(itemName);
    }

    public String getItemDescription() {
        return itemDescription.get();
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = new SimpleStringProperty(itemDescription);
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getCompletedMark() {
        return completedMark.get();
    }

    public void setCompletedMark(String completedMark) {
        this.completedMark = new SimpleStringProperty(completedMark);
    }
}
