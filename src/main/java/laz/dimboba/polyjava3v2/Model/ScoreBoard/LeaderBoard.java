package laz.dimboba.polyjava3v2.Model.ScoreBoard;

import laz.dimboba.polyjava3v2.Model.GameModel.Cell;
import laz.dimboba.polyjava3v2.Model.GameModel.GameListener;
import laz.dimboba.polyjava3v2.Model.ScoreBoard.UserService.UserService;
import laz.dimboba.polyjava3v2.Model.ScoreBoard.entity.User;

import java.util.ArrayList;
import java.util.List;
//TODO: дополнить, в частности убрать обновление списка при вызове get (добавил для теста)
public class LeaderBoard implements GameListener {

    private boolean gameIsActive = false;
    private boolean gameForPoints = true;
    private User currUser;
    private List<LeaderBoardListener> listeners;
    private List<User> topUsers = new ArrayList<>();
    private UserService userService;

    public LeaderBoard(User currUser){
        userService = new UserService();
        this.currUser = currUser;
        topUsers = userService.findAllUsers();
        listeners = new ArrayList<>();
    }

    public void addListener(LeaderBoardListener listener) {
        listeners.add(listener);
    }


    @Override
    public void newGame() {
        if(currUser != null){
            gameForPoints = true;
        }
        gameIsActive = true;
    }
    @Override
    public void rightPair(Cell cell1, Cell cell2) {

    }
    @Override
    public void endGame() {
        if(gameForPoints){
            //TODO: начислять поинты
        }
        gameIsActive = false;
    }
    @Override
    public void wrongPair(Cell cell1, Cell cell2) {

    }
    @Override
    public void makeTurn(Cell cell) {

    }

    public List<User> getTopUsers() {
        topUsers = userService.findAllUsers();
        if(topUsers.size() < 15)
            return topUsers;
        return topUsers.subList(0, 15);
    }

    public User getCurrUser() {
        return currUser;
    }

    public void setCurrUser(User user){
        currUser = user;
        if(gameIsActive){
            gameForPoints = false;
        }
    }

    public void changePassword(String newPassword){
        if(currUser == null){
            return;
        }
        currUser.setPassword(newPassword);
        userService.updateUser(currUser);
    }
}
