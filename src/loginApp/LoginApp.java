package loginApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginApp extends Application {
	public void start(Stage stage) throws Exception {
		//set root node or parent node for all nodes
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("login.fxml"));
		//set scene
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("School Management System");
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
