package com.military.backend.domain

import javax.persistence.*

@Entity
@Table(name = "components")
data class ComponentModel(

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    val id: Int? = null,

    @ManyToOne
    @JoinColumn(name = "oi_id", nullable = true)
    val objectInformatization: ObjectInformatizationModel? = null,

    @Column(name = "name")
    val name: String? = null,

    @Column(name = "series_number")
    val seriesNumber: String? = null,

)
