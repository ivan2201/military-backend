package com.military.backend.domain

import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "inner_document")
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

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as InnerDocumentModel

        if (id != other.id) return false
        if (objectInformatization != other.objectInformatization) return false
        if (name != other.name) return false
        if (registrationNumber != other.registrationNumber) return false
        if (approveDate != other.approveDate) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + (objectInformatization?.hashCode() ?: 0)
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (registrationNumber?.hashCode() ?: 0)
        result = 31 * result + (approveDate?.hashCode() ?: 0)
        return result
    }
}
