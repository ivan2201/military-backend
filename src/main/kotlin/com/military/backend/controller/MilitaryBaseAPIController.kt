package com.military.backend.controller

import com.military.backend.domain.MilitaryBaseModel
import com.military.backend.service.MilitaryBaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MilitaryBaseAPIController {

    @Autowired
    lateinit var militaryBaseService: MilitaryBaseService

    @GetMapping("api/military-bases/")
    fun getMilitaryBases(): List<MilitaryBaseModel> {
        return militaryBaseService.getAll()
    }
}
