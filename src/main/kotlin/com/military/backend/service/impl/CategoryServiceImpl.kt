package com.military.backend.service.impl

import com.military.backend.domain.CategoryModel
import com.military.backend.repository.CategoryRepository
import com.military.backend.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl: CategoryService {
    @Autowired
    var categoryRepository: CategoryRepository? = null
    override fun get(id: Int): CategoryModel {
        return categoryRepository!!.getOne(id)
    }

    override fun getAll(): Set<CategoryModel> {
        return categoryRepository!!.findAll().toSet()
    }
}
