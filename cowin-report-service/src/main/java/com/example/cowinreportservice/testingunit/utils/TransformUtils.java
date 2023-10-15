package com.example.cowinreportservice.testingunit.utils;

import com.example.cowinreportservice.testingunit.exceptions.ReportJsonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
public class TransformUtils {

    private TransformUtils() {
        // Private constructor to prevent instantiation, as it's a utility class
        throw new IllegalStateException("Utility class");
    }

    /**
     * Convert MultipartFile to String.
     *
     * @param file MultipartFile to be converted.
     * @return String representation of the MultipartFile.
     * @throws ReportJsonException if an error occurs during conversion.
     */
    public static String toString(MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                return new String(bytes);
            }
        } catch (IOException exception) {
            handleException(exception);
        }
        return "";
    }

    /**
     * Handles exceptions by logging and throwing a custom exception.
     *
     * @param exception The exception to handle.
     * @throws ReportJsonException with the appropriate message.
     */
    private static void handleException(IOException exception) {
        log.error(exception.getLocalizedMessage());
        throw new ReportJsonException("Error occurred while converting to JSON String: " + exception.getLocalizedMessage());
    }
}
