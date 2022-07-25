package com.military.backend.repository

import com.military.backend.domain.CategoryModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<CategoryModel, Int>
