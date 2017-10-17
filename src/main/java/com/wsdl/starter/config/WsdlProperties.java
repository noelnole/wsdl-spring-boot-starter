package com.scotiabank.wsdl.starter.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *  WSDL properties
 * @author Noel Rodriguez
 */

@ConfigurationProperties(prefix = WsdlProperties.WSDL_PREFIX)
@Data
public class WsdlProperties {

    public static final String WSDL_PREFIX = "scotia.wsdl";


    @Value("${scotia.wsdl.endpoint:''}")
    private String endpoint;
}
