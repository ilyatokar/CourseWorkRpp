package sample.GuessingGame;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {
    Integer startBorder=0, endBorder=100, numberSearch=-1, generate=0;
    @FXML
    TableView<TableModel> Table;
    private ObservableList<TableModel> stepsData = FXCollections.observableArrayList();

    @FXML
    TextField texFieldSearchNumber;

    public void initialize(){

        TableColumn<TableModel, String> startColumn = new TableColumn<TableModel, String>("Число");
        startColumn.setCellValueFactory(new PropertyValueFactory<TableModel, String>("NumberColumn"));
        Table.getColumns().add(startColumn);

        TableColumn<TableModel, String> endColumn = new TableColumn<TableModel, String>("Результат");
        endColumn.setCellValueFactory(new PropertyValueFactory<TableModel, String>("resultColumn"));
        Table.getColumns().add(endColumn);

    }

    public void onClickButtonStartGame(){
        stepsData.clear();
        numberSearch = Integer.parseInt(texFieldSearchNumber.getText());

        boolean game = true;
        while (game){
            int randomNumber = rnd(startBorder, endBorder);
            if(randomNumber<numberSearch) {
                addItemTable(randomNumber, "Задуманное число меньше");
                startBorder = randomNumber-1;
            }
            else if(randomNumber>numberSearch) {
                addItemTable(randomNumber, "Задуманное число больше");
                endBorder = randomNumber-1;
            }
            else{
                addItemTable(randomNumber, "Виктория");
                endBorder = 100;
                startBorder = 0;
                game = false;
            }
        }
    }

    private void addItemTable(Integer item, String str){
        stepsData.add(new TableModel(item.toString(),str));
        Table.setItems(stepsData);
    }

    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

}
