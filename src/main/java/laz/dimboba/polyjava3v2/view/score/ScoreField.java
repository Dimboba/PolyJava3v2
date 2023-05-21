package laz.dimboba.polyjava3v2.view.score;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import laz.dimboba.polyjava3v2.controller.scorecontroller.UserListener;
import laz.dimboba.polyjava3v2.controller.scorecontroller.UserListenerImpl;
import laz.dimboba.polyjava3v2.model.scoreboard.LeaderBoard;
import laz.dimboba.polyjava3v2.model.scoreboard.LeaderBoardListener;

public class ScoreField extends BorderPane implements LeaderBoardListener {
    private final LeaderBoard leaderBoard;
    private final ScoreBoard table;
    private final UserBar userBar;
    private final UserListener listener;
    public ScoreField(LeaderBoard leaderBoard){
        this.setPadding(new Insets(10, 10, 10, 10));
        this.leaderBoard = leaderBoard;
        this.listener = new UserListenerImpl(leaderBoard);
        this.table = new ScoreBoard(leaderBoard);
        this.userBar = new UserBar(leaderBoard, listener);

        //for tests
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
        userBar.refresh();
        table.refresh();
    }

    @Override
    public void logInError(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR,
                message,
                ButtonType.OK);
        alert.showAndWait();
    }
    @Override
    public void logInSuccess(){
        userBar.refresh();
        Alert alert = new Alert(Alert.AlertType.INFORMATION,
                "You was successfully logged in",
                ButtonType.OK);
        alert.showAndWait();
    }

    @Override
    public void logOut() {
        userBar.refresh();
    }

    @Override
    public void changeNicknameError(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION,
                "There are already user with this nickname",
                ButtonType.OK);
        alert.showAndWait();
    }
}

