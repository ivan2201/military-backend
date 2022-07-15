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

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ComponentModel

        if (id != other.id) return false
        if (objectInformatization != other.objectInformatization) return false
        if (name != other.name) return false
        if (seriesNumber != other.seriesNumber) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + (objectInformatization?.hashCode() ?: 0)
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (seriesNumber?.hashCode() ?: 0)
        return result
    }
}
