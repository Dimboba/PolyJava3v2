package laz.dimboba.polyjava3v2.view.score;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import laz.dimboba.polyjava3v2.model.scoreboard.entity.User;

public class ChangeAccountWindow extends Dialog<ButtonType> {
    private final DialogPane root;
    private final TextField userTextField;
    private final TextField pwBox;
    public ChangeAccountWindow(User currUser) {
        root = this.getDialogPane();

        root.getButtonTypes().add(new ButtonType("Change", ButtonBar.ButtonData.OK_DONE));
        root.getButtonTypes().add(new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE));

        GridPane grid = new GridPane();
        root.setContent(grid);
        Text sceneTitle = new Text("Change your account");
        grid.add(sceneTitle, 0, 0, 2, 1);
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label userName = new Label("New nickname:");
        grid.add(userName, 0, 1);

        userTextField = new TextField(currUser.getNickname());
        grid.add(userTextField, 1, 1);

        Label pw = new Label("New password:");
        grid.add(pw, 0, 2);

        pwBox = new TextField(currUser.getPassword());
        grid.add(pwBox, 1, 2);
    }

    public String getNickname(){
        return userTextField.getText();
    }
    public String getPassword(){
        return pwBox.getText();
    }
}
