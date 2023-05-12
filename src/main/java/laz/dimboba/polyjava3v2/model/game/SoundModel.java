package laz.dimboba.polyjava3v2.model.game;

import laz.dimboba.polyjava3v2.model.game.exceptions.NotEvenCellsNumberException;

public class SoundModel extends ModelImpl{
    public SoundModel(int numOfCols, int numOfRows) throws NotEvenCellsNumberException {

        super(numOfCols, numOfRows);
        for(int i = 0; i < numOfRows; i++){
            for(int j = 0; j < numOfCols; j++){
                getCells().add(new SoundCell(i, j));
            }
        }
        makeNewPairs();

    }
}
