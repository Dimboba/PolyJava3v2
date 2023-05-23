package laz.dimboba.polyjava3v2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import laz.dimboba.polyjava3v2.model.game.*;
import laz.dimboba.polyjava3v2.model.scoreboard.LeaderBoard;
import laz.dimboba.polyjava3v2.view.View;

public class MainApp extends Application {
    private final int numOfRows = 2;
    private final int numOfCols = 2;

    public void start(Stage mainStage) throws Exception{
        GameLauncher gameCreator = new GameLauncher();
        LeaderBoard leaderBoard = new LeaderBoard();
        gameCreator.addListener(leaderBoard);
        View root = new View(gameCreator, leaderBoard);
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.setTitle("Memory Game");
        mainStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}