package shootingrange;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/shootingRange.fxml"));
        primaryStage.setTitle("AI Shooter");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();



    }


    public static void main(String[] args) {
        launch(args);
    }
}
