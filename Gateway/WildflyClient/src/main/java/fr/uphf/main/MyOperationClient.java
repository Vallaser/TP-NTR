package fr.uphf.main;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import fr.uphf.service.OperationService;
import fr.uphf.service.OperationServiceServiceLocator;

/**
 * 
 * MyOperationClient est le main du client du serveur Wildfly (Gateway)
 * Cette classe permet de tester le service SOAP de la passerelle
 * 
 * @author Quentin Colras
 */

public class MyOperationClient {

	public static void main(String[] args) throws RemoteException, ServiceException {
		System.out.println("From the Client ");
		OperationServiceServiceLocator loc = new OperationServiceServiceLocator();
		OperationService myservice =loc.getOperationService();
		String resultServiceSoap = myservice.postOperationForClient("colras.quentin@gmail.com", "-", "29/04/2021 18:13:16", "Purchase Game", 30.6f);
		assertEquals(resultServiceSoap, "Success");
		System.out.println("Response "+ resultServiceSoap);
	}

}