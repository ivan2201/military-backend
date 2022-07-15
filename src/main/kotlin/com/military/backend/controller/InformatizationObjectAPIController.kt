package com.military.backend.controller

import com.military.backend.domain.ObjectInformatizationModel
import com.military.backend.service.ObjectInformatizationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class InformatizationObjectAPIController {

    @Autowired
    lateinit var objectInformatizationService: ObjectInformatizationService

    @GetMapping("api/informatization-objects/")
    fun getInformatizationObjects(@RequestParam("mil_base_id") militaryBaseId: Int?):
            List<ObjectInformatizationModel> {
        return objectInformatizationService.getAllByMilitaryBaseId(militaryBaseId)
    }
}
