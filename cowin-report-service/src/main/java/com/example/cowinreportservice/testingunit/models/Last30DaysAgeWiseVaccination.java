package com.example.cowinreportservice.testingunit.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Last30DaysAgeWiseVaccination {
    public String vaccine_date;
    public int total;
    public int vac_12_14;
    public int vac_15_17;
    public int vac_18_45;
    public int vac_45_60;
    public int vac_60_above;
}
