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
            listener.cellClicked(cell, this::safeOnClick);
        });
    }

    public void flip() {
        if(cell.isOpened()) {
            if(cell instanceof ColourCell){
                //this.setStyle("-fx-background-color: " + cell.getColour() + "; ");
            }
            return;
        }

        this.setStyle(baseStyle);
    }

    private void onClick(String data) throws UnknownCellException {
        if(cell instanceof ColourCell){
            this.setStyle("-fx-background-color: " + data + "; ");
        } else if(cell instanceof SoundCell){
            Media media = null;
            try {
                media = new Media(getClass().getResource(data).toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
        } else {
            throw new UnknownCellException("Unknown Cell extension");
        }

    }

    private void safeOnClick(String data){
        try{
            onClick(data);
        } catch (UnknownCellException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
