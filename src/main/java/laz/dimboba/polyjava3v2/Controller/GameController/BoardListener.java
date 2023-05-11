package laz.dimboba.polyjava3v2.Controller.GameController;

import laz.dimboba.polyjava3v2.Model.GameModel.Cell;
import laz.dimboba.polyjava3v2.Model.GameModel.Model;

public class BoardListener implements CellListener{
    private final Model model;

    public BoardListener(Model model){
        this.model = model;
    }

    @Override
    public void cellClicked(Cell cell) {
        if(!cell.isOpened()) {
            System.out.println("Click row:" + cell.getRow() + " column: " + cell.getCol());
            model.makeTurn(cell);
        }
    }
}
