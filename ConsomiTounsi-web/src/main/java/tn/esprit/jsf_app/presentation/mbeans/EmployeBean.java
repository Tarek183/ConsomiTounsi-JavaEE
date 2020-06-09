package tn.esprit.jsf_app.presentation.mbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.jsf_app.DTO.Employe;
import tn.esprit.jsf_app.services.EmployeService;

@ManagedBean(name="employeBean",eager=true)
@SessionScoped
public class EmployeBean {
	
	public int EmployeId;
	public String FirstName; 
	public String LastName; 
	public String email; 
	public String Password; 
	public String phoneNumber;
	private List<Employe> Employe;
	private static final long serialVersionUID = 1L;
    
	EmployeService ES;
	public EmployeBean() {
	  ES = new EmployeService();	
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

	public List<Employe> getEmploye() {
		return Employe;
	}

	public void setEmploye(List<Employe> employe) {
		Employe = employe;
	}

	public EmployeService getES() {
		return ES;
	}

	public void setES(EmployeService eS) {
		ES = eS;
	}
	
	public String addEmploye() {
		ES.Create(new Employe(0,this.FirstName,this.LastName,this.email,"",this.phoneNumber));
		
		return "/ConsomiTounsi-web/Views/ListEmployee.jsf";
	}
	
	
	public List<Employe> getAllEmployees(){	
		return ES.GetAll();
	}

	public String deleteEmploye(String employeId) {
		ES.Delete(Integer.parseInt(employeId));
		return "ListEmployee.jsf";
	}
	 //  public String moveToAddEmploye() {
    //		      return "CreateEmployee.jsf";
	//	   }
	
}
