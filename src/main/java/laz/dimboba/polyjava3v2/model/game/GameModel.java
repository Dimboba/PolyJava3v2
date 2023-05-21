package laz.dimboba.polyjava3v2.model.game;

public interface GameModel {
    Cell getCell(int col, int row);
    void makeTurn(Cell cell);
    int getNumOfCols();
    int getNumOfRows();
    int getNumOfCells();
    int getClosedCells();
    int getOpenedCells();
    boolean isGameIsOn();
}
