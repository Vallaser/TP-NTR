package fr.uphf.RestServer.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Addresses : Classe du serveur Tomcat (Bank) 
 * Cette classe modele permet de representer une liste d'adresses
 * 
 * @author Quentin Colras
 * @param claddressesients Liste d'adresses
 */
@JacksonXmlRootElement
public class Addresses implements Serializable {

    private static final long serialVersionUID = 22L;

    @JacksonXmlProperty(localName = "Address")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Address> addresses = new ArrayList<>();
    
    /** Addresses : Constructeur par default*/
    public Addresses() {
    	super();
    }

    /** Addresses : Constructeur avec parametre*/
    public Addresses(List<Address> addresses) {
		this.addresses = addresses;
	}

    /** Getter/Setter de la classe Addresses*/
	public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
