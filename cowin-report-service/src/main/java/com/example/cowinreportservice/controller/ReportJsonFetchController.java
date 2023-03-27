package com.example.cowinreportservice.controller;

import com.example.cowinreportservice.constants.ReportJsonConstants;
import com.example.cowinreportservice.service.ReportJsonService;
import com.example.cowinreportservice.utils.JsonRetrieval;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ReportJsonConstants.API_VERSION)
public class ReportJsonFetchController {

    @Autowired
    private ReportJsonService reportJsonService;

    /** fetches JSON message from elastic search DB **/
    @GetMapping(path = ReportJsonConstants.FETCH)
    public Object readFile(@PathVariable("type") String type) {
        return JsonRetrieval.getObject(type, reportJsonService.readBulkReport());
    }
}
