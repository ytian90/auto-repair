package com.autorepair.autorepair.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

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
public class Vehicle extends NamedEntity {
	
	@Column(name = "own_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date ownDate;
	
	@ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;
	
	@ManyToOne
    @JoinColumn(name = "type_id")
    private VehicleType type;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pet", fetch = FetchType.EAGER)
    private Set<Visit> visits;

	public Driver getDriver() {
		return driver;
	}

	public Date getOwnDate() {
		return ownDate;
	}

	public void setOwnDate(Date ownDate) {
		this.ownDate = ownDate;
	}

	public VehicleType getType() {
		return type;
	}

	public void setType(VehicleType type) {
		this.type = type;
	}

	public Set<Visit> getVisits() {
		return visits;
	}

	public void setVisits(Set<Visit> visits) {
		this.visits = visits;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	
}
