package com.example.cowinreportservice.testingunit.utils;

import com.example.cowinreportservice.testingunit.exceptions.ReportJsonException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class JsonUtils {
    private JsonUtils() {
        // Private constructor to prevent instantiation
        throw new IllegalStateException("Utility class");
    }

    /**
     * Converts an object to JSON string.
     *
     * @param objectToConvert The object to be converted to JSON.
     * @return JSON string representing the object.
     * @throws IOException if an error occurs during serialization.
     */
    public static String toString(Object objectToConvert) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper.writeValueAsString(objectToConvert);
    }

    /**
     * Converts a JSON string to an object of the specified class.
     *
     * @param jsonString The JSON string to be converted.
     * @param type The class type to convert the JSON string to.
     * @param <T> The type of the target object.
     * @return An object of the specified class.
     * @throws IOException if an error occurs during deserialization.
     */
    public static <T> T convertWithClass(String jsonString, Class<T> type) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return objectMapper.readValue(jsonString, type);
    }
}
