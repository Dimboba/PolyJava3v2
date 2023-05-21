package laz.dimboba.polyjava3v2.model.game;

import laz.dimboba.polyjava3v2.model.game.exceptions.NotEnoughColorsException;
import laz.dimboba.polyjava3v2.model.game.exceptions.NotEvenCellsNumberException;
import laz.dimboba.polyjava3v2.model.game.exceptions.WrongGameModeException;

import java.util.ArrayList;
import java.util.List;

public class GameCreator {
    private Model model;
    private List<GameListener> listeners;
    public GameCreator(){
        listeners = new ArrayList<>();
    }

    public void addListener(GameListener listener){
        listeners.add(listener);
    }
    public void createNewGame(GameMode gameMode, int size)
            throws NotEvenCellsNumberException, NotEnoughColorsException, WrongGameModeException {
        switch (gameMode){
            case Sound -> {
                model = new SoundModel(size, size, listeners);
            }
            case Colour -> {
                model = new ColourModel(size, size, listeners);
            }
            default -> {
                throw new WrongGameModeException("Wrong Game mode");
            }
        }
    }
    public void stopTheGame(){
        model = null;
        listeners.forEach(listener -> listener.endGame(EndGameType.Loose));
    }
}
