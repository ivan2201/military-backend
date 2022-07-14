package com.military.backend.domain

import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "certificate")
data class CertificateModel(

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    val id: Int? = null,

    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false)
    val category: CategoryModel? = null,

    @Column(name = "cert_number")
    val certNumber: Int? = null,

    @Column(name = "approve_date")
    val approveDate: Date? = null,

    @Column(name = "recert_date")
    val recertDate: Date? = null,

    @Column(name = "cert_creator")
    val certCreator: String? = null,

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CertificateModel

        if (id != other.id) return false
        if (category != other.category) return false
        if (certNumber != other.certNumber) return false
        if (approveDate != other.approveDate) return false
        if (recertDate != other.recertDate) return false
        if (certCreator != other.certCreator) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + (category?.hashCode() ?: 0)
        result = 31 * result + (certNumber ?: 0)
        result = 31 * result + (approveDate?.hashCode() ?: 0)
        result = 31 * result + (recertDate?.hashCode() ?: 0)
        result = 31 * result + (certCreator?.hashCode() ?: 0)
        return result
    }
}
