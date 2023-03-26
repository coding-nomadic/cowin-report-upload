package com.example.cowinreportservice.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeeklyVaccination {
    public Date startdate;
    public Date enddate;
    public String label;
    public int total;
    public int dose1;
    public int dose2;
    public int dose_pd;
}
