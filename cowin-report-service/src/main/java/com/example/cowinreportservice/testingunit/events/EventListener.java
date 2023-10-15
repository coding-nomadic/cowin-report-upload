package com.example.cowinreportservice.testingunit.events;

import com.example.cowinreportservice.testingunit.constants.ReportJsonConstants;
import com.example.cowinreportservice.testingunit.exceptions.ReportJsonException;
import com.example.cowinreportservice.testingunit.models.ElasticSearchDetails;
import com.example.cowinreportservice.testingunit.models.JsonRoot;
import com.example.cowinreportservice.testingunit.utils.JsonUtils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

@Component
@Slf4j
public class EventListener implements ApplicationListener<EventMessage> {

    private final RestTemplate restTemplate;
    private final ElasticSearchDetails elasticSearchDetails;

    @Autowired
    public EventListener(RestTemplate restTemplate, ElasticSearchDetails elasticSearchDetails) {
        this.restTemplate = restTemplate;
        this.elasticSearchDetails = elasticSearchDetails;
    }

    @Override
    public void onApplicationEvent(EventMessage event) {
        try {
            final UriComponents uriComponents = UriComponentsBuilder.newInstance()
                    .scheme(elasticSearchDetails.getElasticProtocol())
                    .host(elasticSearchDetails.getElasticUrl())
                    .port(elasticSearchDetails.getElasticPort())
                    .path(ReportJsonConstants.COWIN + "/" + elasticSearchDetails.getTypeName())
                    .build();
            log.info("Received event message - {}", event.getMessage());
            final JsonRoot jsonRequest = JsonUtils.convertWithClass(event.getMessage(), JsonRoot.class);
            restTemplate.exchange(uriComponents.toString(), HttpMethod.POST, getHttpEntity(jsonRequest), String.class);
            log.info("Inserted Data for the cowin report in elastic search Index ");
        } catch (Exception exception) {
            handleException(exception);
        }
    }

    private HttpEntity<String> getHttpEntity(JsonRoot jsonRequest) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(JsonUtils.toString(jsonRequest), headers);
    }

    private void handleException(Exception exception) {
        log.error(exception.getLocalizedMessage());
        throw new ReportJsonException("Error occurred while inserting to elastic search DB", "102");
    }
}
