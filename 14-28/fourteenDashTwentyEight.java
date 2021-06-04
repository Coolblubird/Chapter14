import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import java.math.*;

public class fourteenDashTwentyEight extends Application {
	@Override
	public void start(Stage primaryStage) {
		int rHour = (int)(Math.random()*11);
		int rMinute = (int)(Math.random()*30);
		
		ClockPane clock = new ClockPane(rHour,rMinute,0);
		
		clock.setSecondHandVisibility(false);
		
		BorderPane pane = new BorderPane();
		pane.setCenter(clock);
		
		Scene scene = new Scene(pane, 300, 300);
		primaryStage.setTitle("Random funkee clock go brrr"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
}