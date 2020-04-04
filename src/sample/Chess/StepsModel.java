package sample.Chess;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.ImageView;

public class StepsModel {
    private ImageView figuraColumn;
    private String startColumn;
    private String endColumn;

    public StepsModel(ImageView figuraColumn, String startColumn, String endColumn) {
        this.figuraColumn = figuraColumn;
        this.startColumn = startColumn;
        this.endColumn = endColumn;
    }

    public ImageView getFiguraColumn() {
        return figuraColumn;
    }

    public void setFiguraColumn(ImageView figuraColumn) {
        this.figuraColumn = figuraColumn;
    }

    public String getStartColumn() {
        return startColumn;
    }

    public void setStartColumn(String startColumn) {
        this.startColumn = startColumn;
    }

    public String getEndColumn() {
        return endColumn;
    }

    public void setEndColumn(String endColumn) {
        this.endColumn = endColumn;
    }
}
