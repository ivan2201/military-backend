package com.military.backend.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import com.military.backend.domain.InnerDocumentModel

class CustomInnerDocumentSerializer(t: Class<InnerDocumentModel>?) :
    StdSerializer<InnerDocumentModel>(t) {

    override fun serialize(p0: InnerDocumentModel?, p1: JsonGenerator, p2: SerializerProvider?) {
        if (p0 != null) {
            p1.writeStartObject()
            p0.id?.let { p1.writeNumberField("id", it) }
            p1.writeStringField("name", p0.name)
            p1.writeStringField("registrationNumber", p0.registrationNumber)
            p1.writeStringField("approveDate", p0.approveDate.toString())
            p1.writeObjectFieldStart("objectInformatization")
            p0.objectInformatization?.let {
                it.id?.let { it1 -> p1.writeNumberField("id", it1) }
                p1.writeStringField("name", it.name)
            }
            p1.writeEndObject()
            p1.writeEndObject()
        }
        else
        {
            p1.writeObject(null)
        }
    }

}
