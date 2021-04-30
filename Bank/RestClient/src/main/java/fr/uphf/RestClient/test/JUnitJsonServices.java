package fr.uphf.RestClient.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import fr.uphf.RestClient.model.ClientJson;

/**
 * 
 * JUnitJsonServices : Classe du client du serveur Tomcat (Bank) 
 * utilisée pour tester les services REST JSON
 * 
 * @author Quentin Colras
 */
public class JUnitJsonServices {
	
	@Test
	public void setup() {
		
		ClientConfig clientConfig = new DefaultClientConfig();
		  
		Client client = Client.create(clientConfig);
	 
		WebResource webResource = client.resource("http://localhost:8081/rest/clients");
	 
		Builder builder = webResource.accept(MediaType.APPLICATION_JSON) //
				.header("content-type", MediaType.APPLICATION_JSON);
	 
		ClientResponse response = builder.get(ClientResponse.class);
	 
		// Status 200 is successful.
		if (response.getStatus() != 200) {
	          System.out.println("Failed with HTTP Error code: " + response.getStatus());
	          String error= response.getEntity(String.class);
	          System.out.println("Error: "+error);
	          return;
		}
	      
		GenericType<List<ClientJson>> generic = new GenericType<List<ClientJson>>() {};
	 
		List<ClientJson> list = response.getEntity(generic);
		
		assertEquals(list.size(), 3);
		assertEquals(list.get(0).getOperations().size(), 6);
		assertEquals(list.get(2).getOperations().get(0).getType(), "Purchase Overwatch");
		float balance = list.get(1).getBalance();
		assertTrue(balance < 754);
		assertTrue(balance > 752);
		assertFalse(list.get(0).getFirstName().equals("Quentin"));
		assertEquals(list.get(0).getOperations().get(0).getDateOp(), "09/12/2016 22:52:16");
	}

}
