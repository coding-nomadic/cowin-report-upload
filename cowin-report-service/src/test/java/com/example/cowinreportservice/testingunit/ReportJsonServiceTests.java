package com.example.cowinreportservice.testingunit;

import com.example.cowinreportservice.testingunit.models.*;
import com.example.cowinreportservice.testingunit.service.ReportJsonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ReportJsonServiceTests {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private ElasticSearchDetails elasticSearchDetails;

    @Mock
    private ResponseEntity<Root> json;
    @InjectMocks
    private ReportJsonService reportJsonService;

    @Mock
    UriComponents uriComponents;

    @Test
    public void test_readBulkReport() {
        ResponseEntity<Root> roots = ResponseEntity.ok(getRoots());
        Mockito.when(elasticSearchDetails.getElasticPort()).thenReturn("1990");
        Mockito.when(elasticSearchDetails.getElasticProtocol()).thenReturn("");
        Mockito.when(elasticSearchDetails.getIndexName()).thenReturn("");
        Mockito.when(elasticSearchDetails.getElasticUrl()).thenReturn("");
        Mockito.when(elasticSearchDetails.getTypeName()).thenReturn("");
        Mockito.when(restTemplate.exchange(ArgumentMatchers.anyString(), ArgumentMatchers.any(HttpMethod.class), ArgumentMatchers.any(), ArgumentMatchers.<Class<Root>>any())).thenReturn(roots);
        Assertions.assertNotNull(reportJsonService.readBulkReport());
    }

    @Test
    public void test_readBulkReport_fail() {
        Mockito.when(restTemplate.exchange(ArgumentMatchers.anyString(), ArgumentMatchers.any(HttpMethod.class), ArgumentMatchers.any(), ArgumentMatchers.<Class<Root>>any())).thenReturn(null);
        Assertions.assertThrows(Exception.class,()->reportJsonService.readBulkReport());
    }
    /**
     * @return
     */
    private Root getRoots() {
        Hit hit = new Hit();
        hit.set_id("");
        hit.set_type("");
        hit.set_source(new JsonRoot());
        List<Hit> lists = new ArrayList<>();
        lists.add(hit);
        Hits hits = new Hits();
        hits.setHits(lists);
        Root root = new Root();
        root.setTimedOut(true);
        root.setHits(hits);
        return root;
    }
}
