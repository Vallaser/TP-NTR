package fr.uphf.RestClient.xml;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import fr.uphf.RestClient.model.ClientXml;

/**
 * 
 * GetClientXmlAsList est un main du client du serveur Tomcat (Bank)
 * Cette classe permet de recuperer la liste des clients et de
 * les afficher en utilisant les services REST XML
 * 
 * @author Quentin Colras
 */

public class GetClientXmlAsList {
 
   public static void main(String[] args) {
 
       ClientConfig clientConfig = new DefaultClientConfig();
 
       // Create Client based on Config
       Client client = Client.create(clientConfig);
 
       WebResource webResource = client.resource("http://localhost:8081/rest/clients");
 
       Builder builder = webResource.accept(MediaType.APPLICATION_XML) //
               .header("content-type", MediaType.APPLICATION_XML);
 
       ClientResponse response = builder.get(ClientResponse.class);
 
       // Status 200 is successful.
       if (response.getStatus() != 200) {
           System.out.println("Failed with HTTP Error code: " + response.getStatus());
         String error= response.getEntity(String.class);
         System.out.println("Error: "+error);
           return;
       }
 
       GenericType<List<ClientXml>> generic = new GenericType<List<ClientXml>>() {};
 
       List<ClientXml> list = response.getEntity(generic);
 
       System.out.println("Output from Server .... \n");
 
       for (ClientXml clientt : list) {
    	   System.out.println(" --- ");
    	   System.out.println(clientt.toString());
       }
 
   }
 
}