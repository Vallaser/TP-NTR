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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.uphf.RestServer.model.Operation;
import fr.uphf.RestServer.model.Operations;
import fr.uphf.RestServer.service.ItfOperationService;

/**
 * OperationController : Class qui met en libre acces selon des chemins d'acces, les methodes
 * du service OperationService pour le serveur Tomcat (Bank)
 * @author Quentin Colras
 * @param operationService Service des operations
 *
 */
@RestController
@RequestMapping("/rest")
public class OperationController {
	
	@Autowired
	private ItfOperationService operationService;
	
	/** findOperations Retourne la liste des operations */
	@GetMapping(value="/operations", produces= {MediaType.APPLICATION_JSON_VALUE,
    		MediaType.APPLICATION_XML_VALUE})
    public Operations findOperations() {
        return operationService.findAll();
    }

	/** findOperation Retourne l'operation ayant l'operationId */
    @GetMapping(value="/operations/{operationId}", produces= {MediaType.APPLICATION_JSON_VALUE,
    		MediaType.APPLICATION_XML_VALUE})
    public Operation findOperation(@PathVariable Long operationId) {
        return operationService.findById(operationId);
    }
    
    /** getOperationByType Retourne la liste des operations ayant un type contenant le parametre */
    @GetMapping(value="/operation", produces= {MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> getOperationByType(@RequestParam(value="type", required = true) String type) {
    	Operations operations = operationService.findAllByTypeContaining(type);
    	if (operations.getOperations().isEmpty())
    		return new ResponseEntity<>("Unable to find. Operation with type containing " + type ,HttpStatus.NO_CONTENT);
		return new ResponseEntity<Operations>(operations, HttpStatus.OK);
	}
    
    /** deleteOperation Supprime l'operation ayant l'operationId 
     * Warning Fonction inutilisable dans le contexte de l'application bancaire
     * */
    @DeleteMapping(value="/operations/{operationId}", produces= {MediaType.APPLICATION_JSON_VALUE,
    		MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> deleteOperation(@PathVariable Long operationId)
	{
    	Operation operation = operationService.findById(operationId);
    	if (operation == null)
    		return new ResponseEntity<>("Unable to delete. Operation with id " + operationId + " not found.",
					HttpStatus.NOT_FOUND);
    	operationService.deleteById(operationId);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
    
    /** createOperation Ajoute une nouvelle operation */
    @PostMapping(value="/operations", consumes= {MediaType.APPLICATION_JSON_VALUE,
    		MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> createOperation(@RequestBody Operation operation) {
    	Operation currentOperation = operationService.findById(operation.getId());
		if (currentOperation != null) {
			return new ResponseEntity<>("Unable to create. Operation with id " + 
					operation.getId() + " already exist.",HttpStatus.CONFLICT);
		}
		operationService.save(operation);
		return new ResponseEntity<Operation>(operation, HttpStatus.CREATED);
	}
    
    /** updateOperation Modifie l'operation
     * Warning Fonction inutilisable dans le contexte de l'application bancaire
     * */
    @PutMapping(value = "/operations", consumes= {MediaType.APPLICATION_JSON_VALUE,
    		MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> updateOperation(@RequestBody Operation operation) {
    	Operation currentOperation = operationService.findById(operation.getId());

		if (currentOperation == null) {
			return new ResponseEntity<>("Unable to update. Operation with id " + operation.getId() + " not found.",
					HttpStatus.NOT_FOUND);
		}
		operationService.save(operation);
		return new ResponseEntity<Operation>(operation, HttpStatus.OK);
	}

}
