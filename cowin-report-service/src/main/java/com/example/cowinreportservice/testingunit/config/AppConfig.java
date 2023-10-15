package com.example.cowinreportservice.testingunit.config;

import com.example.cowinreportservice.testingunit.models.ElasticSearchDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    private final String elasticUrl;
    private final String elasticPort;
    private final String elasticProtocol;
    private final String typeName;

    public AppConfig(
            @Value("${config.elastic-url}") String elasticUrl,
            @Value("${config.elastic-port}") String elasticPort,
            @Value("${config.elastic-protocol}") String elasticProtocol,
            @Value("${config.type-name}") String typeName) {
        this.elasticUrl = elasticUrl;
        this.elasticPort = elasticPort;
        this.elasticProtocol = elasticProtocol;
        this.typeName = typeName;
    }

    /**
     * Bean for ElasticSearchDetails.
     *
     * @return ElasticSearchDetails bean.
     */
    @Bean
    public ElasticSearchDetails elasticSearchDetails() {
        ElasticSearchDetails details = new ElasticSearchDetails();
        details.setElasticPort(elasticPort);
        details.setElasticProtocol(elasticProtocol);
        details.setElasticUrl(elasticUrl);
        details.setTypeName(typeName);
        return details;
    }

    /**
     * Bean for RestTemplate.
     *
     * @return RestTemplate bean.
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
