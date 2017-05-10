package com.aa.amps.data;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.aa.amps.model.Maintenance;

@CrossOrigin
@RepositoryRestResource
public interface MaintenanceRepository extends JpaRepository<Maintenance, Long>{
	
	@RestResource(path= "by-tail")
	public Collection<Maintenance> findByTail(@Param("tail") String tail);
	
	@RestResource(path= "by-type")
	public Collection<Maintenance> findByType(@Param("type") String type);
	
	@RestResource(path= "by-name")
	public Collection<Maintenance> findByname(@Param("name") String name);
}
