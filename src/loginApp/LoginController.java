package loginApp;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {
	LoginModel loginModel = new LoginModel();
	
	@FXML
	private Label dbStatus;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private ComboBox<option> combobox;
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		if(this.loginModel.isDatabaseConnected())
			this.dbStatus.setText("Connected to Database");
		else
			this.dbStatus.setText("Not Connected To Database");
		this.combobox.setItems(FXCollections.observableArrayList(option.values()));
	}

}
