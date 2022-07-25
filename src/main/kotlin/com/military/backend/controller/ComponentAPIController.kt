package com.military.backend.controller

import com.military.backend.domain.dto.ComponentDTO
import com.military.backend.service.ComponentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class ComponentAPIController {

    @Autowired
    var componentService: ComponentService? = null

    @GetMapping("api/components/")
    fun getComponents(@RequestParam("inform_obj_id") informObjectId: Int?):
            Set<ComponentDTO> {
        return componentService!!.getAllByInformatizationObjectId(informObjectId)
    }

    @GetMapping("api/component/{id}")
    fun getComponent(@PathVariable componentId: Int): ComponentDTO {
        return componentService!!.get(componentId)
    }

    @PostMapping("api/component/create", consumes = ["application/json"],
        produces = ["application/json"])
    fun createComponent(@RequestBody component: ComponentDTO):
            ComponentDTO {
        return componentService!!.add(component)
    }

    @PostMapping("api/component/update", consumes = ["application/json"],
        produces = ["application/json"])
    fun updateComponent(@RequestBody component: ComponentDTO):
            ComponentDTO {
        return componentService!!.edit(component)
    }

    @PostMapping("api/component/{id}/delete")
    fun deleteComponentById(@RequestParam componentId: Int)
    {
        componentService!!.deleteById(componentId)
    }
}
