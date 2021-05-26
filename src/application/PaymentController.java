package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Duration;
import logic.DatabaseHandler;
import logic.Order;
import logic.Plate;
import javafx.event.*;

public class PaymentController implements Initializable{

   
    @FXML
    private TextField NameField;
    @FXML
    private TextField TelephoneField;
    @FXML
    private TextField EmailField;
    @FXML 
    private TextField AddressField;
    @FXML
    private TextField FloorField;
    @FXML
    private TextField BellField;
    @FXML
    private TextArea ExtraField;
    @FXML
    private Button BackButton;
    @FXML
    private Button FinishButton;
    @FXML
    private RadioButton CashRadioButton;
    @FXML
    private RadioButton CardRadioButton;
  	@FXML
  	private ProgressIndicator progress;
    @FXML
    private TableView<Order> PinakasPliromis;
    @FXML
    private TableColumn<Order,String> ID;
    @FXML
    private TableColumn<Order,String> proion;
    @FXML
    private TableColumn<Order,String> posotita;
    @FXML
    private TableColumn<Order,String> timi;
    @FXML
    private Label totallbl;
 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
  		
  	    //Δημιουργία ToggleGroup
		ToggleGroup group = new ToggleGroup();
		//Προσθήκη όλων των RadioButtons στο ToggleGroup
		group.getToggles().addAll(CardRadioButton,CashRadioButton);
		
		//This closes the form
		BackButton.setOnAction(e -> {((Stage)this.AddressField.getScene().getWindow()).close();});
		//This continues to payment
		FinishButton.setOnAction(e -> {
			if (CardRadioButton.isSelected()) {
				// Show elli's form
				
				return;
			}
			// else 
			//Continue with the payment
			PinakasPliromis.setVisible(false);
			progress.setVisible(true);
			progress.setProgress(-10);
			Timeline fiveSecondsWonder = new Timeline(
	                 new KeyFrame(Duration.seconds(3),
	                		new EventHandler<ActionEvent>() {

	            @Override
	        	public void handle(ActionEvent event) {
					progress.setProgress(100);
					FinishButton.setText("Έξοδος");
					FinishButton.setOnAction(BackButton.getOnAction());
	    		}
	        }));
			fiveSecondsWonder.setCycleCount(1);
			fiveSecondsWonder.play();
		});
	
		ObservableList<Order> orderlist = FXCollections.observableArrayList();
		DatabaseHandler db = new DatabaseHandler();
		ArrayList<Order> orders = db.getCart();
		double total = 0;
		for(Order p : orders) {
			orderlist.add(p);
			total += Integer.parseInt(p.getposotita()) * Double.parseDouble(p.gettimi());
		}
		
		this.ID.setCellValueFactory(new PropertyValueFactory<Order,String>("ID"));
		this.proion.setCellValueFactory(new PropertyValueFactory<Order, String>("proion"));
		this.posotita.setCellValueFactory(new PropertyValueFactory<Order, String>("posotita"));
		this.timi.setCellValueFactory(new PropertyValueFactory<Order, String>("timi"));
		this.PinakasPliromis.setItems(orderlist);
		this.totallbl.setText(this.totallbl.getText() + " " + String.format("%.2f",total) + " €");
		
	}
}