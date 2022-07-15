package com.military.backend.controller

import com.military.backend.domain.CategoryModel
import com.military.backend.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CategoryAPIController {

    @Autowired
    lateinit var categoryService: CategoryService

    @GetMapping("api/categories/")
    fun getCategories():
            Set<CategoryModel> {
        return categoryService.getAll()
    }
}
