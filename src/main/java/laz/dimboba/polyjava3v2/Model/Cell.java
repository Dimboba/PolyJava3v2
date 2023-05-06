package laz.dimboba.polyjava3v2.Model;

public class Cell {
    private final int column;
    private final int row;
    private Cell pairCell;
    private boolean opened;
    private int numOfPair;
    public void setNumOfPair(int newPair){
        this.numOfPair = newPair;
    }
    public int getNumOfPair(){
        return numOfPair;
    }
    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }


    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    public void setPairCell(Cell pairCell) {
        this.pairCell = pairCell;
    }
    public Cell getPairCell() {
        return pairCell;
    }

    public void pairCells(Cell pairCell, int numOfPair){
        this.pairCell = pairCell;
        pairCell.setPairCell(this);

        this.numOfPair = numOfPair;
        pairCell.setNumOfPair(this.numOfPair);
    }
    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        opened = false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass() || obj.hashCode() != hashCode()) return false;
        Cell cell = (Cell) obj;
        return column == cell.column && row == cell.row;
    }

    @Override
    public int hashCode() {
        int res = 11;
        res = res * 19 + row;
        return res * 19 + column;
    }
}