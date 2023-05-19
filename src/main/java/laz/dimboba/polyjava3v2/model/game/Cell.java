package laz.dimboba.polyjava3v2.model.game;

import java.util.function.Consumer;

public interface Cell {
    int getCol();
    int getRow();
    boolean isOpened();
    void setOpened(boolean opened);
    Cell getPairCell();
    void pairCells(Cell cell, int numOfPair);
    void onClick(Consumer<String> consumer);
    int getNumOfPair();
    void setNumOfPair(int num);
    void setPairCell(Cell cell);
}
//
//interface Expression{
//    void doOnChange(String colour);
//}
