package com.example.cowinreportservice.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VaccinationDoneByTimeToday {
    public String ts;
    public Date timestamps;
    public String label;
    public int count;
    public int dose_one;
    public int dose_one_1;
    public int dose_two;
    public int dose_pd;
}
