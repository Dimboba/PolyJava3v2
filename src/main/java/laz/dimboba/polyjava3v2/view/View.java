package laz.dimboba.polyjava3v2.view;

import javafx.scene.layout.BorderPane;
import laz.dimboba.polyjava3v2.model.game.Model;
import laz.dimboba.polyjava3v2.model.game.ModelImpl;
import laz.dimboba.polyjava3v2.model.scoreboard.LeaderBoard;
import laz.dimboba.polyjava3v2.view.game.GameField;
import laz.dimboba.polyjava3v2.view.score.ScoreField;

public class View extends BorderPane{
    private final GameField gameField;
    private final ScoreField scoreField;
    public View (Model model, LeaderBoard leaderBoard){
        gameField = new GameField(model);
        model.addListener(gameField);
        gameField.setPrefWidth(500);
        gameField.setPrefHeight(500);
        this.setCenter(gameField);
        scoreField = new ScoreField(leaderBoard);
        leaderBoard.addListener(scoreField);
        scoreField.setPrefWidth(100);
        this.setLeft(scoreField);

    }
}
