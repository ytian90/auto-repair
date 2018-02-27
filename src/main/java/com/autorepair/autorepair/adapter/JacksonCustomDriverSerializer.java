package com.autorepair.autorepair.adapter;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;

import com.autorepair.autorepair.model.Driver;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * 
 * @author ytian
 *
 */
public class JacksonCustomDriverSerializer extends StdSerializer<Driver> {

	public JacksonCustomDriverSerializer() {
		this(null);
	}

	public JacksonCustomDriverSerializer(Class<Driver> t) {
		super(t);
	}

	@Override
	public void serialize(Driver driver, JsonGenerator gen, SerializerProvider provider) throws IOException {
		Format formatter = new SimpleDateFormat("yyyy/MM/dd");
		gen.writeStartObject();
		if (driver.getId() == null) {
			gen.writeNullField("id");
		} else {
			gen.writeNumberField("id", driver.getId());
		}
		
		gen.writeStringField("firstName", driver.getFirstName());
		gen.writeStringField("lastName", driver.getLastName());
		
		
		
		gen.writeEndArray();
		gen.writeEndObject();
	}
}
