package com.autorepair.autorepair.adapter;

import java.io.IOException;

import com.autorepair.autorepair.model.Vehicle;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * 
 * @author ytian
 *
 */
public class JacksonCustomVehicleSerializer extends StdSerializer<Vehicle> {

	public JacksonCustomVehicleSerializer() {
		this(null);
	}
	
	protected JacksonCustomVehicleSerializer(Class<Vehicle> t) {
		super(t);
	}

	@Override
	public void serialize(Vehicle value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		
	}

	
}
