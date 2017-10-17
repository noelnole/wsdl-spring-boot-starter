package com.scotiabank.wsdl.starter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * Class to create a bean from marshaller
 * @author Noel Rodriguez
 */

@Configuration
@ConditionalOnWebApplication
@AutoConfigureAfter(WebMvcAutoConfiguration.class)
@EnableConfigurationProperties(WsdlProperties.class)
public class SoapAutoConfiguration {

    @Autowired
    private WsdlProperties wsdlProperties;

    @Bean
    @ConditionalOnMissingBean(Jaxb2Marshaller.class)
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPaths(wsdlProperties.getEndpoint());
        return marshaller;
    }
}
