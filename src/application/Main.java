package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import logic.Plate;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;

public class Main extends Application {
	@Override
	public void start(Stage window) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
			window.getIcons().add(new Image("logo black.png"));
			window.setTitle("The Eater's Club");
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			window.setResizable(false);
			window.setScene(scene);
			window.show();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
