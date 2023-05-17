package com.example.cowinreportservice.testingunit;

import com.example.cowinreportservice.testingunit.controller.ReportJsonBulkController;
import com.example.cowinreportservice.testingunit.events.EventPublisher;
import com.example.cowinreportservice.testingunit.service.ReportJsonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

@SpringBootTest
public class ReportJsonBulkControllerTests {
    @Mock
    private EventPublisher eventPublisher;

    @Mock
    private ReportJsonService reportJsonService;

    @InjectMocks
    private ReportJsonBulkController reportJsonBulkController;

    @Test
    public void test_uploadFile_notNull() {
        MockMultipartFile jsonFile = new MockMultipartFile("test.json", "", "application/json", "{\"json\": \"someValue\"}".getBytes());
        Assertions.assertNotNull(reportJsonBulkController.uploadFile(jsonFile));
    }

    @Test
    public void test_uploadFile_status() {
        MockMultipartFile jsonFile = new MockMultipartFile("test.json", "", "application/json", "{\"json\": \"someValue\"}".getBytes());
        Assertions.assertEquals(201, reportJsonBulkController.uploadFile(jsonFile).getStatusCodeValue());
    }

    @Test
    public void test_uploadFile_verify() {
        MockMultipartFile jsonFile = new MockMultipartFile("test.json", "", "application/json", "{\"json\": \"someValue\"}".getBytes());
        Mockito.verify(eventPublisher,Mockito.times(0)).publishEvent("");
    }

    @Test
    public void test_readFile() {
       Assertions.assertNotNull(reportJsonBulkController.readFile());
       Assertions.assertEquals(200,reportJsonBulkController.readFile().getStatusCodeValue());
    }
}
