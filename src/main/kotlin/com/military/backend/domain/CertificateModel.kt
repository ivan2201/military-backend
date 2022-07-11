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

)
