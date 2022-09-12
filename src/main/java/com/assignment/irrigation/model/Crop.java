package com.assignment.irrigation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "crop_id")
    private Long cropId;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "cultivation_period_days")
    private Integer cultivationPeriodDays;
    
    @Column(name = "irrigation_gap_days")
    private Integer irrigationGapDays;
}
