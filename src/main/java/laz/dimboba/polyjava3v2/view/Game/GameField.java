package laz.dimboba.polyjava3v2.view.Game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;
import laz.dimboba.polyjava3v2.Model.GameModel.Cell;
import laz.dimboba.polyjava3v2.Model.GameModel.GameListener;
import laz.dimboba.polyjava3v2.Model.GameModel.Model;

public class GameField extends BorderPane implements GameListener {
    private final Board board;
    public GameField(Model model){
        this.setPadding(new Insets(10, 10, 10, 10));

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
