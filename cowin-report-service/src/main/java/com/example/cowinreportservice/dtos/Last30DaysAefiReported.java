package com.example.cowinreportservice.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Last30DaysAefiReported {
    public String vaccine_date;
    public int aefi;
}
