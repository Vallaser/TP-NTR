package fr.uphf.RestServer.service;

import fr.uphf.RestServer.model.Client;
import fr.uphf.RestServer.model.Clients;

/**
 * 
 * ItfClientService : Interface du serveur Tomcat (Bank) 
 * utilisee pour les services REST
 * Cette interface permet de definir les fonctions qu'utilise la class ClientService
 * 
 * @author Quentin Colras
 */

public interface ItfClientService {
	
	Clients findAll();
	
	Client findById(Long id);
	
	Clients findAllByAddressId(Long addressId);
	
	void deleteById(Long clientId);
	
	void save(Client client);
	
	Client findByEmail(String email);
}
