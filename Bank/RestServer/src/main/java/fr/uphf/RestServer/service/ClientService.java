package fr.uphf.RestServer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uphf.RestServer.model.Client;
import fr.uphf.RestServer.model.Clients;
import fr.uphf.RestServer.repository.ClientRepository;

/**
 * 
 * ClientService : Class du serveur Tomcat (Bank) 
 * utilisee pour les services REST
 * Cette class implemente les methodes de ItfClientService
 * Elle permet de fournir des donnees de la table Client de la base de donnees
 * 
 * @author Quentin Colras
 * @param repository Le repository des clients
 */

@Service
public class ClientService implements ItfClientService {

    @Autowired
    private ClientRepository repository;

    /** findAll Recupere la liste des clients */
    @Override
    public Clients findAll() {
        return new Clients((List<Client>) repository.findAll());
    }

    /** findById Recupere le client ayant l'id */
    @Override
    public Client findById(Long id) {
        return repository.findById(id).orElse(null);
    }
    
    /** deleteById Supprime le client ayant l'id */
    @Override
	public void deleteById(Long clientId) {
		repository.deleteById(clientId);
	}

    /** save Sauvegarde le client*/
	@Override
	public void save(Client client) {
		repository.save(client);
	}

	/** findAllByAddressId Recupere la liste des clients ayant l'adresse */
	@Override
	public Clients findAllByAddressId(Long addressId) {
		return new Clients((List<Client>) repository.findAllByAddressId(addressId));
	}

	/** findByEmail Recupere le client ayant l'email */
	@Override
	public Client findByEmail(String email) {
		return repository.findByEmail(email).orElse(null);
	}
}

