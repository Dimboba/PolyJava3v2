package laz.dimboba.polyjava3v2.controller.gamecontroller;

import laz.dimboba.polyjava3v2.model.game.GameCreator;
import laz.dimboba.polyjava3v2.model.game.GameMode;
import laz.dimboba.polyjava3v2.model.game.exceptions.GameModelException;

public class GameCreatorImpl implements GameCreatorListener{
    private final GameCreator gameCreator;
    public GameCreatorImpl(GameCreator gameCreator){
        this.gameCreator = gameCreator;
    }

    @Override
    public void createGame(GameMode gameMode, Integer size) {
        try {
            gameCreator.createNewGame(gameMode, size);
        } catch (GameModelException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
