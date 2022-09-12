package com.assignment.irrigation.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Plot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plot_id")
    private Long plotId;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "area_sqrmtr")
    private Integer areaSqrmtr;
    
    @Column(name = "cultivation_start_date")
    private LocalDateTime cultivationStartDate;
    
    @Column(name = "crop_id")
    private Long cropId;
}
