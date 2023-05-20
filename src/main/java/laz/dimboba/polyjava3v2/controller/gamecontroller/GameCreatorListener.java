package laz.dimboba.polyjava3v2.controller.gamecontroller;

import laz.dimboba.polyjava3v2.model.game.GameMode;

public interface GameCreatorListener {
    void createGame(GameMode gameMode, Integer size);
}
