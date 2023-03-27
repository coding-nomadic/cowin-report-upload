package com.example.cowinreportservice.events;

import com.example.cowinreportservice.constants.ReportJsonConstants;
import com.example.cowinreportservice.exceptions.ReportJsonException;
import com.example.cowinreportservice.models.ElasticSearchDetails;
import com.example.cowinreportservice.models.JsonRoot;
import com.example.cowinreportservice.utils.JsonUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EventListener implements ApplicationListener<EventMessage> {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ElasticSearchDetails elasticSearchDetails;

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
            log.error(exception.getLocalizedMessage());
            throw new ReportJsonException("Error occurred while inserting to elastic search DB", "102");
        }
    }

    /** get the Http Entity **/
    private HttpEntity<String> getHttpEntity(JsonRoot jsonRequest) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(JsonUtils.toString(jsonRequest), headers);
    }
}
