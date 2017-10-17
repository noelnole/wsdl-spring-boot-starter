package com.scotiabank.wsdl.starter.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.SoapFaultClientException;

import javax.annotation.PostConstruct;

/**
 * This class extends from WebServiceGatewaySupport to return a reponse (R).
  * @author Noel Rodriguez
 */
@Slf4j
public abstract class SoapClient<R,T> extends WebServiceGatewaySupport {

    @Autowired
    private Jaxb2Marshaller marshaller;



    public R marshalSendAndReceive(T request) {
        try {
            return (R) getWebServiceTemplate().marshalSendAndReceive(request);
        } catch (SoapFaultClientException e) {
            logger.error("Error", e);
            return null;
        }
    }

    /**
     * After the dependency injection is completes the method is iniatalized with the marshaller
     */
    @PostConstruct
    private void init() {
        setMarshaller(marshaller);
        setUnmarshaller(marshaller);
    }

}