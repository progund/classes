import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.stage.Stage;

public class HelloFX extends Application {

  private GridPane grid = new GridPane();
  private Label greeting = new Label("Hello");

  @Override
  public void start(Stage primaryStage) {
    Button btn = new Button();
    btn.setText("Greet!");
    btn.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {
          if (getParameters().getRaw().size() != 0) {
            greeting.setText("Hello " + getParameters().getRaw().get(0));
          }
        }
      });

    grid.setAlignment(Pos.CENTER);
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(25, 25, 25, 25));
    grid.add(btn,0,0);
    grid.add(greeting, 0, 1);
    Scene scene = new Scene(grid, 300, 250);
    primaryStage.setTitle("Hello World!");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
