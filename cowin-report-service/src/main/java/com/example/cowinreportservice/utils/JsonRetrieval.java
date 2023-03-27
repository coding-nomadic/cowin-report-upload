package com.example.cowinreportservice.utils;

import com.example.cowinreportservice.constants.ReportJsonConstants;
import com.example.cowinreportservice.exceptions.ReportJsonException;
import com.example.cowinreportservice.models.JsonRoot;

public class JsonRetrieval {

    private JsonRetrieval() {
    }

    /**
     * 
     * @param type
     * @param jsonRoot
     * @return
     */
    public static Object getObject(String type, JsonRoot jsonRoot) {
        switch (type) {
        case ReportJsonConstants.VACCINE_DONE_TIME_TODAY:
            return jsonRoot.vaccinationDoneByTimeToday;
        case ReportJsonConstants.LAST_30_DAYS_VACCINATION:
            return jsonRoot.last30DaysVaccination;
        case ReportJsonConstants.WEEKLY_VACCINATION:
            return jsonRoot.weeklyAgeWiseVaccination;
        case ReportJsonConstants.VACCINATION_BY_TIME_AGE_WISE_TODAY:
            return jsonRoot.vaccinationDoneByTimeAgeWiseToday;
        case ReportJsonConstants.LAST_30_DAYS_AGE_WISE_VACCINATION:
            return jsonRoot.last30DaysAgeWiseVaccination;
        case ReportJsonConstants.WEEKLY_AGE_WISE_VACCINATION:
            return jsonRoot.weeklyAgeWiseVaccination;
        case ReportJsonConstants.REGISTRATION_DONE_BY_TIME_TODAY:
            return jsonRoot.registrationDoneByTimeToday;
        case ReportJsonConstants.LAST_30_DAYS_REGISTRATION:
            return jsonRoot.last30DaysRegistration;
        case ReportJsonConstants.WEEKLY_REGISTRATION:
            return jsonRoot.weeklyRegistration;
        case ReportJsonConstants.LAST_30_DAYS_AEFI_REPORTED:
            return jsonRoot.last30DaysAefiReported;
        case ReportJsonConstants.VACCINATION_BY_AGE:
            return jsonRoot.vaccinationByAge;
        case ReportJsonConstants.STATE_WISE_VACCINATION:
            return jsonRoot.stateWiseVaccination;
        default:
            throw new ReportJsonException("Invalid Type !", "102");
        }
    }
}
