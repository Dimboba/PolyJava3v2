package laz.dimboba.polyjava3v2.Model;

public class LeaderBoard implements GameListener{

    private boolean gameIsActive = false;
    public boolean currUser = true;

    public LeaderBoard(){

    }

    public void newUser(){

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
    public void wrongPair() {

    }
}
