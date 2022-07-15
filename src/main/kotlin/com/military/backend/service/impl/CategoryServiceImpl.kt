package com.military.backend.service.impl

import com.military.backend.domain.CategoryModel
import com.military.backend.repository.CategoryRepository
import com.military.backend.service.CategoryService
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl: CategoryService {
    lateinit var categoryRepository: CategoryRepository
    override fun get(id: Int): CategoryModel {
        return categoryRepository.getOne(id)
    }

    override fun getAll(): List<CategoryModel> {
        return categoryRepository.findAll()
    }
}
