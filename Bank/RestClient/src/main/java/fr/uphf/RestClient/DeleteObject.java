package fr.uphf.RestClient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * 
 * DeleteObject est un main du client du serveur Tomcat (Bank)
 * Cette classe permet de servir d'exemple pour montrer qu'il
 * est possible de supprimer un object en utilisant les service REST 
 * de l'application bancaire.
 * 
 * @author Quentin Colras
 */

public class DeleteObject {
	
	public static void main(String[] args) {
		 
        Client client = Client.create();
 
        WebResource webResource = client.resource("http://localhost:8081/rest/operations/10");
 
        ClientResponse response = webResource.type("application/json").delete(ClientResponse.class);
 
        if (response.getStatus() != 204) {
            System.out.println("Failed : HTTP error code : " + response.getStatus());
 
            String error = response.getEntity(String.class);
            System.out.println("Error: " + error);
            return;
        }
 
        System.out.println("Output from Server .... \n");
        System.out.println("L'objet a bien ete detruit");
 
    }
}
