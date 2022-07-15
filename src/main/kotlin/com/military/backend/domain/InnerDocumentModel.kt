package com.military.backend.domain

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.military.backend.serializer.CustomInnerDocumentSerializer
import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "inner_document")
@JsonSerialize(using = CustomInnerDocumentSerializer::class)
data class InnerDocumentModel(

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    val id: Int? = null,

    @ManyToOne
    @JoinColumn(name = "oi_id", nullable = true)
    val objectInformatization: ObjectInformatizationModel? = null,

    @Column(name = "name")
    val name: String? = null,

    @Column(name = "registration_number")
    val registrationNumber: String? = null,

    @Column(name = "approve_date")
    val approveDate: Date? = null,
)
{

    override fun hashCode(): Int {
        return registrationNumber.hashCode()
    }
    override fun equals(other: Any?): Boolean {
        if (other is InnerDocumentModel)
        {
            if (( id == null || id == -1 || other.id == null || other.id == -1
                        || other.id == id)
                && other.name == name
                && other.registrationNumber == registrationNumber)
                return true
        }
        return false
    }
}
