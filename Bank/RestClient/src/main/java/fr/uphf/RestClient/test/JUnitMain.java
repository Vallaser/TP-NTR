package fr.uphf.RestClient.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * 
 * JUnitMain : Classe du client du serveur Tomcat (Bank) 
 * utilisée pour tester les services REST JSON et XML
 * Ce main permet de lancer l'execution des test des services JSON et XML
 * 
 * @author Quentin Colras
 */
public class JUnitMain {
	
public static void main(String[] args) {
		
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Bienvenue dans le main des tests JUnit pour les services REST JSON et XML");
		System.out.println("--------------------------------------------------------------------------\n");
		Result resultXml = JUnitCore.runClasses(JUnitXmlServices.class);
		for(Failure failure : resultXml.getFailures())	
			System.out.println(failure.toString());
		System.out.println("Resultat des test JUnit des services REST XML : " + resultXml.wasSuccessful());
		Result resultJson = JUnitCore.runClasses(JUnitJsonServices.class);
		for(Failure failure : resultJson.getFailures())	
			System.out.println(failure.toString());
		System.out.println("Resultat des test JUnit des services REST JSON : " + resultJson.wasSuccessful());
		
		System.out.println("\n---------------------------");
		System.out.println("Fin des tests JUnit pour les services REST JSON et XML");
		System.out.println("---------------------------");	

	}

}
