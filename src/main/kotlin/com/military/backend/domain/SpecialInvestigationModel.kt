package com.military.backend.domain

import java.sql.Date
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

)
