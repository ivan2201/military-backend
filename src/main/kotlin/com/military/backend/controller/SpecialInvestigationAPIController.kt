package com.military.backend.controller

import com.military.backend.domain.SpecialInvestigationModel
import com.military.backend.service.SpecialInvestigationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SpecialInvestigationAPIController {

    @Autowired
    lateinit var specialInvestigationService: SpecialInvestigationService

    @GetMapping("api/spec-investigations/")
    fun getSpecialInvestigations():
            List<SpecialInvestigationModel> {
        return specialInvestigationService.getAll()
    }
}
