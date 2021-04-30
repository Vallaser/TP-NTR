/**
 * OperationServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.uphf.service;

/**
 * 
 * OperationServiceServiceLocator : Class 
 * Genere automatiquement par eclipse lorsque l'on
 * cree un Web Service Client a partir du fichier OperationService.wsdl
 * 
 * @author Quentin Colras
 */

public class OperationServiceServiceLocator extends org.apache.axis.client.Service implements fr.uphf.service.OperationServiceService {

    public OperationServiceServiceLocator() {
    }


    public OperationServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public OperationServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for OperationService
    private java.lang.String OperationService_address = "http://localhost:8080/WildFlyServer/services/OperationService";

    public java.lang.String getOperationServiceAddress() {
        return OperationService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String OperationServiceWSDDServiceName = "OperationService";

    public java.lang.String getOperationServiceWSDDServiceName() {
        return OperationServiceWSDDServiceName;
    }

    public void setOperationServiceWSDDServiceName(java.lang.String name) {
        OperationServiceWSDDServiceName = name;
    }

    public fr.uphf.service.OperationService getOperationService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(OperationService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getOperationService(endpoint);
    }

    public fr.uphf.service.OperationService getOperationService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            fr.uphf.service.OperationServiceSoapBindingStub _stub = new fr.uphf.service.OperationServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getOperationServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setOperationServiceEndpointAddress(java.lang.String address) {
        OperationService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (fr.uphf.service.OperationService.class.isAssignableFrom(serviceEndpointInterface)) {
                fr.uphf.service.OperationServiceSoapBindingStub _stub = new fr.uphf.service.OperationServiceSoapBindingStub(new java.net.URL(OperationService_address), this);
                _stub.setPortName(getOperationServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("OperationService".equals(inputPortName)) {
            return getOperationService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.uphf.fr", "OperationServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.uphf.fr", "OperationService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("OperationService".equals(portName)) {
            setOperationServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
