package fr.uphf.service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import fr.uphf.model.CreateOperation;

/**
 * 
 * OperationService : Classe qui implemente l'interface OperationServiceItf
 * Sert a creer le web service SOAP pour le debit ou le remboursement du compte bancaire
 * d'un client
 * 
 * @author Quentin Colras
 */
public class OperationService implements OperationServiceItf{

	/**
	 * Fonction du service SOAP de la passerelle qui fait appels aux services REST XML 
	 * de la banque pour le débit ou le remboursement d'un compte bancaire d'un client
	 * @param emailClient Email unique du client servant a le retrouver dans la base de donnees
	 * @param op L'operateur + pour un remboursement et - pour un debit
	 * @param dateOp Date a laquelle l'operation est cree
	 * @param type Description de l'operation, exemple : Purchase ou Refund Game
	 * @param valueOp Valeur de l'operation
	 * @return Success si c'est l'operation a bien etait creee, Error sinon
	 */
	@Override
	public String postOperationForClient(String  emailClient, String op, String dateOp, String type, Float valueOp) {
		Client client = Client.create();
		 
		//Creation de la ressource web
        WebResource webResource = client.resource("http://localhost:8081/rest/clientsOp");
        //Creation de l'operation a partir des parametres de la fonction
        CreateOperation crOperation = new CreateOperation(op, valueOp, dateOp, type, emailClient);
        
        //Execute une requete POST HTTP et obtiens une reponse
        ClientResponse response = webResource.type("application/xml")
                .accept("application/xml") //
                .post(ClientResponse.class, crOperation);
 
        if (response.getStatus() != 201) { //Si la reponse n'est pas negative
            System.out.println("Failed : HTTP error code : " + response.getStatus());
            return "Error"; 
        }
        return "Success"; //Alors l'operation a bien etait creee
	}
	
}
