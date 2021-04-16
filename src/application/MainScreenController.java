package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.RotateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import logic.Plate;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MainScreenController implements Initializable {
    @FXML private HBox cartButton;
    @FXML private Label brandLbl;
    @FXML private ImageView logoView;
    @FXML private Button finalizeOrderBtn;
    @FXML private ListView<Plate> listView; 
    @FXML private Label selectedPlateLbl;
    @FXML private Label selectedPriceLbl; 
    @FXML private Label finalPriceLbl;
    @FXML private Spinner<Integer> quantitySpinner;
    @FXML private Button addToCartBtn;

	private Plate selected;
    private final int defaultValue = 1;
    private final SpinnerValueFactory<Integer> values = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,500, defaultValue);
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		manageAnimations();
		setupSpinner();
		//Setup list and populate with whatever the database holds
		setupList(fetchData());
		
		//Manage Button Click
		addToCartBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(selected == null) return;
				selected.setQuantity(quantitySpinner.getValue());
				Plate.platesInCart.add(selected);
				String message = "You successfully added \"" + selected.getPlateName() + "\" to your cart!\n\n\nYour cart consists of:\n\n";
				double total = 0;
				for(Plate plate : Plate.platesInCart) {
					total += plate.getPrice() * plate.getQuantity();
					message += "\"" + plate.getPlateName() + "\"\tQuantity:" + plate.getQuantity() + "\tPrice: " + String.format("%.2f", plate.getPrice() * plate.getQuantity()) + "€\n";
				}
				message += "\nTotal Price: " + String.format("%.2f",total) + "€";
				showDialog(message, "Success!");
				quantitySpinner.decrement(quantitySpinner.getValue() -1);
				selected = null;
				quantitySpinner.setDisable(true);
			}
			
		});

	}
	
	private void setupList(ObservableList<Plate> plates) {
		//Set and Populate ListView
		listView.setCellFactory((lv) -> { return new MainListViewItemCell();});
		listView.setItems(plates);
		listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Plate>() {
			public void changed(ObservableValue<? extends Plate> ov, final Plate oldValue, final Plate newValue) {
				selectedPlateLbl.setText("Plate: " + newValue.getPlateName());
				selectedPriceLbl.setText("Plate Price: " + String.format("%.2f", newValue.getPrice()) + "€");
				finalPriceLbl.setText("Final Plate Price: " + String.format("%.2f",newValue.getPrice() * quantitySpinner.getValue())+ "€");
				selected = newValue;
				quantitySpinner.setDisable(false);
			}
		});
	}
	
	private ObservableList<Plate> fetchData() {
		ObservableList<Plate> plates = FXCollections.observableArrayList();
		plates.add(new Plate("Pizza Fan", "2 Κανονικές Πίτσες & 1 choco krats", 12.00, "images/pizzafan.png"));
		plates.add(new Plate("The Big Bad Wolf", "8 Καλαμάκια της επιλογής σας με πιτάκια", 10.99, "images/The Big Bad Wolf.png"));
		plates.add(new Plate("Goody's Burger House", "2 Extreme Deluxe", 11.30, "images/Goody Burger House.png"));
		return plates;
	}
	
	private void setupSpinner() {
		//Setup Spinner to defaults and functionality
		quantitySpinner.setValueFactory(values);
		quantitySpinner.setDisable(true);
		quantitySpinner.valueProperty().addListener(new ChangeListener<Integer>() {

			@Override
			public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
				if(selected == null) return;
				finalPriceLbl.setText("Final Plate Price: " + String.format("%.2f",selected.getPrice() * newValue) + "€");
			}
			
		});
		
	}
	
	private void manageAnimations() {
		//Setup basic event animations
		cartButton.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				cartButton.setPadding(new Insets(10,0,10,0));
				cartButton.setStyle("-fx-background-color:#252525");
				
			}

		});
		cartButton.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				cartButton.setPadding(new Insets(0,0,0,0));
				cartButton.setStyle("-fx-background-color:#353535");
			}});
		finalizeOrderBtn.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				finalizeOrderBtn.setPadding(new Insets(10,0,10,0));
				finalizeOrderBtn.setStyle("-fx-background-color:#252525");
			}});
		finalizeOrderBtn.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				finalizeOrderBtn.setPadding(new Insets(0,0,0,0));
				finalizeOrderBtn.setStyle("-fx-background-color:#353535");
			}});
		
		//Manage brand Name animation
		RotateTransition brandRotate = new RotateTransition();  
		brandRotate.setAxis(Rotate.Z_AXIS);  
		brandRotate.setCycleCount(2);  
		brandRotate.setDuration(Duration.millis(800));  
		brandRotate.setAutoReverse(true);  
		brandRotate.setNode(brandLbl);  
		brandRotate.setByAngle(-30);  
		brandLbl.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				brandRotate.play(); 
			}
		});
		
		//Manage logo Animation
		RotateTransition logoRotate = new RotateTransition();  
		logoRotate.setAxis(Rotate.X_AXIS);  
		logoRotate.setCycleCount(2);  
		logoRotate.setDuration(Duration.millis(1000));  
		logoRotate.setAutoReverse(true);  
		logoRotate.setNode(logoView);  
		logoRotate.setByAngle(180);  
		logoView.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				logoRotate.play(); 
			}
		});
	
	}
	
	private void showDialog(String message, String title) {
		Dialog<String> dialog = new Dialog<String>();
	    dialog.setTitle(title);
	    ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
	    dialog.setContentText(message);
	    
	    dialog.setWidth(500);
	    dialog.getDialogPane().getButtonTypes().add(type);
	    dialog.showAndWait();
	}

}
