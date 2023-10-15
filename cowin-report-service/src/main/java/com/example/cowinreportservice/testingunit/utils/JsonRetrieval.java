package com.example.cowinreportservice.testingunit.utils;

import com.example.cowinreportservice.testingunit.constants.ReportJsonConstants;
import com.example.cowinreportservice.testingunit.exceptions.ReportJsonException;
import com.example.cowinreportservice.testingunit.models.JsonRoot;

public class JsonRetrieval {

    private JsonRetrieval() {
        // Private constructor to prevent instantiation
        throw new IllegalStateException("Utility class");
    }

    /**
     * Retrieves data from JsonRoot based on the specified type.
     *
     * @param type The type of data to retrieve.
     * @param jsonRoot The JsonRoot object containing the data.
     * @return The retrieved data based on the specified type.
     * @throws ReportJsonException if an invalid type is provided.
     */
    public static Object getObject(String type, JsonRoot jsonRoot) {
        switch (type) {
            case ReportJsonConstants.VACCINE_DONE_TIME_TODAY:
                return jsonRoot.getVaccinationDoneByTimeToday();
            case ReportJsonConstants.LAST_30_DAYS_VACCINATION:
                return jsonRoot.getLast30DaysVaccination();
            case ReportJsonConstants.WEEKLY_VACCINATION:
                return jsonRoot.getWeeklyAgeWiseVaccination();
            case ReportJsonConstants.VACCINATION_BY_TIME_AGE_WISE_TODAY:
                return jsonRoot.getVaccinationDoneByTimeAgeWiseToday();
            case ReportJsonConstants.LAST_30_DAYS_AGE_WISE_VACCINATION:
                return jsonRoot.getLast30DaysAgeWiseVaccination();
            case ReportJsonConstants.WEEKLY_AGE_WISE_VACCINATION:
                return jsonRoot.getWeeklyAgeWiseVaccination();
            case ReportJsonConstants.REGISTRATION_DONE_BY_TIME_TODAY:
                return jsonRoot.getRegistrationDoneByTimeToday();
            case ReportJsonConstants.LAST_30_DAYS_REGISTRATION:
                return jsonRoot.getLast30DaysRegistration();
            case ReportJsonConstants.WEEKLY_REGISTRATION:
                return jsonRoot.getWeeklyRegistration();
            case ReportJsonConstants.LAST_30_DAYS_AEFI_REPORTED:
                return jsonRoot.getLast30DaysAefiReported();
            case ReportJsonConstants.VACCINATION_BY_AGE:
                return jsonRoot.getVaccinationByAge();
            case ReportJsonConstants.STATE_WISE_VACCINATION:
                return jsonRoot.getStateWiseVaccination();
            default:
                throw new ReportJsonException("Invalid Type!", "102");
        }
    }
}
