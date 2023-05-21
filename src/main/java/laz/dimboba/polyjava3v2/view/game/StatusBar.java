package laz.dimboba.polyjava3v2.view.game;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import laz.dimboba.polyjava3v2.model.EndGameType;
import laz.dimboba.polyjava3v2.model.game.Cell;
import laz.dimboba.polyjava3v2.model.game.GameCreator;
import laz.dimboba.polyjava3v2.model.game.GameListener;
import laz.dimboba.polyjava3v2.model.game.Model;

public class StatusBar extends HBox implements GameListener {
    private final Label gameStatus;
    private final Label stepsToWin;
    private final Label steps;
    private int numOfMoves;
    private Button restart;
    private Model model;
    private final GameCreator gameCreator;
    public StatusBar(GameCreator gameCreator){
        this.gameCreator = gameCreator;
        gameStatus = new Label("Game is off");
        stepsToWin = new Label();
        steps = new Label();
        restart = new Button("Restart");
        restart.setOnAction(event -> {
            gameCreator.stopTheGame();
        });
        restart.setVisible(false);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
        this.setPadding(new Insets(10, 10, 10, 10));
        this.getChildren().addAll(gameStatus, stepsToWin, steps, restart);
    }

    @Override
    public void makeTurn(Cell cell) {
        numOfMoves++;
        steps.setText("Moves made: " + numOfMoves);
    }

    @Override
    public void wrongPair(Cell cell1, Cell cell2) {

    }

    @Override
    public void rightPair(Cell cell1, Cell cell2) {
        stepsToWin.setText("Cells opened: " + model.getOpenedCells() + '/' + model.getNumOfCells());
    }

    @Override
    public void endGame(EndGameType type) {
        gameStatus.setText("Game is OFF");
        steps.setText("Total moves made: " + numOfMoves);
        stepsToWin.setText("");
        restart.setVisible(false);
        if(type == EndGameType.Loose){
            steps.setText("");
        }
    }

    @Override
    public void newGame(Model model) {
        numOfMoves = 0;
        this.model = model;
        restart.setVisible(true);
        gameStatus.setText("Game is ON");
        steps.setText("Moves made: 0");
        stepsToWin.setText("Cells opened: " + model.getOpenedCells() + '/' + model.getNumOfCells());
    }
}
