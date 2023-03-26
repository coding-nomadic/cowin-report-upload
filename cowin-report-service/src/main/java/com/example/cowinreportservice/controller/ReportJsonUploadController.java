package com.example.cowinreportservice.controller;

import com.example.cowinreportservice.constants.ReportCsvConstants;
import com.example.cowinreportservice.events.EventPublisher;
import com.example.cowinreportservice.service.ReportJsonService;
import com.example.cowinreportservice.utils.TransformUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = ReportCsvConstants.API_VERSION)
public class ReportJsonUploadController {

    @Autowired
    private ReportJsonService reportJsonUploadService;

    @Autowired
    private EventPublisher eventPublisher;

    @PostMapping(ReportCsvConstants.UPLOAD_PATH)
    public ResponseEntity<Void> uploadFile(@RequestParam("file") MultipartFile file) {
        eventPublisher.publishEvent(TransformUtils.convertToString(file));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
