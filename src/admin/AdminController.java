package admin;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dbUtil.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminController implements Initializable{
	
	@FXML
	private TextField id;
	@FXML
	private TextField firstName;
	@FXML
	private TextField lastName;
	@FXML
	private TextField email;
	@FXML
	private DatePicker dob;
	
	@FXML
	private TableView<StudentData> studentTable; 
	
	@FXML
	private TableColumn<StudentData, String> idColumn;
	@FXML
	private TableColumn<StudentData, String> firstNameColumn;
	@FXML
	private TableColumn<StudentData, String> lastNameColumn;
	@FXML
	private TableColumn<StudentData, String> emailColumn;
	@FXML
	private TableColumn<StudentData, String> dobColumn;
	
	private String sql = "select * from students";
	
	//need connection
	private dbConnection dc;
	private ObservableList<StudentData> data;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		this.dc = new dbConnection();
		
	}
	
	@FXML
	private void loadStudentData(ActionEvent event) {
		try {
			Connection conn = dbConnection.getConnection();
			this.data = FXCollections.observableArrayList();
			
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				this.data.add(new StudentData(rs.getString(1), rs.getString(2), 
						rs.getString(3), rs.getString(4), rs.getString(5)));
			}
			
		}catch(SQLException ex) {
			System.err.println("Error "+ ex);
		}
		
		this.idColumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("id"));
		this.firstNameColumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("firstName"));
		this.lastNameColumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("lastName"));
		this.emailColumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("email"));
		this.dobColumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("dob"));
		
		this.studentTable.setItems(null);
		this.studentTable.setItems(data);
	}
	
	@FXML
	private void addStudent(ActionEvent event) {
		String sql = "insert into students (id, fname, lname, email, DOB) values (?, ?, ?, ?, ?)";
		try {
			Connection conn = dbConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, this.id.getText());
			ps.setString(2, this.firstName.getText());
			ps.setString(3, this.lastName.getText());
			ps.setString(4, this.email.getText());
			ps.setString(5, this.dob.getEditor().getText()); //good way of handling DatePicker values
			ps.executeUpdate(); //note the use of executeUpdate() and not executeQuery()
			
			conn.close();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	@FXML
	private void clearFields(ActionEvent event) {
		this.id.setText("");
		this.firstName.setText("");
		this.lastName.setText("");
		this.email.setText("");
		this.dob.setValue(null);
	}
	
}
