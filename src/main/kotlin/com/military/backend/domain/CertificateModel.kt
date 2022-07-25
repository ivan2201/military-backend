package com.military.backend.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import java.sql.Date
import java.time.LocalDateTime
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
    val certNumber: String? = null,

    @Column(name = "approve_date")
    val approveDate: Date? = null,

    @Column(name = "recert_date")
    val recertDate: Date? = null,

    @Column(name = "cert_creator")
    val certCreator: String? = null,

    @JsonIgnore
    @CreationTimestamp
    @Column(name = "created")
    val created: LocalDateTime? = null

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as CertificateModel

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , category = $category , certNumber = $certNumber , approveDate = $approveDate , recertDate = $recertDate , certCreator = $certCreator , created = $created )"
    }
}
