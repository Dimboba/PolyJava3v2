package laz.dimboba.polyjava3v2.Model;

public interface GameListener{
    void makeTurn(Cell cell);
    void wrongPair(Cell cell1, Cell cell2);
    void rightPair(Cell cell1, Cell cell2);
    void endGame();
    void newGame();
}
