package com.military.backend.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import com.military.backend.domain.dto.NewWarCampDTO
import com.military.backend.domain.dto.WarCampDTO
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
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
    val baseNumber: String? = null,

    @Column(name = "location")
    val location: String? = null,

    @JsonIgnore
    @CreationTimestamp
    @Column(name = "created")
    val created: LocalDateTime? = null

) {
    constructor(warCampDTO: NewWarCampDTO):
            this(name=warCampDTO.nameWarCamp, baseNumber = warCampDTO.numberWarCamp, location = warCampDTO.location)

    constructor(warCampDTO: WarCampDTO):
            this(warCampDTO.id, warCampDTO.nameWarCamp, warCampDTO.numberWarCamp, warCampDTO.location)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as MilitaryBaseModel

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , baseNumber = $baseNumber , location = $location , created = $created )"
    }
}
