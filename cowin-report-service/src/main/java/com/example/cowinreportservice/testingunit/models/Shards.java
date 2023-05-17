package com.example.cowinreportservice.testingunit.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Shards {
    private Integer total;
    private Integer successful;
    private Integer skipped;
    private Integer failed;
}
