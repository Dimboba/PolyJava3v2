package laz.dimboba.polyjava3v2.view.score;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import laz.dimboba.polyjava3v2.model.scoreboard.LeaderBoard;
import laz.dimboba.polyjava3v2.model.scoreboard.LeaderBoardListener;

public class ScoreField extends BorderPane implements LeaderBoardListener {
    private final LeaderBoard leaderBoard;
    private final ScoreBoard table;
    private final UserBar userBar;
    public ScoreField(LeaderBoard leaderBoard){
        this.setPadding(new Insets(10, 10, 10, 10));
        this.leaderBoard = leaderBoard;
        this.table = new ScoreBoard(leaderBoard);
        this.userBar = new UserBar(leaderBoard);

        Button btn = new Button("refresh");
        btn.setOnAction(event -> {
            refresh();
        });

        //this.setTop(btn);
        this.setBottom(table);
        this.setTop(userBar);
    }

    @Override
    public void refresh() {
        table.refresh();
    }
}

