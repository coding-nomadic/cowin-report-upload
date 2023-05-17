package com.example.cowinreportservice.testingunit.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Hit {
    private String _index;
    private String _type;
    private String _id;
    private Double _score;
    private JsonRoot _source;
}