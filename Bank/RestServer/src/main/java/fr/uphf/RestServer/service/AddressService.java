package fr.uphf.RestServer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uphf.RestServer.model.Address;
import fr.uphf.RestServer.model.Addresses;
import fr.uphf.RestServer.repository.AddressRepository;

/**
 * 
 * AddressService : Class du serveur Tomcat (Bank) 
 * utilisee pour les services REST
 * Cette class implemente les methodes de ItfAddressService
 * Elle permet de fournir des donnees de la table Address de la base de donnees
 * 
 * @author Quentin Colras
 * @param repository Le repository des adresses
 */

@Service
public class AddressService implements ItfAddressService {

    @Autowired
    private AddressRepository repository;

    /** findAll Recupere la liste des adresses */
    @Override
    public Addresses findAll() {
        return new Addresses((List<Address>) repository.findAll());
    }

    /** findById Recupere l'adresse ayant l'id */
    @Override
    public Address findById(Long id) {
        return repository.findById(id).orElse(null);
    }
    
    /** deleteById Recupere l'adresse ayant l'id */
    @Override
	public void deleteById(Long addressId) {
		repository.deleteById(addressId);
	}

    /** save Sauvegarde l'adresse */
	@Override
	public void save(Address address) {
		repository.save(address);
	}

	/** findAllByCity Recupere la liste des adresses ayant la ville */
	@Override
	public Addresses findAllByCity(String city) {
		return new Addresses((List<Address>) repository.findAllByCity(city));
	}

	/** findAllByStreet Recupere la liste des adresses ayant la rue */
	@Override
	public Addresses findAllByStreet(String street) {
		return new Addresses((List<Address>) repository.findAllByStreet(street));
	}
	
	/** findAllByCountry Recupere la liste des adresses ayant le pays */
	@Override
	public Addresses findAllByCountry(String country) {
		return new Addresses((List<Address>) repository.findAllByCountry(country));
	}

	/** findAllByCityAndStreet Recupere la liste des adresses ayant la ville et la rue */
	@Override
	public Addresses findAllByCityAndStreet(String city, String street) {
		return new Addresses((List<Address>) repository.findAllByCityAndStreet(city, street));
	}

	/** findAllByCityAndCountry Recupere la liste des adresses ayant la ville et le pays */
	@Override
	public Addresses findAllByCityAndCountry(String city, String country) {
		return new Addresses((List<Address>) repository.findAllByCityAndCountry(city, country));
	}

	/** findAllByStreetAndCountry Recupere la liste des adresses ayant la rue et le pays */
	@Override
	public Addresses findAllByStreetAndCountry(String street, String country) {
		return new Addresses((List<Address>) repository.findAllByStreetAndCountry(street, country));
	}

	/** findAllByCityAndStreetAndCountry Recupere la liste des adresses ayant la ville, la rue et le pays */
	@Override
	public Addresses findAllByCityAndStreetAndCountry(String city, String street, String country) {
		return new Addresses((List<Address>) repository.findAllByCityAndStreetAndCountry(city, street, country));
	}
}
