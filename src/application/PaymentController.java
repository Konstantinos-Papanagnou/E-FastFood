package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PaymentController {

    @FXML
    private ListView<?> listview;

    @FXML
    private TextField NameField;

    @FXML
    private TextField NumberField;

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
    private RadioButton cashRadioButton;

    @FXML
    private RadioButton CardRadioButton;

}