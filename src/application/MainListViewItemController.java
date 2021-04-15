package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import logic.Plate;

public class MainListViewItemController extends ListCell<Plate> implements Initializable{

    @FXML
    private ImageView PlateImageView;

    @FXML
    private Label PlateNameLbl;

    @FXML
    private Label PlatePriceLbl;

    @FXML
    private Label PlateDescriptionLbl;

	public MainListViewItemController(Plate plate) {
		// TODO Auto-generated constructor stub

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
    	//PlateNameLbl.setText(plate.getPlateName());
    	//PlateDescriptionLbl.setText(plate.Description());
    	//PlatePriceLbl.setText(Double.toString(plate.getPrice()));
    	//PlateImageView.setImage(new Image(plate.getImagePath()));
		PlateNameLbl.setText("Testing");
	}

}
