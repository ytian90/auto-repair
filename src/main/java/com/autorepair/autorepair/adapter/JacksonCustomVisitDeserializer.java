package com.autorepair.autorepair.adapter;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.autorepair.autorepair.model.Vehicle;
import com.autorepair.autorepair.model.Visit;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class JacksonCustomVisitDeserializer extends StdDeserializer<Visit> {
	
	public JacksonCustomVisitDeserializer() {
		this(null);
	}

	public JacksonCustomVisitDeserializer(Class<Visit> t) {
		super(t);
	}

	@Override
	public Visit deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		Visit visit = new Visit();
		Vehicle Vehicle = new Vehicle();
		ObjectMapper mapper = new ObjectMapper();
		Date visitDate = null;
		JsonNode node = parser.getCodec().readTree(parser);
		JsonNode Vehicle_node = node.get("Vehicle");
		Vehicle = mapper.treeToValue(Vehicle_node, Vehicle.class);
		int visitId = node.get("id").asInt();
		String visitDateStr = node.get("date").asText(null);
		String description = node.get("description").asText(null);
		try {
			visitDate = formatter.parse(visitDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new IOException(e);
		}

		if (!(visitId == 0)) {
			visit.setId(visitId);
		}
		visit.setDate(visitDate);
		visit.setDescription(description);
		visit.setVehicle(Vehicle);
		return visit;
	}

}
