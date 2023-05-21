package laz.dimboba.polyjava3v2.model.game;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.net.URISyntaxException;
import java.util.function.Consumer;

public class SoundCell extends CellImpl{
    private String colour;
    private String soundFile;
    private MediaPlayer mediaPlayer;
    private final double showTime = 1250;
    public SoundCell(int row, int col, MediaPlayer mediaPlayer){
        super(row, col);
        this.mediaPlayer = mediaPlayer;
    }

    @Override
    public void onClick() {
        if(mediaPlayer != null) {
            mediaPlayer.stop();
        }
        mediaPlayer = null;
        Media media = null;
        try {
            media = new Media(getClass().getResource(soundFile).toURI().toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setStopTime(Duration.millis(showTime));
        mediaPlayer.play();

        System.out.println(soundFile);
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
    public String getSoundFile() {
        return soundFile;
    }

    public void setSoundFile(String soundFile) {
        this.soundFile = soundFile;
    }
}
