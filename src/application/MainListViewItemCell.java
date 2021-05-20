package application;


import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import logic.Plate;

public class MainListViewItemCell extends ListCell<Plate>{
	private HBox root = new HBox();
    private ImageView PlateImageView = new ImageView();
	private Label PlateNameLbl = new Label();
	private Label PlatePriceLbl = new Label(); 
	private Label PlateDescriptionLbl = new Label();
    
    public MainListViewItemCell() {
    	beautifyControls();
    	configureLayout();
    }
   
    private void configureLayout() {    
    	root.getChildren().addAll(PlateImageView, createMasterContainer());
    }
    
    private VBox createMasterContainer() {
    	VBox container = new VBox();
    	container.setLayoutX(4);
    	container.setLayoutY(266);
    	container.setPrefHeight(64);
    	container.setPrefWidth(800);
    	container.setPadding(new Insets(0,20,0,20));
    	container.getChildren().addAll(createSlaveContainer(), PlateDescriptionLbl);
    	return container;
    }
    
    private Region makeSpace() {
    	Region space = new Region();
    	space.setPrefHeight(35);
    	space.setPrefWidth(150);
    	return space;
    }
    
    private ImageView makeCartView() {
    	ImageView cart = new ImageView();
    	cart.setFitHeight(20);
    	cart.setFitWidth(21);
    	cart.setPickOnBounds(true);
    	cart.setPreserveRatio(true);
    	File file = new File("./src/img/cartIcon.png");
    	cart.setImage(new Image(file.toURI().toString()));
    	HBox.setMargin(cart, new Insets(2,20,0,0)); //top - right - down - left
    	return cart;
    }
    
    private HBox createSlaveContainer() {
    	HBox controlContainer = new HBox();
    	controlContainer.setPrefHeight(35);
    	controlContainer.setPrefWidth(800);
    	controlContainer.setPadding(new Insets(30,0,0,0));
    	controlContainer.getChildren().addAll(PlateNameLbl, makeSpace(), makeCartView(), PlatePriceLbl);
    	return controlContainer;
    }
    
    private void beautifyControls() {
    	beautifyRoot();
    	beautifyImageView();
    	beautifyPrice();
    	beautifyDescription();
    	beautifyName();
    }
    
    private void beautifyRoot() {
    	//beautify root
    	root.setPrefHeight(250);
    	root.setPadding(new Insets(10,0,10,0));
    	root.setStyle("-fx-background-color: #505050");
    	root.setPrefWidth(800);
    }
    
    private void beautifyImageView() {
    	//beautify PlateImageView
    	PlateImageView.setFitHeight(255);
    	PlateImageView.setFitWidth(366);
    	PlateImageView.setPickOnBounds(true);
    	PlateImageView.setPreserveRatio(true);
    }
    
    private void beautifyPrice() {
    	//Beautify Price label
    	PlatePriceLbl.setAlignment(Pos.CENTER_RIGHT);
    	PlatePriceLbl.setContentDisplay(ContentDisplay.CENTER);
    	PlatePriceLbl.setFont(Font.font("Verdana", 20));
    	PlatePriceLbl.setTextFill(Paint.valueOf("#ffffff"));
    }
    
    private void beautifyDescription() {
    	//Beautify Description Label
    	VBox.setMargin(PlateDescriptionLbl, new Insets(50,0,0,0));
    	PlateDescriptionLbl.setTextAlignment(TextAlignment.CENTER);
    	PlateDescriptionLbl.setTextFill(Paint.valueOf("#b3b3b3"));
    }
    
    private void beautifyName() {
    	//Beautify Name Label
    	PlateNameLbl.setFont(Font.font("Verdana", 20));
    	PlateNameLbl.setTextFill(Paint.valueOf("#ffffff"));
    }
    
    
    @Override
    public void updateItem(Plate plate, boolean empty) {
    	super.updateItem(plate, empty);
    	
    	if(empty) {
    		clearContext();
    	}
    	else {
    		addContext(plate);
    	}

    }
    
	
	private void clearContext() {
		setText(null);
		setGraphic(null);
	}
	
	
	private void addContext(Plate plate)
	{
		setText(null);
		File file = new File(plate.getImagePath());
		PlateImageView.setImage(new Image(file.toURI().toString()));
		PlateNameLbl.setText(plate.getPlateName());
		PlatePriceLbl.setText(String.format("%.2f",plate.getPrice()) + "€");
		PlateDescriptionLbl.setText(plate.getDescription());
		setGraphic(root);
	}

}
