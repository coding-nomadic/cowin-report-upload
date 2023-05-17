package com.example.cowinreportservice.testingunit.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Hits {
    private Total total;
    private Double maxScore;
    private List<Hit> hits = new ArrayList<Hit>();
}