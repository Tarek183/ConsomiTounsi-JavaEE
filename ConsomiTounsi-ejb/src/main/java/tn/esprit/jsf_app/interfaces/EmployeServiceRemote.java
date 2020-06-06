package tn.esprit.jsf_app.interfaces;

import java.util.List;

import tn.esprit.jsf_app.DTO.Employe;

public interface EmployeServiceRemote {
	List<Employe> GetAll();
	public void Delete(Employe EmployeId);
	public void Create(Employe e);
	public void Update(int id,Employe e);
}
