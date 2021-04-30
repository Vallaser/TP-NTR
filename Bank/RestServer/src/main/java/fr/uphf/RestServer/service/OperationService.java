package fr.uphf.RestServer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uphf.RestServer.model.Operation;
import fr.uphf.RestServer.model.Operations;
import fr.uphf.RestServer.repository.OperationRepository;

/**
 * 
 * OperationService : Class du serveur Tomcat (Bank) 
 * utilisee pour les services REST
 * Cette class implemente les methodes de ItfOperationService
 * Elle permet de fournir des donnees de la table Operation de la base de donnees
 * 
 * @author Quentin Colras
 * @param repository Le repository des operations
 */

@Service
public class OperationService implements ItfOperationService {

    @Autowired
    private OperationRepository repository;

    /** findAll Recupere la liste des operations */
    @Override
    public Operations findAll() {
        return new Operations((List<Operation>) repository.findAll());
    }

    /** findById Recupere l'operation ayant l'id */
    @Override
    public Operation findById(Long id) {
        return repository.findById(id).orElse(null);
    }
    
    /** deleteById Supprime une operation ayant l'id */
    @Override
	public void deleteById(Long operationId) {
		repository.deleteById(operationId);
	}

    /** save Sauvegarde une operation */
	@Override
	public void save(Operation operation) {
		repository.save(operation);
	}

	/*
	@Override
	public void test(Operation operation) {
		repository.test(operation.getOp(), operation.getOldBalance(), 
				operation.getValueOp(), operation.getDateOp(), operation.getOwner().getId());
	}*/

	/** findAllByTypeContaining Recupere la liste des operations contenant le type */
	@Override
	public Operations findAllByTypeContaining(String type) {
		return new Operations((List<Operation>) repository.findAllByTypeContaining(type));
	}
}
