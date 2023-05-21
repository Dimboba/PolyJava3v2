package laz.dimboba.polyjava3v2.view;

import javafx.scene.layout.BorderPane;
import laz.dimboba.polyjava3v2.model.game.GameLauncher;
import laz.dimboba.polyjava3v2.model.scoreboard.LeaderBoard;
import laz.dimboba.polyjava3v2.view.game.GameField;
import laz.dimboba.polyjava3v2.view.score.ScoreField;

import java.net.URISyntaxException;

public class View extends BorderPane{
    private GameField gameField;
    private final ScoreField scoreField;
    private LeaderBoard leaderBoard;
    private GameLauncher gameCreator;
    public View (GameLauncher creator, LeaderBoard leaderBoard){
        try {
            this.getStylesheets().add(getClass().getResource("/style.css").toURI().toString());
        } catch (URISyntaxException e){
            System.out.println("Styles weren't downloaded");
        }
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
