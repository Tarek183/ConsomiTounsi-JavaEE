package tn.esprit.jsf_app.DTO;

public class Employe {
	
	public int EmployeId;
	public String FirstName; 
	public String LastName; 
	public String email; 
	public String Password; 
	public String phoneNumber;
	private static final long serialVersionUID = 1L;
	
	public Employe() {

	}

	public Employe(int employeId, String firstName, String lastName, String email, String password,
			String phoneNumber) {
		super();
		EmployeId = employeId;
		FirstName = firstName;
		LastName = lastName;
		this.email = email;
		Password = password;
		this.phoneNumber = phoneNumber;
	}

	public int getEmployeId() {
		return EmployeId;
	}

	public void setEmployeId(int employeId) {
		EmployeId = employeId;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Employe [EmployeId=" + EmployeId + ", FirstName=" + FirstName + ", LastName=" + LastName + ", email="
				+ email + ", Password=" + Password + ", phoneNumber=" + phoneNumber + "]";
	}
	
}
