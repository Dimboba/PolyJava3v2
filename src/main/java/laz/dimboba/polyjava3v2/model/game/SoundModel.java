package laz.dimboba.polyjava3v2.model.game;

import laz.dimboba.polyjava3v2.model.game.exceptions.NotEvenCellsNumberException;

import java.util.List;

public class SoundModel extends ModelImpl{
    private String[] sounds = {
            //TODO: тут должны быть файлы
    };
    public SoundModel(int numOfCols, int numOfRows, List<GameListener> list) throws NotEvenCellsNumberException {

        super(numOfCols, numOfRows, list);
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfCols; j++) {
                getCells().add(new SoundCell(i, j));
            }
        }
        makeNewPairs();
        super.listeners.forEach(listener -> listener.newGame(this));
    }

    public void makeNewPairs(){
        super.makeNewPairs();
        super.makeNewPairs();
        for(int i = 0; i < super.getCells().size()/2; i++) {
            ((SoundCell) super.getCells().get(i)).setSoundFile(sounds[i]);
            ((SoundCell) super.getCells().get(i).getPairCell()).setSoundFile(sounds[i]);
        }
    }

}
