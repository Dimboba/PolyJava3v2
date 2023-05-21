package laz.dimboba.polyjava3v2.view.score;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import laz.dimboba.polyjava3v2.controller.scorecontroller.UserListener;
import laz.dimboba.polyjava3v2.model.scoreboard.LeaderBoard;

public class ChangeAccountButton extends Button {
    private LeaderBoard leaderBoard;
    private UserListener listener;
    public ChangeAccountButton(String text, LeaderBoard leaderBoard, UserListener listener){
        super(text);
        this.leaderBoard = leaderBoard;
        this.listener = listener;
        this.setOnAction(event -> {
            if(leaderBoard.getCurrUser() != null){
                ChangeAccountWindow window = new ChangeAccountWindow(leaderBoard.getCurrUser());
                window.showAndWait();
                if(window.getResult().getButtonData() == ButtonBar.ButtonData.OK_DONE){
                    if(window.getNickname() != leaderBoard.getCurrUser().getNickname()){
                        listener.nicknameChanged(window.getNickname());
                    }
                    if(window.getPassword() != leaderBoard.getCurrUser().getPassword()){
                        listener.passwordChanged(window.getPassword());
                    }
                }
            }
        });
    }
}
