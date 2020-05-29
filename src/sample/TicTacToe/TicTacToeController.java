package sample.TicTacToe;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Random;

public class TicTacToeController {
    @FXML
    private Button button00, button01, button02,
            button10, button11, button12,
            button20, button21, button22;

    private Button[][] arrButton;
    private int[][] position;

    @FXML
    private GridPane gridpane;

    private Integer selectX, selectY, moveX, moveY, figure;

    private Image circle = new Image(getClass().getResourceAsStream("/sample/TicTacToe/images/circle.png"));
    private Image cross = new Image(getClass().getResourceAsStream("/sample/TicTacToe/images/cross.png"));

    private int winner = 0;

    @FXML
    public void initialize(){
        arrButton = new Button[3][3];
        arrButton[0][0] = button00;
        arrButton[0][1] = button01;
        arrButton[0][2] = button02;
        arrButton[1][0] = button10;
        arrButton[1][1] = button11;
        arrButton[1][2] = button12;
        arrButton[2][0] = button20;
        arrButton[2][1] = button21;
        arrButton[2][2] = button22;
    }

    public void InitTictactoe(){
        gridpane.setDisable(false);
        position = new int[3][3];
        position[0][0] = 0;
        position[0][1] = 0;
        position[0][2] = 0;
        position[1][0] = 0;
        position[1][1] = 0;
        position[1][2] = 0;
        position[2][0] = 0;
        position[2][1] = 0;
        position[2][2] = 0;
        StartGame();
        UpdateDesk();
    }

    public void UpdateDesk(){
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                arrButton[i][j].setGraphic(null);
            }
        }
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                if (position[i][j] == 1)
                    arrButton[i][j].setGraphic(new ImageView(circle));
                else if (position[i][j] == 2)
                    arrButton[i][j].setGraphic(new ImageView(cross));
            }
        }
    }

    public void SelectAndMoveFigure(int x, int y){
        if( position[x][y] == 0){
            arrButton[x][y].setGraphic(new ImageView(cross));
            position[x][y] = 2;
            if(CheckEndGame(1)){
                winner = 1;
                EndGame();
                return;
            }
            else if (CheckEndGame(2)){
                winner = 2;
                EndGame();
                return;
            }
            ComputerRunning();
            if(CheckEndGame(1)){
                winner = 1;
                EndGame();
                return;
            }
            else if (CheckEndGame(2)){
                winner = 2;
                EndGame();
                return;
            }
        }

    }

    public void ComputerRunning(){
        //существует методо getGraphic возвращает node c помощью него можно проверять пустые позиции
        ArrayList<Position> vacantPosition = new ArrayList<Position>();
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                if(position[i][j] == 0){
                    vacantPosition.add(new Position(i,j));
                }
            }
        }
        if(vacantPosition.size() > 1) {
            System.out.println(vacantPosition.size());
            Random random = new Random();
            int RandomPosition = random.nextInt(vacantPosition.size()-1);
            int x = vacantPosition.get(RandomPosition).x;
            int y = vacantPosition.get(RandomPosition).y;
            arrButton[x][y].setGraphic(new ImageView(circle));
            position[x][y] = 1;


            for (int i=0; i<3; i++) {
                for (int j = 0; j < 3; j++)
                    System.out.print(position[i][j] + " ");
                System.out.println();
            }

            System.out.println();

        }else{
            EndGame();
        }

    }

    public boolean CheckEndGame(int player){
        if(
            (position[0][0] == player && position[0][1] == player && position[0][2] == player) ||
            (position[1][0] == player && position[1][1] == player && position[1][2] == player) ||
            (position[2][0] == player && position[2][1] == player && position[2][2] == player) ||
            (position[0][0] == player && position[1][0] == player && position[2][0] == player) ||
            (position[0][1] == player && position[1][1] == player && position[2][1] == player) ||
            (position[0][2] == player && position[1][2] == player && position[2][2] == player) ||
            (position[0][0] == player && position[1][1] == player && position[2][2] == player) ||
            (position[0][2] == player && position[1][1] == player && position[2][0] == player)
        ) {
            return true;
        } else {
            return false;
        }

    }

    public void button00(){
        SelectAndMoveFigure(0,0);
    }
    public void button01(){
        SelectAndMoveFigure(0,1);
    }
    public void button02(){
        SelectAndMoveFigure(0,2);
    }
    public void button10(){
        SelectAndMoveFigure(1,0);
    }
    public void button11(){
        SelectAndMoveFigure(1,1);
    }
    public void button12(){
        SelectAndMoveFigure(1,2);
    }
    public void button20(){
        SelectAndMoveFigure(2,0);
    }
    public void button21(){
        SelectAndMoveFigure(2,1);
    }
    public void button22(){
        SelectAndMoveFigure(2,2);
    }


    public void StartGame(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Игра началась");
        alert.setHeaderText(null);
        alert.setContentText("Игра началась");
        alert.showAndWait();
    }

    public void EndGame(){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Конец игры");
        alert.setHeaderText(null);
        if(winner == 0)
            alert.setContentText("Победила дружба!");
        else if(winner == 1)
            alert.setContentText("Победил компьютер!");
        else if(winner == 2)
            alert.setContentText("Вы выграли!");

        alert.showAndWait();

        gridpane.setDisable(true);
    }
}
