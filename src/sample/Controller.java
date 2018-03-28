package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{


    @FXML
    private TableView<Person> tview;

    @FXML
    private TableColumn<Person,String> colName;

    @FXML
    private TableColumn colAge;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTableViewFactory();
        ObservableList<Person> persons = FXCollections.observableArrayList(
                new Person("兔子",12),
                new Person("狗子",33),
                new Person("猫子",666)
                );
         tview.getItems().clear();
         tview.setItems(persons);
         tview.setEditable(true);

    }


    private void initTableViewFactory(){
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        colName.setEditable(true);
        colName.setCellFactory(TextFieldTableCell.forTableColumn());
        colName.setOnEditCommit(event -> getItem(event).setName(event.getNewValue()));
        colAge.setCellFactory(param -> new MoneyTableCell());
    }

    public <S,T> S getItem(TableColumn.CellEditEvent<S,T> t){
       return t.getTableView().getItems().get(t.getTablePosition().getRow());
    }

}
