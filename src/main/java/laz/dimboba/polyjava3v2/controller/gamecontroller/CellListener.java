package laz.dimboba.polyjava3v2.controller.gamecontroller;

import laz.dimboba.polyjava3v2.model.game.Cell;

import java.util.function.Consumer;

public interface CellListener {
    public void cellClicked(Cell cell);
}
