package Lesson_6.NetChat.client;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(new File("A:\\Mine\\Java\\JC_Advanced\\JC_Advanced\\src\\Lesson_6\\NetChat\\client\\resources\\sample.fxml").toURI().toURL());
        Parent root = loader.load();
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("NetChat");
        primaryStage.setScene(new Scene(root, 400, 325));
        primaryStage.show();

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing");
                //primaryStage.close();
                System.exit(0);
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}