package laz.dimboba.polyjava3v2.controller.scorecontroller;

import laz.dimboba.polyjava3v2.model.scoreboard.LeaderBoard;

public class UserListenerImpl implements UserListener{
    private LeaderBoard leaderBoard;
    public UserListenerImpl(LeaderBoard leaderBoard){
        this.leaderBoard = leaderBoard;
    }

    @Override
    public void passwordChanged(String newPassword) {
        leaderBoard.changePassword(newPassword);
    }

    @Override
    public void logOut() {
        leaderBoard.setCurrUser(null);
    }

    @Override
    public void nicknameChanged(String newNickname){
        leaderBoard.changeNickname(newNickname);
    }

    @Override
    public void logIn(String nickname, String password){
        //Можно ли использовать тут бд???
    }

}
