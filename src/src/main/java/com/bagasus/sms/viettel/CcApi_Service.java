
package com.bagasus.sms.viettel;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CcApi", targetNamespace = "http://impl.bulkSms.ws/", wsdlLocation = "http://125.235.4.202:8998/bulkapi?wsdl")
public class CcApi_Service
    extends Service
{

    private final static URL CCAPI_WSDL_LOCATION;
    private final static WebServiceException CCAPI_EXCEPTION;
    private final static QName CCAPI_QNAME = new QName("http://impl.bulkSms.ws/", "CcApi");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://125.235.4.202:8998/bulkapi?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CCAPI_WSDL_LOCATION = url;
        CCAPI_EXCEPTION = e;
    }

    public CcApi_Service() {
        super(__getWsdlLocation(), CCAPI_QNAME);
    }

    public CcApi_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), CCAPI_QNAME, features);
    }

    public CcApi_Service(URL wsdlLocation) {
        super(wsdlLocation, CCAPI_QNAME);
    }

    public CcApi_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CCAPI_QNAME, features);
    }

    public CcApi_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CcApi_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CcApi
     */
    @WebEndpoint(name = "CcApiPort")
    public CcApi getCcApiPort() {
        return super.getPort(new QName("http://impl.bulkSms.ws/", "CcApiPort"), CcApi.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CcApi
     */
    @WebEndpoint(name = "CcApiPort")
    public CcApi getCcApiPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://impl.bulkSms.ws/", "CcApiPort"), CcApi.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CCAPI_EXCEPTION!= null) {
            throw CCAPI_EXCEPTION;
        }
        return CCAPI_WSDL_LOCATION;
    }

}
