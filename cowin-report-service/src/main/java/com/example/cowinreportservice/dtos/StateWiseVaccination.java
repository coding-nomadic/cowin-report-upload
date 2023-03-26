package com.example.cowinreportservice.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StateWiseVaccination {
    public String state_id;
    public String id;
    public String title;
    public String state_name;
    public int total;
    public int partial_vaccinated;
    public int totally_vaccinated;
    public int precaution_dose;
    public int today;
}
