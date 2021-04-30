package fr.uphf.RestClient.model;

import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * AddressJson : Classe du client du serveur Tomcat (Bank) 
 * utilisée pour les services REST JSON
 * Cette classe modele permet de representer une adresse
 * 
 * @author Quentin Colras
 * @param id L'identifiant unique
 * @param street La rue
 * @param city La ville
 * @param country Le pays
 */

@XmlRootElement(name = "addresses")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddressJson {
	
	private Long id;
	
    private String street;

    private String city;

    private String country;
    
    /** AddressJson : Constructeur par default*/
    public AddressJson() {
    	super();
    }

    /** AddressJson : Constructeur avec parametre*/
	public AddressJson(Long id, String street, String city, String country) {
		this.id = id;
		this.street = street;
		this.city = city;
		this.country = country;
	}
	
	/** Getter/Setter de la classe AddressJson*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	/** toString : Renvoie une chaine de caractere correspondant a l'image
	 * d'une adresse*/
	@Override
    public String toString() {
        return "AddressJson{" + "id=" + id + ", street=" + street
                + ", city=" + city + ", country=" + country + '}';
    }

	/** equals : Test l'egalite avec une autre adresse*/
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AddressJson other = (AddressJson) obj;
        if (!Objects.equals(this.street, other.street)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.country, other.country)) {
            return false;
        }

        return Objects.equals(this.id, other.id);
    }

}