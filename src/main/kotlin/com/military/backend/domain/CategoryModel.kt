package com.military.backend.domain

import javax.persistence.*

@Entity
@Table(name = "category")
data class CategoryModel(

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    val id: Int? = null,

    @Column(name = "category_number")
    val categoryNumber: Int? = null,

    @Column(name = "category_name")
    val categoryName: String? = null,

)
