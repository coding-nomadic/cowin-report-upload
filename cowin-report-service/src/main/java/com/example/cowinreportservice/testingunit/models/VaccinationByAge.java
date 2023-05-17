package com.example.cowinreportservice.testingunit.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigInteger;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VaccinationByAge {
    public long total;
    public int vac_12_14;
    public int vac_15_17;
    public int vac_18_45;
    public int vac_45_60;
    public int above_60;
}
