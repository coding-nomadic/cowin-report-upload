package com.example.cowinreportservice.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    private Integer took;
    private Boolean timedOut;
    private Shards _shards;
    private Hits hits;
}
