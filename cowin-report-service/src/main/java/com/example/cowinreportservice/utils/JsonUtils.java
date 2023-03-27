package com.example.cowinreportservice.utils;

import com.example.cowinreportservice.exceptions.ReportJsonException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class JsonUtils {
    private JsonUtils() {

    }

    public static String toString(Object objectToConvert) throws IOException {
        return new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL)
                                        .writeValueAsString(objectToConvert);
    }

    public static <T> T convertWithClass(String jsonString, Class<T> type) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return new ObjectMapper().readValue(jsonString, type);
    }

    public static void checkIfValidJson(MultipartFile file) {
        if (!FilenameUtils.getExtension(file.getName()).equals(".json")) {
            throw new ReportJsonException("Invalid Json File !", "102");
        }
    }

}
