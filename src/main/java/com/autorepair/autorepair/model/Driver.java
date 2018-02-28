package com.autorepair.autorepair.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.core.style.ToStringCreator;

import com.autorepair.autorepair.adapter.JacksonCustomDriverDeserializer;
import com.autorepair.autorepair.adapter.JacksonCustomDriverSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 
 * @author ytian
 *
 */
@Entity
@Table(name = "drivers")
@JsonSerialize(using = JacksonCustomDriverSerializer.class)
@JsonDeserialize(using = JacksonCustomDriverDeserializer.class)
public class Driver extends Person {
	
	@Column(name = "lid")
	@NotEmpty
	private String lid;
	
	@Column(name = "address")
	@NotEmpty
	private String address;
	
	@Column(name = "city")
	@NotEmpty
	private String city;
	
	@Column(name = "zipcode")
	@NotEmpty
	@Digits(fraction = 0, integer = 5)
	private String zipcode;
	
	@Column(name = "telephone")
    @NotEmpty
    @Digits(fraction = 0, integer = 10)
    private String telephone;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "driver", fetch = FetchType.EAGER)
    private Set<Vehicle> vehicles;

	public String getLid() {
		return lid;
	}

	public void setLid(String lid) {
		this.lid = lid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@JsonIgnore
	public Set<Vehicle> getVehiclesInternal() {
		if (this.vehicles == null) {
			this.vehicles = new HashSet<>();
		}
		return this.vehicles;
	}

	public void setVehiclesInternal(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	public List<Vehicle> getVehicles() {
		List<Vehicle> sortedVehicles = new ArrayList<>(getVehiclesInternal());
		PropertyComparator.sort(sortedVehicles, new MutableSortDefinition("name", true, true));
		return Collections.unmodifiableList(sortedVehicles);
	}

	public void addVehicle(Vehicle vehicle) {
		getVehiclesInternal().add(vehicle);
		vehicle.setDriver(this);
	}
	
	public Vehicle getVehicle(String vin) {
		return getVehicle(vin, false);
	}

	public Vehicle getVehicle(String vin, boolean ignoreNew) {
		vin = vin.toLowerCase();
		for (Vehicle vehicle : getVehiclesInternal()) {
			//TODO:
		}
		return null;
	}
	
	@Override
	public String toString() {
		return new ToStringCreator(this)
				//TODO
				.toString();
	}
}
