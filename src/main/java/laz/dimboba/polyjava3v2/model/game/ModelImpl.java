package laz.dimboba.polyjava3v2.model.game;//import javax.sound.midi.*;

import laz.dimboba.polyjava3v2.model.game.exceptions.NotEvenCellsNumberException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ModelImpl implements Model{
    private final int numOfCols, numOfRows, numOfCells;
    private int closedCells;
    private final List<Cell> cells;
    private List<GameListener> listeners;
    private Cell firstCell = null;

    protected ModelImpl(int numOfCols, int numOfRows) throws NotEvenCellsNumberException {
        this.numOfCols = numOfCols;
        this.numOfRows = numOfRows;
        numOfCells = numOfCols * numOfRows;
        closedCells = numOfCells;
        if(numOfCols % 2 != 0 && numOfRows % 2 != 0){
            throw new NotEvenCellsNumberException(numOfCols * numOfRows + " - is not even number");
        }

        listeners = new ArrayList<>();
        cells = new ArrayList<Cell>();

    }

    public Cell getCell(int col, int row){
        for(Cell cell: cells){
            if(cell.getRow() == row && cell.getCol() == col){
                return cell;
            }
        }
        return null;
    }

    public void addListener(GameListener gameListener){
        listeners.add(gameListener);
    }

    public void makeTurn(Cell cell){
        cell.setOpened(true);
        listeners.forEach(listener -> listener.makeTurn(cell));
        if(firstCell == null){
            firstCell = cell;
            return;
        }
        checkPairs(firstCell, cell);
        firstCell = null;
    }

    private void checkPairs(Cell cell1, Cell cell2){
        if(cell1.getPairCell() == cell2){
            System.out.println("Right pair");
            closedCells -= 2;
            if(closedCells == 0){
                System.out.println("Win");
                listeners.forEach(listener -> listener.endGame());
                return;
            }
            listeners.forEach(listener -> listener.rightPair(cell1, cell2));
            return;
        }
        cell1.setOpened(false);
        cell2.setOpened(false);
        System.out.println("Wrong pair");
        listeners.forEach(listener -> listener.wrongPair(cell1, cell2));
    }

    protected void makeNewPairs(){
        Collections.shuffle(cells);
        for(int i = 0; i < cells.size()/2; i++){
            cells.get(i).pairCells(cells.get(cells.size()/2 + i), i);
        }
        listeners.forEach(listener -> listener.newGame());
    }

    protected List<Cell> getCells(){
        return cells;
    }
    public int getNumOfCols() {
        return numOfCols;
    }

    public int getNumOfRows() {
        return numOfRows;
    }

    public int getNumOfCells() {
        return numOfCells;
    }

    public int getClosedCells() {
        return closedCells;
    }
}
