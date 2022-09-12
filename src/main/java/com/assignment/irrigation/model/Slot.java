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
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "slot_id")
    private Long slotId;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "start_time")
    private LocalDateTime startTime;
    
    @Column(name = "end_time")
    private LocalDateTime endTime;
    
    @Column(name = "water_amount_ltr")
    private Integer waterAmountLtr;
    
    @Column(name = "irrigation_status")
    private String irrigationStatus;
    
    @Column(name = "plot_id")
    private Long plotId;
    
}
