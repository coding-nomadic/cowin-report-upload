package com.example.cowinreportservice.testingunit;

import com.example.cowinreportservice.testingunit.constants.ReportJsonConstants;
import com.example.cowinreportservice.testingunit.controller.ReportJsonFetchController;
import com.example.cowinreportservice.testingunit.models.JsonRoot;
import com.example.cowinreportservice.testingunit.models.StateWiseVaccination;
import com.example.cowinreportservice.testingunit.service.ReportJsonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;


@SpringBootTest
public class ReportJsonFetchControllerTests {

    @Mock
    private ReportJsonService reportJsonService;
    @Mock
    private JsonRoot jsonRoot;

    @InjectMocks
    private ReportJsonFetchController reportJsonFetchController;

    @Test
    public void test_readFile() {
        JsonRoot jsonRoot = new JsonRoot();
        jsonRoot.setStateWiseVaccination(new ArrayList<StateWiseVaccination>());
        Mockito.when(reportJsonService.readBulkReport()).thenReturn(jsonRoot);
        Assertions.assertNotNull(reportJsonFetchController.readFile(ReportJsonConstants.STATE_WISE_VACCINATION));
    }

    @Test
    public void test_readFile_verify() {
        JsonRoot jsonRoot = new JsonRoot();
        jsonRoot.setStateWiseVaccination(new ArrayList<StateWiseVaccination>());
        Mockito.when(reportJsonService.readBulkReport()).thenReturn(jsonRoot);
        reportJsonFetchController.readFile(ReportJsonConstants.STATE_WISE_VACCINATION);
        Mockito.verify(reportJsonService,Mockito.times(1)).readBulkReport();
    }
}
