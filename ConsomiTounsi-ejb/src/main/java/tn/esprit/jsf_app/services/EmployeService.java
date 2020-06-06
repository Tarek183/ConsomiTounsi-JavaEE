package tn.esprit.jsf_app.services;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.persistence.EntityManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import tn.esprit.jsf_app.DTO.Employe;
import tn.esprit.jsf_app.interfaces.EmployeServiceRemote;

public class EmployeService implements EmployeServiceRemote {

	public String GlobalEndPoint = "empresentation-dev.eu-west-1.elasticbeanstalk.com";

	public EmployeService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Employe> GetAll() {
		EntityManager em ;
		
		List<Employe>  lasp = new ArrayList<Employe>();
		Client client = ClientBuilder.newClient();
    	
    	WebTarget web = client.target("http://"+GlobalEndPoint+"/api/EventWebApi/"); 
    	
    	Response response = web.request().get();
    	
    	String result = response.readEntity(String.class); 
    	
    	//System.out.println(result);
    	JsonReader jsonReader = Json.createReader(new StringReader(result));
    	JsonArray object =  jsonReader.readArray();
    	
    	 
    	for (int i=0;i<object.size();i++)
    	{
    	 
    		Employe e = new Employe();
    	 //String dateString;
       	 e.setEmployeId(object.getJsonObject(i).getInt("EmployeId")); 
    	 e.setFirstName(object.getJsonObject(i).getString("FirstName")); 
    	 e.setLastName(object.getJsonObject(i).getString("LastName")); 
    	 e.setEmail(object.getJsonObject(i).getString("Email")); 
    	 e.setPhoneNumber(object.getJsonObject(i).getString("phoneNumber"));
    	 e.setPassword(object.getJsonObject(i).getString("Password"));
    	
    	 lasp.add(e);
    	}
      return lasp;  
	}

	@Override
	public void Delete(Employe emp) {

		Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://"+GlobalEndPoint+"/api/EventWebApi?id="+emp.getEmployeId()); 
		WebTarget hello = target.path("");     	
    	Response res=(Response) hello.request().delete();
	}

	@Override
	public void Create(Employe e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(int id, Employe e) {
		// TODO Auto-generated method stub
		
	}

}
