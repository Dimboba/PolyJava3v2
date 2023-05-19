package laz.dimboba.polyjava3v2.view.game;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class CreateGameForm extends HBox {
    private final ToggleGroup mode;
    private final ComboBox<String> comboBox;
    public CreateGameForm() {
        mode = new ToggleGroup();

        RadioButton sound = new RadioButton("Sound");
        RadioButton colour = new RadioButton("Colour");
        mode.getToggles().addAll(sound, colour);
        VBox radioBox = new VBox(sound, colour);
        this.getChildren().add(radioBox);

        Label boardSizeLabel = new Label("Board's size:");
        char times = '\u00D7';
        String t = " " +times + " ";
        ObservableList<String> comboList = FXCollections.observableArrayList(
                2 + t + 2, 4 + t + 4);
        comboBox = new ComboBox<>(comboList);
        comboBox.setValue(4 + t + 4);
        this.getChildren().add(comboBox);
    }
}
