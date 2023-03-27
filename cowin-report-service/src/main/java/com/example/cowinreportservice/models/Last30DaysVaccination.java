package com.example.cowinreportservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Last30DaysVaccination {
    public String vaccine_date;
    public int total;
    public int dose_1;
    public int dose_2;
    public int dose_pd;
    public int rural;
    public int urban;
}
