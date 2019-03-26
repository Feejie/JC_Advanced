package Lesson_6.NetChat.client;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MiniStage extends Stage {
    public MiniStage() {
        Parent root = null;

        try {
            FXMLLoader loader = new FXMLLoader(new File("A:\\Mine\\Java\\JC_Advanced\\JC_Advanced\\src\\Lesson_6\\NetChat\\client\\resources\\SecondWindow.fxml").toURI().toURL());
            root = loader.load();
            setTitle("NetChat");
            setScene(new Scene(root, 400, 325));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
