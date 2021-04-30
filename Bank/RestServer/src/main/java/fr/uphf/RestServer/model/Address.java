package fr.uphf.RestServer.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


/**
 * 
 * Address : Classe du serveur Tomcat (Bank)
 * Cette classe modele permet de representer une adresse
 * 
 * @author Quentin Colras
 * @param id L'identifiant unique
 * @param street La rue
 * @param city La ville
 * @param country Le pays
 */

@Entity
@Table(name = "addresses")
@JacksonXmlRootElement(localName = "Address")
public class Address implements Serializable{
	
	private static final long serialVersionUID = 21L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdAddress", nullable = false)
	@JacksonXmlProperty
	private Long id;
 
    @Column(name = "Street", nullable = false)
    @JacksonXmlProperty
    private String street;
    
    @Column(name = "City", nullable = false)
    @JacksonXmlProperty
    private String city;
    
    @Column(name = "Country", nullable = false)
    @JacksonXmlProperty
    private String country;
    
    /** Address : Constructeur par default*/
    public Address() {
    	super();
    }

    /** Address : Constructeur avec parametre*/
	public Address(Long id, String street, String city, String country) {
		this.id = id;
		this.street = street;
		this.city = city;
		this.country = country;
	}

	/** Getter/Setter de la classe Address*/
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
        return "Address{" + "id=" + id + ", street=" + street
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
        final Address other = (Address) obj;
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
