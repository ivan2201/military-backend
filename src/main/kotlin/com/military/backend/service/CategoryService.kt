package com.military.backend.service

import com.military.backend.domain.CategoryModel

interface CategoryService {
    fun get(id: Int): CategoryModel
    fun getAll(): Set<CategoryModel>
}
