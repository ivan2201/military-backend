package com.military.backend.controller

import com.military.backend.domain.ComponentModel
import com.military.backend.service.ComponentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ComponentAPIController {

    @Autowired
    lateinit var componentService: ComponentService

    @GetMapping("api/components/")
    fun getComponents(@RequestParam("inform_obj_id") informObjectId: Int?):
            List<ComponentModel> {
        return componentService.getAllByInformatizationObjectId(informObjectId)
    }
}