package laz.dimboba.polyjava3v2.view.game;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import laz.dimboba.polyjava3v2.model.game.GameMode;
import laz.dimboba.polyjava3v2.model.game.exceptions.WrongGameModeException;

import java.util.function.BiConsumer;

public class CreateGameForm extends StackPane {
    private final ToggleGroup mode;
    private final ComboBox<String> comboBox;
    private final GridPane root;
    private final VBox radioBox;
    private final Button sendButton;
    public CreateGameForm(BiConsumer<GameMode, Integer> create) {
        root = new GridPane();

        mode = new ToggleGroup();
        RadioButton sound = new RadioButton("Sound");
        RadioButton colour = new RadioButton("Colour");
        mode.getToggles().addAll(sound, colour);
        radioBox = new VBox(sound, colour);
        radioBox.setSpacing(10);
        root.add(radioBox, 0, 1);

        char times = '\u00D7';
        String t = " " +times + " ";
        ObservableList<String> comboList = FXCollections.observableArrayList(
                2 + t + 2, 4 + t + 4);
        comboBox = new ComboBox<>(comboList);
        comboBox.setValue(4 + t + 4);
        root.add(comboBox, 1, 1);

        Label gameTypeLabel = new Label("Choose game type:");
        Label boardSizeLabel = new Label("Board's size:");
        root.add(gameTypeLabel, 0, 0);
        root.add(boardSizeLabel, 1, 0);

        sendButton = new Button("Start game");
        sendButton.setOnAction(event -> {
            if(comboBox.getValue() != null
            && mode.getSelectedToggle() != null){
                try {
                    create.accept(
                            getGameMode(),
                            getSize());
                } catch (WrongGameModeException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        root.add(sendButton, 1, 2);

        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25, 25, 25));
        root.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        this.getChildren().add(root);
    }

    private GameMode getGameMode() throws WrongGameModeException{
        switch (((RadioButton) (mode.getSelectedToggle())).getText() ){
            case "Sound" -> {
                return GameMode.Sound;
            }
            case "Colour" -> {
                return GameMode.Colour;
            }
            default -> {
                throw new WrongGameModeException("Wrong GameMode");
            }
        }
    }

    private int getSize() {
        return Integer.parseInt(comboBox.getValue().substring(0, 1));
    }
}
