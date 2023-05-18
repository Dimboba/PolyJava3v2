package laz.dimboba.polyjava3v2.view.score;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import laz.dimboba.polyjava3v2.controller.scorecontroller.UserListener;
import laz.dimboba.polyjava3v2.controller.scorecontroller.UserListenerImpl;
import laz.dimboba.polyjava3v2.model.scoreboard.LeaderBoard;

public class UserBar extends VBox {
    private UserListener listener;
    private final Label nickname;
    private final Label score;
    private final LeaderBoard leaderBoard;
    UserBar(LeaderBoard leaderBoard, UserListener listener){
        this.leaderBoard = leaderBoard;
        this.listener = listener;

        this.setPadding(new Insets(10, 10, 10, 10));
        this.setSpacing(10);

        HBox buttons = new HBox();
        Button logOut = new Button("Log Out");
        //TODO: при выходе очки никому не начисляются, игра прекращается, выползает окно
        logOut.setOnAction(event -> {
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
        });
        Button account = new Button("Account");

        buttons.getChildren().addAll(logOut, account);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(5);

        VBox userInfo = new VBox();
        nickname = new Label("Nickname:  " + leaderBoard.getCurrUser().getNickname());
        score = new Label("Score:  " + leaderBoard.getCurrUser().getScore());
        userInfo.getChildren().addAll(nickname, score);
        userInfo.setSpacing(5);

        this.getChildren().add(0, userInfo);
        this.getChildren().add(1, buttons);
    }

    public void refresh(){
        if (leaderBoard.getCurrUser() == null){
            nickname.setText("You are not logged in");
            score.setText("To farm points log in");
            return;
        }
        nickname.setText("Nickname:  " + leaderBoard.getCurrUser().getNickname());
        score.setText("Score:  " + leaderBoard.getCurrUser().getScore());
    }
}
