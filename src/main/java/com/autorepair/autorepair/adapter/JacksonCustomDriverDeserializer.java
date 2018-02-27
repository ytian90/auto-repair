package com.autorepair.autorepair.adapter;

import java.io.IOException;

import com.autorepair.autorepair.model.Driver;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class JacksonCustomDriverDeserializer extends StdDeserializer<Driver> {
	
	public JacksonCustomDriverDeserializer() {
		this(null);
	}
	
	public JacksonCustomDriverDeserializer(Class<Driver> t) {
		super(t);
	}

	@Override
	public Driver deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		JsonNode node = p.getCodec().readTree(p);
		Driver driver = new Driver();
		int id = node.get("id").asInt();
		String firstName = node.get("firstName").asText(null);
		String lastName = node.get("lastName").asText(null);
		String address = node.get("address").asText(null);
		String city = node.get("city").asText(null);
		String telephone = node.get("telephone").asText(null);
		
		if (!(id == 0)) {
			driver.setId(id);
		}
		driver.setFirstName(firstName);
		driver.setLastName(lastName);
		
		
		return driver;
	}
	
	

}
