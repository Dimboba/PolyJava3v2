package laz.dimboba.polyjava3v2.controller.scorecontroller;

public interface UserListener {
    void logIn(String nickname, String password);
    void nicknameChanged(String newNickname);
    void passwordChanged(String newPassword);
    void logOut();
}
