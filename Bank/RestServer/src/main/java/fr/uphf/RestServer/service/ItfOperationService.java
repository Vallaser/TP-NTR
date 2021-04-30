package fr.uphf.RestServer.service;

import fr.uphf.RestServer.model.Operation;
import fr.uphf.RestServer.model.Operations;

/**
 * 
 * ItfOperationService : Interface du serveur Tomcat (Bank) 
 * utilisee pour les services REST
 * Cette interface permet de definir les fonctions qu'utilise la class OperationService
 * 
 * @author Quentin Colras
 */

public interface ItfOperationService {

	Operations findAll();
	
    Operation findById(Long id);
    
    void deleteById(Long operationId);
    
	void save(Operation operation);
	
	//void test(Operation operation);
	
	Operations findAllByTypeContaining(String type);
}
