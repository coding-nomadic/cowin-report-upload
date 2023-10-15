package com.example.cowinreportservice.testingunit.service;

import com.example.cowinreportservice.testingunit.constants.ReportJsonConstants;
import com.example.cowinreportservice.testingunit.exceptions.ReportJsonException;
import com.example.cowinreportservice.testingunit.models.ElasticSearchDetails;
import com.example.cowinreportservice.testingunit.models.JsonRoot;
import com.example.cowinreportservice.testingunit.models.Root;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
public class ReportJsonService {

    private final RestTemplate restTemplate;
    private final ElasticSearchDetails elasticSearchDetails;

    @Autowired
    public ReportJsonService(RestTemplate restTemplate, ElasticSearchDetails elasticSearchDetails) {
        this.restTemplate = restTemplate;
        this.elasticSearchDetails = elasticSearchDetails;
    }

    /**
     * Reads bulk report from ElasticSearch.
     *
     * @return JsonRoot representing the bulk report.
     */
    public JsonRoot readBulkReport() {
        try {
            final UriComponents uriComponents = UriComponentsBuilder.newInstance()
                    .scheme(elasticSearchDetails.getElasticProtocol())
                    .host(elasticSearchDetails.getElasticUrl())
                    .port(elasticSearchDetails.getElasticPort())
                    .path(ReportJsonConstants.COWIN + "/_search").build();

            ResponseEntity<Root> response = restTemplate.exchange(
                    uriComponents.toString(),
                    HttpMethod.GET,
                    getHttpEntity(),
                    Root.class);

            if (response.getBody() != null) {
                return response.getBody().getHits().getHits().get(0).getSource();
            }
        } catch (Exception exception) {
            handleException(exception);
        }
        return new JsonRoot();
    }

    private void handleException(Exception exception) {
        log.error(exception.getLocalizedMessage());
        throw new ReportJsonException("Error occurred while fetching from elastic search DB", "102");
    }

    /**
     * Get the Http Entity with JSON content type.
     *
     * @return HttpEntity<String> with JSON content type.
     */
    private HttpEntity<String> getHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(headers);
    }
}
