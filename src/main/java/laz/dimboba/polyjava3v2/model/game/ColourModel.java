package laz.dimboba.polyjava3v2.model.game;

import laz.dimboba.polyjava3v2.model.game.exceptions.NotEnoughColorsException;
import laz.dimboba.polyjava3v2.model.game.exceptions.NotEvenCellsNumberException;

import java.util.List;

public class ColourModel extends GameModelImpl {
    private String[] colors = {
            "#78c5d6",
            "#449ba9",
            "#78c267",
            "#c6d648",
            "#f4d73d",
            "#f28c34",
            "#e868a3",
            "#bf62a6"
    };
    public ColourModel(int numOfRows, int numOfCols, List<GameListener> list)
            throws NotEvenCellsNumberException, NotEnoughColorsException{
        super(numOfRows, numOfCols, list);
        for(int i = 0; i < numOfRows; i++){
            for(int j = 0; j < numOfCols; j++){
                ColourCell colourCell = new ColourCell(i,j);
                getCells().add(colourCell);
            }
        }
        if(super.getCells().size()/2 > colors.length){
            throw new NotEnoughColorsException("Not enough colors");
        }
        makeNewPairs();

        super.listeners.forEach(listener -> listener.newGame(this));
    }

    @Override
    public void makeNewPairs(){
        super.makeNewPairs();
        for(int i = 0; i < super.getCells().size()/2; i++) {
            ((ColourCell) super.getCells().get(i)).setColour(colors[i]);
            ((ColourCell) super.getCells().get(i).getPairCell()).setColour(colors[i]);
        }
    }
}
