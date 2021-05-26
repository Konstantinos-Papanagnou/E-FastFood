package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.util.Duration;
import logic.Order;
import logic.Plate;
import javafx.event.*;

public class PaymentController implements Initializable{

   
	@FXML
    private ListView<String> listview;
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
    private TableView<Order> pinakaspliromis;
    @FXML
    private TableColumn<Order,String> proion;
    @FXML
    private TableColumn<Order,String> posotita;
    @FXML
    private TableColumn<Order,String> timi;

 
  	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
  		
  	    //Δημιουργία ToggleGroup
		ToggleGroup group = new ToggleGroup();
		//Προσθήκη όλων των RadioButtons στο ToggleGroup
		group.getToggles().addAll(CardRadioButton,CashRadioButton);
		
		//This closes the form
		BackButton.setOnAction(e -> {Main.OpenedStage.close();});
		//This continues to payment
		FinishButton.setOnAction(e -> {
			if (CardRadioButton.isSelected()) {
				// Show elli's form
				
			}
			// else 
			//Continue with the payment
			listview.setVisible(false);
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
	
		
		
		
		
		
	}
}