package laz.dimboba.polyjava3v2.view;

import javafx.scene.layout.BorderPane;
import laz.dimboba.polyjava3v2.Model.GameModel.Model;
import laz.dimboba.polyjava3v2.Model.ScoreBoard.LeaderBoard;
import laz.dimboba.polyjava3v2.view.Game.GameField;
import laz.dimboba.polyjava3v2.view.Score.ScoreBoard;
import laz.dimboba.polyjava3v2.view.Score.ScoreField;

public class View extends BorderPane{
    private final GameField gameField;
    private final ScoreField scoreField;
    public View (Model model, LeaderBoard leaderBoard){
        gameField = new GameField(model);
        model.addListener(gameField);
        this.setCenter(gameField);
        scoreField = new ScoreField(leaderBoard);
        this.setLeft(scoreField);

    }
}
