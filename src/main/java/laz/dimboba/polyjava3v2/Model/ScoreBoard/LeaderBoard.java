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
    private User currUser;
    private List<LeaderBoardListener> listeners;
    private List<User> topUsers = new ArrayList<>();

    public LeaderBoard(User currUser){
        UserService userService = new UserService();
        this.currUser = currUser;
        topUsers = userService.findAllUsers();
        listeners = new ArrayList<>();
    }

    public void addListener(LeaderBoardListener listener) {
        listeners.add(listener);
    }


    @Override
    public void newGame() {
        gameIsActive = true;
    }
    @Override
    public void rightPair(Cell cell1, Cell cell2) {

    }
    @Override
    public void endGame() {
        gameIsActive = false;
    }
    @Override
    public void wrongPair(Cell cell1, Cell cell2) {

    }
    @Override
    public void makeTurn(Cell cell) {

    }

    public List<User> getTopUsers() {
        UserService userService = new UserService();
        topUsers = userService.findAllUsers();
        if(topUsers.size() < 15)
            return topUsers;
        return topUsers.subList(0, 15);
    }

    public User getCurrUser() {
        return currUser;
    }
}
