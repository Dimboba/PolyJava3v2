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
    private final LogInOutButton logInOut;
    UserBar(LeaderBoard leaderBoard, UserListener listener){
        this.leaderBoard = leaderBoard;
        this.listener = listener;

        this.setPadding(new Insets(10, 10, 10, 10));
        this.setSpacing(10);

        HBox buttons = new HBox();
        if(leaderBoard.getCurrUser() == null) {
            logInOut = new LogInOutButton("Log In", leaderBoard, listener);
        } else {
            logInOut = new LogInOutButton("Log Out", leaderBoard, listener);
        }
        //TODO: при выходе очки никому не начисляются, игра прекращается, выползает окно
        Button account = new Button("Account");

        buttons.getChildren().addAll(logInOut, account);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(5);

        VBox userInfo = new VBox();
        nickname = new Label();
        score = new Label();
        userInfo.getChildren().addAll(nickname, score);
        userInfo.setSpacing(5);

        this.getChildren().add(0, userInfo);
        this.getChildren().add(1, buttons);
        refresh();
    }

    public void refresh(){
        if (leaderBoard.getCurrUser() == null){
            logInOut.setText("Log In");
            nickname.setText("You are not logged in");
            score.setText("To farm points log in");
            return;
        }
        logInOut.setText("Log Out");
        nickname.setText("Nickname:  " + leaderBoard.getCurrUser().getNickname());
        score.setText("Score:  " + leaderBoard.getCurrUser().getScore());
    }

}
