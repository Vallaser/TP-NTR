package fr.uphf.RestServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.uphf.RestServer.model.Client;
import fr.uphf.RestServer.model.Clients;
import fr.uphf.RestServer.model.CreateOperation;
import fr.uphf.RestServer.model.Operation;
import fr.uphf.RestServer.service.ItfClientService;
import fr.uphf.RestServer.service.ItfOperationService;

/**
 * ClientController : Class qui met en libre acces selon des chemins d'acces, les methodes
 * du service ClientService pour le serveur Tomcat (Bank)
 * @author Quentin Colras
 * @parma clientService Service des clients
 * @param operationService Service des operations
 *
 */
@RestController
@RequestMapping("/rest")
public class ClientController {
	
	@Autowired
	private ItfClientService clientService;//Service which will do all data retrieval/manipulation work
	@Autowired
	private ItfOperationService operationService;

	/** findClients Retourne la liste des clients */
	@GetMapping(value="/clients", produces= {MediaType.APPLICATION_JSON_VALUE,
    		MediaType.APPLICATION_XML_VALUE})
    public Clients findClients() {
        return clientService.findAll();
    }
	
	/** findClientsByAddress Retourne le client ayant l'idAdresse */
	@GetMapping(value="/clientsAdr/{idAddress}", produces= {MediaType.APPLICATION_JSON_VALUE,
    		MediaType.APPLICATION_XML_VALUE})
    public Clients findClientsByAddress(@PathVariable Long idAddress) {
        return clientService.findAllByAddressId(idAddress);
    }
	
	/** findClientByEmail Retourne le client ayant l'email */
	@GetMapping(value="/clientsEmail/{email}", produces= {MediaType.APPLICATION_JSON_VALUE,
    		MediaType.APPLICATION_XML_VALUE})
    public Client findClientByEmail(@PathVariable String email) {
        return clientService.findByEmail(email);
	}
    
	/** findClient Retourne le client ayant le clientId */
    @GetMapping(value="/clients/{clientId}", produces= {MediaType.APPLICATION_JSON_VALUE,
    		MediaType.APPLICATION_XML_VALUE})
    public Client findClient(@PathVariable Long clientId) {
    	//Attention car si id n'existe pas ça renvoie quand meme un client avec tous les attributs à null
        return clientService.findById(clientId);
    }
    
    /** findBalanceByClientId Retourne le solde du client ayant le clientId */
    @GetMapping(value="/clients/solde/{clientId}", produces= {MediaType.APPLICATION_JSON_VALUE,
    		MediaType.APPLICATION_XML_VALUE})
    public Float findBalanceByClientId(@PathVariable Long clientId) {
    	//Attention car si id n'existe pas ça renvoie quand meme un client avec tous les attributs à null
        return clientService.findById(clientId).getBalance();
    }
    
    /** deleteClient Supprime le client ayant le clientId */
    @DeleteMapping(value="/clients/{clientId}", produces= {MediaType.APPLICATION_JSON_VALUE,
    		MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> deleteClient(@PathVariable Long clientId)
	{
    	Client client = clientService.findById(clientId);
    	if (client == null)
    		return new ResponseEntity<>("Unable to delete. Client with id " + clientId + " not found.",
					HttpStatus.NOT_FOUND);
    	clientService.deleteById(clientId);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
    
    /** createOperationForClient Ajout une nouvelle operation pour un client */
    @PostMapping(value="/clientsOp", produces= {MediaType.APPLICATION_JSON_VALUE,
    		MediaType.APPLICATION_XML_VALUE}, consumes= {MediaType.APPLICATION_JSON_VALUE,
    		MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> createOperationForClient(@RequestBody CreateOperation operation) {
    	Operation currentOperation = new Operation(operation);
    	Client clientOperation = clientService.findByEmail(operation.getEmailClient());
    	if (clientOperation.addOperation(currentOperation) == false) {
			return new ResponseEntity<>("Unable to create this operation " + currentOperation.getValueOp() + 
					" for a client with id " + clientOperation.getId() + " balance go negative.",HttpStatus.NO_CONTENT);
		}
    	operationService.save(currentOperation);
		return new ResponseEntity<Operation>(currentOperation, HttpStatus.CREATED);
	}
    
    /** createClient Ajoute un nouveau client*/
    @PostMapping(value="/clients", consumes= {MediaType.APPLICATION_JSON_VALUE,
    		MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> createClient(@RequestBody Client client) {
    	Client currentClient = clientService.findById(client.getId());
		if (currentClient != null) {
			return new ResponseEntity<>("Unable to create. A client with id " + 
					client.getId() + " already exist.",HttpStatus.CONFLICT);
		}
		clientService.save(client);
		return new ResponseEntity<Client>(client, HttpStatus.CREATED);
	}
    
    /** updateClient Modifie le client*/
    @PutMapping(value = "/clients", consumes= {MediaType.APPLICATION_JSON_VALUE,
    		MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> updateClient(@RequestBody Client client) {
    	Client currentClient = clientService.findById(client.getId());

		if (currentClient == null) {
			return new ResponseEntity<>("Unable to update. Client with id " + client.getId() + " not found.",
					HttpStatus.NOT_FOUND);
		}
		clientService.save(client);
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}

}
