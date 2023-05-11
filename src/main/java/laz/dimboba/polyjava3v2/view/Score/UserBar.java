package laz.dimboba.polyjava3v2.view.Score;

import javafx.scene.layout.HBox;
import laz.dimboba.polyjava3v2.Controller.ScoreController.UserListener;
import laz.dimboba.polyjava3v2.Controller.ScoreController.UserListenerImpl;
import laz.dimboba.polyjava3v2.Model.GameModel.Model;
import laz.dimboba.polyjava3v2.Model.ScoreBoard.LeaderBoard;

public class UserBar extends HBox {
    private UserListener listener;
    UserBar(LeaderBoard leaderBoard){
        listener = new UserListenerImpl(leaderBoard);
    }
}
