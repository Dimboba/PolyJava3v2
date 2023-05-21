package laz.dimboba.polyjava3v2.view.game;

import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import laz.dimboba.polyjava3v2.controller.gamecontroller.CellListener;
import laz.dimboba.polyjava3v2.model.game.Cell;
import laz.dimboba.polyjava3v2.model.game.ColourCell;
import laz.dimboba.polyjava3v2.model.game.SoundCell;
import laz.dimboba.polyjava3v2.view.game.exceptions.UnknownCellException;
import java.net.URISyntaxException;

public class CellButton extends Button {
    private final Cell cell;
    private final CellListener listener;
    private String baseStyle;

    public CellButton(Cell cell, CellListener listener){
        super();
        this.cell = cell;
        this.listener = listener;
        this.baseStyle = this.getStyle();
        this.setOnAction(e -> {
            listener.cellClicked(cell);
        });
    }

    public void flip() {
        if(cell.isOpened()) {
            this.setStyle("-fx-background-color: " + cell.getColour() + "; ");
            return;
        }

        this.setStyle(baseStyle);
    }
}
