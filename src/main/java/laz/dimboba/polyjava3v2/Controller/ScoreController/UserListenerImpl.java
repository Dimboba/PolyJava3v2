package laz.dimboba.polyjava3v2.Controller.ScoreController;

import laz.dimboba.polyjava3v2.Model.ScoreBoard.LeaderBoard;

public class UserListenerImpl implements UserListener{
    private LeaderBoard leaderBoard;
    public UserListenerImpl(LeaderBoard leaderBoard){
        this.leaderBoard = leaderBoard;
    }

    @Override
    public void passwordChanged() {

    }
}
