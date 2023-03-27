package com.example.cowinreportservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VaccinationDoneByTimeAgeWiseToday {
    public String ts;
    public Date timestamps;
    public String label;
    public int total;
    public int vac_12_14;
    public int vac_15_17;
    public int vac_18_45;
    public int vac_45_60;
    public int vac_60_above;
    public int rural;
    public int urban;
}
