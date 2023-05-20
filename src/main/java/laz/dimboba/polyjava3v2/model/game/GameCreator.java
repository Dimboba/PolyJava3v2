package laz.dimboba.polyjava3v2.model.game;

import laz.dimboba.polyjava3v2.model.game.exceptions.NotEnoughColorsException;
import laz.dimboba.polyjava3v2.model.game.exceptions.NotEvenCellsNumberException;
import laz.dimboba.polyjava3v2.model.game.exceptions.WrongGameModeException;

public class GameCreator {
    private Model model;
    public GameCreator(){

    }

    public Model createNewGame(GameMode gameMode, int size)
            throws NotEvenCellsNumberException, NotEnoughColorsException, WrongGameModeException {
        switch (gameMode){
            case Sound -> {
                model = new SoundModel(size, size);
            }
            case Colour -> {
                model = new ColourModel(size, size);
            }
            default -> {
                throw new WrongGameModeException("Wrong Game mode");
            }
        }
        return model;
    }
}
