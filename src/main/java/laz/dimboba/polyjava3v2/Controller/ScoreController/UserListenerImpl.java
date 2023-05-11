package laz.dimboba.polyjava3v2.Controller.ScoreController;

import laz.dimboba.polyjava3v2.Model.ScoreBoard.LeaderBoard;

public class UserListenerImpl implements UserListener{
    private LeaderBoard leaderBoard;
    private boolean isLoggin;
    public UserListenerImpl(LeaderBoard leaderBoard){
        this.leaderBoard = leaderBoard;
        isLoggin = this.leaderBoard.getCurrUser() != null;

    }

    @Override
    public void passwordChanged(String newPassword) {
        leaderBoard.changePassword(newPassword);
    }

    @Override
    public void logOut() {
        isLoggin = false;
        leaderBoard.setCurrUser(null);
    }


}
