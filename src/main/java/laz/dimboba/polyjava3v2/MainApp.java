package laz.dimboba.polyjava3v2;

import javafx.application.Application;
import javafx.stage.Stage;
import laz.dimboba.polyjava3v2.UserService.UserService;
import laz.dimboba.polyjava3v2.entity.User;

public class MainApp extends Application {

    public void start(Stage mainStage) throws Exception{
        UserService userService = new UserService();
        User user = userService.findUser(14);
        System.out.println(user.toString());
        System.out.println(user.getScore());


        userService.saveUser("hello", "2345");
    }

    public static void main(String[] args){
        launch(args);
    }
}