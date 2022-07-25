package com.military.backend.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import com.military.backend.domain.dto.DocumentDTO
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import java.sql.Date
import java.time.LocalDateTime
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

    @JsonIgnore
    @CreationTimestamp
    @Column(name = "created")
    val created: LocalDateTime? = null

) {
    constructor(documentDTO: DocumentDTO): this(documentDTO.id, null,
        documentDTO.name, documentDTO.regNum, Date.valueOf(documentDTO.date))

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as InnerDocumentModel

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , registrationNumber = $registrationNumber , approveDate = $approveDate , created = $created )"
    }
}
