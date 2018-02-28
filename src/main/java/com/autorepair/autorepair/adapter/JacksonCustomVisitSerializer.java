package com.autorepair.autorepair.adapter;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;

import com.autorepair.autorepair.model.Driver;
import com.autorepair.autorepair.model.Vehicle;
import com.autorepair.autorepair.model.VehicleType;
import com.autorepair.autorepair.model.Visit;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class JacksonCustomVisitSerializer extends StdSerializer<Visit> {

	public JacksonCustomVisitSerializer() {
		this(null);
	}

	protected JacksonCustomVisitSerializer(Class<Visit> t) {
		super(t);
	}

	@Override
	public void serialize(Visit visit, JsonGenerator jgen, SerializerProvider provider) throws IOException {
		if ((visit == null) || (visit.getVehicle() == null)) {
			throw new IOException("Cannot serialize Visit object - visit or visit.vehicle is null");
		}
		Format formatter = new SimpleDateFormat("yyyy/MM/dd");
		jgen.writeStartObject(); // visit
		if (visit.getId() == null) {
			jgen.writeNullField("id");
		} else {
			jgen.writeNumberField("id", visit.getId());
		}
		jgen.writeStringField("date", formatter.format(visit.getDate()));
		jgen.writeStringField("description", visit.getDescription());

		Vehicle vehicle = visit.getVehicle();
		jgen.writeObjectFieldStart("vehicle");
		if (vehicle.getId() == null) {
			jgen.writeNullField("id");
		} else {
			jgen.writeNumberField("id", vehicle.getId());
		}
		jgen.writeStringField("name", vehicle.getName());
		jgen.writeStringField("birthDate", formatter.format(vehicle.getOwnDate()));

		VehicleType vehicleType = vehicle.getType();
		jgen.writeObjectFieldStart("type");
		if (vehicleType.getId() == null) {
			jgen.writeNullField("id");
		} else {
			jgen.writeNumberField("id", vehicleType.getId());
		}
		jgen.writeStringField("name", vehicleType.getName());
		jgen.writeEndObject(); // type

		Driver driver = vehicle.getDriver();
		jgen.writeObjectFieldStart("driver");
		if (driver.getId() == null) {
			jgen.writeNullField("id");
		} else {
			jgen.writeNumberField("id", driver.getId());
		}
		jgen.writeStringField("firstName", driver.getFirstName());
		jgen.writeStringField("lastName", driver.getLastName());
		jgen.writeStringField("address", driver.getAddress());
		jgen.writeStringField("city", driver.getCity());
		jgen.writeStringField("telephone", driver.getTelephone());
		jgen.writeEndObject(); // driver
		jgen.writeEndObject(); // vehicle
		jgen.writeEndObject(); // visit
	}

}

