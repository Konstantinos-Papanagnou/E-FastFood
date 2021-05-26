package application;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.util.Duration;
import logic.DatabaseHandler;
import javafx.scene.control.ProgressIndicator;

public class cardpaymentController implements Initializable{

	@FXML
	private RadioButton visarb;
	@FXML
	private RadioButton paypalrb;
	@FXML
	private RadioButton mastercardrb;
    @FXML
    private TextField namefield;

    @FXML
    private TextField cardnumberfield;

    @FXML
    private TextField securitycodefield;

    @FXML
    private Label totalLbl;

    @FXML
    private Button Paybtn;

    @FXML
    private DatePicker expirationdatepicker;
    
    @FXML
    private ProgressIndicator progressBar;
    
    @FXML
    private Label expdateLbl;

    DatabaseHandler db = new DatabaseHandler();
    
    @FXML
    void PayClick(ActionEvent event) {
    	if(!checkName(namefield.getText())) {
    		showDialog("Λανθασμενο Ονοματεπωνυμο","Λανθασμενη Εισαγωγη Στοιχείων");
    		return;
    	}
    	if(!checkCardNumber(cardnumberfield.getText())) {
    		showDialog("Λανθασμενος Αριθμός κάρτας ","Λανθασμενη Εισαγωγη Στοιχείων");
    		return;
    	
    	}
    	if(!check3digitCode(securitycodefield.getText())) {
    		showDialog("Λανθασμενος τριψήφιος κωδικός","Λανθασμενη Εισαγωγη Στοιχείων");
    		return;
    	}
      	// Add progressBar bar
    	hideObjects();
    	
    	progressBar.setVisible(true);
    	progressBar.setProgress(-10);
		Timeline timer = new Timeline(
	            new KeyFrame(Duration.seconds(3),
	               new EventHandler<ActionEvent>() {

	            @Override
	        	public void handle(ActionEvent event) {
	            	progressBar.setProgress(100);
		
	    		}
	        }));
		timer.setCycleCount(1);
		timer.play();
    		
    	db.clearCart();
    	
    }
    
    private void hideObjects() {
    	Paybtn.setVisible(false);
    	totalLbl.setVisible(false);
    	visarb.setVisible(false);
    	paypalrb.setVisible(false);
    	mastercardrb.setVisible(false);
    	expirationdatepicker.setVisible(false);
    	namefield.setVisible(false);
    	cardnumberfield.setVisible(false);
    	securitycodefield.setVisible(false);
    	expdateLbl.setVisible(false);
    }

    private boolean checkName(String name) {
    	if(name.length() > 0) {
    		return true;
    	}
    	return false;
    }
    
    private boolean checkCardNumber(String cardNumber) {
    	if(cardNumber.length() == 16) {
    		
    		return true;
    		
    	}
    	return false;
    }
    
    private boolean check3digitCode(String code) {
    	if( code.length() == 3)
    	{
    		return true;
    	
    	}
    	else {
    		return false;
    	}
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		totalLbl.setText(totalLbl.getText() + "6.90€");
		expirationdatepicker.setValue(LocalDate.now());
		ToggleGroup group = new ToggleGroup();
		group.getToggles().addAll(visarb, paypalrb,mastercardrb);
		visarb.setSelected(true);
		//progressBar.setVisible(false);
	}
	
	private void showDialog(String Message, String Title) {
		Dialog<String> dialog = new Dialog<String>();
		dialog.setTitle(Title);
	    ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
	    dialog.setContentText(Message);
	    
	    dialog.setWidth(500);
	    dialog.getDialogPane().getButtonTypes().add(type);
	    dialog.showAndWait();
	}
}
