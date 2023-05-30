package laz.dimboba.polyjava3v2.model.game;

import laz.dimboba.polyjava3v2.model.game.exceptions.GameModelException;
import laz.dimboba.polyjava3v2.model.game.exceptions.NotEnoughColorsException;
import laz.dimboba.polyjava3v2.model.game.exceptions.NotEvenCellsNumberException;
import laz.dimboba.polyjava3v2.model.game.exceptions.WrongGameModeException;

import java.util.ArrayList;
import java.util.List;

public class GameLauncher {
    private GameModel model;
    private List<GameListener> listeners;
    public GameLauncher(){
        listeners = new ArrayList<>();
    }

    public void addListener(GameListener listener){
        listeners.add(listener);
    }
    public void createNewGame(GameMode gameMode, int size)
            throws NotEvenCellsNumberException, NotEnoughColorsException, WrongGameModeException {
        try {
            model = new GameModelFactory().getNewGame(gameMode, size, listeners);
        } catch (GameModelException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public void stopTheGame(){
        model = null;
        listeners.forEach(listener -> listener.endGame(EndGameType.Loose));
    }

    //for tests only
    public GameModel getModel() {
        return model;
    }
}
