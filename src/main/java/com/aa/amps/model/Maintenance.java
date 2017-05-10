package com.aa.amps.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="acft_mntnc")
@Data
@NoArgsConstructor
public class Maintenance {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	@NotNull private String name;
	@NotNull private String tail;
	@NotNull private String type;
	private Long ata;
	private Long workpackageId;
	private String criticality;
	
	@Column(name="dfrl_lock_ind")
	private Character dfrlLock;
	
	@Column(name="rt_ctrl")
	private Character rtCtrl;
	
	private Date forecastDate;
	
	@Column(name="schd_date")
	private Date schdDate;
	@Column(name="planned_station")
	private String station;

}
