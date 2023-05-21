package laz.dimboba.polyjava3v2.model.scoreboard;

import laz.dimboba.polyjava3v2.model.game.EndGameType;
import laz.dimboba.polyjava3v2.model.game.Cell;
import laz.dimboba.polyjava3v2.model.game.GameListener;
import laz.dimboba.polyjava3v2.model.game.Model;
import laz.dimboba.polyjava3v2.model.scoreboard.userservice.UserService;
import laz.dimboba.polyjava3v2.model.scoreboard.entity.User;

import java.util.ArrayList;
import java.util.List;

//TODO: доделать, добавить login logout refresh
public class LeaderBoard implements GameListener {

    private boolean gameIsActive = false;
    private boolean gameForPoints = false;
    private User currUser;
    private int currPoints;
    private List<LeaderBoardListener> listeners;
    private List<User> topUsers = new ArrayList<>();
    private UserService userService;

    public LeaderBoard(){
        this(null);
    }

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
    public void newGame(Model model) {
        gameForPoints = false;
        if(currUser != null){
            gameForPoints = true;
            currPoints = model.getNumOfCells() * 5;
        }
        gameIsActive = true;
    }
    @Override
    public void rightPair(Cell cell1, Cell cell2) {

    }
    @Override
    public void endGame(EndGameType type) {
        if(gameForPoints && type == EndGameType.Win){
            currUser.setScore(currUser.getScore() + currPoints);
            userService.updateUser(currUser);
            listeners.forEach(listener -> listener.refresh());
        }
        gameIsActive = false;
    }
    @Override
    public void wrongPair(Cell cell1, Cell cell2) {
        if(gameForPoints){
            currPoints -= 3;
            if(currPoints < 10){
                currPoints = 10;
            }
        }
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

    public void logIn(String nickname, String password){
        UserService userService = new UserService();
        User user = userService.findByNickname(nickname);

        if (user == null || user.getNickname() == null){
            listeners.forEach(listener -> listener.logInError("Wrong nickname"));
            currUser = null;
            return;
        }
        if(user.getNickname().equals(nickname)
                && user.getPassword().equals(password)){
            currUser = user;
            listeners.forEach(listener -> listener.logInSuccess());
            if(gameIsActive){
                gameForPoints = false;
            }
        } else if(user.getNickname().equals(nickname)){
            listeners.forEach(listener -> listener.logInError("Wrong password"));
        }

    }
    public void logOut() {
        currUser = null;
        listeners.forEach(listener -> listener.logOut());
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
        listeners.forEach(listener -> listener.refresh());
    }

    public void changeNickname(String newNickname){
        if(currUser == null){
            return;
        }
        if(userService.findByNickname(newNickname) != null){
            listeners.forEach(listener -> listener.changeNicknameError());
            return;
        }
        currUser.setNickname(newNickname);
        userService.updateUser(currUser);
        listeners.forEach(listener -> listener.refresh());
    }
}
