package com.example.cowinreportservice.testingunit.models;

import lombok.Data;

@Data
public class ElasticSearchDetails {
    private String elasticUrl;
    private String elasticPort;
    private String elasticProtocol;
    private String indexName;
    private String typeName;
}
