package fr.uphf.RestServer.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Operations : Classe du serveur Tomcat (Bank) 
 * Cette classe modele permet de representer une liste d'operation
 * 
 * @author Quentin Colras
 * @param operations Liste d'operations
 */
@JacksonXmlRootElement
public class Operations implements Serializable {

    private static final long serialVersionUID = 24L;

    @JacksonXmlProperty(localName = "Operation")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Operation> operations = new ArrayList<>();
    
    /** Operations : Constructeur par default*/
    public Operations() {
    	super();
    }

    /** Operations : Constructeur avec parametre*/
    public Operations(List<Operation> operations) {
		this.operations = operations;
	}

    /** Getter/Setter de la classe Operations*/
    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
}
