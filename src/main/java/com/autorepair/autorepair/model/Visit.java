package com.autorepair.autorepair.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.autorepair.autorepair.adapter.JacksonCustomVisitDeserializer;
import com.autorepair.autorepair.adapter.JacksonCustomVisitSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "visits")
@JsonSerialize(using = JacksonCustomVisitSerializer.class)
@JsonDeserialize(using = JacksonCustomVisitDeserializer.class)
public class Visit extends BaseEntity{
	
	@Column(name = "visit_date")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy/MM/dd")
    private Date date;
	
	@NotEmpty
    @Column(name = "description")
    private String description;
	
	@ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
	
	public Visit() {
        this.date = new Date();
    }

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}


}
