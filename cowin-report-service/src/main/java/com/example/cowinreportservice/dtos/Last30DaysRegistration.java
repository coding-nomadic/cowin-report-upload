package com.example.cowinreportservice.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Last30DaysRegistration {
    public Date reg_date;
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
