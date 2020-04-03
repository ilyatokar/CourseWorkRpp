package sample.Chess;

import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class ChessController {
    @FXML
    private Button button00, button01, button02,
        button10, button11, button12,
        button20, button21, button22;

    @FXML
    private GridPane gridpane;

    private Button[][] arrButton;
    private int[][] position;

    private Integer selectX, selectY, moveX, moveY, figure;

    private Image pawnBlack = new Image(getClass().getResourceAsStream("/sample/Chess/images/pawn_black.png"));
    private Image ferz = new Image(getClass().getResourceAsStream("/sample/Chess/images/elephant_white.png"));

    public void InitGameChess(){
        gridpane.setDisable(false);
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

        position = new int[3][3];
        position[0][0] = 2;
        position[0][1] = 2;
        position[0][2] = 2;
        position[1][0] = 0;
        position[1][1] = 0;
        position[1][2] = 0;
        position[2][0] = 1;
        position[2][1] = 1;
        position[2][2] = 1;

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
                    arrButton[i][j].setGraphic(new ImageView(pawnBlack));
                else if (position[i][j] == 2)
                    arrButton[i][j].setGraphic(new ImageView(ferz));
            }
        }
    }

    public void SelectAndMoveFigure(int x, int y){
        if(selectX == null && selectY == null){
            selectX = x;
            selectY = y;
            figure = position[x][y];
        }
        else if(selectX == x &&
                selectY == y){
            ClearSelect();
        }
        else{
            if(position[x][y] == 0){
                moveX = x;
                moveY = y;
                position[selectX][selectY] = 0;
                position[x][y] = figure;
                UpdateDesk();
            }
            ClearSelect();
            СheckEndGame();
        }
    }

    public void ClearSelect (){
        selectX = null;
        selectY = null;
        figure = null;
        moveX = null;
        moveY = null;
    }

    public void ClearGame(){
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                arrButton[i][j].setGraphic(null);
            }
        }
        gridpane.setDisable(true);
    }

    public void СheckEndGame(){
        if(position[0][0] == 1 &&
            position[0][1] == 1 &&
            position[0][2] == 1 &&
            position[2][0] == 2 &&
            position[2][1] == 2 &&
            position[2][2] == 2
        ){
            AlertSuccess();
            ClearGame();
        }
    }
    public void AlertSuccess(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Игра завершена !!!");
        alert.setHeaderText(null);
        alert.setContentText("Игра завершена !!!");
        alert.showAndWait();
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
}
