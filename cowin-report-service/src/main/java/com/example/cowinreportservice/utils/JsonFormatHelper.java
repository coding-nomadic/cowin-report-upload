package com.example.cowinreportservice.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonFormatHelper {
    private JsonFormatHelper() {

    }
    public static String toString(Object objectToConvert) throws IOException {
        return new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL).writeValueAsString(objectToConvert);
    }

    public static <T> T convertWithClass(String jsonString, Class<T> type) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return new ObjectMapper().readValue(jsonString, type);
    }
}
