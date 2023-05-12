package laz.dimboba.polyjava3v2.model.game;

public interface Cell {
    int getCol();
    int getRow();
    boolean isOpened();
    void setOpened(boolean opened);
    Cell getPairCell();
    void pairCells(Cell cell, int numOfPair);
    void onClick();
    int getNumOfPair();
    void setNumOfPair(int num);
    void setPairCell(Cell cell);
}
