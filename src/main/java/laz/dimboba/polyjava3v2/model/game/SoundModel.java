package laz.dimboba.polyjava3v2.model.game;

import laz.dimboba.polyjava3v2.model.game.exceptions.NotEvenCellsNumberException;

public class SoundModel extends ModelImpl{
    private String[] sounds = {
            //TODO: тут должны быть файлы
    };
    public SoundModel(int numOfCols, int numOfRows) throws NotEvenCellsNumberException {

        super(numOfCols, numOfRows);
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfCols; j++) {
                getCells().add(new SoundCell(i, j));
            }
        }
        makeNewPairs();
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
