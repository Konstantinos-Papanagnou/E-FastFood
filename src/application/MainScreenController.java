package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import logic.Plate;

public class MainScreenController implements Initializable {

    @FXML
    private HBox cartButton;

    @FXML
    private Button finalizeOrderBtn;

    @FXML
    private HBox ListView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cartButton.setOnMouseEntered(new EventHandler() {

			@Override
			public void handle(Event event) {
				cartButton.setStyle("-fx-background-color:#252525");
			}});
		cartButton.setOnMouseExited(new EventHandler() {

			@Override
			public void handle(Event event) {
				cartButton.setStyle("-fx-background-color:#353535");
			}});
		
		
		finalizeOrderBtn.setOnMouseEntered(new EventHandler() {

			@Override
			public void handle(Event event) {
				finalizeOrderBtn.setStyle("-fx-background-color:#252525");
			}});
		finalizeOrderBtn.setOnMouseExited(new EventHandler() {

			@Override
			public void handle(Event event) {
				finalizeOrderBtn.setStyle("-fx-background-color:#353535");
			}});
		
		//Load Data from database..
		ArrayList<Plate> plates = new ArrayList<Plate>();
		plates.add(new Plate("Pizza Fan", "2 Κανονικές Πίτσες & 1 choco krats", 12.0, "images/pizzafan.png"));
		plates.add(new Plate("The Big Bad Wolf", "8 Καλαμάκια της επιλογής σας με πιτάκια", 10.99, "images/The Big Bad Wolf.png"));
		plates.add(new Plate("Goody's Burger House", "2 Extreme Deluxe", 11.30, "Goody's Burger House.png"));
		
		
		//Create ListViewItems foreach Entry
		Node[] nodes = new Node[plates.size()];
		for(int i = 0; i < plates.size(); i++){
			
			FXMLLoader loader = new FXMLLoader();
			try {
				nodes[i] = loader.load(getClass().getResource("MainListViewItem.fxml"));
				MainListViewItemController controller = new MainListViewItemController(plates.get(i));
				//loader.setController(new MainListViewItemController(plates.get(i)));
				loader.setController(controller);
				//((IUpdatable)loader.getController()).populate(plates.get(i));
				///nodes[i] = loader;
				ListView.getChildren().add(nodes[i]);		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			
		}
		
	}

}
