package fr.uphf.RestClient.json;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import fr.uphf.RestClient.model.OperationJson;

/**
 * 
 * GetOperationJsonAsList est un main du client du serveur Tomcat (Bank)
 * Cette classe permet de recuperer la liste des operations et de
 * les afficher en utilisant les services REST JSON
 * 
 * @author Quentin Colras
 */

public class GetOperationJsonAsList {
 
  public static void main(String[] args) {
 
	  ClientConfig clientConfig = new DefaultClientConfig();
	  
      // Create Client based on Config
      Client client = Client.create(clientConfig);
 
      WebResource webResource = client.resource("http://localhost:8081/rest/operations");
 
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
 
      GenericType<List<OperationJson>> generic = new GenericType<List<OperationJson>>() {};
 
      List<OperationJson> list = response.getEntity(generic);
 
      System.out.println("Output from Server .... \n");
 
      for (OperationJson operation : list) {
          System.out.println(" --- ");
	      System.out.println(operation.toString());
      }
 
  }
 
}
