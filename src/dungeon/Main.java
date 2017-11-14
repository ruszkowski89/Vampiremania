package dungeon;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  public static void main(String[] args) {
    launch(args);

    //new Dungeon(10,7,5,22,true).run();

  }

  @Override
  public void start(Stage stage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("guiBeforeGameStart.fxml"));

    Scene scene = new Scene(root);

    stage.setTitle("Vampiremania");
    stage.setScene(scene);
    stage.show();
  }
}
