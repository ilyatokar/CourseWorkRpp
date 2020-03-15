package sample.TicTacToe;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class TicTacToeWin {
    public TicTacToeWin(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(TicTacToeWin.class.getResource("tictactoe.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Крестики-нолики");
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
