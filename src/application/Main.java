package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
		 FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("/application/scene.fxml"));
	        Parent root = loader.load();

	        Scene scene = new Scene(root);
	        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
	        primaryStage.setTitle("CSV Generator");
	        primaryStage.setScene(scene);
	        primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public static void main(String[] args) {
		launch(args);

	}

}
