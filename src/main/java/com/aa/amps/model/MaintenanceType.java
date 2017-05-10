package com.aa.amps.model;

public enum MaintenanceType {
	
	CHK("CHK"),
	ECO("ECO"),
	SIC("SIC");
	
	private String type;
	
	private MaintenanceType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
}
