package com.aa.amps;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.stereotype.Component;

import com.aa.amps.data.MaintenanceRepository;
import com.aa.amps.task.messaging.MaintenanceTaskChannel;

@EnableDiscoveryClient
@SpringBootApplication
@EnableBinding(MaintenanceTaskChannel.class)
@IntegrationComponentScan
public class TasksServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasksServiceApplication.class, args);
	}
	
	@Component
	class SampleData implements CommandLineRunner {
		
		private final MaintenanceRepository maintenanceRepository;
		
		@Autowired
		public SampleData(MaintenanceRepository maintenanceRepository) {
			this.maintenanceRepository = maintenanceRepository;
		}
		
		@Override
		public void run(String... arg0) throws Exception {
			
			/*List<String> tails = Arrays.asList("3AA","3AB","3AC");
			List<String> chkTasks = Arrays.asList("PS","AC");
			Supplier<Stream<String>> sicTasks = () -> Stream.of("1949","1979","2900","3900");
			Supplier<Stream<String>> ecoTasks = () -> Stream.of("J1234AA","J1234AB","J1234AC","J1234AD");
			
			tails.forEach(tail -> chkTasks.forEach(chk -> {
				Maintenance mntnc = new Maintenance();
				mntnc.setName(chk);
				mntnc.setTail(tail);
				mntnc.setType(MaintenanceType.CHK.getType());
				mntnc.setAta(getRandomAta());
				mntnc.setForecastDate(getRandomForecastDate());
				maintenanceRepository.save(mntnc);
			}));
			
			tails.forEach(tail -> ecoTasks.get().forEach(chk -> {
				Maintenance mntnc = new Maintenance();
				mntnc.setName(chk);
				mntnc.setTail(tail);
				mntnc.setType(MaintenanceType.ECO.getType());
				mntnc.setAta(getRandomAta());
				mntnc.setForecastDate(getRandomForecastDate());
				maintenanceRepository.save(mntnc);
			}));
			
			tails.forEach(tail -> sicTasks.get().forEach(chk -> {
				Maintenance mntnc = new Maintenance();
				mntnc.setName(chk);
				mntnc.setTail(tail);
				mntnc.setType(MaintenanceType.SIC.getType());
				mntnc.setAta(getRandomAta());
				mntnc.setForecastDate(getRandomForecastDate());
				maintenanceRepository.save(mntnc);
			}));*/
			
			maintenanceRepository.findAll().forEach(System.out::println);
		}
		
	}
	
	static Long getRandomAta() {
		
		return new Random().longs(1100, 4900).findFirst().getAsLong();
	}
	
	static Date getRandomForecastDate () {
		
		final Calendar c = Calendar.getInstance();
		Date date = new Date();
		c.setTime(date);
		c.add(Calendar.DAY_OF_YEAR, new Random().ints(0, 999).findAny().getAsInt());
		
		return c.getTime();
	}
}
