package com.autorepair.autorepair.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.samples.petclinic.model.Owner;

import com.autorepair.autorepair.adapter.JacksonCustomVehicleDeserializer;
import com.autorepair.autorepair.adapter.JacksonCustomVehicleSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 
 * @author ytian
 *
 */
@Entity
@Table(name = "vehicles")
@JsonSerialize(using = JacksonCustomVehicleSerializer.class)
@JsonDeserialize(using = JacksonCustomVehicleDeserializer.class)
public class Vehicle {
	
	@ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

}
