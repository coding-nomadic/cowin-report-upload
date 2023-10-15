package com.example.cowinreportservice.testingunit.controller;

import com.example.cowinreportservice.testingunit.constants.ReportJsonConstants;
import com.example.cowinreportservice.testingunit.events.EventPublisher;
import com.example.cowinreportservice.testingunit.models.JsonRoot;
import com.example.cowinreportservice.testingunit.service.ReportJsonService;
import com.example.cowinreportservice.testingunit.utils.TransformUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(ReportJsonConstants.API_VERSION)
public class ReportJsonBulkController {

    private final EventPublisher eventPublisher;
    private final ReportJsonService reportJsonService;

    @Autowired
    public ReportJsonBulkController(EventPublisher eventPublisher, ReportJsonService reportJsonService) {
        this.eventPublisher = eventPublisher;
        this.reportJsonService = reportJsonService;
    }

    /**
     * Sends JSON message to event.
     *
     * @param file The uploaded file.
     * @return ResponseEntity with HTTP status code 201 if successful.
     */
    @PostMapping(ReportJsonConstants.UPLOAD_PATH)
    public ResponseEntity<Void> uploadFile(@RequestParam("file") MultipartFile file) {
        String jsonString = TransformUtils.toString(file);
        eventPublisher.publishEvent(jsonString);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Fetches JSON message from elastic search DB.
     *
     * @return ResponseEntity containing the JSON data with HTTP status code 200 if successful.
     */
    @GetMapping(ReportJsonConstants.FETCH_PATH)
    public ResponseEntity<JsonRoot> fetchBulkReport() {
        JsonRoot jsonRoot = reportJsonService.readBulkReport();
        return ResponseEntity.ok(jsonRoot);
    }
}
