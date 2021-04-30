package fr.uphf.RestClient.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import javax.ws.rs.core.MediaType;

import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import fr.uphf.RestClient.model.ClientXml;
import fr.uphf.RestClient.model.CreateOperation;

/**
 * 
 * JUnitXmlServices : Classe du client du serveur Tomcat (Bank) 
 * utilisée pour tester les services REST XML
 * 
 * @author Quentin Colras
 */
public class JUnitXmlServices {
	
	@Test
	public void setup() {
		
		ClientConfig clientConfig = new DefaultClientConfig();
		  
		Client client = Client.create(clientConfig);
	 
		WebResource webResource = client.resource("http://localhost:8081/rest/clients/3");
	 
		Builder builder = webResource.accept(MediaType.APPLICATION_XML) //
				.header("content-type", MediaType.APPLICATION_XML);
	 
		ClientResponse response = builder.get(ClientResponse.class);
		
		ClientXml client1 = (ClientXml) response.getEntity(ClientXml.class);
	      
		int balanceBefore = Math.round(client1.getBalance());
		assertEquals(balanceBefore, 157);
		
		webResource = client.resource("http://localhost:8081/rest/clientsOp");
		 
        // This object will be automatically converted into XML
        CreateOperation crOperation = new CreateOperation("-", 10000.f, "27/03/2021 23:52:16", 
        		"Test JUnit", "colras.quentin@gmail.com");
 
        // Send XML and receive XML
        response = webResource.type("application/xml").accept("application/xml")
        		.post(ClientResponse.class, crOperation);
        
        assertFalse(response.getStatus() != 204);
        
        crOperation = new CreateOperation("-", 30.f, "27/03/2021 23:52:16", 
        		"Test JUnit", "colras.quentin@gmail.com");
        
        webResource.type("application/xml").accept("application/xml")
        		.post(ClientResponse.class, crOperation);
        
        crOperation = new CreateOperation("+", 50.f, "27/03/2021 23:52:19", 
        		"Test JUnit2", "colras.quentin@gmail.com");
        
        webResource.type("application/xml").accept("application/xml")
			.post(ClientResponse.class, crOperation);
        
        webResource = client.resource("http://localhost:8081/rest/clients/3");
        
        response = webResource.accept(MediaType.APPLICATION_XML).
        		header("content-type", MediaType.APPLICATION_XML).get(ClientResponse.class);
        
        ClientXml client2 = (ClientXml) response.getEntity(ClientXml.class);
        
        assertFalse(balanceBefore == client2.getBalance());
        assertEquals(Math.round(client2.getBalance()), 177);

	}

}
