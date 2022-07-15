package com.military.backend.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import com.military.backend.domain.ObjectInformatizationModel

class CustomObjectInformatizationSerializer(t: Class<ObjectInformatizationModel>?) :
    StdSerializer<ObjectInformatizationModel>(t) {

    override fun serialize(p0: ObjectInformatizationModel?, p1: JsonGenerator, p2: SerializerProvider?) {
        if (p0 != null) {
            p1.writeStartObject()
            p0.id?.let { p1.writeNumberField("id", it) }
            p1.writeStringField("name", p0.name)
            p1.writeObjectField("cert", p0.cert)
            p1.writeObjectField("militaryBase", p0.militaryBase)
            p1.writeObjectField("specialCheckResult", p0.specialCheckResult)
            p1.writeObjectField("specialInvestigation", p0.specialInvestigation)
            p1.writeArrayFieldStart("components")
            p0.components?.let {
                for (component in it)
                {
                    p1.writeStartObject()
                    component.id?.let { it1 -> p1.writeNumberField("id", it1) }
                    p1.writeStringField("name", component.name)
                    p1.writeStringField("seriesNumber", component.seriesNumber)
                    p1.writeEndObject()
                }
            }
            p1.writeEndArray()
            p1.writeArrayFieldStart("innerDocuments")
            p0.innerDocuments?.let {
                for (doc in it)
                {
                    p1.writeStartObject()
                    doc.id?.let { it1 -> p1.writeNumberField("id", it1) }
                    p1.writeStringField("name", doc.name)
                    p1.writeStringField("registrationNumber", doc.registrationNumber)
                    p1.writeStringField("approveDate", doc.approveDate.toString())
                    p1.writeEndObject()
                }
            }
            p1.writeEndArray()
            p1.writeEndObject()
        }
        else
        {
            p1.writeObject(null)
        }
    }

}
