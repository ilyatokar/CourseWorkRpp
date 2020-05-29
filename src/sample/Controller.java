package sample;

import sample.Chess.ChessWin;
import sample.GuessingGame.GuessingGameWin;
import sample.TicTacToe.TicTacToeWin;

public class Controller {

    public void onClickChess(){
        ChessWin chessWin = new ChessWin();
    }

    public void onClickTicTacToe(){
        TicTacToeWin ticTacToeWin = new TicTacToeWin();
    }

    public void onClickGuessingGame(){
        GuessingGameWin guessingGameWin = new GuessingGameWin();
    }

}
