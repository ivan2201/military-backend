package com.military.backend.domain

import javax.persistence.*

@Entity
@Table(name = "military_base")
data class MilitaryBaseModel(

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    val id: Int? = null,

    @Column(name = "name")
    val name: String? = null,

    @Column(name = "base_number")
    val baseNumber: Int? = null,

    @Column(name = "location")
    val location: String? = null,

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MilitaryBaseModel

        if (id != other.id) return false
        if (name != other.name) return false
        if (baseNumber != other.baseNumber) return false
        if (location != other.location) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (baseNumber ?: 0)
        result = 31 * result + (location?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "MilitaryBaseModel(id=$id, name=$name, baseNumber=$baseNumber, location=$location)"
    }
}
