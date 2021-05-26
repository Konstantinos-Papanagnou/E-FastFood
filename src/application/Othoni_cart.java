package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import logic.DatabaseHandler;
import logic.Order;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class Othoni_cart implements Initializable{
	@FXML Button BackButton; //θα γυρνάει στου κώστα na valw auto pou esteile sto discord kai tis eikones na dw mono autes pou thelw
	@FXML Button OrderCompletionBtn;
	@FXML
	private TableView<Order> FoodTables;	
	@FXML
	private TableColumn<Order, String> ID;	
	@FXML
	private TableColumn<Order, String> posotita;
	@FXML
	private TableColumn<Order, String> proion;	
	@FXML
	private TableColumn<Order, String> timi;
	DatabaseHandler db = new DatabaseHandler();
	
	@FXML
	private void removeClick(MouseEvent e) {
		for(Order order : FoodTables.getSelectionModel().getSelectedItems()) {
			FoodTables.getItems().remove(order);
			db.deleteFromCart(Integer.parseInt(order.getID()));
		}
	}
	
	public void initialize(URL location, ResourceBundle resources) { 
		FoodTables.getSelectionModel().setSelectionMode(
			    SelectionMode.MULTIPLE
			);
		BackButton.setDisable(false);
		BackButton.setOnAction(new EventHandler<ActionEvent>() {
	  
			@Override public void handle(ActionEvent event) { 
			((Stage)BackButton.getScene().getWindow()).close();
			}
		});
		  
		OrderCompletionBtn.setDisable(false);
		OrderCompletionBtn.setOnAction(new EventHandler<ActionEvent>() {
	  
			@Override public void handle(ActionEvent event) { 
				try {
					Stage window = new Stage();
					Parent root = FXMLLoader.load(getClass().getResource("Payment.fxml"));
					window.getIcons().add(new Image("file:./src/img/logo black.png"));
					window.setTitle("The Eater's Club");
					Scene scene = new Scene(root);
					
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					window.setResizable(false);
					window.setScene(scene);
					Main.OpenedStage = window;
					window.showAndWait();
				} catch(Exception e1) {
					e1.printStackTrace();
					System.out.println(e1.getMessage());
				}
			}
		}); 
		
		ID.setCellValueFactory(new PropertyValueFactory<Order, String>("ID"));
		posotita.setCellValueFactory(new PropertyValueFactory<Order, String>("posotita"));
		proion.setCellValueFactory(new PropertyValueFactory<Order, String>("proion"));
		timi.setCellValueFactory(new PropertyValueFactory<Order, String>("timi"));
		
		ObservableList<Order> oblist = FXCollections.observableArrayList();
		
		for(Order order : db.getCart()) {
			oblist.add(order);
		}
		
		
		
		FoodTables.setItems(oblist);
		
	}
	  
	 
}//a valw setCellValuefactory?


