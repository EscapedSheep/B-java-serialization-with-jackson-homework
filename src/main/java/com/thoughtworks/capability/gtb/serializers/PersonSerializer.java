package com.thoughtworks.capability.gtb.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.thoughtworks.capability.gtb.vo.PersonVo;

import java.io.IOException;

public class PersonSerializer extends StdSerializer<PersonVo> {
    protected PersonSerializer() {
        super(PersonVo.class);
    }

    @Override
    public void serialize(PersonVo personVo, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("id", personVo.getId());
        gen.writeNumberField("age", personVo.getAge() == null ? 0 : personVo.getAge());
        gen.writeStringField("name", personVo.getName());
        if (personVo.getHobby() != null) {
            gen.writeStringField("hobby", personVo.getHobby());
        }
        gen.writeEndObject();
    }
}
