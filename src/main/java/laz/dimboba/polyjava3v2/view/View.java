package laz.dimboba.polyjava3v2.view;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import laz.dimboba.polyjava3v2.Model.Model;

public class View extends BorderPane{
    private final GameField gameField;
    public View (Model model){
        gameField = new GameField(model);
        model.addListener(gameField);
        this.setCenter(gameField);
    }
}
