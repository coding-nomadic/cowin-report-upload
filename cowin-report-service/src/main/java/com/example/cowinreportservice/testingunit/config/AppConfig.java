package com.example.cowinreportservice.testingunit.config;

import com.example.cowinreportservice.testingunit.models.ElasticSearchDetails;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ConfigurationProperties(prefix = "config")
public class AppConfig {

    @Value("${config.elastic-url}")
    private String elasticUrl;
    @Value("${config.elastic-port}")
    private String elasticPort;
    @Value("${config.elastic-protocol}")
    private String elasticProtocol;
    @Value("${config.type-name}")
    private String typeName;

    @Bean
    public ElasticSearchDetails elasticSearchDetails() {
        ElasticSearchDetails elasticSearchDetails = new ElasticSearchDetails();
        elasticSearchDetails.setElasticPort(elasticPort);
        elasticSearchDetails.setElasticProtocol(elasticProtocol);
        elasticSearchDetails.setElasticUrl(elasticUrl);
        elasticSearchDetails.setTypeName(typeName);
        return elasticSearchDetails;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
