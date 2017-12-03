package admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StudentData {
	private StringProperty id;
	private StringProperty firstName;
	private StringProperty lastName;
	private StringProperty email;
	private StringProperty dob;
	
	public StudentData(String id, String firstName, String lastName, String email, String dob) {
		this.id = new SimpleStringProperty(id);
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.email = new SimpleStringProperty(email);
		this.dob = new SimpleStringProperty(dob);
	}

	public StringProperty getId() {
		return id;
	}

	public void setId(StringProperty id) {
		this.id = id;
	}

	public StringProperty getFirstName() {
		return firstName;
	}

	public void setFirstName(StringProperty firstName) {
		this.firstName = firstName;
	}

	public StringProperty getLastName() {
		return lastName;
	}

	public void setLastName(StringProperty lastName) {
		this.lastName = lastName;
	}

	public StringProperty getEmail() {
		return email;
	}

	public void setEmail(StringProperty email) {
		this.email = email;
	}

	public StringProperty getDOB() {
		return dob;
	}

	public void setDOB(StringProperty DOB) {
		dob = DOB;
	}
	
	/* !!! The following property methods are used internally to keep displaying the most up to
	date values of these properties. MAKE SURE that their names logically match your field names 
	for example if you have a field private String dob, then there should be a function called
	public StringProperty dobProperty() NOT public StringProperty DOBProperty()
	*/
	public StringProperty idProperty() {
		return this.id;
	}
	
	public StringProperty firstNameProperty() {
		return this.firstName;
	}
	
	public StringProperty lastNameProperty() {
		return this.lastName;
	}
	
	public StringProperty emailProperty() {
		return this.email;
	}
	
	public StringProperty dobProperty(){
		return this.dob;
	}
}
