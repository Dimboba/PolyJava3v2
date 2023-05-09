package laz.dimboba.polyjava3v2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import laz.dimboba.polyjava3v2.Model.Model;
import laz.dimboba.polyjava3v2.UserService.UserService;
import laz.dimboba.polyjava3v2.view.View;

public class MainApp extends Application {
    private final int windowWidth = 500;
    private final int windowHeight = 500;
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

        Model model = new Model(numOfRows, numOfCols);
        View root = new View(model);
        Scene scene = new Scene(root, windowWidth, windowHeight);
        mainStage.setScene(scene);
        mainStage.setTitle("Testing");
        mainStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}