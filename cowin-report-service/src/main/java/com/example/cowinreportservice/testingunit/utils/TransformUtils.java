package com.example.cowinreportservice.testingunit.utils;

import com.example.cowinreportservice.testingunit.exceptions.ReportJsonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
public class TransformUtils {
    public static String toString(MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                return new String(bytes);
            }
        } catch (IOException exception) {
            log.error(exception.getLocalizedMessage());
            throw new ReportJsonException("Error occurred while converting to JSON String : {}", exception.getLocalizedMessage());
        }
        return "";
    }
}
