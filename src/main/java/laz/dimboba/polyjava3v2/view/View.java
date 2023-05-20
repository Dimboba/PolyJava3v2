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
    private CreateGameForm form;
    private Model model;
    private LeaderBoard leaderBoard;
    private GameCreator gameCreator;
    public View (GameCreator creator, LeaderBoard leaderBoard){
        this.gameCreator = creator;
        this.leaderBoard = leaderBoard;
        this.form = new CreateGameForm(createGame);
        this.setCenter(form);
        form.setPrefHeight(500);
        form.setPrefWidth(500);
        scoreField = new ScoreField(leaderBoard);
        leaderBoard.addListener(scoreField);
        scoreField.setPrefWidth(100);
        this.setLeft(scoreField);
    }

    private final BiConsumer<GameMode, Integer> createGame = (mode, size) -> {
        try {
            model = gameCreator.createNewGame(mode, size);
        } catch (GameModelException e){
            throw new RuntimeException(e);
        }
        gameField = new GameField(model);
        gameField.setPrefWidth(500);
        gameField.setPrefHeight(500);
        this.setCenter(gameField);

        model.addListener(gameField);
        model.addListener(this.leaderBoard);
    };
}
