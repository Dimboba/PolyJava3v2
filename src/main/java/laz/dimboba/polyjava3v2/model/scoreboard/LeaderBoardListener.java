package laz.dimboba.polyjava3v2.model.scoreboard;

public interface LeaderBoardListener {
    public void refresh();
    public void logInError(String message);
    public void logInSuccess();
    public void logOut();
}
