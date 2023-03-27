package com.example.cowinreportservice.service;

import com.example.cowinreportservice.constants.ReportJsonConstants;
import com.example.cowinreportservice.exceptions.ReportJsonException;
import com.example.cowinreportservice.models.ElasticSearchDetails;
import com.example.cowinreportservice.models.JsonRoot;
import com.example.cowinreportservice.models.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReportJsonService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ElasticSearchDetails elasticSearchDetails;

    /** reads bulk report **/
    public JsonRoot readBulkReport() {
        try {
            final UriComponents uriComponents = UriComponentsBuilder.newInstance()
                                            .scheme(elasticSearchDetails.getElasticProtocol())
                                            .host(elasticSearchDetails.getElasticUrl())
                                            .port(elasticSearchDetails.getElasticPort())
                                            .path(ReportJsonConstants.COWIN + "/" + "_search").build();
            final ResponseEntity<Root> json = restTemplate.exchange(uriComponents.toString(), HttpMethod.GET,
                                            getHttpEntity(), Root.class);
            if (json.getBody() != null) {
                return json.getBody().getHits().getHits().get(0).get_source();
            }
        } catch (Exception exception) {
            log.error(exception.getLocalizedMessage());
            throw new ReportJsonException("Error occurred while fetching from elastic search DB", "102");
        }
        return new JsonRoot();
    }

    /** get the Http Entity **/
    private HttpEntity<String> getHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(headers);
    }

}
