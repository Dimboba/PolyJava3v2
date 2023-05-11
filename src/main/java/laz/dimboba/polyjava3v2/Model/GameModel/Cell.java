package laz.dimboba.polyjava3v2.Model.GameModel;

public class Cell {
    private final int col;
    private final int row;
    private Cell pairCell;
    private boolean opened;
    private int numOfPair;

    public void pairCells(Cell pairCell, int numOfPair){
        this.pairCell = pairCell;
        pairCell.setPairCell(this);

        this.numOfPair = numOfPair;
        pairCell.setNumOfPair(this.numOfPair);
    }
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        opened = false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass() || obj.hashCode() != hashCode()) return false;
        Cell cell = (Cell) obj;
        return col == cell.col && row == cell.row;
    }

    @Override
    public int hashCode() {
        int res = 11;
        res = res * 19 + row;
        return res * 19 + col;
    }


    public void setNumOfPair(int newPair){
        this.numOfPair = newPair;
    }
    public int getNumOfPair(){
        return numOfPair;
    }
    public int getCol() {
        return col;
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

    private void setPairCell(Cell pairCell) {
        this.pairCell = pairCell;
    }
    public Cell getPairCell() {
        return pairCell;
    }
}