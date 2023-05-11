package laz.dimboba.polyjava3v2.view.Score;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import laz.dimboba.polyjava3v2.Controller.ScoreController.UserListener;
import laz.dimboba.polyjava3v2.Controller.ScoreController.UserListenerImpl;
import laz.dimboba.polyjava3v2.Model.GameModel.Model;
import laz.dimboba.polyjava3v2.Model.ScoreBoard.LeaderBoard;

public class UserBar extends VBox {
    private UserListener listener;
    UserBar(LeaderBoard leaderBoard){
        listener = new UserListenerImpl(leaderBoard);

        this.setPadding(new Insets(10, 10, 10, 10));
        this.setSpacing(10);

        HBox buttons = new HBox();
        Button logOut = new Button("Log Out");
        Button account = new Button("Account");
        buttons.getChildren().addAll(logOut, account);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(5);

        VBox userInfo = new VBox();
        Label nickname = new Label("Nickname:  " + leaderBoard.getCurrUser().getNickname());
        Label score = new Label("Score:  " + leaderBoard.getCurrUser().getScore());
        userInfo.getChildren().addAll(nickname, score);
        userInfo.setSpacing(5);

        this.getChildren().add(0, userInfo);
        this.getChildren().add(1, buttons);
    }
}
