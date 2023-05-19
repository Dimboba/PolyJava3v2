package laz.dimboba.polyjava3v2.controller.scorecontroller;

import laz.dimboba.polyjava3v2.model.scoreboard.LeaderBoard;
import laz.dimboba.polyjava3v2.model.scoreboard.entity.User;
import laz.dimboba.polyjava3v2.model.scoreboard.userservice.UserService;
//TODO: добавить проверки на существования ника и реакцию на это
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
        leaderBoard.logOut();
    }

    @Override
    public void nicknameChanged(String newNickname){
        leaderBoard.changeNickname(newNickname);
    }

    @Override
    public void logIn(String nickname, String password){
        leaderBoard.logIn(nickname, password);
        //TODO: придумать что с логином!!! (непонятно, что делать в случае неудачи)
        //TODO: мб сделать в лидер борде не setCurrUser a login logout
    }

}
