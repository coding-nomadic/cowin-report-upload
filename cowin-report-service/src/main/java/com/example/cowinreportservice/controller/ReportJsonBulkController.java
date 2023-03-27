package com.example.cowinreportservice.controller;

import com.example.cowinreportservice.constants.ReportJsonConstants;
import com.example.cowinreportservice.events.EventPublisher;
import com.example.cowinreportservice.models.JsonRoot;
import com.example.cowinreportservice.service.ReportJsonService;
import com.example.cowinreportservice.utils.JsonUtils;
import com.example.cowinreportservice.utils.TransformUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = ReportJsonConstants.API_VERSION)
public class ReportJsonBulkController {

    @Autowired
    private EventPublisher eventPublisher;

    @Autowired
    private ReportJsonService reportJsonService;

    /** sends JSON message to event **/
    @PostMapping(ReportJsonConstants.UPLOAD_PATH)
    public ResponseEntity<Void> uploadFile(@RequestParam("file") MultipartFile file) {
        JsonUtils.checkIfValidJson(file);
        eventPublisher.publishEvent(TransformUtils.toString(file));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /** fetches JSON message from elastic search DB **/
    @GetMapping(ReportJsonConstants.FETCH_PATH)
    public ResponseEntity<JsonRoot> readFile() {
        return new ResponseEntity<>(reportJsonService.readBulkReport(), HttpStatus.OK);
    }

}
