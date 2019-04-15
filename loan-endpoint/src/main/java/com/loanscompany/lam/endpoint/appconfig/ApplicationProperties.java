package com.loanscompany.lam.endpoint.appconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * Properties specific to Dova.
 * <p>
 * Properties configured in the test.properties file.
 *
 * @author percym
 */
@Data
@Component
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = true)
@Import({springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration.class})
public class ApplicationProperties {

    private String secret;

    private long tokenValidityInSeconds;

}