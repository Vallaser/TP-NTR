/**
 * OperationServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.uphf.service;

/**
 * 
 * OperationServiceService : Interface 
 * Genere automatiquement par eclipse lorsque l'on
 * cree un Web Service Client a partir du fichier OperationService.wsdl
 * 
 * @author Quentin Colras
 */

public interface OperationServiceService extends javax.xml.rpc.Service {
    public java.lang.String getOperationServiceAddress();

    public fr.uphf.service.OperationService getOperationService() throws javax.xml.rpc.ServiceException;

    public fr.uphf.service.OperationService getOperationService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
