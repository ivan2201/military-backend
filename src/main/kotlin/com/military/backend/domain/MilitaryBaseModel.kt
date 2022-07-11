package com.military.backend.domain

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
    val baseNumber: Int? = null,

    @Column(name = "location")
    val location: String? = null,

)
