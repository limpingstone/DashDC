import java.io.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Launch extends Application {

    /**
     * The method for initializing the javafx application
     * @param primaryStage a Stage object as the container for the application
     */
    @Override
    public void start(Stage primaryStage) {
        Button launchBtn = new Button("Launch Spring Boot");
        Button killBtn = new Button("End Spring Boot");

        launchBtn.setOnAction(e -> {
            Launch.launchJarFile();
        });

        killBtn.setOnAction(e -> {
            Launch.killJarFile();
        });

        GridPane pane = new GridPane();
        pane.add(launchBtn, 0, 1);
        pane.add(killBtn, 0, 3);

        Scene scene = new Scene(pane);

        primaryStage.setTitle("Console");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The static method that launches the jar file for Spring Boot backend
     */
    public static void launchJarFile() {
        try {
            // The method that opens the Spring Boot jar file
            Runtime.getRuntime().exec("java -jar ../../../../build/libs/DashDC-1.0.jar");
        } // When file is not found / error opening the file
        catch (IOException e) {
            System.out.println("Unable to launch jar file");
        }
    }

    public static void killJarFile() {
        try {
            Runtime.getRuntime().exec("killall java");
        }
        catch (IOException e) {
            System.out.println("Unable to end spring boot process");
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
