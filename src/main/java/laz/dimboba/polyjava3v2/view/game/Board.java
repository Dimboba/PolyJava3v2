package laz.dimboba.polyjava3v2.view.game;

import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import laz.dimboba.polyjava3v2.controller.gamecontroller.BoardListener;
import laz.dimboba.polyjava3v2.model.game.Cell;
import laz.dimboba.polyjava3v2.model.game.Model;

import java.util.HashMap;
//TODO: добавить цвета
public class Board extends GridPane {
    private BoardListener listener;
    private HashMap<Cell, CellButton> cellButtonMap;

    public Board(Model model) {

        cellButtonMap = new HashMap<>();
        listener = new BoardListener(model);

        this.setAlignment(Pos.CENTER);
        for (int i = 0; i < model.getNumOfRows(); i++) {

            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100d / model.getNumOfRows());
            this.getRowConstraints().add(row);

            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(100d / model.getNumOfCols());
            this.getColumnConstraints().add(col);

            for (int j = 0; j < model.getNumOfCols(); j++) {

                Cell currCell = model.getCell(i, j);
                CellButton btn = new CellButton(currCell, listener, "#ff0000");
                cellButtonMap.put(currCell, btn);

                btn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                this.add(btn, i, j);
            }
        }


    }

    public CellButton getCellButton(Cell cell){ return cellButtonMap.get(cell); }
}
