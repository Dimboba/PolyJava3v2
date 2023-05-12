module laz.dimboba.polyjava3v2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires com.almasb.fxgl.all;
    requires javafx.media;
    requires java.sql;

    opens laz.dimboba.polyjava3v2 to javafx.fxml;
    exports laz.dimboba.polyjava3v2;
    exports laz.dimboba.polyjava3v2.view;
    opens laz.dimboba.polyjava3v2.view to javafx.fxml;
    exports laz.dimboba.polyjava3v2.view.game;
    opens laz.dimboba.polyjava3v2.view.game to javafx.fxml;
    opens laz.dimboba.polyjava3v2.model.scoreboard.entity to javafx.base;
}