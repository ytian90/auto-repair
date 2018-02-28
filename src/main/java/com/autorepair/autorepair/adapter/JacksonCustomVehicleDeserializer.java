package com.autorepair.autorepair.adapter;

import java.io.IOException;
import java.text.SimpleDateFormat;

import com.autorepair.autorepair.model.Vehicle;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

/**
 * 
 * @author ytian
 *
 */
public class JacksonCustomVehicleDeserializer extends StdDeserializer<Vehicle> {

	public JacksonCustomVehicleDeserializer() {
		this(null);
	}

	public JacksonCustomVehicleDeserializer(Class<Vehicle> t) {
		super(t);
	}

	@Override
	public Vehicle deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		Vehicle vehicle = new Vehicle();
		
		
		return null;
	}
}
