package laz.dimboba.polyjava3v2.view.game;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;
import laz.dimboba.polyjava3v2.model.game.Cell;
import laz.dimboba.polyjava3v2.model.game.GameListener;
import laz.dimboba.polyjava3v2.model.game.Model;
import laz.dimboba.polyjava3v2.model.game.ModelImpl;

public class GameField extends BorderPane implements GameListener {
    private final Board board;
    private Timeline timeline;
    private final int showTime = 1250;
    public GameField(Model model){
        this.setPadding(new Insets(10, 10, 10, 10));

        board = new Board(model);
        this.setCenter(board);
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
    public void newGame() {

    }

    @Override
    public void endGame() {

    }
}
