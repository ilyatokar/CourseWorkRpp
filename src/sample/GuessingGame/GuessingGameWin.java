package sample.GuessingGame;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class GuessingGameWin {
    public GuessingGameWin(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GuessingGameWin.class.getResource("simple.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Угадайка");
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
