package sample.GuessingGame;


public class TableModel {

    private String numberColumn;
    private String resultColumn;

    public TableModel(String NumberColumn, String resultColumn) {
        this.numberColumn = NumberColumn;
        this.resultColumn = resultColumn;
    }

    public String getNumberColumn() {
        return numberColumn;
    }

    public void setNumberColumn(String numberColumn) {
        this.numberColumn = numberColumn;
    }

    public String getResultColumn() {
        return resultColumn;
    }

    public void setResultColumn(String resultColumn) {
        this.resultColumn = resultColumn;
    }
}
