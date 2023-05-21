package laz.dimboba.polyjava3v2.model.game;

import laz.dimboba.polyjava3v2.model.game.exceptions.GameModelException;
import laz.dimboba.polyjava3v2.model.game.exceptions.WrongGameModeException;

import java.util.List;

public class GameModelFactory {
    public GameModel getNewGame(GameMode gameMode, int size, List<GameListener> listeners)
            throws GameModelException {
        switch (gameMode){
            case Sound -> {
                return new SoundModel(size, size, listeners);
            }
            case Colour -> {
                return new ColourModel(size, size, listeners);
            }
            default -> {
                throw new WrongGameModeException("Wrong Game mode");
            }
        }
    }
}
