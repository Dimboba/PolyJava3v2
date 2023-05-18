package laz.dimboba.polyjava3v2.view.score;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import laz.dimboba.polyjava3v2.controller.scorecontroller.UserListener;
import laz.dimboba.polyjava3v2.model.scoreboard.LeaderBoard;

public class LogInOutButton extends Button {
    private final LeaderBoard leaderBoard;
    private final UserListener listener;
    public LogInOutButton (String text, LeaderBoard leaderBoard, UserListener listener){
        super(text);
        this.leaderBoard = leaderBoard;
        this.listener = listener;
        this.setOnAction(event -> {
            if(leaderBoard.getCurrUser() == null){
                LogInWindow window = new LogInWindow();
                window.showAndWait();
                if(window.getResult().getButtonData() == ButtonBar.ButtonData.OK_DONE){
                    listener.logIn(window.getNickname(), window.getPassword());
                }
                return;
            }
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "Are you really want to log out?",
                    ButtonType.YES, ButtonType.NO);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                listener.logOut();
            }
        });;
    }
}
