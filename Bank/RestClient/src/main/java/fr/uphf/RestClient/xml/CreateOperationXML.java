package fr.uphf.RestClient.xml;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import fr.uphf.RestClient.model.CreateOperation;

/**
 * 
 * CreateOperationXML est un main du client du serveur Tomcat (Bank)
 * Cette classe permet de creer une operation pour un client 
 * en utilisant les services REST XML
 * 
 * @author Quentin Colras
 */

public class CreateOperationXML {
	
	public static void main(String[] args) {
		 
        Client client = Client.create();
 
        WebResource webResource = client.resource("http://localhost:8081/rest/clientsOp");
 
        // This object will be automatically converted into XML
        CreateOperation crOperation = new CreateOperation("-", 30.f, "27/03/2021 23:52:16", 
        		"Test JUnit", "colras.quentin@gmail.com");
        System.out.println(crOperation.toString());
 
        // Send XML and receive XML
        ClientResponse response = webResource.type("application/xml")//
                .accept("application/xml") //
                .post(ClientResponse.class, crOperation);
 
        if (response.getStatus() != 201) {
            System.out.println("Failed : HTTP error code : " + response.getStatus());
            return;
        }
        else
        {
        	System.out.println("Output from Server .... \n");
        	 
            String output = response.getEntity(String.class);
     
            System.out.println(output);
     
        }
        System.out.println("Fin du prog");
        
    }
 
}