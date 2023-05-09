package laz.dimboba.polyjava3v2.view;

import javafx.scene.control.Button;
import laz.dimboba.polyjava3v2.Controller.CellListener;
import laz.dimboba.polyjava3v2.Model.Cell;

public class CellButton extends Button {
    private final Cell cell;
    private final CellListener listener;
    private String colour;
    private String baseStyle;

    public CellButton(Cell cell, CellListener listener, String colour){
        super();
        this.cell = cell;
        this.listener = listener;
        this.colour = colour;
        this.baseStyle = this.getStyle();
        this.setOnAction(e -> {
            listener.cellClicked(cell);
        });
    }

    public void flip() {
        if(cell.isOpened()) {
            this.setStyle("-fx-background-color: " + colour + "; ");
            return;
        }

        this.setStyle(baseStyle);
    }
}
