package fr.uphf.RestServer.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Clients : Classe du serveur Tomcat (Bank) 
 * Cette classe modele permet de representer une liste de clients
 * 
 * @author Quentin Colras
 * @param clients Liste de clients
 */
@JacksonXmlRootElement
public class Clients implements Serializable {

    private static final long serialVersionUID = 26L;

    @JacksonXmlProperty(localName = "Client")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Client> clients = new ArrayList<>();
    
    /** Clients : Constructeur par default*/
    public Clients() {
    	super();
    }
    
    /** Clients : Constructeur avec parametre*/
    public Clients(List<Client> clients) {
		this.clients = clients;
	}

    /** Getter/Setter de la classe Clients*/
    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}

