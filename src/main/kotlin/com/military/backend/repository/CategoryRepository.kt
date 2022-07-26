package com.military.backend.repository

import com.military.backend.domain.CategoryModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CategoryRepository : JpaRepository<CategoryModel, Int> {
    fun findByCategoryName(categoryName: String): Optional<CategoryModel>
}
