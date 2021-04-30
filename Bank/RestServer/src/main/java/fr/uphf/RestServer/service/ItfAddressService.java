package fr.uphf.RestServer.service;

import fr.uphf.RestServer.model.Address;
import fr.uphf.RestServer.model.Addresses;

/**
 * 
 * ItfAddressService : Interface du serveur Tomcat (Bank) 
 * utilisee pour les services REST
 * Cette interface permet de definir les fonctions qu'utilise la class AddressService
 * 
 * @author Quentin Colras
 */

public interface ItfAddressService {
	
	Addresses findAll();
	
	Address findById(Long id);
	
	Addresses findAllByCity(String city);
	
	Addresses findAllByStreet(String street);
	
	Addresses findAllByCountry(String country);
	
	Addresses findAllByCityAndStreet(String city, String street);
	
	Addresses findAllByCityAndCountry(String city, String country);
	
	Addresses findAllByStreetAndCountry(String street, String country);
	
	Addresses findAllByCityAndStreetAndCountry(String city, String street, String country);
	
	void deleteById(Long addressId);
	
	void save(Address address);

}
