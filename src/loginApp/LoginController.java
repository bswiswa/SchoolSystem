package loginApp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import admin.AdminController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import students.StudentsController;

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
	@FXML
	private Button loginButton;
	@FXML
	private Label loginStatus;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		if (this.loginModel.isDatabaseConnected())
			this.dbStatus.setText("Connected to Database");
		else
			this.dbStatus.setText("Not Connected To Database");
		this.combobox.setItems(FXCollections.observableArrayList(option.values()));
	}

	@FXML
	private void Login(ActionEvent event) {
		try {
			if (this.loginModel.isLogin(this.username.getText(), this.password.getText(),
					((option)this.combobox.getValue()).toString())) {
				Stage stage = (Stage) this.loginButton.getScene().getWindow();
				stage.close();

				switch (this.combobox.getValue().toString()) {
				case "Admin":
					adminLogin();
					break;
				case "Student":
					studentLogin();
					break;
				}
			} else {
				this.loginStatus.setText("Wrong Credentials");
			}
		} catch (Exception localEx) {

		}
	}

	public void studentLogin() {
		try {
			Stage studentStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane pane = (Pane) loader.load(getClass().getResource("/students/student.fxml").openStream());

			StudentsController studentsController = (StudentsController) loader.getController();

			Scene scene = new Scene(pane);
			studentStage.setScene(scene);
			studentStage.setTitle("Student Dashboard");
			studentStage.setResizable(false);
			studentStage.show();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void adminLogin() {
		try {
			Stage adminStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane pane = (Pane) loader.load(getClass().getResource("/admin/admin.fxml").openStream());
			AdminController adminController = (AdminController) loader.getController();
			Scene scene = new Scene(pane);
			adminStage.setScene(scene);
			adminStage.setTitle("Admin Dashboard");
			adminStage.setResizable(false);
			adminStage.show();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
