package laz.dimboba.polyjava3v2.model.game;

import laz.dimboba.polyjava3v2.model.game.exceptions.NotEvenCellsNumberException;

public class ColourModel extends ModelImpl {
    public ColourModel(int numOfRows, int numOfCols) throws NotEvenCellsNumberException {
        super(numOfRows, numOfCols);
        for(int i = 0; i < numOfRows; i++){
            for(int j = 0; j < numOfCols; j++){
                getCells().add(new ColourCell(i, j));
            }
        }
        makeNewPairs();
    }

}
