package laz.dimboba.polyjava3v2.Model;

public interface GameListener{
    void wrongPair();
    void rightPair(Cell cell1, Cell cell2);
    void endGame();
    void newGame();
}
