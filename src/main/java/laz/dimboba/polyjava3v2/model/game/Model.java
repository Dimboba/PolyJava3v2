package laz.dimboba.polyjava3v2.model.game;

public interface Model {
    Cell getCell(int col, int row);
    void addListener(GameListener gameListener);
    void makeTurn(Cell cell);
    int getNumOfCols();
    int getNumOfRows();
    int getNumOfCells();
    int getClosedCells();
}
