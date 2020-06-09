package tn.esprit.jsf_app.services;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.net.ssl.*;
import javax.persistence.EntityManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.esprit.jsf_app.DTO.Employe;
import tn.esprit.jsf_app.interfaces.EmployeServiceRemote;

public class EmployeService implements EmployeServiceRemote {

	public String GlobalEndPoint = "https://localhost:44382/api/";
	TrustManager[] noopTrustManager = new TrustManager[]{
            new X509TrustManager() {

                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                }

                @Override
                public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                }
            }
        };
	public EmployeService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Employe> GetAll() {
		
    	List<Employe> lasp=new ArrayList<Employe>();
		try {
			  SSLContext sc = SSLContext.getInstance("ssl");
	            sc.init(null, noopTrustManager, null);
		Client client = ClientBuilder.newBuilder().sslContext(sc).build();
		WebTarget web = client.target(GlobalEndPoint+"Employees/Get"); 
		Response response = web.request().get();
    	
    	String result = response.readEntity(String.class); 
    	
    	//System.out.println(result);
    	JsonReader jsonReader = Json.createReader(new StringReader(result));
    	JsonArray object =  jsonReader.readArray();
    	
    	 
    	for (int i=0;i<object.size();i++)
    	{
    		Employe e = new Employe();
    		
       	 e.setEmployeId(object.getJsonObject(i).getInt("employeId")); 
    	 e.setFirstName(object.getJsonObject(i).getString("FirstName")); 
    	 e.setLastName(object.getJsonObject(i).getString("LastName")); 
    	 e.setEmail(object.getJsonObject(i).getString("email")); 
    	 e.setPhoneNumber(object.getJsonObject(i).getString("phoneNumber"));
    	 System.out.println(e.getEmployeId()+" "+e.getEmail()+" "+e.getFirstName()+" "+e.getLastName()+" "+e.getPhoneNumber());
    	 lasp.add(e);
    	}
		}catch(Exception ex) {
			System.out.println(ex);
		}
      return lasp;  
	}

	@Override
	public void Delete(int employeId) {
		try {
            SSLContext sc = SSLContext.getInstance("ssl");
            sc.init(null, noopTrustManager, null);
            
            
		Client client = ClientBuilder.newBuilder().sslContext(sc).build();
		String finalUrl=GlobalEndPoint+"Employees/Delete/"+employeId;
		WebTarget target = client.target(finalUrl);
		Response response = target
		               .request().delete();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void Create(Employe e) {
		
		try {
			  SSLContext sc = SSLContext.getInstance("ssl");
	            sc.init(null, noopTrustManager, null);
		Client client = ClientBuilder.newBuilder().sslContext(sc).build();
		WebTarget web = client.target(GlobalEndPoint+"Employees/Post"); 
		WebTarget hello =web.path("");
		
		Response response =hello.request().post(Entity.entity(e, MediaType.APPLICATION_JSON) );		
		
		String result=response.readEntity(String.class);
		System.out.println(result);

		response.close();
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
	}
	@Override
	public void Update(int id, Employe e) {
		Employe emp = new Employe();
		emp.setFirstName(e.getFirstName());;
		emp.setLastName(e.getLastName());;
		emp.setEmail(e.getEmail());;
		emp.setPhoneNumber(e.getPhoneNumber());
		 try {
	            SSLContext sc = SSLContext.getInstance("ssl");
	            sc.init(null, noopTrustManager, null);
	                        
			Client client = ClientBuilder.newBuilder().sslContext(sc).build();
  	
		WebTarget target = client.target(GlobalEndPoint+"/Employees/Put/"+id);
		Response response = target
		                 .request()
		                 .put(Entity.entity(e, MediaType.APPLICATION_JSON));
	
		 }catch(Exception ex) {
			 System.out.println(ex);
		 }
     }


   }
