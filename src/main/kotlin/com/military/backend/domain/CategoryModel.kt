package com.military.backend.domain

import org.hibernate.Hibernate
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
    val categoryName: String? = null

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as CategoryModel

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , categoryNumber = $categoryNumber , categoryName = $categoryName )"
    }
}
