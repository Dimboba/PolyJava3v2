package laz.dimboba.polyjava3v2.Model;//import javax.sound.midi.*;

import laz.dimboba.polyjava3v2.Model.Exceptions.NotEvenCellsNumberException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Model {
    private final int numOfCols, numOfRows, numOfCells;
    private int closedCells;
    private final List<Cell> cells;
    private List<GameListener> listeners;

    public Model(int numOfCols, int numOfRows) throws NotEvenCellsNumberException {
        this.numOfCols = numOfCols;
        this.numOfRows = numOfRows;
        numOfCells = numOfCols * numOfRows;
        closedCells = numOfCells;
        if(numOfCols % 2 != 0 && numOfRows % 2 != 0){
            throw new NotEvenCellsNumberException(numOfCols * numOfRows + " - is not even number");
        }
        cells = new ArrayList<Cell>();
        for(int i = 0; i < numOfRows; i++){
            for(int j = 0; j < numOfCols; j++){
                cells.add(new Cell(i, j));
            }
        }
        makeNewPairs();

    }

    public Cell getCell(int col, int row){
        for(Cell cell: cells){
            if(cell.getRow() == row && cell.getColumn() == col){
                return cell;
            }
        }
        return null;
    }

    public void addListener(GameListener gameListener){
        listeners.add(gameListener);
    }

    public void makeTurn(Cell cell1, Cell cell2){
        if(cell1.getPairCell() == cell2){
            cell1.setOpened(true);
            cell2.setOpened(true);
            closedCells -= 2;
            if(closedCells == 0){
                listeners.forEach(listener -> listener.endGame());
                return;
            }
            listeners.forEach(listener -> listener.rightPair(cell1, cell2));
            return;
        }

        listeners.forEach(listener -> listener.wrongPair());
    }

    private void makeNewPairs(){
        Collections.shuffle(cells);
        for(int i = 0; i < cells.size()/2; i++){
            cells.get(i).pairCells(cells.get(cells.size()/2 + i), i);
        }
        listeners.forEach(listener -> listener.newGame());
    }

}
