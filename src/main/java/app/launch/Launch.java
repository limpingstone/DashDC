import java.io.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Launch extends Application {

    /**
     * The method for initializing the javafx application
     * @param primaryStage a Stage object as the container for the application
     */
    @Override
    public void start(Stage primaryStage) {
        Button launchBtn = new Button();
        launchBtn.setText("Launch Spring Boot");
        launchBtn.setOnAction(e -> {
            Launch.launchJarFile();
        });

        StackPane root = new StackPane();
        root.getChildren().add(launchBtn);
        Scene scene = new Scene(root, 300, 300);

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
            Runtime.getRuntime().exec("java -jar ../../../../../build/libs/DashDC-1.0.jar");
        } // When file is not found / error opening the file
        catch (IOException e) {
            System.out.println("Unable to launch jar file");
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
