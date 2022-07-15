package com.military.backend.domain

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.military.backend.serializer.CustomComponentSerializer
import javax.persistence.*

@Entity
@Table(name = "components")
@JsonSerialize(using = CustomComponentSerializer::class)
data class ComponentModel(

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    val id: Int? = null,

    @ManyToOne
    @JoinColumn(name = "oi_id", nullable = true)
    val objectInformatization: ObjectInformatizationModel? = null,

    @Column(name = "name")
    val name: String? = null,

    @Column(name = "series_number")
    val seriesNumber: String? = null,
    )
{

    override fun hashCode(): Int {
        return seriesNumber.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (other is ComponentModel)
        {
            if (( id == null || id == -1 || other.id == null || other.id == -1
                        || other.id == id)
                && other.name == name
                && other.seriesNumber == seriesNumber)
                return true
        }
        return false
    }
}
