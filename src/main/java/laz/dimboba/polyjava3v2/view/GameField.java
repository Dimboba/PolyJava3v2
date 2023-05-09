package laz.dimboba.polyjava3v2.view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import laz.dimboba.polyjava3v2.Model.Cell;
import laz.dimboba.polyjava3v2.Model.GameListener;
import laz.dimboba.polyjava3v2.Model.Model;

public class GameField extends BorderPane implements GameListener {
    private final Board board;
    public GameField(Model model){
        board = new Board(model);
        this.setCenter(board);
    }

    @Override
    public void rightPair(Cell cell1, Cell cell2) {

    }

    @Override
    public void wrongPair(Cell cell1, Cell cell2) {
        int showTime = 1250;

        CellButton cellButton1 = board.getCellButton(cell1);
        CellButton cellButton2 = board.getCellButton(cell2);

        Timeline timeline = new Timeline(
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

    }

    @Override
    public void newGame() {

    }

    @Override
    public void endGame() {

    }
}
