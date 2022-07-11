package com.military.backend.domain

import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "special_check_result")
data class SpecialCheckResultModel(

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    val id: Int? = null,

    @Column(name = "scr_number")
    val specialCheckResultNumber: String? = null,

    @Column(name = "approve_date")
    val approveDate: Date? = null,
)
