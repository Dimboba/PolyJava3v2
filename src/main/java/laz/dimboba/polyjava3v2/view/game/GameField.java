package laz.dimboba.polyjava3v2.view.game;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;
import laz.dimboba.polyjava3v2.controller.gamecontroller.GameCreatorImpl;
import laz.dimboba.polyjava3v2.controller.gamecontroller.GameCreatorListener;
import laz.dimboba.polyjava3v2.model.game.EndGameType;
import laz.dimboba.polyjava3v2.model.game.*;

import java.util.function.BiConsumer;

public class GameField extends BorderPane implements GameListener {
    private Model model;
    private Board board;
    private final StatusBar statusBar;
    private Timeline timeline;
    private GameCreatorListener gameCreatorListener;
    private final int showTime = 1250, winShowTime = 2500;
    private CreateGameForm form;
    public GameField(GameCreator gameCreator){
        this.statusBar = new StatusBar(gameCreator);
        gameCreator.addListener(statusBar);
        this.setBottom(statusBar);

        this.gameCreatorListener = new GameCreatorImpl(gameCreator);
        this.setPadding(new Insets(10, 10, 10, 10));

        createForm();
    }

    @Override
    public void rightPair(Cell cell1, Cell cell2) {
        CellButton cellButton1 = board.getCellButton(cell1);
        CellButton cellButton2 = board.getCellButton(cell2);

        timeline = new Timeline(
                new KeyFrame(Duration.millis(showTime),
                        ev -> {
                            cellButton1.setVisible(false);
                            cellButton2.setVisible(false);
                        }));
        timeline.setCycleCount(1);
        timeline.play();
    }

    @Override
    public void wrongPair(Cell cell1, Cell cell2) {
        CellButton cellButton1 = board.getCellButton(cell1);
        CellButton cellButton2 = board.getCellButton(cell2);

        timeline = new Timeline(
                new KeyFrame(Duration.millis(showTime),
                        ev -> {
                            cellButton1.flip();
                            cellButton2.flip();
                        }));
        timeline.setCycleCount(1);
        timeline.play();

    }

    @Override
    public void makeTurn(Cell cell) {
        CellButton cellButton = board.getCellButton(cell);
        cellButton.flip();

        if(timeline != null && timeline.getStatus() == Animation.Status.RUNNING){
            timeline.stop();
            timeline.playFrom(Duration.millis(showTime));
        }
    }

    @Override
    public void newGame(Model model) {
        this.model = model;
        board = new Board(model);
        this.setCenter(board);
    }

    private final BiConsumer<GameMode, Integer> createGame = (mode, size) -> {
        gameCreatorListener.createGame(mode, size);
    };
    public void createForm(){
        form = new CreateGameForm(createGame);
        this.setCenter(form);
    }
    @Override
    public void endGame(EndGameType type) {
        if(type == EndGameType.Loose){
            createForm();
            return;
        }
        Label winLabel = new Label("You won!!!");
        this.setCenter(winLabel);

        timeline = new Timeline(
                new KeyFrame(Duration.millis(winShowTime),
                        ev -> {
                            createForm();
                        }));
        timeline.setCycleCount(1);
        timeline.play();

    }
}
