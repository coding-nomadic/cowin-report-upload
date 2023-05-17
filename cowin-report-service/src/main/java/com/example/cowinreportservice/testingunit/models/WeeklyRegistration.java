package com.example.cowinreportservice.testingunit.models;

import lombok.Data;

import java.util.Date;

@Data
public class WeeklyRegistration {
    public Date startdate;
    public Date enddate;
    public String label;
    public String total;
    public String age12;
    public String age15;
    public String age18;
    public String age45;
    public String age60;
    public String male;
    public String female;
    public String others;
}
