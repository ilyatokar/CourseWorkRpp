package sample.Chess;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ChessWin {
    public ChessWin(){
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ChessWin.class.getResource("chess.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Переставь фигуру");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.setResizable(false);

            dialogStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
