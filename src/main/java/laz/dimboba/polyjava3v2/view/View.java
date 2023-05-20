package laz.dimboba.polyjava3v2.view;

import javafx.scene.layout.BorderPane;
import laz.dimboba.polyjava3v2.model.game.GameCreator;
import laz.dimboba.polyjava3v2.model.game.GameMode;
import laz.dimboba.polyjava3v2.model.game.Model;
import laz.dimboba.polyjava3v2.model.game.exceptions.GameModelException;
import laz.dimboba.polyjava3v2.model.game.exceptions.NotEnoughColorsException;
import laz.dimboba.polyjava3v2.model.game.exceptions.NotEvenCellsNumberException;
import laz.dimboba.polyjava3v2.model.game.exceptions.WrongGameModeException;
import laz.dimboba.polyjava3v2.model.scoreboard.LeaderBoard;
import laz.dimboba.polyjava3v2.view.game.CreateGameForm;
import laz.dimboba.polyjava3v2.view.game.GameField;
import laz.dimboba.polyjava3v2.view.score.ScoreField;

import java.util.function.BiConsumer;

public class View extends BorderPane{
    private GameField gameField;
    private final ScoreField scoreField;
    private LeaderBoard leaderBoard;
    private GameCreator gameCreator;
    public View (GameCreator creator, LeaderBoard leaderBoard){
        this.gameCreator = creator;
        this.leaderBoard = leaderBoard;
        gameField = new GameField(gameCreator);
        gameCreator.addListener(gameField);
        gameField.setPrefWidth(500);
        gameField.setPrefHeight(500);
        this.setCenter(gameField);

        scoreField = new ScoreField(leaderBoard);
        leaderBoard.addListener(scoreField);
        scoreField.setPrefWidth(100);
        this.setLeft(scoreField);
    }


}
