package com.aa.amps.task.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MaintenanceTaskChannel {
	
	@Input SubscribableChannel input();
}
