package com.assignment.irrigation.constants;

import java.util.Objects;

import org.springframework.util.StringUtils;

public enum IrrigationStatus {
	CREATED("CREATED"),
	STARTED("STARTED"),
	RUNNING("RUNNING"),
	COMPLETED("COMPLETED");
	
	private final String status;
	
	IrrigationStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Get irrigation status after matching.
	 * @param status
	 * @return
	 */
	public static String getIrrigationStatus(String status) {
		String irrigationStatus = null;
		if(!StringUtils.hasText(status)) {
			irrigationStatus = null;
		}
		
		for (IrrigationStatus irriStatus : IrrigationStatus.values()) {
			if(irriStatus.getStatus().equals(status)) {
				irrigationStatus = irriStatus.getStatus();
			}
		}
		
		return irrigationStatus;
	}

	/**
	 * Get status.
	 * @return
	 */
	public String getStatus() {
		return status;
	}
	
	
}
