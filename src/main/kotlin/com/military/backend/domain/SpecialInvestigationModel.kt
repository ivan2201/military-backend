package com.military.backend.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import java.sql.Date
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "special_investigation")
data class SpecialInvestigationModel(

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    val id: Int? = null,

    @Column(name = "si_number")
    val specialInvestigationNumber: String? = null,

    @Column(name = "approve_date")
    val approveDate: Date? = null,

    @JsonIgnore
    @CreationTimestamp
    @Column(name = "created")
    val created: LocalDateTime? = null

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as SpecialInvestigationModel

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , specialInvestigationNumber = $specialInvestigationNumber , approveDate = $approveDate , created = $created )"
    }
}
