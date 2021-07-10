package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

//class for each item
public class Item {

    //create data types to hold the names, descriptions, and due dates
    private SimpleStringProperty itemName, itemDescription;
    private LocalDate dueDate;

    public Item(String itemName, String itemDescription, LocalDate dueDate) {
        this.itemName = new SimpleStringProperty(itemName);
        this.itemDescription = new SimpleStringProperty(itemDescription);
        this.dueDate = dueDate;
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


}
