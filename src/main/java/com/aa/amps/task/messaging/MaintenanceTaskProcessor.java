package com.aa.amps.task.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

import com.aa.amps.data.MaintenanceRepository;
import com.aa.amps.model.Maintenance;

@MessageEndpoint
public class MaintenanceTaskProcessor {
	
	private final MaintenanceRepository maintenanceRepository;
	
	@Autowired
	public MaintenanceTaskProcessor(MaintenanceRepository maintenanceRepository) {
		this.maintenanceRepository = maintenanceRepository;
	}
	
	@ServiceActivator(inputChannel="input")
	public void taskProcessor(Maintenance m) {
		System.out.println(m);
		this.maintenanceRepository.save(m);
	}
	
}
