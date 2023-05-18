package laz.dimboba.polyjava3v2.view.score;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class LogInWindow extends Dialog<ButtonType> {
    private final DialogPane root;
    private final TextField userTextField;
    private final PasswordField pwBox;
    public LogInWindow() {
        root = this.getDialogPane();

        root.getButtonTypes().add(new ButtonType("Log In", ButtonBar.ButtonData.OK_DONE));
        root.getButtonTypes().add(new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE));

        GridPane grid = new GridPane();
        root.setContent(grid);
        Text sceneTitle = new Text("Welcome");
        grid.add(sceneTitle, 0, 0, 2, 1);

        Label userName = new Label("Nickname:");
        grid.add(userName, 0, 1);

        userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);
    }

    public String getNickname(){
        return userTextField.getText();
    }
    public String getPassword(){
        return pwBox.getText();
    }
}
