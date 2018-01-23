package sample;

import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableCell;

public class MoneyTableCell extends TableCell<Person,String> {

    private Person person;
    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (getIndex()>-1 && getTableView().getItems().size() > getIndex()){
            person = getTableView().getItems().get(getIndex());
            item=Convert.amount2RMB(person.getAge());
        }
        Hyperlink label = new Hyperlink(item==null?"":item);
        label.setOnAction(event -> System.out.println(label.getText()));
        setGraphic(label);
    }
}
