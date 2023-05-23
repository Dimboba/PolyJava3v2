package laz.dimboba.polyjava3v2.model.game;

import javafx.scene.media.MediaPlayer;
import laz.dimboba.polyjava3v2.model.game.exceptions.NotEvenCellsNumberException;

import java.util.List;

public class SoundModel extends GameModelImpl {
    private MediaPlayer mediaPlayer;
    private String colour = "#82888d";
    private String[] sounds = {
            "1.wav",
            "2.wav",
            "3.wav",
            "4.wav",
            "5.wav",
            "6.wav",
            "7.wav",
            "8.wav"
    };
    public SoundModel(int numOfCols, int numOfRows, List<GameListener> list) throws NotEvenCellsNumberException {

        super(numOfCols, numOfRows, list);
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfCols; j++) {
                SoundCell cell = new SoundCell(i, j, mediaPlayer);
                cell.setColour(colour);
                getCells().add(cell);
            }
        }
        makeNewPairs();
        super.listeners.forEach(listener -> listener.newGame(this));
    }

    public void makeNewPairs(){
        super.makeNewPairs();
        super.makeNewPairs();
        for(int i = 0; i < super.getCells().size()/2; i++) {
            String url = "/sounds/" + sounds[i];
            ((SoundCell) super.getCells().get(i)).setSoundFile(url);
            ((SoundCell) super.getCells().get(i).getPairCell()).setSoundFile(url);
        }
    }

}
