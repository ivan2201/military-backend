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

)
