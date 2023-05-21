package laz.dimboba.polyjava3v2.controller.gamecontroller;

import laz.dimboba.polyjava3v2.model.game.Cell;
import laz.dimboba.polyjava3v2.model.game.Model;

import java.util.function.Consumer;

public class BoardListener implements CellListener{
    private final Model model;

    public BoardListener(Model model){
        this.model = model;
    }

    @Override
    public void cellClicked(Cell cell) {
        if(!cell.isOpened()) {
            cell.onClick();
            System.out.println("Click row:" + cell.getRow() + " column: " + cell.getCol());
            model.makeTurn(cell);
        }
    }
}
