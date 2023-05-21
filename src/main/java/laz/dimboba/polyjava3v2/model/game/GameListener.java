package laz.dimboba.polyjava3v2.model.game;

import laz.dimboba.polyjava3v2.model.EndGameType;

public interface GameListener{
    void makeTurn(Cell cell);
    void wrongPair(Cell cell1, Cell cell2);
    void rightPair(Cell cell1, Cell cell2);
    void endGame(EndGameType type);
    void newGame(Model model);
}
