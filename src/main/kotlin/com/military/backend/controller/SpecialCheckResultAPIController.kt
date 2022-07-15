package com.military.backend.controller

import com.military.backend.domain.SpecialCheckResultModel
import com.military.backend.service.SpecialCheckResultService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SpecialCheckResultAPIController {

    @Autowired
    lateinit var specialCheckResultService: SpecialCheckResultService

    @GetMapping("api/spec-checks/")
    fun getSpecialCheckResults():
            List<SpecialCheckResultModel> {
        return specialCheckResultService.getAll()
    }
}