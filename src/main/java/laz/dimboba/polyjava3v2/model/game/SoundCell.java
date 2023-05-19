package laz.dimboba.polyjava3v2.model.game;

import java.util.function.Consumer;

public class SoundCell extends CellImpl{
    private String soundFile;
    public SoundCell(int row, int col){
        super(row, col);
    }

    @Override
    public void onClick(Consumer<String> consumer) {
        consumer.accept(soundFile);
    }

    public String getSoundFile() {
        return soundFile;
    }

    public void setSoundFile(String soundFile) {
        this.soundFile = soundFile;
    }
}
