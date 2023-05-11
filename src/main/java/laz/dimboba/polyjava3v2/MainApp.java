package laz.dimboba.polyjava3v2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import laz.dimboba.polyjava3v2.Model.GameModel.Model;
import laz.dimboba.polyjava3v2.Model.ScoreBoard.LeaderBoard;
import laz.dimboba.polyjava3v2.Model.ScoreBoard.UserService.UserService;
import laz.dimboba.polyjava3v2.Model.ScoreBoard.entity.User;
import laz.dimboba.polyjava3v2.view.View;

public class MainApp extends Application {
    private final int numOfRows = 2;
    private final int numOfCols = 2;

    public void start(Stage mainStage) throws Exception{
        UserService userService = new UserService();
//        User user = userService.findUser(14);
//        System.out.println(user.toString());
//        System.out.println(user.getScore());
//
//
//        userService.saveUser("hello", "2345");
//        user.setNickname("Abracadabra");
//        userService.updateUser(user);
//        userService.deleteUser(user);
//        List<User> users = userService.findAllUsers();
//        for(User user: users){
//            System.out.println(user.toString());
//        }

        User testUser = new User(1001, "TestUser", "", 0);

        Model model = new Model(numOfRows, numOfCols);
        LeaderBoard leaderBoard = new LeaderBoard(testUser);
        View root = new View(model, leaderBoard);
        Scene scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("/style.css").toURI().toString());
        mainStage.setScene(scene);
        mainStage.setTitle("Testing");
        mainStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}