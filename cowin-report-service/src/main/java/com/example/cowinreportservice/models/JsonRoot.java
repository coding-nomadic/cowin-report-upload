package com.example.cowinreportservice.models;

import java.util.ArrayList;

import lombok.Data;

@Data
public class JsonRoot {
    public ArrayList<VaccinationDoneByTimeToday> vaccinationDoneByTimeToday;
    public ArrayList<Last30DaysVaccination> last30DaysVaccination;
    public ArrayList<WeeklyVaccination> weeklyVaccination;
    public ArrayList<VaccinationDoneByTimeAgeWiseToday> vaccinationDoneByTimeAgeWiseToday;
    public ArrayList<Last30DaysAgeWiseVaccination> last30DaysAgeWiseVaccination;
    public ArrayList<WeeklyAgeWiseVaccination> weeklyAgeWiseVaccination;
    public ArrayList<RegistrationDoneByTimeToday> registrationDoneByTimeToday;
    public ArrayList<Last30DaysRegistration> last30DaysRegistration;
    public ArrayList<WeeklyRegistration> weeklyRegistration;
    public ArrayList<Last30DaysAefiReported> last30DaysAefiReported;
    public VaccinationByAge vaccinationByAge;
    public ArrayList<StateWiseVaccination> stateWiseVaccination;
}
