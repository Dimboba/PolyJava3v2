package laz.dimboba.polyjava3v2.view.score;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumnBase;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import laz.dimboba.polyjava3v2.model.scoreboard.LeaderBoard;
import laz.dimboba.polyjava3v2.model.scoreboard.entity.User;

public class ScoreBoard extends TableView<User> {
    private final LeaderBoard leaderBoard;
    public ScoreBoard(LeaderBoard leaderBoard){
        this.leaderBoard = leaderBoard;
        ObservableList<User> topUsers =
                FXCollections.observableList(leaderBoard.getTopUsers());
        this.setItems(topUsers);
        this.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        //отключает скроллинг
//        table.addEventFilter(ScrollEvent.ANY, event -> {
//                System.out.println("Here ");
//
//                table.scrollTo(0);
//
//        });

        TableColumn<User, String> nicknameColumn = new TableColumn<>("Nickname");
        nicknameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("nickname"));
        this.getColumns().add(nicknameColumn);

        TableColumn<User, String> scoreColumn = new TableColumn<>("Score");
        scoreColumn.setCellValueFactory(new PropertyValueFactory<User, String>("score"));
        this.getColumns().add(scoreColumn);
        this.setMinWidth(this.getColumns()
                .stream()
                .mapToDouble(TableColumnBase::getWidth)
                .sum());


        this.setFixedCellSize(25);
        this.prefHeightProperty().bind(this.fixedCellSizeProperty().multiply(Bindings.size(this.getItems()).add(1.01)));
        this.minHeightProperty().bind(this.prefHeightProperty());
        this.maxHeightProperty().bind(this.prefHeightProperty());

    }

    public void refresh() {
        this.setItems(FXCollections.observableList(
                leaderBoard.getTopUsers()));

    }
}
