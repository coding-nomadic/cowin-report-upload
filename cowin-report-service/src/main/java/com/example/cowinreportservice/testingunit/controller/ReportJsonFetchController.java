package com.example.cowinreportservice.testingunit.controller;

import com.example.cowinreportservice.testingunit.constants.ReportJsonConstants;
import com.example.cowinreportservice.testingunit.service.ReportJsonService;
import com.example.cowinreportservice.testingunit.utils.JsonRetrieval;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ReportJsonConstants.API_VERSION + ReportJsonConstants.FETCH)
public class ReportJsonFetchController {

    private final ReportJsonService reportJsonService;

    @Autowired
    public ReportJsonFetchController(ReportJsonService reportJsonService) {
        this.reportJsonService = reportJsonService;
    }

    /**
     * Fetches JSON message from elastic search DB based on the provided type.
     *
     * @param type The type of JSON data to retrieve.
     * @return Object representing the JSON data.
     */
    @GetMapping("/{type}")
    public Object fetchJsonData(@PathVariable("type") String type) {
        return JsonRetrieval.getObject(type, reportJsonService.readBulkReport());
    }
}
